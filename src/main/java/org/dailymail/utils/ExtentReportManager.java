package org.dailymail.utils;


import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.dailymail.base.BaseUI;

public class ExtentReportManager extends BaseUI {

	public static ExtentReports extent;
	public static ExtentSparkReporter htmlReporter;

	/************** Getting report instance for Extent Report ****************/
	public static ExtentReports getReportInstance() {
		String repName = "TestReport-"+BaseUI.timestamp+".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")
				+ "/TestOutput/" + repName);
		try {
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")
					+ "/src/test/resources/extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		return extent;
	}
}