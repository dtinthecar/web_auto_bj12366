package testcase.ywcl.dbsx.allZsj;

import org.testng.annotations.Test;

import base.BaseTester;
import base.CaseDataProvider;

public class AllZsjTester extends BaseTester{
	@Override
	protected String getCurrentPageName() {
		return "工单转省局系统页面";
	}
  @Test(dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void ywcl_dbsx_allZsj_success_test_case(YwclDbsxAllZsjSuccessData zsjSuccessData) {
	  to("login_after_url");
		windowsMaximize();
		click("业务处理");
		click("待办事项");
		switchTo("待办事项内联框架");
		click("业务类别选择框");
		select1("业务类别列表", zsjSuccessData.getYwlb());
		click("查询按钮");
		clickHandle("当前环节列表", "处理列表", "业务编号列表",zsjSuccessData.getDqhj());
		switchTo("处理详情内联框架");
		click("签收按钮");
		theadSleep(2000);
		click("处理方式(zywzc)选择框");
		select1("处理方式列表", zsjSuccessData.getClfs1());
		if (zsjSuccessData.getYwlb().equals("投诉")) {
			click("显示更多按钮");
			String value=getElementTextNotNull("投诉类型框");
			clickRadio("sfslradio列表", "2");
			click("三级分类");
			switchToHandle(1);
			click("二级分类点击按钮");
			theadSleep(2000);		
            if (value.equals("系统服务商投诉")) {
            	click("三级分类点击按钮");
    			theadSleep(2000);
    			clickCheckBoxByIndex("三级分类节点列表", "3", "4");
			}else{
				clickCheckBoxByIndex("二级分类节点列表", "3", "4");
			}
			click("确定按钮");
			switchToHandle(0);
			switchTo("待办事项内联框架");
			switchTo("处理详情内联框架");
		}
		type("处理意见输入框", zsjSuccessData.getSuggestion());
		click("提交按钮");
		switchTo("待办事项内联框架");
		clickHandle("业务编号列表", "处理列表");
		switchTo("处理详情内联框架");
		click("签收按钮");
		theadSleep(2000);
		click("处理方式(zexzz)选择框");
		select1("处理方式列表", zsjSuccessData.getClfs2());
		type("处理意见输入框", zsjSuccessData.getSuggestion());
		click("提交按钮");
		switchTo("待办事项内联框架");
		clickHandle("业务编号列表", "处理列表");
		switchTo("处理详情内联框架");
		click("签收按钮");
		theadSleep(2000);
		click("处理方式(zsj)选择框");
		select1("处理方式列表", zsjSuccessData.getClfs3()); 
		click("接受机构选择框");
		select1("接受机构列表",zsjSuccessData.getSjjg());
		type("处理意见输入框", zsjSuccessData.getSuggestion());
		click("提交按钮");
		click("转省局确定按钮");
		assertClfsInDataBase(zsjSuccessData.getSql(), zsjSuccessData.getKey(), zsjSuccessData.getExpected());
	  
  }


}
