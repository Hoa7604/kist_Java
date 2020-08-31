package tp.kits3.learntogether.vo;

public class ResultEssay {

    private Integer id;

    private String score;

    private Integer essayId;

    private Integer instructorId;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Integer getEssayId() {
        return essayId;
    }

    public void setEssayId(Integer essayId) {
        this.essayId = essayId;
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

	public ResultEssay(String score, Integer essayId, Integer instructorId, Integer userId) {
		super();
		this.score = score;
		this.essayId = essayId;
		this.instructorId = instructorId;
		this.userId = userId;
	}
    
}
