package tp.kits3.learntogether.interfaces;

import java.util.List;

import tp.kits3.learntogether.vo.CourseOrder;

public interface ICourseOrderDao <T extends CourseOrder> extends IRestaurant<T>{

	@Override
	default void add(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	default void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	default List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default T findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
