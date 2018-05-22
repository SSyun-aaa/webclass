package dao;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import model.ContentsdataBean;

public class ContentsdataDAO extends DaoBase{

		//コンテンツIDから参加者すべてを取得
		public ArrayList<ContentsdataBean> getAllContentsdata(String id){
			ArrayList<ContentsdataBean> arraycontentsdata = new ArrayList<ContentsdataBean>();
			try{
				//super.DbOpen();
				super.connection();
				
				String sql  ="select * from contentsdata where contentsID = ?";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, id);
				rs=stmt.executeQuery();
				
				while(rs.next()){
					ContentsdataBean contentsdatabean = new ContentsdataBean();
					
				    contentsdatabean.setContentsID(rs.getString("contentsID"));
				    contentsdatabean.setContentsdataID(rs.getString("contentsdataID"));
				    contentsdatabean.setContentsdataName(rs.getString("contentsdataName"));
				    contentsdatabean.setContentsdataPicture(rs.getBlob("contentsdataPicture"));
				    contentsdatabean.setIntroduction(rs.getString("introduction"));
				    contentsdatabean.setSex(rs.getString("sex"));
				    contentsdatabean.setBirthday(rs.getDate("birthday"));
					
					arraycontentsdata.add(contentsdatabean);
				}
				
			}catch(Exception e){
				
			}finally {
				try{
					super.DbClose();
				}catch(Exception e){
					System.out.println("error");
				}
			}
			return arraycontentsdata;
		}
		
		//参加者1件の情報を取得
		public ContentsdataBean getContentsdate(String contentsid,String contentsdataid){
			ContentsdataBean contentsdatabean = new ContentsdataBean();
			try{
				//super.DbOpen();
				super.connection();
				
				String sql  ="select * from contentsdata where contentsID = ? and contentsdataID = ?";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, contentsid);
				stmt.setString(2, contentsdataid);
				rs=stmt.executeQuery();
				
				rs.next();
				
				contentsdatabean.setContentsID(rs.getString("contentsID"));
				contentsdatabean.setContentsdataID(rs.getString("contentsdataID"));
				contentsdatabean.setContentsdataName(rs.getString("contentsdataName"));
				contentsdatabean.setContentsdataPicture(rs.getBlob("contentsdataPicture"));
				contentsdatabean.setIntroduction(rs.getString("introduction"));
			    contentsdatabean.setSex(rs.getString("sex"));
			    contentsdatabean.setBirthday(rs.getDate("birthday"));
				
			}catch(Exception e){
				
			}finally {
				try{
					super.DbClose();
				}catch(Exception e){
					System.out.println("error");
				}
			}
			return contentsdatabean;
		}
		
		public void contentsdataInsert(String contentsid,String contentsdataid,String name,InputStream picture,String intro,String sex,Date birth){
			
			try{
				//super.DbOpen();
				super.connection();
				String sql  ="insert into contentsdata values(?,?,?,?,?,?,?)";
				
				stmt = con.prepareStatement(sql);
				
				stmt.setString(1, contentsid);
				stmt.setString(2, contentsdataid);
				stmt.setString(3, name);
				stmt.setBlob(4, picture);
				stmt.setString(5, intro);
				stmt.setString(6, sex);
				stmt.setDate(7, birth);
				
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
		
		public void contentsdataUpdate(String contentsid,String contentsdataid,String name,InputStream picture,String intro,String sex,Date birth){
			try{
				//super.DbOpen();
				super.connection();
				
				String sql ="Update contentsdata set contentsdataName=?,contentsdataPicture=?,introduction=?,sex=?,birthday=? where contentsID = ? and contentsdataID = ?";
				stmt = con.prepareStatement(sql);
				
				stmt.setString(1, name);
				stmt.setBlob(2, picture);
				stmt.setString(3, intro);
				stmt.setString(4, sex);
				stmt.setDate(5, birth);
				stmt.setString(6, contentsid);
				stmt.setString(7, contentsdataid);
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
		
		public void contentsdataDelete(String contentsid,String contentsdataid){
			try{
				//super.DbOpen();
				super.connection();
				
				String sql ="Delete from contentsdata where contentsID = ? and contentsdataID = ?";
				stmt = con.prepareStatement(sql);
				
				stmt.setString(1,contentsid);
				stmt.setString(2,contentsdataid);
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
		public BufferedImage getPicture(String contentsid,String contentsdataid){
			try{
			   super.connection();
			   String sql  ="select * from contents where contentsID = ? and contentsdataID = ?";
			   stmt = con.prepareStatement(sql); 
			   stmt.setString(1, contentsid);
			   stmt.setString(1, contentsdataid);
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
