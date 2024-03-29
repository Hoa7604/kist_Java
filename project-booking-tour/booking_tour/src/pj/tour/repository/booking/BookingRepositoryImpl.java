package pj.tour.repository.booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pj.tour.entity.AccountEntity;
import pj.tour.entity.TourEntity;
import pj.tour.entity.UserEntity;
import pj.tour.repository.account.AccountRepository;
import pj.tour.config.ConnectionFactory;

public class BookingRepositoryImpl implements BookingTour{
	
	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	Scanner input = new Scanner(System.in);
	
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	@Override
	public List<TourEntity> findAll() {
		// TODO Auto-generated method stub
		List<TourEntity> tourlists = new ArrayList<TourEntity>();
		String queryString = "SELECT * FROM tour";
		
		try {
			connection = getConnection();	
			stmt = connection.prepareStatement(queryString);
			rs = stmt.executeQuery(); //Select
			
			while(rs.next()) {
				TourEntity cus = new TourEntity();
				
				cus.setName_tour(rs.getString("name_Tour"));
				cus.setLocation_start(rs.getString("location_start"));
				cus.setTime_start(rs.getString("time_start"));
				cus.setDate_start(rs.getString("date_start"));
				cus.setMem_number(rs.getInt("mem_number"));
				cus.setDay_number(rs.getInt("day_number"));
				
				tourlists.add(cus); 
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			}
			catch (SQLException e) {
				System.out.println(e);
			}
		}
		return tourlists;
}

	@Override
	public String findById() {
		// TODO Auto-generated method stub
		String queryString = "SELECT * FROM tour where tour_id = ?";
		boolean check1 = true;
		try {
			do {
				System.out.println("----------Choose Tour!!----------");
				System.out.println("Enter Tour_ID: ");
				String inputID = input.next();
				connection = getConnection();	
				stmt = connection.prepareStatement(queryString);
				stmt.setString(1, inputID);
				rs = stmt.executeQuery(); //Select
				
				if(rs.next()) {
					if (inputID.equals(rs.getString("tour_id"))) {
						return inputID;
						
					}else {
						
					}	System.out.println("Enter Id again: ");
					
				}
			} while (check1);
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			}
			catch (SQLException e) {
				System.out.println(e);
			}
		}
		return null;
	}


	@Override
	public int addInfo() {
		// TODO Auto-generated method stub
		try {
			String queryString = "INSERT INTO "
		+"user(name, dprtmt_id, rank_id, reg_id, reg_date, updt_id, updt_date)" 
		+"VALUES(?,?,?,?,now(),?,now())";
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
//			stmt.setString(1, dto.getName());
//			stmt.setString(2, dto.getDprtmt_id());
//			stmt.setString(3, dto.getRank_id());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}


	@Override
	public List<TourEntity> showListTour(String tour_id) {
		// TODO Auto-generated method stub
		
		List<TourEntity> tourlists = new ArrayList<TourEntity>();
		String queryString = "SELECT * FROM tour WHERE tour_id = ?";
		
		try {
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1, tour_id);
			rs = stmt.executeQuery(); //Select	
			
			while(rs.next()) {
				TourEntity cus = new TourEntity();	
				cus.setTour_id(rs.getString("tour_id"));
				cus.setName_tour(rs.getString("name_Tour"));
				cus.setLocation_start(rs.getString("location_start"));
				cus.setTime_start(rs.getString("time_start"));
				cus.setDate_start(rs.getString("date_start"));
				cus.setMem_number(rs.getInt("mem_number"));
				cus.setDay_number(rs.getInt("day_number"));				
				cus.setPrice_tour(rs.getInt("price_tour"));
				
				tourlists.add(cus);
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			}
			catch (SQLException e) {
				System.out.println(e);
			}
		}
		return tourlists;
	}

	@Override
	public String bookingTour() {
		// TODO Auto-generated method stub
		boolean check = true;
		List<TourEntity> listTours = new ArrayList<TourEntity>();
		String queryString = "SELECT * FROM tour WHERE tour_id = ?";
				
		try {
			do {
				System.out.println("Enter id: ");
				String id = input.next();
				connection = getConnection();
				stmt = connection.prepareStatement(queryString);
				stmt.setString(1, id);
				rs = stmt.executeQuery(); //Select	
				if(rs.next()) {
					if (id.equals(rs.getString("tour_id")) ) {						
						TourEntity cus = new TourEntity();	
						listTours = showListTour(id);			
						
						
						System.out.println("Id_tour: " + listTours.get(0).getTour_id() + "  ");
						System.out.print("Name_tour: " + listTours.get(0).getName_tour()+" -- ");
						System.out.print("location_start: " + listTours.get(0).getLocation_start()+" -- ");
						System.out.print("time_start: " + listTours.get(0).getTime_start()+" -- ");
						System.out.print("date_start: " + listTours.get(0).getDate_start()+" -- ");
						System.out.print("day_number: " + listTours.get(0).getDay_number() + "day --");
						System.out.println("price_tour: "+ listTours.get(0).getPrice_tour()+"$");
						
						int count = listTours.get(0).getMem_number() + 1;
//						System.out.println("plus: "+ count);
						cus.setMem_number(count);
						cus.setTour_id(id);
						plusNumberMember(cus);
						check = false;
					}
				}
				return id;
			} while (check);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			}
			catch (SQLException e) {
				System.out.println(e);
			}
			
		}
		return null;
	}
	

	@Override
	public void plusNumberMember(TourEntity tour) {
		// TODO Auto-generated method stub
		List<AccountEntity> lsRegister = new ArrayList<AccountEntity>();
		try {
			String queryString = "update tour set mem_number = ? where tour_id = ?";
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setInt(1, tour.getMem_number());
			stmt.setString(2, tour.getTour_id());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
