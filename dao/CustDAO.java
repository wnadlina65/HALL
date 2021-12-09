package dao;
import java.sql.*;
import java.util.*;

import javax.servlet.annotation.WebServlet;

import com.mysql.jdbc.Connection;

import bean.CustBean;
import bean.StaffBean;
import servlet.ConnectionManager;

@WebServlet("/CustDAO")
public class CustDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static String id, name, phone, address, zipcode, city;
	static List<CustBean> custBean = null;

	public static List<CustBean> getCustBean() {
		return custBean;
	}

	public static void setCustBean() {
		CustDAO.custBean = new LinkedList<>(getAll());
	}
	
	//add new cust
	public static int addCust(CustBean cb) {
		int i = 0;
		String sql1 = "insert into customer (c_name,c_phone,c_address,c_zipcode,c_city) values(?,?,?,?,?)";
		PreparedStatement stmt1 = null;
	
		try {
			// connect to DB
			currentCon = (Connection) ConnectionManager.getConnection();
			stmt1 = currentCon.prepareStatement(sql1);
			stmt1.setString(1, cb.getC_name());
			stmt1.setString(2, cb.getC_phone());
			stmt1.setString(3, cb.getC_address());
			stmt1.setString(4, cb.getC_zipcode());
			stmt1.setString(5, cb.getC_city());
			
			i = stmt1.executeUpdate();
			
			// trace process
			System.out.println(sql1);
		} 
		catch (Exception ex) {
			System.out.println("Query failed in addCust: " + ex);
		} // some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt1 != null) {
				try {
					stmt1.close();
				} 
				catch (Exception e) {
				}
				stmt1 = null;
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
	 
	 public static List<CustBean> getAll() {
			//preparing some objects/variable
			List<CustBean> custList = new LinkedList<>();
			String sql = "select * from customer";
			Statement stmt = null;
			
			//trace process
			System.out.println("in CustBean.getAll");
			try {
				//connect to DB
				currentCon = (Connection) ConnectionManager.getConnection();
				stmt = currentCon.createStatement();
				rs = stmt.executeQuery(sql);
				System.out.println("sql");
				
				//iterate over theResultSet, add row into object and object into list
				while(rs.next()) {
					CustBean cb = new CustBean();
					cb.setC_id(rs.getString(1));
					cb.setC_name(rs.getString(2));
					cb.setC_phone(rs.getString(3));
					cb.setC_address(rs.getString(4));
					cb.setC_zipcode(rs.getString(5));
					cb.setC_city(rs.getString(6));
					custList.add(cb);
				} 
			}
			catch(Exception ex) {
				System.out.println("cust.getAll Fail !!: An Exception has occurred! " + ex);
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
			return custList;
	}
	 
	//method to get single data
	 public static CustBean getCust(String id) {
			// trace process
			try {
				System.out.println("in CustBean.getCust");
				for (int x = 0; x < getCustBean().size(); x++) {
					if (getCustBean().get(x).getC_id().equals(id)) {
						return getCustBean().get(x);
					}
				}
			} catch (Exception ex) {
				System.out.println("Data not found !: " + ex);
			} // some exception handling

			return null;
	}
	 
	//update
	 public static boolean updateCust(CustBean cb) {
		 String name = cb.getC_name();
		 String phone = cb.getC_phone();
		 String add = cb.getC_address();
		 String zipcode = cb.getC_zipcode();
		 String city = cb.getC_city();
		 String id = cb.getC_id();
		 PreparedStatement stmt = null;
		 
		 String query = "UPDATE customer SET c_name='" + name + "', c_phone='" + phone + "', c_address='" + add + "', c_zipcode='" + zipcode + "', c_city='" + city + "' WHERE c_id='" + id + "'";
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
    
	 //delete
	 public static int custDelete(String id) {
			int i = 0;
			String sql2 = "delete from customer where c_id=?";
			PreparedStatement stmt2 = null;
			
			try {
				// trace process
				System.out.print(sql2);
				// connect to DB
				currentCon = (Connection) ConnectionManager.getConnection();
				stmt2 = currentCon.prepareStatement(sql2);
				stmt2.setString(1, id);
				i = stmt2.executeUpdate();
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
				if (stmt2 != null) {
					try {
						//stmt1.close();
						stmt2.close();
					} catch (Exception e) {
					}
					//stmt1 = null;
					stmt2 = null;
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
}