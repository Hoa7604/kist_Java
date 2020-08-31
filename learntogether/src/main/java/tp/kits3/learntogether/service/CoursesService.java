package tp.kits3.learntogether.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.learntogether.dao.CoursesDao;
import tp.kits3.learntogether.vo.Course;

@Service
public class CoursesService {
	@Autowired
    CoursesDao coursesdao;
	
	
	public List<Course> getAll(){
		List<Course> listcourse = coursesdao.findAll();
		System.out.println("-------------"+listcourse);
		return listcourse;
	}
	
	
}
