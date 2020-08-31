package tp.kits3.learntogether.vo;

public class AnswerEssay {

    private Integer id;

    private String answer;

    private Integer userId;

    private Integer essayId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getEssayId() {
        return essayId;
    }

    public void setEssayId(Integer essayId) {
        this.essayId = essayId;
    }


    public void CopyData(AnswerEssay param)
    {
        this.id = param.getId();
        this.answer = param.getAnswer();
        this.userId = param.getUserId();
        this.essayId = param.getEssayId();
    }
}