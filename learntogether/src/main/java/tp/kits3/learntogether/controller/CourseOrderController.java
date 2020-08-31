package tp.kits3.learntogether.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tp.kits3.learntogether.service.CourseOrderService;
import tp.kits3.learntogether.vo.CourseOrder;

@Controller
public class CourseOrderController {
	@Autowired
	private CourseOrderService courseOrderService;
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String orderCart(@RequestParam ("idcourse") int id, Model model) {
		System.out.println(id);
		CourseOrder courseitem = courseOrderService.addCart(id);
		System.out.println("price: "+ courseitem.getCourse().getCourseTitle());
		model.addAttribute("ItemCart", courseitem);
		return "cart";
	}
}
