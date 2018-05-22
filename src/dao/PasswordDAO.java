package dao;

import model.PasswordBean;

public class PasswordDAO extends DaoBase {

	public PasswordBean searchUser(String id,String pass) {
		
		try{
		PasswordBean userpass = new PasswordBean();
		super.connection();
		
		String sql ="select userID,password from password where userID = ? and password = ?";
		stmt = con.prepareStatement(sql);
		
		stmt.setString(1, id);
		stmt.setString(2, pass);
		rs=stmt.executeQuery();
		rs.next();
		
		userpass.setUserID(rs.getString(1));
		userpass.setPassword(rs.getString(2));
		return userpass;
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return null;
		//ユーザが見つかれば該当ユーザ情報を、いなければnullをかえす
	}
	
	public void passwordInsert(PasswordBean userpass) {
		
		try{
			super.connection();
		
			super.connection();
			String sql  ="insert into password values(?,?)";
			
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, userpass.getUserID());
			stmt.setString(2, userpass.getPassword());
			
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
	
	public void passwordDelete(String id){
		try{
			//super.DbOpen();
			super.connection();
			
			String sql ="Delete from password where userID = ?";
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
	
	public PasswordBean getPassword(String id) {
		
		try{
		PasswordBean userpass = new PasswordBean();
		super.connection();
		
		String sql ="select * from password where userID = ?";
		stmt = con.prepareStatement(sql);
		
		stmt.setString(1, id);
		rs=stmt.executeQuery();
		rs.next();
		
		userpass.setUserID(rs.getString(1));
		userpass.setPassword(rs.getString(2));
		return userpass;
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
	
	public void passwordUpdate(String id,String pass){
		try{
			//super.DbOpen();
			super.connection();
			
			String sql ="Update password set password=? where userID = ?";
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1,pass);
			stmt.setString(2,id);
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
