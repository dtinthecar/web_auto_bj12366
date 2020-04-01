package base;

import java.sql.Driver;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver.Options;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public  class test extends BaseTester{
	

	public static void main(String[] args) {
		driver.get("http://test.lemonban.com/");
		Options options=driver.manage();
		options.addCookie(new Cookie("mobilephone", "13888888888"));
		options.addCookie(new Cookie("JSESSIONID", "232CAA50A2F1C6D73E7A1AB6EE464B6B"));
		driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/index.html?t=20181011");
		
	}

	@Override
	protected String getCurrentPageName() {
		// TODO Auto-generated method stub
		return null;
	}
}
