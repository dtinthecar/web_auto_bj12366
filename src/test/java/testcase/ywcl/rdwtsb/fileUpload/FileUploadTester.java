package testcase.ywcl.rdwtsb.fileUpload;

import org.testng.annotations.Test;

import base.BaseTester;
import base.CaseDataProvider;

public class FileUploadTester extends BaseTester{
	@Override
	protected String getCurrentPageName() {
		return "文件上传";
	}
  @Test(dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void ywcl_rdwtsb_fileUpload_success_test_case(YwclRdwtsbFileUploadSuccessData fileUploadSuccessData) {
	  to("login_after_url");
	  windowsMaximize();
	  click("业务处理");
	  click("北京中心热点问题上报");
	  switchTo("北京中心热点问题上报内联框架");
	  theadSleep(2000);
	  click("查询按钮");
	  click("查看按钮");
	  switchToDefalut();
	  switchTo("上报内联框架");
	  theadSleep(2000);
	  click("上报按钮");
	  switchToDefalut();
	  theadSleep(2000);
	  switchTo("附件内联框架");
	  theadSleep(2000);
	  jsExcute("window.scroll(0,document.body.scrollHeight)");
	  click("附件上传");
	  switchToDefalut();
	  switchTo("添加附件内联框架");
	  theadSleep(2000);
	  type("上传附件输入框", fileUploadSuccessData.getUploadPath());
  }


}
