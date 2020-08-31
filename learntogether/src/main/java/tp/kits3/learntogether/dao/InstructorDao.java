package tp.kits3.learntogether.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import tp.kits3.learntogether.interfaces.IInstructor;
import tp.kits3.learntogether.vo.Instructor;

public class InstructorDao implements IInstructor<Instructor> {


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
	public void add(Instructor t) {
		// TODO Auto-generated method stub
		SqlSession session = getInstance().openSession();
		session.insert("mappers.categoryMapper.insert", t);
		session.commit();
		session.close();
	}

	@Override
	public void update(Instructor t) {
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
	public List<Instructor> findAll() {
		// TODO Auto-generated method stub
		SqlSession session = getInstance().openSession();
		List<Instructor> list =  session.selectList("mappers.categoryMapper.selectAll");
		session.close();
		return list;
	}

	@Override
	public Instructor findOne(int id) {
		// TODO Auto-generated method stub
		SqlSession session = getInstance().openSession();
		Instructor instructor = session.selectOne("mappers.categoryMapper,selectOne", id);
		session.close();
		return instructor;
	}

}
