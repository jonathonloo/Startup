package com.wobuddy;

import android.app.Application;
import android.content.Context;

public class AppContext extends Application {

	private String islipData = "";
	private String hipData = "";
	private int hipCount = 0;
	private int islipCount = 0;

	public void clearIslipData() {
		this.islipData = "";
		this.islipCount = 0;
	}

	public void clearHipData() {
		this.hipData = "";
		this.hipCount = 0;
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
