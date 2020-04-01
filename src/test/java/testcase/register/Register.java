//package testcase.register;
//
//import org.openqa.selenium.By;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import base.BaseTester;
//import testcase.login.LoginDataProvider;
//import testcase.register.RegisterDataProvider;
//
//public class Register extends BaseTester {
//
//	@Test(dataProvider = "dp", dataProviderClass = RegisterDataProvider.class)
//	public void register(String mobilephone, String password, String pwdconfirm, String verifycode, String expected) throws InterruptedException {
//		to("register_url");
//		type(By.id("mobilephone"), mobilephone);
//		type(By.id("password"), password);
//		type(By.id("pwdconfirm"), pwdconfirm);
//		type(By.id("verifycode"), verifycode);
//		click(By.id("signup-button"));
//		Thread.sleep(2000);
//		String actual = gText(By.className("tips"));
//		Assert.assertEquals(actual, expected);
//	}
//
//}
