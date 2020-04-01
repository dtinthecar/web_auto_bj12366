package testcase.xzs.scjgl.edit;

import org.testng.annotations.Test;

import base.BaseTester;
import base.CaseDataProvider;
import pojo.ExcelObject;

public class EditTester extends BaseTester{
	@Override
	protected String getCurrentPageName() {
		return "收藏夹管理编辑";
	}
  @Test(dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void xzs_scjgl_edit_success_test_case(XzsScjglEditSuccessData editSuccessData) {
	  to("login_after_url");
	  windowsMaximize();
	  click("小助手按钮");
	  click("收藏夹管理按钮");
	  switchTo("收藏夹管理内联框架");
	  click("编辑按钮");
	  switchToDefalut();
	  switchTo("收藏目录修改内联框架");
	  type("收藏目录名称输入框", editSuccessData.getName());
	  click("更新按钮");
	  
  }


}
