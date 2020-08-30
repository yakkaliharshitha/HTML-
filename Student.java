package com.model;

public class Student {
	protected int stdid ;
	protected String stdname ;
	protected int stdsem;
	protected int stdroll ; 
	protected String stdadd ;
	protected int stdphnno ;
	public int getStdid() {
		return stdid;
	}
	public void setStdid(int stdid) {
		this.stdid = stdid;
	}
	public String getStdname() {
		return stdname;
	}
	public void setStdname(String stdname) {
		this.stdname = stdname;
	}
	public int getStdsem() {
		return stdsem;
	}
	public void setStdsem(int stdsem) {
		this.stdsem = stdsem;
	}
	public int getStdroll() {
		return stdroll;
	}
	public void setStdroll(int stdroll) {
		this.stdroll = stdroll;
	}
	public String getStdadd() {
		return stdadd;
	}
	public void setStdadd(String stdadd) {
		this.stdadd = stdadd;
	}
	public int getStdphnno() {
		return stdphnno;
	}
	public void setStdphnno(int stdphnno) {
		this.stdphnno = stdphnno;
	}
	public Student(int stdid, String stdname, int stdsem, int stdroll, String stdadd, int stdphnno) {
		super();
		this.stdid = stdid;
		this.stdname = stdname;
		this.stdsem = stdsem;
		this.stdroll = stdroll;
		this.stdadd = stdadd;
		this.stdphnno = stdphnno;
	}
	@Override
	public String toString() {
		return "Student [stdid=" + stdid + ", stdname=" + stdname + ", stdsem=" + stdsem + ", stdroll=" + stdroll
				+ ", stdadd=" + stdadd + ", stdphnno=" + stdphnno + "]";
	}
	
	public Student (){
		
		
	}
	

}
