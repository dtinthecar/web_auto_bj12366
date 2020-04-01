package testcase.ywcl.dbsx.tscl.bj;

import org.testng.annotations.Test;

import base.BaseTester;
import base.CaseDataProvider;

public class TsclBjTester extends BaseTester{
	@Override
	protected String getCurrentPageName() {
		return "投诉办结页面";
	}
  @Test(dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void ywcl_dbsx_tscl_bj_success_test_case(YwclDbsxTsclBjSuccessData bjSuccessData) {
	  to("login_after_url");
		windowsMaximize();
		click("业务处理");
		click("待办事项");
		switchTo("待办事项内联框架");
		click("业务类别选择框");
		select1("业务类别列表", bjSuccessData.getYwlb());
		click("查询按钮");
		clickHandle("当前环节列表", "处理列表", "业务编号列表",bjSuccessData.getDqhj());
		switchTo("处理详情内联框架");
		click("签收按钮");
		theadSleep(2000);
		click("处理方式选择框");
		select1("处理方式列表", bjSuccessData.getClfs());
		type("处理意见输入框", bjSuccessData.getSuggestion());
		click("提交按钮");
		click("确定按钮");
		assertClfsInDataBase(bjSuccessData.getSql(), bjSuccessData.getKey(), bjSuccessData.getExpected());
  }


}
