package tp.kits3.learntogether.vo;

import java.sql.Date;

public class User {

    private Integer id;

    private String email;

    private String username;

    private String password;

    private String fullname;

    private String address;

    private Double amount;

    private Date birthdate;

    private Integer roleId;

    private String urlimg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getUrlimg() {
        return urlimg;
    }

    public void setUrlimg(String urlimg) {
        this.urlimg = urlimg;
    }

    public void CopyData(User param)
    {
        this.id = param.getId();
        this.email = param.getEmail();
        this.username = param.getUsername();
        this.password = param.getPassword();
        this.fullname = param.getFullname();
        this.address = param.getAddress();
        this.amount = param.getAmount();
        this.birthdate = param.getBirthdate();
        this.roleId = param.getRoleId();
        this.urlimg = param.getUrlimg();
    }
}