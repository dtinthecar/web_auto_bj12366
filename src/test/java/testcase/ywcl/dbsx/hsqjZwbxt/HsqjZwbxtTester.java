package testcase.ywcl.dbsx.hsqjZwbxt;

import org.testng.annotations.Test;

import base.BaseTester;
import base.CaseDataProvider;

public class HsqjZwbxtTester extends BaseTester{
	@Override
	protected String getCurrentPageName() {
		return "汇算清缴转外部系统";
	}
  @Test(dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void ywcl_dbsx_hsqjZwbxt_success_test_case(YwclDbsxHsqjZwbxtSuccessData zwbxtSuccessData) {
	  to("login_after_url");
		windowsMaximize();
		click("业务处理");
		click("待办事项");
		switchTo("待办事项内联框架");
		click("业务类别选择框");
		select1("业务类别列表", "汇算清缴");
		click("查询按钮");
		clickHandle("当前环节列表", "处理列表", "业务编号列表",zwbxtSuccessData.getDqhj());
		switchTo("处理详情内联框架");
		click("签收按钮");
		theadSleep(2000);
		click("处理方式(zywzc)选择框");
		select1("处理方式列表", zwbxtSuccessData.getClfs1());
		type("处理意见输入框", "已处理");
		click("提交按钮");
		switchTo("待办事项内联框架");
		clickHandle("业务编号列表", "处理列表");
		switchTo("处理详情内联框架");
		click("签收按钮");
		theadSleep(2000);
		click("处理方式(zexzz)选择框");
		select1("处理方式列表", zwbxtSuccessData.getClfs2());
		type("处理意见输入框", zwbxtSuccessData.getSuggestion());
		click("提交按钮");
		switchTo("待办事项内联框架");
		clickHandle("业务编号列表", "处理列表");
		switchTo("处理详情内联框架");
		click("签收按钮");
		theadSleep(2000);
		click("处理方式(zwbxt)选择框");
		select1("处理方式列表", zwbxtSuccessData.getClfs3()); 
		click("外部系统选择框");
		select1("外部系统列表",zwbxtSuccessData.getWbxt());
		click("接收部门选择框");
		select1("接收部门列表", zwbxtSuccessData.getDept());
		type("处理意见输入框", zwbxtSuccessData.getSuggestion());
		click("提交按钮");
		assertClfsInDataBase(zwbxtSuccessData.getSql(), zwbxtSuccessData.getKey(), zwbxtSuccessData.getExpected());
  }


}
