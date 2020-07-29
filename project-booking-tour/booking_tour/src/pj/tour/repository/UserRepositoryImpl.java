package pj.tour.repository;

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

public class UserRepositoryImpl implements UserRepository{
	
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
	public UserEntity findById(int id) {
		// TODO Auto-generated method stub
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
	public void findTour(){
		// TODO Auto-generated method stub
		boolean check = true;
		List<TourEntity> listTours = new ArrayList<TourEntity>();
		String queryString = "SELECT * FROM Tour where location_start = ?";
		
		try {
			do {
				System.out.println("Enter location: ");
				String location = input.next();
				connection = getConnection();
				stmt = connection.prepareStatement(queryString);
				stmt.setString(1, location);
				rs = stmt.executeQuery(); //Select	
				
				if(rs.next()) {
					if (location.equals(rs.getString("location_start")) ) {						
						listTours = showListTour(location);
						for (int i = 0; i < listTours.size(); i++) {
							System.out.println("Id_tour: " + listTours.get(i).getTour_id() + "  ");
							System.out.print("Name_tour: " + listTours.get(i).getName_tour()+" -- ");
							System.out.print("location_start: " + listTours.get(i).getLocation_start()+" -- ");
							System.out.print("time_start: " + listTours.get(i).getTime_start()+" -- ");
							System.out.print("date_start: " + listTours.get(i).getDate_start()+" -- ");
							System.out.println("day_number: " + listTours.get(i).getDay_number() + " day");
						}
						check = false;
					}
				}
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
	}

	@Override
	public List<TourEntity> showListTour(String location) {
		// TODO Auto-generated method stub
		
		List<TourEntity> tourlists = new ArrayList<TourEntity>();
		String queryString = "SELECT * FROM tour WHERE location_start = ?";
		
		try {
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1, location);
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

	
}
