package dao;
//コメント
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import model.ContentsBean;

public class ContentsDAO extends DaoBase {
	
	//すべてのコンテンツを取得
	public ArrayList<ContentsBean> getAllContents(){
		ArrayList<ContentsBean> arraycontents = new ArrayList<ContentsBean>();
		try{
			//super.DbOpen();
			super.connection();
			
			String sql  ="select * from contents";
			stmt = con.prepareStatement(sql);
			rs=stmt.executeQuery();
			
			while(rs.next()){
				ContentsBean contentsbean = new ContentsBean();
				
			    contentsbean.setContentsID(rs.getString("contentsID"));
			    contentsbean.setContentsName(rs.getString("contentsName"));
			    contentsbean.setContentsDate(rs.getDate("contentsDate"));
			    contentsbean.setStartDate(rs.getDate("startDate"));
			    contentsbean.setEndDate(rs.getDate("endDate"));
			    contentsbean.setContentsPicture(rs.getBlob("contentsPicture"));
				
				arraycontents.add(contentsbean);
			}
			
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return arraycontents;
	}
	
	//現在開催中のコンテンツを取得
	public ArrayList<ContentsBean> getInSessionContents(Date nowtime){
		ArrayList<ContentsBean> arraycontents = new ArrayList<ContentsBean>();
		try{
			//super.DbOpen();
			super.connection();
			
			String sql  ="select * from contents where trunc(?) >= startDate and trunc(?) <= endDate";
			stmt = con.prepareStatement(sql);
			stmt.setDate(1, nowtime);
			rs=stmt.executeQuery();
			
			while(rs.next()){
				ContentsBean contentsbean = new ContentsBean();
				
			    contentsbean.setContentsID(rs.getString("contentsID"));
			    contentsbean.setContentsName(rs.getString("contentsName"));
			    contentsbean.setContentsDate(rs.getDate("contentsDate"));
			    contentsbean.setStartDate(rs.getDate("startDate"));
			    contentsbean.setEndDate(rs.getDate("endDate"));
			    contentsbean.setContentsPicture(rs.getBlob("contentsPicture"));
				
				arraycontents.add(contentsbean);
			}
			
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return arraycontents;
	}
	
	//指定したコンテンツ1件の情報を取得
	public ContentsBean getContents(String id){
		ContentsBean contentsbean = new ContentsBean();
		try{
			//super.DbOpen();
			super.connection();
			
			String sql  ="select * from contents where contentsID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			rs=stmt.executeQuery();
			
			rs.next();
			
			contentsbean.setContentsID(rs.getString("contentsID"));
			contentsbean.setContentsName(rs.getString("contentsName"));
			contentsbean.setContentsDate(rs.getDate("contentsDate"));
			contentsbean.setStartDate(rs.getDate("startDate"));
			contentsbean.setEndDate(rs.getDate("endDate"));
			contentsbean.setContentsPicture(rs.getBlob("contentsPicture"));
				
			
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return contentsbean;
	}
	
	public void contentsInsert(String id,String name,Date start,Date end,InputStream picture){
		
		try{
			//super.DbOpen();
			super.connection();
			String sql  ="insert into contents(contentsID,contentsName,startDate,endDate,contentsPicture) values(?,?,?,?,?)";
			
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, id);
			stmt.setString(2, name);
			stmt.setDate(3, start);
			stmt.setDate(4, end);
			stmt.setBlob(5, picture);
			
			rsno = stmt.executeUpdate();
				
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
	}
	
	public void contentsUpdate(String id,String name,Date start,Date end,InputStream picture){
		try{
			//super.DbOpen();
			super.connection();
			
			String sql ="Update contents set contentsName=?,startDate=?,endDate=?,contentsPicture=? where contentsID = ?";
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, name);
			stmt.setDate(2, start);
			stmt.setDate(3, end);
			stmt.setBlob(4, picture);
			stmt.setString(5, id);
			rsno=stmt.executeUpdate();
			
			}catch(Exception e){
				
			}finally {
				try{
					super.DbClose();
				}catch(Exception e){
					System.out.println("error");
				}
			}
	}
	
	public void contentsDelete(String id){
		try{
			//super.DbOpen();
			super.connection();
			
			String sql ="Delete from contents where contentsID = ?";
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1,id);
			rsno=stmt.executeUpdate();
			
			}catch(Exception e){
				
			}finally {
				try{
					super.DbClose();
				}catch(Exception e){
					System.out.println("error");
				}
			}
	}
	
	//画像取得
	public BufferedImage getPicture(String id){
		try{
		   super.connection();
		   String sql  ="select * from contents where contentsID = ?";
		   stmt = con.prepareStatement(sql); 
		   stmt.setString(1, id);
		   rs = stmt.executeQuery();
		   rs.next();
		   InputStream is = rs.getBinaryStream("picture");
		   BufferedInputStream bis = new BufferedInputStream(is);
		   return ImageIO.read(bis);

		}catch(Exception e){

		}finally {
		   try{
		    super.DbClose();
		   }catch(Exception e){
		    System.out.println("error");
		   }
		} 
		  return null;
	}
}
