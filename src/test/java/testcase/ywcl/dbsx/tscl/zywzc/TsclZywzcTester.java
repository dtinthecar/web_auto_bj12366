package testcase.ywcl.dbsx.tscl.zywzc;

import org.testng.annotations.Test;

import base.BaseTester;
import base.CaseDataProvider;

public class TsclZywzcTester extends BaseTester {
	@Override
	protected String getCurrentPageName() {
		return "转业务支持页面";
	}

	@Test(enabled=false,dataProvider = "dp", dataProviderClass = CaseDataProvider.class)
	public void ywcl_dbsx_tscl_zywzc_success_test_case(YwclDbsxTsclZywzcSuccessData zywzcSuccessData) {
		to("login_after_url");
		windowsMaximize();
		click("业务处理");
		click("待办事项");
		switchTo("待办事项内联框架");
		click("业务类别选择框");
		select1("业务类别列表", zywzcSuccessData.getYwlb());
		click("查询按钮");
		clickHandle("当前环节列表", "处理列表", "业务编号列表",zywzcSuccessData.getDqhj());
		switchTo("处理详情内联框架");
		click("签收按钮");
		theadSleep(2000);
		click("处理方式选择框");
		select1("处理方式列表", zywzcSuccessData.getClfs());
		clickRadio("sfslradio列表", "2");
		click("三级分类");
		switchToHandle(1);
		click("服务言行点击按钮");
		theadSleep(2000);
		clickCheckBoxByIndex("服务言行节点列表", "3", "4");
		click("确定按钮");
		switchToHandle(0);
		switchTo("待办事项内联框架");
		switchTo("处理详情内联框架");
		type("处理意见输入框", zywzcSuccessData.getSuggestion());
		click("提交按钮");
		switchTo("待办事项内联框架");
		assertGdTansferSubmit("业务编号列表", "当前环节列表", zywzcSuccessData.getExpectedDqhj());

	}
	@Test(dataProvider = "dp", dataProviderClass = CaseDataProvider.class)
	public void ywcl_dbsx_tscl_zywzc_failure_test_case(YwclDbsxTsclZywzcFailureData failureData){
		to("login_after_url");
		windowsMaximize();
		click("业务处理");
		click("待办事项");
		switchTo("待办事项内联框架");
		click("业务类别选择框");
		select1("业务类别列表", failureData.getYwlb());
		click("查询按钮");
		clickHandle("当前环节列表", "处理列表", "业务编号列表",failureData.getDqhj());
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
