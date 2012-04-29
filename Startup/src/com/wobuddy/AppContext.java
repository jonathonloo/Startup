package com.wobuddy;

import java.util.Date;

import android.app.Application;

public class AppContext extends Application {

	
	private String islipData = "";
	private String hipData = "";
	private int hipCount = 0;
	private int islipCount = 0;

	private String lastUsedIslip = "";
	private String lastUsedHip = "";
	private String lastUsedTreadmill = "";

	public void clearIslipData() {
		this.islipData = lastUsedIslip;
		this.islipCount = 0;
	}

	public void clearHipData() {
		this.hipData = lastUsedHip;
		this.hipCount = 0;
	}

	public void setLastUsedHip(Date date) {
		lastUsedHip = "Last Used: " + date.toString();
	}

	public void setLastUsedIslip(Date date) {
		lastUsedIslip = "Last Used: " + date.toString();
	}
	

	public void setLastUsedTreadmill(Date date) {
		lastUsedTreadmill = "Last Used: " + date.toString();
	}


	/**
	 * @return the islipData
	 */
	public String getIslipData() {
		return islipData;
	}

	/**
	 * @param islipData
	 *            the islipData to set
	 */
	public void appendIslipData(String islipData) {
		this.islipData += '\n' + islipData;
	}

	/**
	 * @return the hipData
	 */
	public String getHipData() {
		return hipData;
	}

	/**
	 * @param hipData
	 *            the hipData to set
	 */
	public void appendHipData(String hipData) {
		hipCount++;
		this.hipData += "\nSet " + hipCount + ": " + hipData;
	}

	public int getIslipSetNum() {
		return islipCount;
	}

	public int getHipSetNum() {
		return hipCount;
	}
	
}
