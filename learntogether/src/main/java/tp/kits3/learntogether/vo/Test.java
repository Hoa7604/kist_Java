package tp.kits3.learntogether.vo;

public class Test {

    private Integer id;

    private String title;

    private Integer numquestion;

    private Double score;

    private Integer sectionId;

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

    public Integer getNumquestion() {
        return numquestion;
    }

    public void setNumquestion(Integer numquestion) {
        this.numquestion = numquestion;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public void CopyData(Test param)
    {
        this.id = param.getId();
        this.title = param.getTitle();
        this.numquestion = param.getNumquestion();
        this.score = param.getScore();
        this.sectionId = param.getSectionId();
    }
}
