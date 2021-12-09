package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;

import bean.BookBean;
import bean.CustBean;
import servlet.ConnectionManager;

@WebServlet("/BookDAO")
public class BookDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static List<BookBean> bookBean = null;
		
	public static List<BookBean> getBookBean() {
		return bookBean;
	}

	public static void setBookBean() {
		BookDAO.bookBean = new LinkedList<>(getAll());
	}
	
	//add new booking 
	 public static int addBook(BookBean bean){
		 
		 int i = 0;
		  //get all data from booking table
		  String event = bean.getBk_name();
		  String strdate = bean.getBk_strdate();
		  String enddate = bean.getBk_enddate();
		  String pax = bean.getBk_pax();
		  String total = bean.getBk_totprice();
		  String cust = bean.getC_id();
		  String hall = bean.getH_id();
		  
		  Statement stmt = null;
		  
		  //create connection
		  currentCon = ConnectionManager.getConnection();
		   
		  try {
			  
			  //create statement
			  ps = currentCon.prepareStatement("insert into booking(bk_name,bk_strdate,bk_enddate,bk_pax,bk_totprice,c_id,h_id)values(?,?,?,?,?,?,?)");
			  ps.setString(1, event);
			  ps.setString(2, strdate);
			  ps.setString(3, enddate);
			  ps.setString(4, pax);
			  ps.setString(5, total);
			  ps.setString(6, cust);
			  ps.setString(7, hall);
			  
			//trace process
			  System.out.println("Query : " + ps);
			 
			  //execute statement
			  i = ps.executeUpdate();
			  System.out.println("Data is successfully inserted!");
			  currentCon.close();
		  } 
		  catch (SQLException e) {
			  e.printStackTrace();
		  }
		  finally {
			if (rs != null) {
				try {
					rs.close();
				} 
				catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} 
				catch (Exception e) {
				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} 
				catch (Exception e) {
				}
				currentCon = null;
			}
		}
		return i; 
	 }
	 
	 public static List<BookBean> getAll() {
			//preparing some objects/variable
			List<BookBean> bookList = new LinkedList<>();
			String sql = "SELECT bk_id,bk_name,bk_strdate,bk_enddate,bk_pax,bk_totprice,c_name,h_name FROM booking b"
					+ " LEFT JOIN customer c ON b.c_id = c.c_id"
					+ " LEFT JOIN hall h ON b.h_id = h.h_id";
			
			Statement stmt = null;
			
			//trace process
			System.out.println("in BookBean.getAll");
			System.out.println("Query : " + sql);
			
			try {
				//connect to DB
				currentCon = ConnectionManager.getConnection();
				stmt = currentCon.createStatement();
				rs = stmt.executeQuery(sql);
				
				//iterate over theResultSet, add row into object and object into list
				while(rs.next()) {
					BookBean b = new BookBean();
					b.setBk_id(rs.getString(1));
					b.setBk_name(rs.getString(2));
					b.setBk_strdate(rs.getString(3));
					b.setBk_enddate(rs.getString(4));
					b.setBk_pax(rs.getString(5));
					b.setBk_totprice(rs.getString(6));
					b.setC_id(rs.getString(7));
					b.setH_id(rs.getString(8));
					bookList.add(b);
				} 
			}
			catch(Exception ex) {
				System.out.println("Error!" + ex);
			}//some exception handling
			finally {
				if(rs!=null) {
					try {
						rs.close();
					}
					catch(Exception ex) {}
						rs = null;
				}
				if(stmt!=null) {
					try {
						stmt.close();
					}
					catch(Exception ex) {}
					stmt = null;
				}
				if(currentCon!=null) {
					try {
						currentCon.close();
					}
					catch(Exception ex) {}
					currentCon = null;
				}
			}
			return bookList;
	}
	 
	//method to get single data
	 public static BookBean getBook(String id) {
		// trace process
		try {
			System.out.println("in BookBean.getBook");
			for (int x = 0; x < getBookBean().size(); x++) {
				if (getBookBean().get(x).getBk_id().equals(id)) {
					return getBookBean().get(x);
				}
			}
		} catch (Exception ex) {
			System.out.println("Data not found !: " + ex);
		} // some exception handling

		return null;
	}
	
	//update
	 public static boolean updateBook(BookBean bb) {
		 String start = bb.getBk_strdate();
		 String end = bb.getBk_enddate();
		 String pax = bb.getBk_pax();
		 String price = bb.getBk_totprice();
		 String cust = bb.getC_id();
		 String hall = bb.getH_id();
		 String id = bb.getBk_id();
		 PreparedStatement stmt = null;
		 
		 String query = "UPDATE booking SET bk_strdate='" + start + "', bk_enddate='" + end + "', bk_pax='" + pax + "', bk_totprice='" + price + "', c_id='" + cust + "', h_id='" + hall + "' WHERE bk_id='" + id + "'";
		 System.out.println(query);
		 try {
			 currentCon = (Connection) ConnectionManager.getConnection();
			 stmt = currentCon.prepareStatement(query);
			 stmt.executeUpdate();
		 }
		 catch(SQLException e) {
			System.out.println("Query failed : " + e);
		}
		 finally {
			if (rs != null) {
				try {
					rs.close();
				} 
				catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					//stmt1.close();
					stmt.close();
				} 
				catch (Exception e) {
				}
				//stmt1 = null;
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} 
				catch (Exception e) {
				}
				currentCon = null;
			}
		}
		return true; 
	 }
	 
	 public static int updateBook1(BookBean bb){
		 int i = 0;
		 String sql = "update booking set bk_strdate=?, bk_enddate=?, bk_totprice=?, bk_pax=?, c_id=?, h_id=? WHERE bk_id=?";
		 PreparedStatement stmt = null;
		// trace process
		try {
			// connect to DB
			currentCon = (Connection) ConnectionManager.getConnection();
			stmt = currentCon.prepareStatement(sql);
			
			stmt.setString(1, bb.getBk_strdate());
			stmt.setString(2, bb.getBk_enddate());
			stmt.setString(3, bb.getBk_pax());
			stmt.setString(4, bb.getBk_totprice());
			stmt.setString(5, bb.getC_id());
			stmt.setString(6, bb.getH_id());
			stmt.setString(7, bb.getBk_id());
			
			i = stmt.executeUpdate();
		} 
		catch (Exception ex) {
			System.out.println("Query failed: " + ex);
		} // some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		return i;
	}
	 
	//delete  
	 public static int deleteBook(String bk_id){
		  int rows = 0;
		   
		  try {
			  //create connection
			  currentCon = ConnectionManager.getConnection();
			  
			  //create statement
			  ps = currentCon.prepareStatement("DELETE FROM booking WHERE bk_id=?");
			  ps.setString(1, bk_id);
			  
			  //trace process
			  System.out.println("Query : " + ps);
			 
			  //execute statement
			  rows = ps.executeUpdate();
			  if(rows > 0) {
				  System.out.println("A data was deleted successfully!");
				  currentCon.close();
			  }
		  } 
		  catch (SQLException e) {
			  e.printStackTrace();
		  } 
		  return rows;
	 }
}
