package tp.kits3.learntogether.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import tp.kits3.learntogether.interfaces.ICategory;
import tp.kits3.learntogether.vo.Category;

public class CategoryDao implements ICategory<Category> {
	private static SqlSessionFactory factory =null;
	public static SqlSessionFactory getInstance() {
		if(factory==null) {
			try {
				Reader resource = Resources.getResourceAsReader("mybatis/mybatis-config.xml");
				factory = new SqlSessionFactoryBuilder().build(resource);
				resource.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return factory;
	}
	@Override
	public void add(Category t) {
		// TODO Auto-generated method stub
		SqlSession session = getInstance().openSession();
		session.insert("mappers.categoryMapper.insert", t);
		session.commit();
		session.close();
	}

	@Override
	public void update(Category t) {
		// TODO Auto-generated method stub
		SqlSession session = getInstance().openSession();
		session.update("mappers.categoryMapper.update", t);
		session.commit();
		session.close();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		SqlSession session =getInstance().openSession();
		session.delete("mappers.categoryMapper.delete", id);
		session.commit();
		session.close();
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		SqlSession session = getInstance().openSession();
		List<Category> list =  session.selectList("mappers.categoryMapper.selectAll");
		session.close();
		return list;
	}

	@Override
	public Category findOne(int id) {
		// TODO Auto-generated method stub
		SqlSession session = getInstance().openSession();
		Category category = session.selectOne("mappers.categoryMapper,selectOne", id);
		session.close();
		return category;
	}

}
