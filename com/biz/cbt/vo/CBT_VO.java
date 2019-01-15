package com.biz.cbt.vo;

public class CBT_VO {
	private long id;
	private String cb_que;
	private String cb_fir;
	private String cb_sec;
	private String cb_thi;
	private String cb_fou;
	private int cb_ans;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCb_que() {
		return cb_que;
	}
	public void setCb_que(String cb_que) {
		this.cb_que = cb_que;
	}
	public String getCb_fir() {
		return cb_fir;
	}
	public void setCb_fir(String cb_fir) {
		this.cb_fir = cb_fir;
	}
	public String getCb_sec() {
		return cb_sec;
	}
	public void setCb_sec(String cb_sec) {
		this.cb_sec = cb_sec;
	}
	public String getCb_thi() {
		return cb_thi;
	}
	public void setCb_thi(String cb_thi) {
		this.cb_thi = cb_thi;
	}
	public String getCb_fou() {
		return cb_fou;
	}
	public void setCb_fou(String cb_fou) {
		this.cb_fou = cb_fou;
	}
	public int getCb_ans() {
		return cb_ans;
	}
	public void setCb_ans(int cb_ans) {
		this.cb_ans = cb_ans;
	}
	@Override
	public String toString() {
		return "CBT_VO [id=" + id + ", cb_que=" + cb_que + ", cb_fir=" + cb_fir + ", cb_sec=" + cb_sec + ", cb_thi="
				+ cb_thi + ", cb_fou=" + cb_fou + ", cb_ans=" + cb_ans + "]";
	}
	
	
}