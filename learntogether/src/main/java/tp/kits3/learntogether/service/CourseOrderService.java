package tp.kits3.learntogether.service;

import java.util.HashMap;

/*import java.util.HashMap;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.learntogether.dao.CourseOrderDao;
import tp.kits3.learntogether.dao.CoursesDao;
import tp.kits3.learntogether.vo.Course;
import tp.kits3.learntogether.vo.CourseOrder;

@Service
public class CourseOrderService {
	@Autowired
	private CoursesDao coursedao;
	
	
	public CourseOrder addCart(int id) { 
		CourseOrder courseorder = new CourseOrder();
		Course course = coursedao.findOne(id);
		if (course != null) {
			courseorder.setCourse(course);
		}
		/* System.out.println("price"+course.getPriceCourse()); */
		
		return courseorder; 
	}
	

	/*
	 * public HashMap<Integer, CourseOrder> addCart1(int id, HashMap<Integer,
	 * CourseOrder> cart){ CourseOrder courseorder = new CourseOrder(); courseorder
	 * = courseorderdao.findOne(id);
	 * System.out.println("output: "+courseorder.toString()); return cart; }
	 */
	 
}

