package com.wobuddy;

import android.app.Application;

public class AppContext extends Application {

	private String islipData = "";
	private String hipData = "";
	private int i = 0;

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
		i++;
		this.hipData += "\nSet " + i + ": " + hipData;
	}

}
