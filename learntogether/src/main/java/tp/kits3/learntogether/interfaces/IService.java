package tp.kits3.learntogether.interfaces;

import java.util.List;

public interface IService<T extends Object> {

	// add
	void add(T t);

	// update
	void update(T t);

	// delete
	void delete(int id);

	// find all
	public List<T> findAll();

	// find one
	T findOne(int id);
}
