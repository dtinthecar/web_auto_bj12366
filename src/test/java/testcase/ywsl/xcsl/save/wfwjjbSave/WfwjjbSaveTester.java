package testcase.ywsl.xcsl.save.wfwjjbSave;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.BaseTester;
import base.CaseDataProvider;

public class WfwjjbSaveTester extends BaseTester{
	@Override
	protected String getCurrentPageName() {
		return "现场受理违法违纪举报保存页面";
	}
  @Test(dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void ywsl_xcsl_save_wfwjjbSave_success_test_case(YwslXcslSaveWfwjjbSaveSuccessData wfwjjbSaveSuccessData) {
	  to("login_after_url");
		windowsMaximize();
		click("现场受理按钮");
		switchToHandle(1);
		switchTo("现场受理内联框架");	
		clickRadio("单位类型列表", wfwjjbSaveSuccessData.getDwlx());
		click("一级问题归属地选择框");
		select1("问题归属地列表", wfwjjbSaveSuccessData.getYjgsd());
		click("二级问题归属地选择框");
		select1("问题归属地列表", wfwjjbSaveSuccessData.getEjgsd());
		click("三级问题归属地选择框");
		select1("问题归属地列表", wfwjjbSaveSuccessData.getSjgsd());
		clickRadio("业务类别列表",wfwjjbSaveSuccessData.getYwlb() );		
		click("信息下拉按钮");
		type("姓名", wfwjjbSaveSuccessData.getName());
		type("联系电话", wfwjjbSaveSuccessData.getPhone());
		type("纳税人识别号", wfwjjbSaveSuccessData.getNsrsbh());
		type("短信号码", wfwjjbSaveSuccessData.getMsgNumber());
		type("传真号码", wfwjjbSaveSuccessData.getCzNumber());
		type("联系地址", wfwjjbSaveSuccessData.getAddress());
		type("身份证号码", wfwjjbSaveSuccessData.getSfzNumber());
		type("工作单位", wfwjjbSaveSuccessData.getWorkPlace());
		type("电子邮箱", wfwjjbSaveSuccessData.getEmail());
		clickRadio("纳税人评价等级列表", wfwjjbSaveSuccessData.getNsrpjdj());
		click("违法违纪类型输入框");
		select1("违法违纪类型列表", wfwjjbSaveSuccessData.getWfwjlx());
		type("被举报人姓名输入框", wfwjjbSaveSuccessData.getBjbrxm());
		type("所属单位输入框", wfwjjbSaveSuccessData.getSsdw());
		type("反映内容输入框", wfwjjbSaveSuccessData.getFynr());
		if ("1".equals(wfwjjbSaveSuccessData.getSfcyy())) {
			click("常用语按钮");
			switchToDefalut();
			switchTo("常用语内联框架");
			clickCheckBoxByIndex("常用语勾选框列表", "0", "2");
			click("常用语确认按钮");
			switchToDefalut();
			switchTo("现场受理内联框架");	
		}
		if ("1".equals(wfwjjbSaveSuccessData.getSffj())) {
			click("附件上传按钮");
			switchToDefalut();
			switchTo("附件上传内联框架");
			type("附件上传", "C:\\Users\\Administrator\\Desktop\\csv.txt");
			click("开始上传按钮");
			alertAccept();
			switchToDefalut();
			switchTo("现场受理内联框架");	
		}
		if ("0".equals(wfwjjbSaveSuccessData.getXjlx())) {
			type("答复内容输入框", wfwjjbSaveSuccessData.getDfnr());
		}
		clickRadio("小结类型列表", wfwjjbSaveSuccessData.getXjlx());
		click("紧急程度选择框");
		select1("紧急程度列表", wfwjjbSaveSuccessData.getJjcd());
		click("保存按钮");
		switchToDefalut();
		assertElementTextEquls("保存提示框", wfwjjbSaveSuccessData.getTips());
		click("确认按钮");
  }
  
  @Test(dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void ywsl_xcsl_save_wfwjjbSave_failure_test_case(YwslXcslSaveWfwjjbSaveFailureData wfwjjbSaveFailureData) {
	  to("login_after_url");
		windowsMaximize();
		click("现场受理按钮");
		switchToHandle(1);
		switchTo("现场受理内联框架");	
		clickRadio("单位类型列表", wfwjjbSaveFailureData.getDwlx());
		click("一级问题归属地选择框");
		select1("问题归属地列表", wfwjjbSaveFailureData.getYjgsd());
		click("二级问题归属地选择框");
		select1("问题归属地列表", wfwjjbSaveFailureData.getEjgsd());
		click("三级问题归属地选择框");
		select1("问题归属地列表", wfwjjbSaveFailureData.getSjgsd());
		clickRadio("业务类别列表",wfwjjbSaveFailureData.getYwlb() );		
		click("信息下拉按钮");
		type("姓名", wfwjjbSaveFailureData.getName());
		type("联系电话", wfwjjbSaveFailureData.getPhone());
		type("纳税人识别号", wfwjjbSaveFailureData.getNsrsbh());
		type("短信号码", wfwjjbSaveFailureData.getMsgNumber());
		type("传真号码", wfwjjbSaveFailureData.getCzNumber());
		type("联系地址", wfwjjbSaveFailureData.getAddress());
		type("身份证号码", wfwjjbSaveFailureData.getSfzNumber());
		type("工作单位", wfwjjbSaveFailureData.getWorkPlace());
		type("电子邮箱", wfwjjbSaveFailureData.getEmail());
		clickRadio("纳税人评价等级列表", wfwjjbSaveFailureData.getNsrpjdj());
		click("违法违纪类型输入框");
		select1("违法违纪类型列表", wfwjjbSaveFailureData.getWfwjlx());
		type("被举报人姓名输入框", wfwjjbSaveFailureData.getBjbrxm());
		type("所属单位输入框", wfwjjbSaveFailureData.getSsdw());
		type("反映内容输入框", wfwjjbSaveFailureData.getFynr());
		if ("0".equals(wfwjjbSaveFailureData.getXjlx())) {
			type("答复内容输入框", wfwjjbSaveFailureData.getDfnr());
		}
		clickRadio("小结类型列表", wfwjjbSaveFailureData.getXjlx());
		click("紧急程度选择框");
		select1("紧急程度列表", wfwjjbSaveFailureData.getJjcd());
		click("保存按钮");
		assertElementTextEquls("提示语", wfwjjbSaveFailureData.getTips());	
  }
  
  @AfterMethod
  public void afterMethod(){
	  driver.close();
      switchToHandle(0);	
  }

}
