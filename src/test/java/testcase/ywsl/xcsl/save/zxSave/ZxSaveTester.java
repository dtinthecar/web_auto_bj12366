package testcase.ywsl.xcsl.save.zxSave;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.BaseTester;
import base.CaseDataProvider;

public class ZxSaveTester extends BaseTester{
	@Override
	protected String getCurrentPageName() {
		return "现场受理咨询保存页面";
	}
  @Test(dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void ywsl_xcsl_save_zxSave_success_test_case(YwslXcslSaveZxSaveSuccessData zxSaceSuccessData) {
//	  boolean flag=isAlertPresent();
//	  if (flag==true) {
//		  theadSleep(2000);
//		alertAccept();
//		switchToHandle(0);		
//	}
//	 
	  to("login_after_url");
		windowsMaximize();
		click("现场受理按钮");
		switchToHandle(1);
		switchTo("现场受理内联框架");	
		clickRadio("单位类型列表", zxSaceSuccessData.getDwlx());
		click("一级问题归属地选择框");
		select1("问题归属地列表", zxSaceSuccessData.getYjgsd());
		click("二级问题归属地选择框");
		select1("问题归属地列表", zxSaceSuccessData.getEjgsd());
		click("三级问题归属地选择框");
		select1("问题归属地列表", zxSaceSuccessData.getSjgsd());
		click("信息下拉按钮");
		type("姓名", zxSaceSuccessData.getName());
		type("联系电话", zxSaceSuccessData.getPhone());
		type("纳税人识别号", zxSaceSuccessData.getNsrsbh());
		type("短信号码", zxSaceSuccessData.getMsgNumber());
		type("传真号码", zxSaceSuccessData.getCzNumber());
		type("联系地址", zxSaceSuccessData.getAddress());
		type("身份证号码", zxSaceSuccessData.getSfzNumber());
		type("工作单位", zxSaceSuccessData.getWorkPlace());
		type("电子邮箱", zxSaceSuccessData.getEmail());
		clickRadio("纳税人评价等级列表", zxSaceSuccessData.getNsrpjdj());
		click("标签按钮");
		switchToHandle(2);
		click("第一个标签下拉按钮");
		click("第一个下拉选项");
		click("标签关闭按钮");
		switchToHandle(1);
		switchTo("现场受理内联框架");
		click("问题类型按钮");
		switchToHandle(2);	
		switchTo("问题类型内联框架");
		click("问题类型选择框");
		click("问题类型确定按钮");
		switchToHandle(1);
		switchTo("现场受理内联框架");
		type("反映内容输入框", zxSaceSuccessData.getFynr());
		clickRadio("小结类型列表", zxSaceSuccessData.getXjlx());
		if ("1".equals(zxSaceSuccessData.getSfcyy())) {
			click("常用语按钮");
			switchToDefalut();
			switchTo("常用语内联框架");
			clickCheckBoxByIndex("常用语勾选框列表", "0", "2");
			click("常用语确认按钮");
			switchToDefalut();
			switchTo("现场受理内联框架");	
		}
		if ("1".equals(zxSaceSuccessData.getSffj())) {
			click("附件上传按钮");
			switchToDefalut();
			switchTo("附件上传内联框架");
			type("附件上传", "C:\\Users\\Administrator\\Desktop\\csv.txt");
			click("开始上传按钮");
			alertAccept();
			switchToDefalut();
			switchTo("现场受理内联框架");	
		}
		if ("0".equals(zxSaceSuccessData.getXjlx())) {
			type("答复内容输入框", zxSaceSuccessData.getDfnr());
		}
		click("紧急程度选择框");
		select1("紧急程度列表", zxSaceSuccessData.getJjcd());
		click("保存按钮");
		switchToDefalut();
		assertElementTextEquls("保存提示框", zxSaceSuccessData.getTips());
		click("确认按钮");
        
  }
  @Test(enabled=false,dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void ywsl_xcsl_save_zxSave_failure_test_case(YwslXcslSaveZxSaveFailureData zxSaveFailureData) {
//	  boolean flag=isAlertPresent();
//	  if (flag==true) {
//		  theadSleep(2000);
//		alertAccept();
//		switchToHandle(0);		
//	}
//	 
	  to("login_after_url");
		windowsMaximize();
		click("现场受理按钮");
		switchToHandle(1);
		switchTo("现场受理内联框架");	
		clickRadio("单位类型列表", zxSaveFailureData.getDwlx());
		click("一级问题归属地选择框");
		select1("问题归属地列表", zxSaveFailureData.getYjgsd());
		click("二级问题归属地选择框");
		select1("问题归属地列表", zxSaveFailureData.getEjgsd());
		click("三级问题归属地选择框");
		select1("问题归属地列表", zxSaveFailureData.getSjgsd());
		click("信息下拉按钮");
		type("姓名", zxSaveFailureData.getName());
		type("联系电话", zxSaveFailureData.getPhone());
		type("纳税人识别号", zxSaveFailureData.getNsrsbh());
		type("短信号码", zxSaveFailureData.getMsgNumber());
		type("传真号码", zxSaveFailureData.getCzNumber());
		type("联系地址", zxSaveFailureData.getAddress());
		type("身份证号码", zxSaveFailureData.getSfzNumber());
		type("工作单位", zxSaveFailureData.getWorkPlace());
		type("电子邮箱", zxSaveFailureData.getEmail());
		clickRadio("纳税人评价等级列表", zxSaveFailureData.getNsrpjdj());
		
//		click("第一个标签下拉按钮");
		if ("1".equals(zxSaveFailureData.getBq())) {
			click("标签按钮");
			switchToHandle(2);
			clickCheckBoxByIndex("标签勾选框列表", zxSaveFailureData.getBq());
			click("标签关闭按钮");
			switchToHandle(1);
			switchTo("现场受理内联框架");
		}
		if ("1".equals(zxSaveFailureData.getWtlx())) {
			click("问题类型按钮");
			switchToHandle(2);	
			switchTo("问题类型内联框架");
			clickCheckBoxByIndex("问题类型勾选框列表", zxSaveFailureData.getWtlx());
			click("问题类型确定按钮");
			switchToHandle(1);
			switchTo("现场受理内联框架");
		}
		
		type("反映内容输入框", zxSaveFailureData.getFynr());
		clickRadio("小结类型列表", zxSaveFailureData.getXjlx());
		if ("1".equals(zxSaveFailureData.getSfcyy())) {
			click("常用语按钮");
			switchToDefalut();
			switchTo("常用语内联框架");
			clickCheckBoxByIndex("常用语勾选框列表", "0", "2");
			click("常用语确认按钮");
			switchToDefalut();
			switchTo("现场受理内联框架");	
		}
		if ("1".equals(zxSaveFailureData.getSffj())) {
			click("附件上传按钮");
			switchToDefalut();
			switchTo("附件上传内联框架");
			type("附件上传", "C:\\Users\\Administrator\\Desktop\\csv.txt");
			click("开始上传按钮");
			alertAccept();
			switchToDefalut();
			switchTo("现场受理内联框架");	
		}
		if ("0".equals(zxSaveFailureData.getXjlx())) {
			type("答复内容输入框", zxSaveFailureData.getDfnr());
		}
		click("紧急程度选择框");
		select1("紧急程度列表", zxSaveFailureData.getJjcd());
		click("保存按钮");
//		switchToDefalut();
		assertElementTextEquls("提示语", zxSaveFailureData.getTips());
//		click("确认按钮");
      
  }
  @AfterMethod
  public void afterMethod(){
	  driver.close();
      switchToHandle(0);	
  }
  

}
