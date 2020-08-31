package tp.kits3.learntogether.vo;

public class ResultMultichoice {

    private Integer id;

    private Integer score;

    private Integer multichoiceId;

    private Integer instructorId;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getMultichoiceId() {
        return multichoiceId;
    }

    public void setMultichoiceId(Integer multichoiceId) {
        this.multichoiceId = multichoiceId;
    }

    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void CopyData(ResultMultichoice param)
    {
        this.id = param.getId();
        this.score = param.getScore();
        this.multichoiceId = param.getMultichoiceId();
        this.instructorId = param.getInstructorId();
        this.userId = param.getUserId();
    }
}