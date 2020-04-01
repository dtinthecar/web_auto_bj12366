package testcase.ywsl.xcsl.save.cxSave;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.BaseTester;
import base.CaseDataProvider;


//@Listeners(listener.AssertListener.class)
public class CxSaveTester extends BaseTester{
	@Override
	protected String getCurrentPageName() {
		return "现场受理查询保存页面";
	}
  @Test(dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void ywsl_xcsl_save_cxSave_success_test_case(YwslXcslSaveCxSaveSuccessData cxSaveSuccessData) {
	  to("login_after_url");
		windowsMaximize();
		click("现场受理按钮");
		switchToHandle(1);
		switchTo("现场受理内联框架");	
		clickRadio("单位类型列表", cxSaveSuccessData.getDwlx());
		click("一级问题归属地选择框");
		select1("问题归属地列表", cxSaveSuccessData.getYjgsd());
		click("二级问题归属地选择框");
		select1("问题归属地列表", cxSaveSuccessData.getEjgsd());
		click("三级问题归属地选择框");
		select1("问题归属地列表", cxSaveSuccessData.getSjgsd());
		clickRadio("业务类别列表",cxSaveSuccessData.getYwlb() );
		click("信息下拉按钮");
		type("姓名", cxSaveSuccessData.getName());
		type("联系电话", cxSaveSuccessData.getPhone());
		type("纳税人识别号", cxSaveSuccessData.getNsrsbh());
		type("短信号码", cxSaveSuccessData.getMsgNumber());
		type("传真号码", cxSaveSuccessData.getCzNumber());
		type("联系地址", cxSaveSuccessData.getAddress());
		type("身份证号码", cxSaveSuccessData.getSfzNumber());
		type("工作单位", cxSaveSuccessData.getWorkPlace());
		type("电子邮箱", cxSaveSuccessData.getEmail());
		clickRadio("纳税人评价等级列表", cxSaveSuccessData.getNsrpjdj());
		click("查询类型输入框");
		select1("查询内容列表", cxSaveSuccessData.getCxlx());
		type("反映内容输入框", cxSaveSuccessData.getFynr());
		if ("1".equals(cxSaveSuccessData.getSfcyy())) {
			click("常用语按钮");
			switchToDefalut();
			switchTo("常用语内联框架");
			clickCheckBoxByIndex("常用语勾选框列表", "0", "2");
			click("常用语确认按钮");
			switchToDefalut();
			switchTo("现场受理内联框架");	
		}
		if ("1".equals(cxSaveSuccessData.getSffj())) {
			click("附件上传按钮");
			switchToDefalut();
			switchTo("附件上传内联框架");
			type("附件上传", "C:\\Users\\Administrator\\Desktop\\csv.txt");
			click("开始上传按钮");
			alertAccept();
			switchToDefalut();
			switchTo("现场受理内联框架");	
		}
		type("答复内容输入框", cxSaveSuccessData.getDfnr());
		click("紧急程度选择框");
		select1("紧急程度列表", cxSaveSuccessData.getJjcd());
		click("保存按钮");
		switchToDefalut();
		assertElementTextEquls("保存提示框", cxSaveSuccessData.getTips());
		click("确认按钮");
//        driver.close();
//        switchToHandle(0);	
  }
  

  @Test(enabled=false,dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void ywsl_xcsl_save_cxSave_failure_test_case(YwslXcslSaveCxSaveFailureData cxSaveFailureData) {
	  to("login_after_url");
		windowsMaximize();
		click("现场受理按钮");
		switchToHandle(1);
		switchTo("现场受理内联框架");	
		clickRadio("单位类型列表", cxSaveFailureData.getDwlx());
		click("一级问题归属地选择框");
		select1("问题归属地列表", cxSaveFailureData.getYjgsd());
		click("二级问题归属地选择框");
		select1("问题归属地列表", cxSaveFailureData.getEjgsd());
		click("三级问题归属地选择框");
		select1("问题归属地列表", cxSaveFailureData.getSjgsd());
		clickRadio("业务类别列表",cxSaveFailureData.getYwlb() );
		click("信息下拉按钮");
		type("姓名", cxSaveFailureData.getName());
		type("联系电话", cxSaveFailureData.getPhone());
		type("纳税人识别号", cxSaveFailureData.getNsrsbh());
		type("短信号码", cxSaveFailureData.getMsgNumber());
		type("传真号码", cxSaveFailureData.getCzNumber());
		type("联系地址", cxSaveFailureData.getAddress());
		type("身份证号码", cxSaveFailureData.getSfzNumber());
		type("工作单位", cxSaveFailureData.getWorkPlace());
		type("电子邮箱", cxSaveFailureData.getEmail());
		clickRadio("纳税人评价等级列表", cxSaveFailureData.getNsrpjdj());
		click("查询类型输入框");
		select1("查询内容列表", cxSaveFailureData.getCxlx());
		clear("反映内容输入框");
		type("反映内容输入框", cxSaveFailureData.getFynr());
		type("答复内容输入框", cxSaveFailureData.getDfnr());
		click("紧急程度选择框");
		select1("紧急程度列表", cxSaveFailureData.getJjcd());
		click("保存按钮");		
		assertElementTextEquls("提示语", cxSaveFailureData.getTips());			
		
  }
  @AfterMethod
  public void afterMethod(){
	  driver.close();
      switchToHandle(0);	
  }


}
