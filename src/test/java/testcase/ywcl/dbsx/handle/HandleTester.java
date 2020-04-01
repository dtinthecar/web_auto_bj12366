package testcase.ywcl.dbsx.handle;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseTester;

public class HandleTester extends BaseTester{
	@Override
	protected String getCurrentPageName() {
		return "点击处理页面";
	}
  @Test
  public void ywcl_dbsx_handle_success_test_case() {
	  to("login_after_url");
	  windowsMaximize();
	  click("业务处理");
	  click("待办事项");
	  switchTo("业务处理内联框架");
	  theadSleep(2000);
//	  List<WebElement> list=getElements("处理按钮");
//	  click("查询按钮");
	  click("处理按钮");
	  switchTo("处理详情内联框架");
	  assertEnabled("签收按钮");
  }


}
