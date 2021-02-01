package com.lawyeraid.model;

public class TermModel {

	private String termDesc;
	private int termDuration;

	public TermModel() {
		
	}
	
	public TermModel(String termDesc, int termDuration) {
		this.termDesc = termDesc;
		this.termDuration = termDuration;
	}

	public String getTermDesc() {
		return termDesc;
	}

	public void setTermDesc(String termDesc) {
		this.termDesc = termDesc;
	}

	public int getTermDuration() {
		return termDuration;
	}

	public void setTermDuration(int termDuration) {
		this.termDuration = termDuration;
	}
	
	@Override
	public String toString() {
		return this.termDesc;
	}

}
