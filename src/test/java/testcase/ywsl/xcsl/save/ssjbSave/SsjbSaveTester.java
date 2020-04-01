package testcase.ywsl.xcsl.save.ssjbSave;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.BaseTester;
import base.CaseDataProvider;

public class SsjbSaveTester extends BaseTester{
	@Override
	protected String getCurrentPageName() {
		return "现场受理涉税举报保存页面";
	}
  @Test(dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void ywsl_xcsl_save_ssjbSave_success_test_case(YwslXcslSaveSsjbSaveSuccessData ssjbSaveSuccessData) {
	  to("login_after_url");
		windowsMaximize();
		click("现场受理按钮");
		switchToHandle(1);
		switchTo("现场受理内联框架");	
		clickRadio("单位类型列表", ssjbSaveSuccessData.getDwlx());
		click("一级问题归属地选择框");
		select1("问题归属地列表", ssjbSaveSuccessData.getYjgsd());
		click("二级问题归属地选择框");
		select1("问题归属地列表", ssjbSaveSuccessData.getEjgsd());
		click("三级问题归属地选择框");
		select1("问题归属地列表", ssjbSaveSuccessData.getSjgsd());
		clickRadio("业务类别列表",ssjbSaveSuccessData.getYwlb() );
		click("信息下拉按钮");
		type("姓名", ssjbSaveSuccessData.getName());
		type("联系电话", ssjbSaveSuccessData.getPhone());
		type("纳税人识别号", ssjbSaveSuccessData.getNsrsbh());
		type("短信号码", ssjbSaveSuccessData.getMsgNumber());
		type("传真号码", ssjbSaveSuccessData.getCzNumber());
		type("联系地址", ssjbSaveSuccessData.getAddress());
		type("身份证号码", ssjbSaveSuccessData.getSfzNumber());
		type("工作单位", ssjbSaveSuccessData.getWorkPlace());
		type("电子邮箱", ssjbSaveSuccessData.getEmail());
		clickRadio("纳税人评价等级列表", ssjbSaveSuccessData.getNsrpjdj());
		click("涉税举报类型输入框");
		select1("涉税举报类型列表", ssjbSaveSuccessData.getSsjblx());
		if ("纳税人一般税收违法行为举报".equals(ssjbSaveSuccessData.getSsjblx())) {
			click("举报二级分类按钮");
			switchToHandle(2);
			clickCheckBox("举报二级分类勾选框列表1", ssjbSaveSuccessData.getJbejfl());
			click("举报二级分类确定按钮");
			switchToHandle(1);
			switchTo("现场受理内联框架");
		}
		if ("轻微纳税人税收违法行为举报".equals(ssjbSaveSuccessData.getSsjblx())) {
			click("举报二级分类按钮");
			switchToHandle(2);
			click("举报二级分类1级下拉按钮");
			click("举报二级分类2级下拉按钮");
			click("举报二级分类3级勾选框");
			click("举报二级分类确定按钮");
			switchToHandle(1);
			switchTo("现场受理内联框架");
		}
		if ("税务机关和税务人员税收违法行政行为举报".equals(ssjbSaveSuccessData.getSsjblx())) {
			if ("0".equals(ssjbSaveSuccessData.getJbdx())) {
				clickCheckBoxByIndex("举报对象", ssjbSaveSuccessData.getJbdx());
				click("人员级别输入框");
				select1("人员级别列表", ssjbSaveSuccessData.getRyjb());
				type("岗位", ssjbSaveSuccessData.getZwgw());
			}
			if ("1".equals(ssjbSaveSuccessData.getJbdx())) {
				clickCheckBoxByIndex("举报对象", ssjbSaveSuccessData.getJbdx());
				type("被举报机关名称", ssjbSaveSuccessData.getBjjjgmc());
				click("机关级别输入框");
				type("机关级别列表", ssjbSaveSuccessData.getJgjb());
				
			}
			if ("2".equals(ssjbSaveSuccessData.getJbdx())) {
				clickCheckBox("举报对象", ssjbSaveSuccessData.getJbdx());
				click("人员级别输入框");
				select1("人员级别列表", ssjbSaveSuccessData.getRyjb());
				type("岗位", ssjbSaveSuccessData.getZwgw());
				type("被举报机关名称", ssjbSaveSuccessData.getBjjjgmc());
				click("机关级别输入框");
				type("机关级别列表", ssjbSaveSuccessData.getJgjb());
			}
			clickRadio("是否已申请行政复议", ssjbSaveSuccessData.getSfysqxzfy());
			clickRadio("是否已提起行政诉讼", ssjbSaveSuccessData.getSfytqxzss());
			clickRadio("是否曾提出信访或举报", ssjbSaveSuccessData.getSfctcxfhjb());
			if ("0".equals(ssjbSaveSuccessData.getSfctcxfhjb())) {
				type("向何单位提出", ssjbSaveSuccessData.getXhdwtc());
				type("信访或举报简要结果", ssjbSaveSuccessData.getXfhjbjyjg());
			}
			
		}
		if (!"1".equals(ssjbSaveSuccessData.getJbdx())) {
			type("被检举人姓名", ssjbSaveSuccessData.getBjjrxm());
			type("被检举人住所或单位", ssjbSaveSuccessData.getBjjrzs());
		}
		
		type("反映内容输入框", ssjbSaveSuccessData.getJbnr());
		if ("1".equals(ssjbSaveSuccessData.getSfcyy())) {
			click("常用语按钮");
			switchToDefalut();
			switchTo("常用语内联框架");
			clickCheckBoxByIndex("常用语勾选框列表", "0", "2");
			click("常用语确认按钮");
			switchToDefalut();
			switchTo("现场受理内联框架");	
		}
		if ("1".equals(ssjbSaveSuccessData.getSffj())) {
			click("附件上传按钮");
			switchToDefalut();
			switchTo("附件上传内联框架");
			type("附件上传", "C:\\Users\\Administrator\\Desktop\\csv.txt");
			click("开始上传按钮");
			alertAccept();
			switchToDefalut();
			switchTo("现场受理内联框架");	
		}
  }

  @AfterMethod
  public void afterMethod(){
	  driver.close();
      switchToHandle(0);	
  }
}
