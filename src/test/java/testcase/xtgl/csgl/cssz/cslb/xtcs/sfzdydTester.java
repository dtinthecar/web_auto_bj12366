package testcase.xtgl.csgl.cssz.cslb.xtcs;

import org.testng.annotations.Test;

import base.BaseTester;
import base.CaseDataProvider;

public class sfzdydTester extends BaseTester{
	@Override
	protected String getCurrentPageName() {
		return "是否自动应答";
	}
  @Test(dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void xtgl_csgl_cssz_cslb_xtcs_success_test_case(XtglCsglCsszCslbXtcsSuccessData xtcsSuccessData) {
	  to("login_after_url");
	  windowsMaximize();
	  click("系统管理");
	  click("参数管理");
	  click("参数设置");
	  switchTo("参数设置内联框架");
	  click("系统参数按钮");
	  click("通讯设置按钮");
	  click("是否自动应答按钮");
	  switchTo("参数信息内联框架");
	  clear("参数值输入框");
	  type("参数值输入框", xtcsSuccessData.getParm());
	  click("保存按钮");
	  switchToDefalut();
	  assertElementTextEquls("保存成功提示框", xtcsSuccessData.getTips());
  }
  
  @Test(dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void xtgl_csgl_cssz_cslb_xtcs_failure_test_case(XtglCsglCsszCslbXtcsFailureData xtcsFailureData){
	  to("login_after_url");
	  windowsMaximize();
	  click("系统管理");
	  click("参数管理");
	  click("参数设置");
	  switchTo("参数设置内联框架");
	  click("系统参数按钮");
	  click("通讯设置按钮");
	  click("是否自动应答按钮");
	  switchTo("参数信息内联框架");
	  clear("参数值输入框");
	  click("保存按钮");
	  assertElementTextEquls("参数未输入提示语",xtcsFailureData.getTips() );
	  
  }


}
