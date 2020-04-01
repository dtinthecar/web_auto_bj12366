package testcase.ywsl.xcsl.save;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseTester;
import base.CaseDataProvider;

public class XcslSaveTester extends BaseTester{
	@Override
	protected String getCurrentPageName() {
		return "现场受理保存页面";
	}
	
	@BeforeTest
	public void openBrowser(){
		
	}
  @Test(dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void ywsl_xcsl_save_success_test_case(YwslXcslSaveSuccessData saveSuccessData) {
	  boolean flag=isAlertPresent();
	  if (flag==true) {
		driver.switchTo().alert().accept();
		switchToHandle(0);
	}
	  to("login_after_url");
		windowsMaximize();
		click("现场受理按钮");
		switchToHandle(1);
		switchTo("现场受理内联框架");		
		jsExcute("document.getElementsByName('casethkssj')[0].removeAttribute('readonly')");
		clear("来访时间输入框");
		type("来访时间输入框", saveSuccessData.getLfsj());
		clickRadio("单位类型列表", saveSuccessData.getDwlx());
//		clickRadioByText("单位类型列表", saveSuccessData.getDwlx());
		click("一级问题归属地选择框");
		select1("问题归属地列表", saveSuccessData.getYjgsd());
		click("二级问题归属地选择框");
		select1("问题归属地列表", saveSuccessData.getEjgsd());
		click("三级问题归属地选择框");
		select1("问题归属地列表", saveSuccessData.getSjgsd());
		click("信息下拉按钮");
		type("姓名", saveSuccessData.getName());
		type("联系电话", saveSuccessData.getPhone());
		type("纳税人识别号", saveSuccessData.getNsrsbh());
		type("短信号码", saveSuccessData.getMsgNumber());
		type("传真号码", saveSuccessData.getCzNumber());
		type("联系地址", saveSuccessData.getAddress());
		type("身份证号码", saveSuccessData.getSfzNumber());
		type("工作单位", saveSuccessData.getWorkPlace());
		type("电子邮箱", saveSuccessData.getEmail());
		clickRadio("业务类别列表", saveSuccessData.getYwlb());
		clickRadio("纳税人评价等级列表", saveSuccessData.getNsrpjdj());
		if ("0".equals(saveSuccessData.getYwlb())) {
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
			
		}else if ("1".equals(saveSuccessData.getYwlb())) {			
			click("查询类型输入框");
			select1("查询类型列表", saveSuccessData.getCxlx());
			
		}else if ("2".equals(saveSuccessData.getYwlb())) {
			click("接收方式输入框");
			select1("接收方式列表", saveSuccessData.getJsfs());
			click("信息来源输入框");
			select1("信息来源列表", saveSuccessData.getXxly());
			click("投诉类型输入框");
			select1("投诉类型列表", saveSuccessData.getTslx());
			type("被投诉人单位或个人输入框", saveSuccessData.getBtsrdwhgr());
			
		}else if ("3".equals(saveSuccessData.getYwlb())) {			
			click("违法举报类型输入框");
			select1("违法举报类型列表",saveSuccessData.getWfjblx());
			type("被举报人姓名输入框", saveSuccessData.getBjbrxm());
			type("所属单位输入框", saveSuccessData.getSsdw());
			
		}else if ("4".equals(saveSuccessData.getYwlb())) {
			click("涉税举报类型输入框");
			type("涉税举报类型列表", saveSuccessData.getSsjblx());
			click("举报二级分类按钮");
			switchToHandle(2);
			clickCheckBox("举报二级分类勾选框列表", saveSuccessData.getJbejfl());
			click("举报二级分类确定按钮");
			switchToHandle(1);
			switchTo("现场受理内联框架");
			
		} 
		type("反映内容输入框", saveSuccessData.getFynr());
		
		if ("0".equals(saveSuccessData.getYwlb())||"3".equals(saveSuccessData.getYwlb())) {
			clickRadio("小结类型列表", saveSuccessData.getXjlx());
			if ("0".equals(saveSuccessData.getXjlx())) {
				type("答复内容输入框", saveSuccessData.getDfnr());
			}			
		}
		click("紧急程度选择框");
		select1("紧急程度列表", saveSuccessData.getJjcd());
		click("保存按钮");
		switchToDefalut();
		assertElementTextEquls("保存提示框", saveSuccessData.getTips());
		click("确认按钮");
		
		
  }


}
