package tp.kits3.learntogether.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import tp.kits3.learntogether.interfaces.IResultEssay;
import tp.kits3.learntogether.vo.ResultEssay;

public class ResultEssayDao implements IResultEssay<ResultEssay> {


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
	public void add(ResultEssay t) {
		// TODO Auto-generated method stub
		SqlSession session = getInstance().openSession(); //connection DB
		session.insert("mappers.contactMapper.insert", t);
		session.commit();
		session.close();
	}

	@Override
	public void update(ResultEssay t) {
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
	public List<ResultEssay> findAll() {
		// TODO Auto-generated method stub
		SqlSession session = getInstance().openSession(); //connection DB	
		List<ResultEssay> list = session.selectList("mappers.orderMapper.selectAll");
		session.close();
		return list;
	}

	@Override
	public ResultEssay findOne(int id) {
		// TODO Auto-generated method stub
		SqlSession session = getInstance().openSession(); //connection DB	
		ResultEssay resultessay = session.selectOne("mappers.orderMapper.selectOne");
		session.close();
		return resultessay;
		
	}
	
}
