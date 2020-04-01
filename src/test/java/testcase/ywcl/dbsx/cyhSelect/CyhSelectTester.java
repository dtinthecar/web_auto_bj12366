package testcase.ywcl.dbsx.cyhSelect;

import org.testng.annotations.Test;

import base.BaseTester;

public class CyhSelectTester extends BaseTester{
	@Override
	protected String getCurrentPageName() {
		return "待办事项常用语选择页面";
	}
  @Test
  public void f() {
	  to("login_after_url");
		windowsMaximize();
		click("业务处理");
		click("待办事项");
		switchTo("待办事项内联框架");
		clickHandle("当前环节列表", "处理列表", "转工单提交");
		switchTo("处理详情内联框架");
		click("签收按钮");
		theadSleep(2000);
		click("常用语按钮");
		switchToDefalut();
		switchTo("常用语内联框架");
		clickCheckBox("常用语勾选框列表","常用语内容列表", "2");
		click("确定按钮");
		switchTo("待办事项内联框架");
		switchTo("处理详情内联框架");
		assertStringEquals("处理意见输入框");
//		System.out.println("处理意见为："+getInputValue("处理意见输入框"));
		
  }


}
