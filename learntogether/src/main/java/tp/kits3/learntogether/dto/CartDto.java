package tp.kits3.learntogether.dto;

import tp.kits3.learntogether.vo.Course;

public class CartDto {
	private Course course;
	private Double totalPrice;
	
	public CartDto() {
		super();
	}
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public CartDto( Course course, Double totalPrice) {
		super();
		this.course = course;
		this.totalPrice = totalPrice;
	}
	
}
