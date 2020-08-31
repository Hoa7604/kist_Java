package tp.kits3.learntogether.vo;

public class CourseOrder {

	private Integer orderitemID;

    private Course course;

    private Integer orderId;

    private Integer quantity;
    
    public CourseOrder() {
  		super();
  	}
    
    public Integer getQuantity() {
		return quantity;
	}

	public void setQuatity(Integer quantity) {
		this.quantity = quantity;
	}

    public Integer getOrderId() {
        return orderId;
    }

	public Integer getOrderitemID() {
		return orderitemID;
	}

	public void setOrderitemID(Integer orderitemID) {
		this.orderitemID = orderitemID;
	}

	public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

	public Course getCourse() {
			return course;
		}

	public void setCourse(Course course) {
			this.course = course;
		}

	public CourseOrder(Integer orderitemID, Course course, Integer orderId, Integer quantity) {
		super();
		this.orderitemID = orderitemID;
		this.course = course;
		this.orderId = orderId;
		this.quantity = quantity;
	}
	
	
}
