package testcase.welcome.nextNotice;

import org.testng.annotations.Test;

import base.BaseTester;

public class NextNotice extends BaseTester{
	@Override
	protected String getCurrentPageName() {
		return "下一通知公告页面";
	}
  @Test
  public void welcome_nextNotice_success_test_case() {
	  to("login_after_url");
	  windowsMaximize();
	  switchTo("欢迎页内联框架");
	  theadSleep(2000);
	  click("通知链接");
	  switchToDefalut();
	  switchTo("通知公告详情内联框架");
	  theadSleep(2000);
	  click("下一公告");
	  switchTo("通知公告详情内联框架");
	  theadSleep(2000);
	  assertEnabled("上一公告");
  }

}
