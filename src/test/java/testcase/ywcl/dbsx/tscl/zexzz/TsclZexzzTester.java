package testcase.ywcl.dbsx.tscl.zexzz;

import org.testng.annotations.Test;

import base.BaseTester;
import base.CaseDataProvider;

public class TsclZexzzTester extends BaseTester {
	@Override
	protected String getCurrentPageName() {
		return "转二线组长页面";
	}

	@Test(dataProvider = "dp", dataProviderClass = CaseDataProvider.class)
	public void ywcl_dbsx_tscl_zexzz_success_test_case(YwclDbsxTsclZexzzSuccessData successData) {
		to("login_after_url");
		windowsMaximize();
		click("业务处理");
		click("待办事项");
		switchTo("待办事项内联框架");
		click("业务类别选择框");
		select1("业务类别列表", successData.getYwlb());
		click("查询按钮");
		clickHandle("当前环节列表", "处理列表", "业务编号列表", successData.getDqhj());
		switchTo("处理详情内联框架");
		click("签收按钮");
		theadSleep(2000);
		click("处理方式选择框");
		select1("处理方式列表", successData.getClfs());
		type("处理意见输入框", successData.getSuggestion());
		click("提交按钮");
		switchTo("待办事项内联框架");
		assertGdTansferSubmit("业务编号列表", "当前环节列表", successData.getExpectedDqhj());

	}

	@Test(dataProvider = "dp", dataProviderClass = CaseDataProvider.class)
	public void ywcl_dbsx_tscl_zexzz_failure_test_case(YwclDbsxTsclZexzzFailureData failureData) {
		to("login_after_url");
		windowsMaximize();
		click("业务处理");
		click("待办事项");
		switchTo("待办事项内联框架");
		click("业务类别选择框");
		select1("业务类别列表", failureData.getYwlb());
		click("查询按钮");
		clickHandle("当前环节列表", "处理列表", "业务编号列表", failureData.getDqhj());
		switchTo("处理详情内联框架");
		click("签收按钮");
		theadSleep(2000);
		click("处理方式选择框");
		select1("处理方式列表", failureData.getClfs());
		type("处理意见输入框", failureData.getSuggestion());
		click("提交按钮");
		assertAlertText(failureData.getTips());

	}

}
