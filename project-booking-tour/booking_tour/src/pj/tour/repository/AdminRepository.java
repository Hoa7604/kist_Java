package pj.tour.repository;

import java.util.List;

import pj.tour.entity.TourEntity;
import pj.tour.entity.UserEntity;

public interface AdminRepository {
	List<UserEntity> findAll();
	void findTour();
	UserEntity findById(int id);
	void updateTour(TourEntity add);
	void deleteTour(TourEntity tour);
	void deleteUser();
	void addTour(TourEntity tour);
}
