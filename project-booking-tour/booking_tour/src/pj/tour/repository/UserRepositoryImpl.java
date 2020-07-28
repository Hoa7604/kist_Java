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
	public List<UserEntity> findAll() {
		// TODO Auto-generated method stub
		List<UserEntity> lsUser = new ArrayList<UserEntity>();
		String queryString = "SELECT * FROM user";
		
		try {
			connection = getConnection();
			
			stmt = connection.prepareStatement(queryString);
			rs = stmt.executeQuery(); //Select
			
			while(rs.next()) {
				UserEntity user = new UserEntity();
				
				user.setId(rs.getInt(1));
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				//cus.setTeam(rs.getString("team"));
				
				lsUser.add(user);
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
		return lsUser;
}

	@Override
	public UserEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	@Override
	public int update() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int add() {
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
	public List<TourEntity> findTour() {
		// TODO Auto-generated method stub
		List<UserEntity> lsUser = new ArrayList<UserEntity>();
		String queryString = "SELECT * FROM Tour where name_tour = ? and date_tour = ?";
		String nameTour = null;
		String dateStart = null;
		try {
			connection = getConnection();
			
			stmt = connection.prepareStatement(queryString);
			rs = stmt.executeQuery(); //Select
			System.out.println("Enter location: ");
			nameTour = input.next();
			System.out.println("Enter date start: ");
			dateStart = input.next();
			if(rs.next()) {
				TourEntity tour = new TourEntity();
				
//				tour.setId(rs.getInt(1));
//				tour.setName(rs.getString("name"));
//				tour.setAddress(rs.getString("address"));
//				
//				lsUser.add(tour);
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
//		return lsUser;
		return null;
	}
	
}
