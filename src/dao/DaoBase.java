package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;
/**
 * DAOsuperクラス
 * @author aquaAir
 */
public class DaoBase {
	Connection con=null;	//DBMSへの接続や切断を行う
	PreparedStatement stmt = null;	//SQLの送信を行う
	ResultSet rs=null;		//DBMSからの検索結果を受け取る
	int rsno=0;				//DBMSからの処理件数を受け取る

	//データソース
	DataSource ds = null;

	public DaoBase() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	/*public Connection DbOpen(){
		//JDBCドライバのロード(java6から(現在は)省略可)
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//指定するデータベースへ接続(引数:URL/利用ユーザ/パスワード)
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ScheduleDB", "root", "root");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}*/

	/**
	 * データベースへの接続処理を行うメソッド
	 * @return コネクション情報
	 */
	public Connection connection() throws Exception {
		//データソースがなければ、context.xmlから読み込んで設定する
		if (ds == null) {
			ds = (DataSource) (new InitialContext()).lookup("java:comp/env/jdbc/Myds");
		}
		//プールしているコネクションの参照情報を取得
		con = ds.getConnection();
		return con;
	}
	
	public void DbClose(){
	    //接続したものが空でなければ閉じる
		try {
  		if(rs != null){rs.close();}
		    if(stmt != null){stmt.close();}
		    if(con != null){con.close();}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
