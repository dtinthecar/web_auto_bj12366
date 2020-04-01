package testcase.quit;

import org.testng.annotations.Test;

import base.BaseTester;
import base.CaseDataProvider;

public class QuitTester extends BaseTester {
	@Override
	protected String getCurrentPageName() {
		return "退出";
	}

	@Test(dataProvider="dp",dataProviderClass=CaseDataProvider.class)
	public void quit_success_test_case(QuitSuccessData quitSuccessData) {
		to("search_url");
		windowsMaximize();
		click("退出下拉按钮");
		click("退出按钮");
		assertPageUrlContains(quitSuccessData.getPartialUrl());
	}

}
