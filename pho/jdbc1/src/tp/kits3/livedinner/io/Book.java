package tp.kits3.livedinner.io;

//import java.sql.Time;
import java.sql.Timestamp;

//import com.sun.jmx.snmp.Timestamp;

public class Book {

	/*
	 * Vo os value Object (== Table of DB)
	 * Model, Entity
	 * 
	 * DB connect, crud, convert too comfortable
	 * DB framework
	 * -mybatis : already set db tables by DB architector : spring MVC
	 * -hibernate : new db tables by developer : spring boot
	 * 
	 * 1. config.xml <- for have a file container setup mybatis
	 * 2. mapper.xml <- for contain SQL 
	 * 
	 */
	
    private Integer bkid;

    private String bkname;

    private String bkemail;

    private String bkphone;

    private Timestamp bktime;

    private Integer bknum;

    private String booking;

    private String bkmemo;

    public Integer getBkid() {
        return bkid;
    }

    public void setBkid(Integer bkid) {
        this.bkid = bkid;
    }

    public String getBkname() {
        return bkname;
    }

    public void setBkname(String bkname) {
        this.bkname = bkname;
    }

    public String getBkemail() {
        return bkemail;
    }

    public void setBkemail(String bkemail) {
        this.bkemail = bkemail;
    }

    public String getBkphone() {
        return bkphone;
    }

    public void setBkphone(String bkphone) {
        this.bkphone = bkphone;
    }

    public Timestamp getBktime() {
        return bktime;
    }

    public void setBktime(Timestamp bktime) {
        this.bktime = bktime;
    }

    public Integer getBknum() {
        return bknum;
    }

    public void setBknum(Integer bknum) {
        this.bknum = bknum;
    }

    public String getBooking() {
        return booking;
    }

    public void setBooking(String booking) {
        this.booking = booking;
    }

    public String getBkmemo() {
        return bkmemo;
    }

    public void setBkmemo(String bkmemo) {
        this.bkmemo = bkmemo;
    }

    @Override
	public String toString() {
		return "Book [bkid=" + bkid + ", bkname=" + bkname + ", bkemail=" + bkemail + ", bkphone=" + bkphone
				+ ", bktime=" + bktime + ", bknum=" + bknum + ", booking=" + booking + ", bkmemo=" + bkmemo + "]";
	}

	// Book ëª¨ë�¸ ë³µì‚¬
    public void CopyData(Book param)
    {
        this.bkid = param.getBkid();
        this.bkname = param.getBkname();
        this.bkemail = param.getBkemail();
        this.bkphone = param.getBkphone();
        this.bktime = param.getBktime();
        this.bknum = param.getBknum();
        this.booking = param.getBooking();
        this.bkmemo = param.getBkmemo();
    }
}