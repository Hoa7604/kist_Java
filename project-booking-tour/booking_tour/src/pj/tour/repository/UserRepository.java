package pj.tour.repository;

import java.util.List;

import pj.tour.entity.AccountEntity;
import pj.tour.entity.TourEntity;
import pj.tour.entity.UserEntity;

public interface UserRepository {
	List<TourEntity> findAll();
	UserEntity findById(int id);
	void findTour();
	void updateInfo();
	List<TourEntity> showListTour(String location);
	void inputMoney();
}
