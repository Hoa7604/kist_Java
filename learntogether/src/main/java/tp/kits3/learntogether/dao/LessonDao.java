package tp.kits3.learntogether.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import tp.kits3.learntogether.interfaces.IlessonDao;
import tp.kits3.learntogether.vo.Lesson;

public class LessonDao implements IlessonDao<Lesson>{

private static SqlSessionFactory factory = null; //co static thi bo gia tri khoi tao vao
	
	//need static method to factory field
	public static SqlSessionFactory getInstance() {
		if(factory == null) {
			//create Factory
			try {
				Reader resource = Resources.getResourceAsReader("mybatis/mybatis-config.xml"); 
				factory = new SqlSessionFactoryBuilder().build(resource);
				resource.close(); // close file (mybatis/mybatis-config.xml)
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return factory;
	}//end factory
	
	@Override
	public void add(Lesson t) {
		// TODO Auto-generated method stub
		SqlSession session = getInstance().openSession(); //connection DB
		session.insert("mappers.contactMapper.insert", t);
		session.commit();
		session.close();
	}

	@Override
	public void update(Lesson t) {
		// TODO Auto-generated method stub
		SqlSession session = getInstance().openSession(); //connection DB
		session.update("mappers.orderMapper.update", t);
		session.commit();
		session.close();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		SqlSession session = getInstance().openSession(); //connection DB	
		session.delete("mappers.contactMapper.delete", id);
		session.commit();
		session.close();
	}

	@Override
	public List<Lesson> findAll() {
		// TODO Auto-generated method stub
		SqlSession session = getInstance().openSession(); //connection DB	
		List<Lesson> list = session.selectList("mappers.orderMapper.selectAll");
		session.close();
		return list;
	}

	@Override
	public Lesson findOne(int id) {
		// TODO Auto-generated method stub
		SqlSession session = getInstance().openSession(); //connection DB	
		Lesson lesson = session.selectOne("mappers.orderMapper.selectOne");
		session.close();
		return lesson;
		
	}


}
