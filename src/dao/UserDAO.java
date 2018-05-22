package dao;

import model.UserBean;

public class UserDAO extends DaoBase {
	
	public UserBean getUser(String id){
		UserBean user = new UserBean();
		try{
		super.connection();
		
		String sql ="select * from user where userID = ?";
		stmt = con.prepareStatement(sql);
		
		stmt.setString(1, id);
		rs=stmt.executeQuery();
		rs.next();
		
		user.setUserID(rs.getString(1));
		user.setUserName(rs.getString(2));
		user.setCreateDate(rs.getDate(3));
		user.setAuthority(rs.getString(4));
		user.setSex(rs.getString(5));
		user.setBirthday(rs.getDate(6));
		
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return user;
		//ユーザが見つかれば該当ユーザ情報を、いなければnullをかえす
	}
	
	public void userInsert(UserBean user){
		//渡されたユーザ情報をユーザテーブルへ挿入
		try{
			//super.DbOpen();
			super.connection();
			String sql  ="insert into user(userID,userName,authority,sex,birthday) values(?,?,?,?,?)";
			
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, user.getUserID());
			stmt.setString(2, user.getUserName());
			stmt.setString(3, user.getAuthority());
			stmt.setString(4, user.getSex());
			stmt.setDate(5, user.getBirthday());
			
			rsno = stmt.executeUpdate();
				
		}catch(Exception e){
			user=null;
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
	}
	
	public void userDelete(String id){
		try{
			//super.DbOpen();
			super.connection();
			
			String sql ="Delete from user where userID = ?";
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
	
}
