package tp.kits3.learntogether.vo;

public class MultiChoice {

    private Integer id;

    private String title;

    private Integer rightanswer;

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

    public Integer getRightanswer() {
        return rightanswer;
    }

    public void setRightanswer(Integer rightanswer) {
        this.rightanswer = rightanswer;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public void CopyData(MultiChoice param)
    {
        this.id = param.getId();
        this.title = param.getTitle();
        this.rightanswer = param.getRightanswer();
        this.testId = param.getTestId();
    }
}
