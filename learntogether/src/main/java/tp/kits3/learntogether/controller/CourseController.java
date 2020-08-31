package tp.kits3.learntogether.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tp.kits3.learntogether.service.CoursesService;
import tp.kits3.learntogether.vo.Course;

@Controller
public class CourseController {
	@Autowired
	private CoursesService courseservice;
	
	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {		
		List<Course> listcourse = courseservice.getAll();
		model.addAttribute("ListCourses", listcourse);
		return "courses";
	}
}
