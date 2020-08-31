package tp.kits3.learntogether.vo;

public class Essay {

    private Integer id;

    private String title;

    private Integer testId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

	public Essay(String title, Integer testId) {
		super();
		this.title = title;
		this.testId = testId;
	}
    
}
