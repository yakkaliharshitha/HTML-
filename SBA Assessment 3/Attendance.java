package com.model;

import java.sql.Date;

public class Attendance {
	protected String stdname;
	protected int stdid;
	protected int stdsem;
	protected Date datee;
	protected String att;
	public String getStdname() {
		return stdname;
	}
	public void setStdname(String stdname) {
		this.stdname = stdname;
	}
	public int getStdid() {
		return stdid;
	}
	public void setStdid(int stdid) {
		this.stdid = stdid;
	}
	public int getStdsem() {
		return stdsem;
	}
	public void setStdsem(int stdsem) {
		this.stdsem = stdsem;
	}
	public Date getDatee() {
		return datee;
	}
	public void setDatee(Date datee) {
		this.datee = datee;
	}
	public String getAtt() {
		return att;
	}
	public void setAtt(String att) {
		this.att = att;
	}
	@Override
	public String toString() {
		return "Attendance [stdname=" + stdname + ", stdid=" + stdid + ", stdsem=" + stdsem + ", datee=" + datee
				+ ", att=" + att + "]";
	}
	public Attendance(String stdname, int stdid, int stdsem, Date date, String att) {
		super();
		this.stdname = stdname;
		this.stdid = stdid;
		this.stdsem = stdsem;
		this.datee = date;
		this.att = att;
	}
	public Attendance() {}

}
