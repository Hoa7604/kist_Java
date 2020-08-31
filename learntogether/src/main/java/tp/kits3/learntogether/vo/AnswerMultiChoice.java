package tp.kits3.learntogether.vo;

public class AnswerMultiChoice {

    private Integer id;

    private Integer questionId;

    private String answer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void CopyData(AnswerMultiChoice param)
    {
        this.id = param.getId();
        this.questionId = param.getQuestionId();
        this.answer = param.getAnswer();
    }
}
