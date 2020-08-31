package tp.kits3.learntogether.interfaces;

import java.awt.Menu;
import java.util.List;

public interface IMenuDao<T extends Menu> extends IRestaurant<T>{

	List<Menu> findAllByCategoryID(int categoryID);
}
