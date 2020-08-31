package tp.kits3.learntogether.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import tp.kits3.learntogether.interfaces.IService;

public class Service{
	private static SqlSessionFactory factory = null;

	private static SqlSessionFactory getInstance() {
		if (factory == null) {
			try {
				Reader resource = Resources.getResourceAsReader("mybatis/mybatis-config.xml");
				factory = new SqlSessionFactoryBuilder().build(resource);
				resource.close(); // close mybatis.xml
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return factory;
	}
}
