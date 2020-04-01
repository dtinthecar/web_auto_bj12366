package testcase.xtgl.yhgl.xjyh.save.nogh;

import org.testng.annotations.Test;

import base.BaseTester;
import base.CaseDataProvider;

public class xjyhSaveNoghTester extends BaseTester{
	@Override
	protected String getCurrentPageName() {
		return "新建用户保存页面";
	}
  @Test(enabled=false,dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void xtgl_yhgl_xjyh_save_nogh_success_test_case(XtglYhglXjyhSaveNoghSuccessData saveSuccessData) {
	  to("login_after_url");
	  windowsMaximize();
	  click("系统管理");
	  click("用户管理");
	  click("子用户管理");
	  switchTo("子用户管理内联框架");
	  click("新建按钮");
	  switchToDefalut();
	  switchTo("新建用户页面内联框架");
	  click("部门名称选择框");
	  select1("部门名称列表", saveSuccessData.getApartMentName());
	  type("用户账号输入框", saveSuccessData.getYhzh());
	  type("用户名称输入框", saveSuccessData.getYhmc());
	  type("密码输入框", saveSuccessData.getPassword());
	  type("密码确认输入框", saveSuccessData.getPasswordConfirm());
	  click("性别选择框");
	  select1("性别列表", saveSuccessData.getSex());
	  type("电子邮箱输入框", saveSuccessData.getEmail());
	  type("手机号码输入框", saveSuccessData.getMobileNum());
	  type("电话号码输入框", saveSuccessData.getTelNum());
	  clickCheckBox("知识库检索范围列表", saveSuccessData.getZskSearch());
	  click("人员选择输入框");
	  select1("人员选择列表", saveSuccessData.getRylb());
	  type("备注输入框", saveSuccessData.getBz());
	  click("保存按钮");
	  switchToDefalut();
	  assertElementTextEquls("保存成功提示框", saveSuccessData.getTips());
	  
  }
  
  @Test(dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void xtgl_yhgl_xjyh_save_nogh_failure_test_case(XtglYhglXjyhSaveNoghFailureData failureData){
	  to("login_after_url");
	  windowsMaximize();
	  click("系统管理");
	  click("用户管理");
	  click("子用户管理");
	  switchTo("子用户管理内联框架");
	  click("新建按钮");
	  switchToDefalut();
	  switchTo("新建用户页面内联框架");
	  click("部门名称选择框");
	  select1("部门名称列表", failureData.getApartMentName());
	  type("用户账号输入框", failureData.getYhzh());
	  type("用户名称输入框", failureData.getYhmc());
	  type("密码输入框", failureData.getPassword());
	  type("密码确认输入框", failureData.getPasswordConfirm());
	  click("性别选择框");
	  select1("性别列表", failureData.getSex());
	  type("电子邮箱输入框", failureData.getEmail());
	  type("手机号码输入框", failureData.getMobileNum());
	  type("电话号码输入框", failureData.getTelNum());
	  clickCheckBox("知识库检索范围列表", failureData.getZskSearch());
	  click("人员选择输入框");
	  select1("人员选择列表", failureData.getRylb());
	  type("备注输入框", failureData.getBz());
	  click("保存按钮");
	  assertElementTextEquls("部门提示框", failureData.getTips());
	  
  }


}
