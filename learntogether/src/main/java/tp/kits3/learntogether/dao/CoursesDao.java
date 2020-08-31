package tp.kits3.learntogether.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import tp.kits3.learntogether.interfaces.ICourses;
import tp.kits3.learntogether.vo.Course;

@Repository
public class CoursesDao implements ICourses<Course> {
	private static SqlSessionFactory factory=null;
	public static SqlSessionFactory getInstance() {
		if(factory == null) {
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
	public void add(Course t) {
		// TODO Auto-generated method stub
		SqlSession session = getInstance().openSession();
		session.insert("mappers.courseMapper.insert",t);
		session.commit();
		session.close();
	}

	@Override
	public void update(Course t) {
		// TODO Auto-generated method stub
		SqlSession session = getInstance().openSession();
		session.update("mappers.courseMapper.update",t);
		session.commit();
		session.close();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		SqlSession session = getInstance().openSession();
		session.delete("mappers.courseMapper.delete", id);
		session.commit();
		session.close();
	}

	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		SqlSession session = getInstance().openSession();
		List<Course> list = session.selectList("mappers.courseMapper.selectAll");
		System.out.println("-----------------"+list);
//		session.close();
		return list;
	}

	@Override
	public Course findOne(int id) {
		// TODO Auto-generated method stub
		SqlSession session = getInstance().openSession();
		Course course = session.selectOne("mapper.courseMapper.selectOne", id);
		session.close();
		return course;
	}

}
