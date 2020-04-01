package testcase.welcome.noticeCollect;

import org.testng.annotations.Test;

import base.BaseTester;
import base.CaseDataProvider;

public class NoticeCollectTester extends BaseTester{
	@Override
	protected String getCurrentPageName() {
		return "通知公告收藏页面";
	}
  @Test(dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void welcome_noticeCollect_success_test_case(WelcomeNoticeCollectSuccessData collectSuccessData) {
	  to("login_after_url");
	  windowsMaximize();
	  switchTo("欢迎页内联框架");
	  theadSleep(2000);
	  click("通知链接");
	  switchToDefalut();
	  switchTo("通知公告详情内联框架");
	  theadSleep(2000);
	  click("收藏按钮");
	  switchToDefalut();
	  switchTo("收藏内联框架");
	  type("收藏文件名称输入框", collectSuccessData.getCollectName());
	  click("收藏目录名称选择框");
	  click("保存按钮");
	  switchToDefalut();
	  assertElementTextEquls("收藏成功提示", collectSuccessData.getTips());
	  
  }


}
