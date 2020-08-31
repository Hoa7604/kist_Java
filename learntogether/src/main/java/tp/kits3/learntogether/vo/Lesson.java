package tp.kits3.learntogether.vo;

public class Lesson {

    private Integer id;

    private String title;

    private String urlvid;

    private Integer sectionId;

    private String urlimg;

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

    public String getUrlvid() {
        return urlvid;
    }

    public void setUrlvid(String urlvid) {
        this.urlvid = urlvid;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public String getUrlimg() {
        return urlimg;
    }

    public void setUrlimg(String urlimg) {
        this.urlimg = urlimg;
    }

    public void CopyData(Lesson param)
    {
        this.id = param.getId();
        this.title = param.getTitle();
        this.urlvid = param.getUrlvid();
        this.sectionId = param.getSectionId();
        this.urlimg = param.getUrlimg();
    }
}
