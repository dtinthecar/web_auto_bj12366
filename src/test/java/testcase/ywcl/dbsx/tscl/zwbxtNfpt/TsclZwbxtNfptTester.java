package testcase.ywcl.dbsx.tscl.zwbxtNfpt;

import org.testng.annotations.Test;

import base.BaseTester;
import base.CaseDataProvider;

public class TsclZwbxtNfptTester extends BaseTester{
	@Override
	protected String getCurrentPageName() {
		return "转外部系统纳服平台页面";
	}
  @Test(dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void ywcl_dbsx_tscl_zwbxtNfpt_success_test_case(YwclDbsxTsclZwbxtNfptSuccessData zwbxtNfptSuccessData) {
	  to("login_after_url");
		windowsMaximize();
		click("业务处理");
		click("待办事项");
		switchTo("待办事项内联框架");
		click("业务类别选择框");
		select1("业务类别列表", zwbxtNfptSuccessData.getYwlb());
		click("查询按钮");
		clickHandle("当前环节列表", "处理列表", "业务编号列表",zwbxtNfptSuccessData.getDqhj());
		switchTo("处理详情内联框架");
		click("签收按钮");
		theadSleep(2000);
		click("处理方式选择框");
		select1("处理方式列表", zwbxtNfptSuccessData.getClfs());
		click("外部系统选择框");
		select1("外部系统列表", zwbxtNfptSuccessData.getXzwbxt());
		type("处理意见输入框", zwbxtNfptSuccessData.getSuggestion());
		click("提交按钮");
		assertClfsInDataBase(zwbxtNfptSuccessData.getSql(), zwbxtNfptSuccessData.getKey(), zwbxtNfptSuccessData.getExpected());
  }


}
