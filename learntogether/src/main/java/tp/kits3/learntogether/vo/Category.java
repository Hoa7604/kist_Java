package tp.kits3.learntogether.vo;

public class Category {

    private Integer id;

    private String categoryName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryname(String categoryName) {
        this.categoryName = categoryName;
    }

    public void CopyData(Category param)
    {
        this.id = param.getId();
        this.categoryName = param.getCategoryName();
    }
}
