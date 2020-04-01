package testcase.login;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTester;
import base.CaseDataProvider;

public class LoginTester extends BaseTester {
	public  String getCurrentPageName() {
		return "登陆页面";
	}
	

	@Test(dataProvider = "dp", dataProviderClass = CaseDataProvider.class)
	public void login_failure_test_case(LoginFailureData loginFailData) throws InterruptedException {
		to("login_url");
		type("账号输入框", loginFailData.getPhone());
		type("密码输入框", loginFailData.getPassword());
		click("登陆按钮");
		if (getAllWindowHandles().size()>1) {
			switchToHandle(1);
		}
		
//		String actual = getElementTextNotNull("提示语");
//		Assert.assertEquals(actual, loginFailData.getExpectedTips());
		assertElementTextEquls("提示语", loginFailData.getExpectedTips());
	}

	//enabled=false,让测试用例失效，不执行
	@Test(dataProvider = "dp", dataProviderClass = CaseDataProvider.class)
	public void login_success_test_case(LoginSuccessData loginSuccessData) throws InterruptedException {
		to("login_url");
		type("账号输入框", loginSuccessData.getPhone());
		type("密码输入框", loginSuccessData.getPassword());
		click("登陆按钮");
		switchToHandle(1);
//		Assert.assertTrue(CurrentPageUrlContains(loginSuccessData.getPartialUrl()));
		assertPageUrlContains(loginSuccessData.getPartialUrl());
	}
}
