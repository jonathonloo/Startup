package com.wobuddy;

import android.app.Application;

public class AppContext extends Application {

	private String islipData = "";
	private String hipData = "";

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
		islipData += '\n' + islipData;
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
		hipData += '\n' + hipData;
	}

}
