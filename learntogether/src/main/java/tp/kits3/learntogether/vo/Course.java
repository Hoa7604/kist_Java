package tp.kits3.learntogether.vo;

import java.sql.Timestamp;

public class Course {

    private Integer id;

    private String courseTitle;

    private String description;

    private Double priceCourse;

    private String language;

    private Integer numStudent;

    private Timestamp createDate;

    private Timestamp lasteUpdate;

    private Integer courseInfoId;

    private Integer instructorId;

    private Integer categoryId;

    private Integer certificateId;

    private String urlImg;

    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPriceCourse() {
        return priceCourse;
    }

    public void setPriceCourse(Double priceCourse) {
        this.priceCourse = priceCourse;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getNumStudent() {
        return numStudent;
    }

    public void setNumStudent(Integer numStudent) {
        this.numStudent = numStudent;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getLasteUpdate() {
        return lasteUpdate;
    }

    public void setLasteUpdate(Timestamp lasteUpdate) {
        this.lasteUpdate = lasteUpdate;
    }

    public Integer getCourseInfoId() {
        return courseInfoId;
    }

    public void setCourseInfoId(Integer courseInfoId) {
        this.courseInfoId = courseInfoId;
    }

    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Integer certificateId) {
        this.certificateId = certificateId;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void CopyData(Course param)
    {
        this.id = param.getId();
        this.courseTitle = param.getCourseTitle();
        this.description = param.getDescription();
        this.priceCourse = param.getPriceCourse();
        this.language = param.getLanguage();
        this.numStudent = param.getNumStudent();
        this.createDate = param.getCreateDate();
        this.lasteUpdate = param.getLasteUpdate();
        this.courseInfoId = param.getCourseInfoId();
        this.instructorId = param.getInstructorId();
        this.categoryId = param.getCategoryId();
        this.certificateId = param.getCertificateId();
        this.urlImg = param.getUrlImg();
        this.status = param.getStatus();
    }
}
