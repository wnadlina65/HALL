package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import bean.CustBean;
import bean.HallBean;
import bean.StaffBean;
import servlet.ConnectionManager;

@WebServlet("/HallDAO")
public class HallDAO {
		static Connection currentCon = null;
		static ResultSet rs = null;
		static PreparedStatement ps = null;
		static List<HallBean> hallBean = null;

		public static List<HallBean> getHallBean() {
			return hallBean;
		}

		public static void setHallBean() {
			HallDAO.hallBean = new LinkedList<>(getAll());
		}
		
		//add new hall 
		 public static int addHall(HallBean hb){
			  int i = 0;
			  String hall = hb.getH_name();
			  String status = hb.getH_status();
			  String price = hb.getH_price();
			  String type = hb.getHt_id();
			  String sql = "insert into hall(h_name,h_status,h_price,ht_id)values(?,?,?,?)";
			  
			  //trace process
			  System.out.println("in HallBean.addHall");
			  System.out.println("Your hall name is " + hall);
			  System.out.println("Your hall status is " + status);
			  System.out.println("Your hall price is " + price);
			  System.out.println("Your hall type is " + type);
			  System.out.println("Query : " + sql);
			
			  try {
				  
				//create connection
				  currentCon = ConnectionManager.getConnection();
				  
				  //create statement
				  ps = currentCon.prepareStatement(sql);
				  
				  ps.setString(1,hall);
				  ps.setString(2,status);
				  ps.setString(3,price);
				  ps.setString(4,type);
				  
				  //execute statement
				  i = ps.executeUpdate();
				  
				  System.out.println("Data is successfully inserted!");
			  } 
			  catch (SQLException e) {
				  System.out.println("Query failed in addHall: " + e);
			  } 
			  finally {
					if (rs != null) {
						try {
							rs.close();
						} catch (Exception e) {
						}
						rs = null;
					}
					if (ps != null) {
						try {
							ps.close();
						} 
						catch (Exception e) {
						}
						ps = null;
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
			 
		public static List<HallBean> getAll() {
			//preparing some objects/variable
			List<HallBean> hallList = new LinkedList<>();
			String sql = "select h_id, h_name, h_status, h_price, ht_name from hall h inner join halltype ht where h.ht_id = ht.ht_id";
			Statement stmt = null;
			
			//trace process
			System.out.println("in HallBean.getAll");
			System.out.println("Query : " + sql);
			
			try {
				//connect to DB
				currentCon = ConnectionManager.getConnection();
				stmt = currentCon.createStatement();
				rs = stmt.executeQuery(sql);
				
				//iterate over theResultSet, add row into object and object into list
				while(rs.next()) {
					HallBean hb = new HallBean();
					hb.setH_id(rs.getString(1));
					hb.setH_name(rs.getString(2));
					hb.setH_status(rs.getString(3));
					hb.setH_price(rs.getString(4));
					hb.setHt_id(rs.getString(5));
					hallList.add(hb);
				} 
			}
			catch(Exception ex) {
				System.out.println("Error! An Exception has occurred!" + ex);
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
			return hallList;
		}
		
		//get a single data
		public static HallBean getHall(String id) {
			// trace process
			try {
				System.out.println("in HallBean.getHall");
				for (int x = 0; x < getHallBean().size(); x++) {
					if (getHallBean().get(x).getH_id().equals(id)) {
						return getHallBean().get(x);
					}
				}
			} catch (Exception ex) {
				System.out.println("Error!: " + ex);
			} // some exception handling

			return null;
		}
		
		//update
		public static boolean hallUpdate(HallBean hb) {
			String hname = hb.getH_name();
			String status = hb.getH_status();
			String price = hb.getH_price();
			String type = hb.getHt_id();
			String id = hb.getH_id();
			PreparedStatement ps = null;
			
			String sql = "UPDATE hall SET h_name='" + hname + "', h_status='" + status + "', h_price='" + price + "', ht_id='" + type + "' WHERE h_id='" + id + "'";
			System.out.println(sql);
			try {
				currentCon = (Connection) ConnectionManager.getConnection();
				ps = currentCon.prepareStatement(sql);
				ps.executeUpdate();
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
				if (ps != null) {
					try {
						ps.close();
					} 
					catch (Exception e) {
					}
					ps = null;
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
		public static int hallDelete(String id) {
			int i = 0;
			String sql2 = "delete from hall where h_id=?";
			PreparedStatement stmt2 = null;
			
			try {
				// connect to DB
				currentCon = (Connection) ConnectionManager.getConnection();
				stmt2 = currentCon.prepareStatement(sql2);
				stmt2.setString(1, id);
				i = stmt2.executeUpdate();
				// trace process
				System.out.print(i);

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
