package tp.kits3.learntogether.vo;

public class Instructor {

    private Integer id;

    private Integer userId;

    private Integer experienceYear;

    private Integer numStudent;

    private Integer rateValue;

    private String skillLevel;

    private String urlImg;

    private String aboutMe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getExperienceyear() {
        return experienceYear;
    }

    public void setExperienceyear(Integer experienceyear) {
        this.experienceYear = experienceyear;
    }

    public Integer getNumstudent() {
        return numStudent;
    }

    public void setNumstudent(Integer numStudent) {
        this.numStudent = numStudent;
    }

    public Integer getRatevalue() {
        return rateValue;
    }

    public void setRatevalue(Integer rateValue) {
        this.rateValue = rateValue;
    }

    public String getSkilllevel() {
        return skillLevel;
    }

    public void setSkilllevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

	public Instructor(Integer userId, Integer experienceYear, Integer numStudent, Integer rateValue, String skillLevel,
			String urlImg, String aboutMe) {
		super();
		this.userId = userId;
		this.experienceYear = experienceYear;
		this.numStudent = numStudent;
		this.rateValue = rateValue;
		this.skillLevel = skillLevel;
		this.urlImg = urlImg;
		this.aboutMe = aboutMe;
	}


}