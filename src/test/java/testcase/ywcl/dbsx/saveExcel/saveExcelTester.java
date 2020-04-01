package testcase.ywcl.dbsx.saveExcel;

import org.testng.annotations.Test;

import base.BaseTester;
import base.CaseDataProvider;

public class saveExcelTester extends BaseTester{
	@Override
	protected String getCurrentPageName() {
		return "另存为Excel";
	}
  @Test(dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void ywcl_dbsx_saveExcel_success_test_case(YwclDbsxSaveExcelSuccessData saveExcelSuccessData) {
	  to("login_after_url");
	  windowsMaximize();
	  click("业务处理");
	  click("待办事项");
	  switchTo("待办事项内联框架");
	  theadSleep(2000);
	  click("另存为excel按钮");
	  theadSleep(2000);
	  assertIsFileDownLoad(saveExcelSuccessData.getDownloadPath(), saveExcelSuccessData.getFileName());
  }


}
