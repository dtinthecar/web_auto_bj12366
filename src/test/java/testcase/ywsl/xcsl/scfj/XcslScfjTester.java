package testcase.ywsl.xcsl.scfj;

import org.testng.annotations.Test;

import base.BaseTester;
import base.CaseDataProvider;

public class XcslScfjTester extends BaseTester{
	@Override
	protected String getCurrentPageName() {
		return "现场受理附件上传";
	}	
  @Test(dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void ywsl_xcsl_scfj_success_test_case(YwslXcslScfjSuccessData scfjSuccessData) {
	  to("login_after_url");
		windowsMaximize();
		click("现场受理按钮");
		switchToHandle(1);
		switchTo("现场受理内联框架");
		click("附件上传按钮");
		switchToDefalut();
		switchTo("附件上传内联框架");
		type("附件上传", scfjSuccessData.getPath());
		click("开始上传按钮");
		assertAlertText(scfjSuccessData.getTips());
  }

  @Test(dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void ywsl_xcsl_scfj_failure_test_case(YwslXcslScfjFailureData scfjFailureData) {
	  to("login_after_url");
		windowsMaximize();
		click("现场受理按钮");
		switchToHandle(1);
		switchTo("现场受理内联框架");
		click("附件上传按钮");
		switchToDefalut();
		switchTo("附件上传内联框架");
		type("附件上传", scfjFailureData.getPath());
		click("开始上传按钮");
		assertAlertText(scfjFailureData.getTips());
  }
}
