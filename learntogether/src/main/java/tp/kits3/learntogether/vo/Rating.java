package tp.kits3.learntogether.vo;

public class Rating {

    private Integer id;

    private Integer ratevalue;

    private Integer courseId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRatevalue() {
        return ratevalue;
    }

    public void setRatevalue(Integer ratevalue) {
        this.ratevalue = ratevalue;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public void CopyData(Rating param)
    {
        this.id = param.getId();
        this.ratevalue = param.getRatevalue();
        this.courseId = param.getCourseId();
    }
}
