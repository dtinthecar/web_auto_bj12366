package listener;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import base.BaseTester;
import io.qameta.allure.Attachment;

public class WebAutoListener extends TestListenerAdapter {
    //tr对象包含了当前测试用例所有的信息
	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		//测试方法名
		String methodName=tr.getMethod().getMethodName();
		try {
			takeScreenShot(methodName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Attachment(value = "Failure in method {0}", type = "image/png")
	private byte[] takeScreenShot(String methodName) throws Exception {
		TakesScreenshot takesScreenshot = (TakesScreenshot) BaseTester.getDriver();
		return takesScreenshot.getScreenshotAs(OutputType.BYTES);
	}
}
