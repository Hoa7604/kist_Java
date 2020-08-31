package tp.kits3.learntogether.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import tp.kits3.learntogether.interfaces.ICourseOrderDao;
import tp.kits3.learntogether.vo.CourseOrder;

@Repository
public class CourseOrderDao implements ICourseOrderDao<CourseOrder>{

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
	public void add(CourseOrder t) {
		// TODO Auto-generated method stub
		SqlSession session = getInstance().openSession();
		session.insert("mappers.courseOrderMapper.insert", t);
		session.commit();
		session.close();
	}

	@Override
	public void update(CourseOrder t) {
		// TODO Auto-generated method stub
		SqlSession session = getInstance().openSession();
		session.update("mappers.courseOrderMapper.update", t);
		session.commit();
		session.close();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		SqlSession session =getInstance().openSession();
		session.delete("mappers.courseOrderMapper.delete", id);
		session.commit();
		session.close();
	}

	@Override
	public List<CourseOrder> findAll() {
		// TODO Auto-generated method stub
		SqlSession session = getInstance().openSession();
		List<CourseOrder> list =  session.selectList("mappers.courseOrderMapper.selectAll");
		session.close();
		return list;
	}

	@Override
	public CourseOrder findOne(int id) {
		// TODO Auto-generated method stub
		System.out.println("dsdsds : "+id);
		SqlSession session = getInstance().openSession();
		CourseOrder courseorder = session.selectOne("mappers.courseOrderMapper.selectOne", id);
		System.out.println("courseorder: "+ courseorder.toString());
		session.close();
		return courseorder;
	}
}
