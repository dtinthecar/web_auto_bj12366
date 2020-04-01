package testcase.ywsl.xcsl.save.tsSave;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.BaseTester;
import base.CaseDataProvider;

public class TsSaveTester extends BaseTester{
	@Override
	protected String getCurrentPageName() {
		return "现场受理投诉保存页面";
	}
  @Test(dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void ywsl_xcsl_save_tsSave_success_test_case(YwslXcslSaveTsSaveSuccessData tsSaveSuccessData) {
	  to("login_after_url");
		windowsMaximize();
		click("现场受理按钮");
		switchToHandle(1);
		switchTo("现场受理内联框架");	
		clickRadio("单位类型列表", tsSaveSuccessData.getDwlx());
		click("一级问题归属地选择框");
		select1("问题归属地列表", tsSaveSuccessData.getYjgsd());
		click("二级问题归属地选择框");
		select1("问题归属地列表", tsSaveSuccessData.getEjgsd());
		click("三级问题归属地选择框");
		select1("问题归属地列表", tsSaveSuccessData.getSjgsd());
		clickRadio("业务类别列表",tsSaveSuccessData.getYwlb() );
		click("接收方式输入框");
		select1("接收方式列表", tsSaveSuccessData.getJsfs());
		click("信息来源输入框");
		select1("信息来源列表", tsSaveSuccessData.getXxly());
		click("信息下拉按钮");
		if ("0".equals(tsSaveSuccessData.getSmts())) {
			type("姓名", tsSaveSuccessData.getName());
			type("联系电话", tsSaveSuccessData.getPhone());
			type("工作单位", tsSaveSuccessData.getWorkPlace());
			type("身份证号码", tsSaveSuccessData.getSfzNumber());
			type("纳税人识别号", tsSaveSuccessData.getNsrsbh());
			type("短信号码", tsSaveSuccessData.getMsgNumber());
			type("传真号码", tsSaveSuccessData.getCzNumber());
			type("联系地址", tsSaveSuccessData.getAddress());			
			type("电子邮箱", tsSaveSuccessData.getEmail());			
		}
		if ("1".equals(tsSaveSuccessData.getSmts())) {
			clickRadio("实名投诉列表", tsSaveSuccessData.getSmts());
		}
		clickRadio("纳税人评价等级列表", tsSaveSuccessData.getNsrpjdj());
		click("投诉类型输入框");
		select1("投诉类型列表", tsSaveSuccessData.getTslx());
		type("被投诉人单位或个人输入框", tsSaveSuccessData.getBtsrdwhgr());
		type("反映内容输入框", tsSaveSuccessData.getFynr());
		if ("1".equals(tsSaveSuccessData.getSfcyy())) {
			click("常用语按钮");
			switchToDefalut();
			switchTo("常用语内联框架");
			clickCheckBoxByIndex("常用语勾选框列表", "0", "2");
			click("常用语确认按钮");
			switchToDefalut();
			switchTo("现场受理内联框架");	
		}
		if ("1".equals(tsSaveSuccessData.getSffj())) {
			click("附件上传按钮");
			switchToDefalut();
			switchTo("附件上传内联框架");
			type("附件上传", "C:\\Users\\Administrator\\Desktop\\csv.txt");
			click("开始上传按钮");
			alertAccept();
			switchToDefalut();
			switchTo("现场受理内联框架");	
		}
		click("紧急程度选择框");
		select1("紧急程度列表", tsSaveSuccessData.getJjcd());
		click("保存按钮");
		switchToDefalut();
		assertElementTextEquls("保存提示框", tsSaveSuccessData.getTips());
		click("确认按钮");
		
  }
  
  @Test(enabled=false,dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void ywsl_xcsl_save_tsSave_failure_test_case(YwslXcslSaveTsSaveFailureData tsSaveFailureData) {
	  to("login_after_url");
		windowsMaximize();
		click("现场受理按钮");
		switchToHandle(1);
		switchTo("现场受理内联框架");	
		clickRadio("单位类型列表", tsSaveFailureData.getDwlx());
		click("一级问题归属地选择框");
		select1("问题归属地列表", tsSaveFailureData.getYjgsd());
		click("二级问题归属地选择框");
		select1("问题归属地列表", tsSaveFailureData.getEjgsd());
		click("三级问题归属地选择框");
		select1("问题归属地列表", tsSaveFailureData.getSjgsd());
		clickRadio("业务类别列表",tsSaveFailureData.getYwlb() );
		click("接收方式输入框");
		select1("接收方式列表", tsSaveFailureData.getJsfs());
		click("信息来源输入框");
		select1("信息来源列表", tsSaveFailureData.getXxly());
		click("信息下拉按钮");
		if ("0".equals(tsSaveFailureData.getSmts())) {
			type("姓名", tsSaveFailureData.getName());
			type("联系电话", tsSaveFailureData.getPhone());
			type("工作单位", tsSaveFailureData.getWorkPlace());
			type("身份证号码", tsSaveFailureData.getSfzNumber());
			type("纳税人识别号", tsSaveFailureData.getNsrsbh());
			type("短信号码", tsSaveFailureData.getMsgNumber());
			type("传真号码", tsSaveFailureData.getCzNumber());
			type("联系地址", tsSaveFailureData.getAddress());			
			type("电子邮箱", tsSaveFailureData.getEmail());			
		}
		if ("1".equals(tsSaveFailureData.getSmts())) {
			clickRadio("实名投诉列表", tsSaveFailureData.getSmts());
		}
		clickRadio("纳税人评价等级列表", tsSaveFailureData.getNsrpjdj());
		click("投诉类型输入框");
		select1("投诉类型列表", tsSaveFailureData.getTslx());
		type("被投诉人单位或个人输入框", tsSaveFailureData.getBtsrdwhgr());
		clear("反映内容输入框");
		type("反映内容输入框", tsSaveFailureData.getFynr());
		if ("1".equals(tsSaveFailureData.getSfcyy())) {
			click("常用语按钮");
			switchToDefalut();
			switchTo("常用语内联框架");
			clickCheckBoxByIndex("常用语勾选框列表", "0", "2");
			click("常用语确认按钮");
			switchToDefalut();
			switchTo("现场受理内联框架");	
		}
		if ("1".equals(tsSaveFailureData.getSffj())) {
			click("附件上传按钮");
			switchToDefalut();
			switchTo("附件上传内联框架");
			type("附件上传", "C:\\Users\\Administrator\\Desktop\\csv.txt");
			click("开始上传按钮");
			alertAccept();
			switchToDefalut();
			switchTo("现场受理内联框架");	
		}
		click("紧急程度选择框");
		select1("紧急程度列表", tsSaveFailureData.getJjcd());
		click("保存按钮");
		assertElementTextEquls("提示语", tsSaveFailureData.getTips());		
	  
  }
  @AfterMethod
  public void afterMethod(){
	  driver.close();
      switchToHandle(0);	
  }
  
  



}
