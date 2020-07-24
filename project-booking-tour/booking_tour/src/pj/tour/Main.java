package pj.tour;

import java.util.ArrayList;
import java.util.List;

import pj.tour.entity.UserEntity;
import pj.tour.repository.UserRepository;
import pj.tour.repository.UserRepositoryImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserRepository userReponsitory = new UserRepositoryImpl();
		List<UserEntity> ls = new ArrayList<UserEntity>();
		ls = userReponsitory.findAll();
		for (int i = 0; i < ls.size(); i++) {
			System.out.println(ls.get(i).getName());
		}
	}

}
