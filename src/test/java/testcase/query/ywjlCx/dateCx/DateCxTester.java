package testcase.query.ywjlCx.dateCx;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import base.BaseTester;
import base.CaseDataProvider;

public class DateCxTester extends BaseTester{
	@Override
	protected String getCurrentPageName() {
		return "时间查询页面";
	}
	
  @Test(dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void query_ywjlCx_dateCx_success_test_case(QueryYwjlCxDateCxSuccessData dateCxSuccessData) {
	  to("login_after_url");
	  windowsMaximize();
	  click("综合查询");
	  click("业务记录查询");
	  switchTo("业务记录查询内联框架");
	  theadSleep(2000);
	  click("开始时间选择按钮");
	  click("开始时间日期");
	  click("结束时间选择按钮");
	  click("结束时间日期");
//	  clear("开始时间输入框");
//	  clear("结束时间输入框");
//	  type("开始时间输入框", dateCxSuccessData.getBeginTime());
//	  type("结束时间输入框", dateCxSuccessData.getEndTime());
	  click("查询按钮");
	  theadSleep(2000);
	  assertNum("查询结果", dateCxSuccessData.getSql());
  }


}
