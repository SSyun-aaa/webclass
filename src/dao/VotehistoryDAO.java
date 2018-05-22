package dao;

import java.sql.Date;
import java.util.ArrayList;

import model.VotehistoryBean;

public class VotehistoryDAO extends DaoBase{
	
	//ユーザーごとの履歴取得
	public ArrayList<VotehistoryBean> getUserVotehistory(String id){
		ArrayList<VotehistoryBean> arrayvotehistory = new ArrayList<VotehistoryBean>();
		try{
			//super.DbOpen();
			super.connection();
			
			String sql  ="select * from votehistory where userID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			rs=stmt.executeQuery();
			
			while(rs.next()){
				VotehistoryBean votehistorybean = new VotehistoryBean();
				
				votehistorybean.setVotehistoryID(rs.getString("votehistoryID"));
				votehistorybean.setUserID(rs.getString("userID"));
				votehistorybean.setContentsID(rs.getString("contentsID"));
				votehistorybean.setContentsdataID(rs.getString("contentsdataID"));
				
				arrayvotehistory.add(votehistorybean);
			}
			
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return arrayvotehistory;
	}
	
	//コンテンツごとの投票数取得
		public int getContentsVotehistory(String id){
			int count = -1;
			try{
				//super.DbOpen();
				super.connection();
				
				String sql  ="select count(*) from votehistory where contentsID = ?";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, id);
				rs=stmt.executeQuery();
				rs.next();
				
				count = rs.getInt(1);
				
			}catch(Exception e){
				
			}finally {
				try{
					super.DbClose();
				}catch(Exception e){
					System.out.println("error");
				}
			}
			return count;
		}
		
		//コンテンツ詳細ごとの投票数取得
		public int getContentsdataVotehistory(String contentsid,String contentsdataid){
			int count = -1;
			try{
				//super.DbOpen();
				super.connection();
						
				String sql  ="select count(*) from votehistory where contentsID = ? and contentsdataID = ?";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, contentsid);
				stmt.setString(2, contentsdataid);
				rs=stmt.executeQuery();
				rs.next();
						
				count = rs.getInt(1);
						
			}catch(Exception e){
						
			}finally {
				try{
					super.DbClose();
				}catch(Exception e){
					System.out.println("error");
				}
			}
			return count;
		}
		public void contentsdataInsert(String userid,String contentsid,String contentsdataid){
			
			try{
				//super.DbOpen();
				super.connection();
				String sql  ="insert into votehistory values(?,?,?)";
				
				stmt = con.prepareStatement(sql);
				
				stmt.setString(1, userid);
				stmt.setString(2, contentsid);
				stmt.setString(3, contentsdataid);
				
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
}
