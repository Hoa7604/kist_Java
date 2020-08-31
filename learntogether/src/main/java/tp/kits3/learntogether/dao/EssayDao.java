package tp.kits3.learntogether.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import tp.kits3.learntogether.interfaces.IEssay;
import tp.kits3.learntogether.vo.Essay;

public class EssayDao implements IEssay<Essay> {

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
	public void add(Essay t) {
		// TODO Auto-generated method stub
		SqlSession session = getInstance().openSession();
		session.insert("mappers.categoryMapper.insert", t);
		session.commit();
		session.close();
	}

	@Override
	public void update(Essay t) {
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
	public List<Essay> findAll() {
		// TODO Auto-generated method stub
		SqlSession session = getInstance().openSession();
		List<Essay> list =  session.selectList("mappers.categoryMapper.selectAll");
		session.close();
		return list;
	}

	@Override
	public Essay findOne(int id) {
		// TODO Auto-generated method stub
		SqlSession session = getInstance().openSession();
		Essay essay = session.selectOne("mappers.categoryMapper,selectOne", id);
		session.close();
		return essay;
	}
	
}
