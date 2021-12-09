package dao;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import bean.StaffBean;
import servlet.ConnectionManager;

@WebServlet("/StaffDAO")
public class StaffDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static List<StaffBean> staffBean = null;

	public static List<StaffBean> getStaffBean() {
		return staffBean;
	}

	public static void setStaffBean() {
		StaffDAO.staffBean = new LinkedList<>(getAll());
	}

	public static List<StaffBean> getAll() {
		// preparing some objects/variable
		List<StaffBean> staffList = null;
		staffList = new LinkedList<>();
		String sql = null;
		sql = "SELECT s_id, s_FName, s_LName, s_no, st_typename FROM staff s INNER JOIN stafftype st ON s.st_id = st.st_id";
		Statement stmt = null;
		
		// trace process
		System.out.println("in StaffBean.getAll");
		try {
			// connect to DB
			currentCon = null;
			rs = null;
			currentCon = (Connection) ConnectionManager.getConnection();
			stmt = (Statement) currentCon.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.print(rs);
			
			// iterate over the ResultSet, add row into object and object into list
			while (rs.next()) {
				StaffBean sb = null;
				sb = new StaffBean();
				sb.setS_id(rs.getInt(1));
				sb.setS_FName(rs.getString(2));
				sb.setS_LName(rs.getString(3));
				sb.setS_no(rs.getString(4));
				sb.setSt_id(rs.getString(5));
				staffList.add(sb);
			}
		} 
		catch (Exception ex) {
			System.out.println("staff.getAll Fail !!: An Exception has occurred! " + ex);
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
		return staffList;
	}

	public static StaffBean getStaff(String sno) {
		// trace process
		try {
			System.out.println("in StaffBean.getStaff");
			for (int x = 0; x < getStaffBean().size(); x++) {
				if (getStaffBean().get(x).getS_no().equals(sno)) {
					return getStaffBean().get(x);
				}
			}
		} catch (Exception ex) {
			System.out.println("Data not found !: " + ex);
		} // some exception handling

		return null;
	}

	public static StaffBean login(StaffBean bean) {
		Statement stmt = null;
		String s_no = bean.getS_no();
		String s_pass = bean.getS_pass();
		String searchQuery = "select * from staff where s_no='" + s_no + "' AND s_pass='" + s_pass + "'";
		//prepared statement
		//String searchQuery = "select * from user where username=? and password=?";
		
		//use to trace process
		System.out.println("in StaffBean.login");
		System.out.println("Your staff no is " + s_no);
		System.out.println("Your password is " + s_pass);
		System.out.println("Query : " + searchQuery);
		try {
			//connect to DB
			currentCon = (Connection) ConnectionManager.getConnection();
			stmt = (Statement) currentCon.createStatement();
			//prepared statement
			//PreparedStatement stmt = currentCon.prepareStatement(searchQuery);
			//stmt.setString(1, username);
			//stmt.setString(2, password);
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();
			//if user does not exist
			if(!more) {
				System.out.println("Sorry, you are not a registered user!" + "Please sign up first!");
				bean.setValid(false);
			}
			//if user exists
			else if(more) {
				String firstName = rs.getString("s_FName");
				String sno = rs.getString("s_no");
				System.out.println("Welcome " + firstName);
				bean.setS_FName(firstName);
				bean.setS_no(sno);
				bean.setValid(true);
			}
		}
		catch(Exception ex) {
			System.out.println("Log In failed : An exception has occured! " + ex);
		} //some exception handling
		finally {
			if(rs!=null) {
				try {
					rs.close();
				}
				catch(Exception e) {}
					rs = null;
			}
			if(stmt!=null) {
				try {
					stmt.close();
				}
				catch(Exception e) {}
				stmt = null;
			}
			if(currentCon!=null) {
				try {
					currentCon.close();
				}
				catch(Exception e) {}
				currentCon = null;
			}
		}
		return bean;
	}

	public static int checkStaff(StaffBean sb) {
		int i = 0;
		String sql = "SELECT COUNT(s_no) FROM staff WHERE s_no=?";
		PreparedStatement stmt = null;
		
		// trace process
		try {
			// connect to DB
			currentCon = (Connection) ConnectionManager.getConnection();
			stmt = currentCon.prepareStatement(sql);
			stmt.setString(1, sb.getS_no());
			rs = stmt.executeQuery();
			System.out.println(sql);
			
			if (rs.next()) {
				i = Integer.parseInt(rs.getString(1));
				return i;
			}
		} catch (Exception ex) {
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

	public static int addStaff(StaffBean sb) {
		int i = 0;
		String sql1 = "insert into staff (s_FName, s_LName, s_no, s_pass, st_id) values(?,?,?,?,?)";
		PreparedStatement stmt1 = null;
		
		// trace process
		System.out.println(sql1);
		try {
			// connect to DB
			currentCon = (Connection) ConnectionManager.getConnection();
			stmt1 = currentCon.prepareStatement(sql1);
			stmt1.setString(1, sb.getS_FName());
			stmt1.setString(2, sb.getS_LName());
			stmt1.setString(3, sb.getS_no());
			stmt1.setString(4, sb.getS_pass());
			stmt1.setString(5, sb.getSt_id());
			
			i = stmt1.executeUpdate();
		} 
		catch (Exception ex) {
			System.out.println("Query failed in addStaff: " + ex);
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
	
	//update
	public static boolean updateStaff(StaffBean sb) {
		String fname = sb.getS_FName();
		String lname = sb.getS_LName();
		String type = sb.getSt_id();
		String no = sb.getS_no();
		PreparedStatement stmt = null;
		
		String searchQuery = "UPDATE staff SET s_FName='" + fname + "', s_LName='" + lname + "', st_id='" + type + "' WHERE s_no='" + no + "'";
		System.out.println(searchQuery);
		try {
			currentCon = (Connection) ConnectionManager.getConnection();
			stmt = currentCon.prepareStatement(searchQuery);
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
		return true; 
	}
	
	//delete
	public static int staffDelete(String s_no) {
		int i = 0;
		String sql2 = "delete from staff where s_no=?";
		PreparedStatement stmt2 = null;
		
		try {
			// trace process
			System.out.print(sql2);
			// connect to DB
			currentCon = (Connection) ConnectionManager.getConnection();
			stmt2 = currentCon.prepareStatement(sql2);
			stmt2.setString(1, s_no);
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
				} 
				catch (Exception e) {
				}
				//stmt1 = null;
				stmt2 = null;
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
}
