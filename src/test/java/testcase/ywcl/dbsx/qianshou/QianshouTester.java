package testcase.ywcl.dbsx.qianshou;

import org.testng.annotations.Test;

import base.BaseTester;

public class QianshouTester extends BaseTester{
	@Override
	protected String getCurrentPageName() {
		return "点击签收页面";
	}
  @Test
  public void ywcl_dbsx_qianshou_test_case() {
	  to("login_after_url");
	  windowsMaximize();
	  click("业务处理");
	  click("待办事项");
	  switchTo("待办事项内联框架");
	  theadSleep(2000);
	  click("处理按钮");
	  switchTo("处理详情内联框架");
	  click("签收按钮");
	  theadSleep(2000);
	  jsExcute("window.scroll(0,document.body.scrollHeight)");
	  assertIsDisplayed("取消签收");
  }


}
