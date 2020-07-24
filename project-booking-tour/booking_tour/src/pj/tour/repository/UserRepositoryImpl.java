package pj.tour.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pj.tour.entity.AccountEntity;
import pj.tour.entity.UserEntity;
import pj.tour.config.ConnectionFactory;

public class UserRepositoryImpl implements UserRepository{
	
	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
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
	public List<AccountEntity> registerAcount() {
		// TODO Auto-generated method stub
		List<AccountEntity> lsRegister = new ArrayList<AccountEntity>();
		String queryString = "Insert INTO " + "user_account (username_ac, password_ac, nameaccount)" + "VALUES (?,?,?,?)";
		try {
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			rs = stmt.executeQuery();
			while (rs.next()) {
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public int add() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
