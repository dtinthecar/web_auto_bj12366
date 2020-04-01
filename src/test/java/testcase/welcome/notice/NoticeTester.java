package testcase.welcome.notice;

import org.testng.annotations.Test;

import base.BaseTester;
import base.CaseDataProvider;

public class NoticeTester extends BaseTester{
	@Override
	protected String getCurrentPageName() {
		return "通知公告页面";
	}
  @Test(dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void welcome_notice_success_test_case(WelcomeNoticeSuccessData noticeSuccessData) {
	  to("login_after_url");
	  windowsMaximize();
	  switchTo("欢迎页内联框架");
	  theadSleep(2000);
	  click("通知链接");
	  switchToDefalut();
	  switchTo("通知公告详情内联框架");
	  theadSleep(2000);
	  assertElementTextEquls("通知标题", noticeSuccessData.getTitle());
	  
	  
  }


}
