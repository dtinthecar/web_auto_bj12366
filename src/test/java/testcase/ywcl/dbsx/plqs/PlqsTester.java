package testcase.ywcl.dbsx.plqs;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import base.BaseTester;
import base.CaseDataProvider;

public class PlqsTester extends BaseTester{
	@Override
	protected String getCurrentPageName() {
		return "批量签收页面";
	}
  @Test(dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void ywcl_dbsx_plqs_success_test_case(YwclDbsxPlqsSuccessData dbsxPlqsSuccessData) {
	  to("login_after_url");
	  windowsMaximize();
	  click("业务处理");
	  click("待办事项");
	  switchTo("待办事项内联框架");
	  theadSleep(2000);
	  //得到工单数量并转成int类型
	  int num1=stringToInt(getElementTextNotNull("工单数量"));
	  clickCheckBox("工单勾选框", dbsxPlqsSuccessData.getNum());
	  click("批量签收按钮");
	  click("批量签收确认按钮");
	  theadSleep(2000);
	  int num2=num1-stringToInt(dbsxPlqsSuccessData.getNum());
	  int num3=stringToInt(getElementTextNotNull("工单数量"));
	  assertNum(num2, num3);
	  //切出iframe框架，回到默认页面
	  switchToDefalut();
	  assertElementTextEquls("成功签收提示框", dbsxPlqsSuccessData.getTips());
	  
	  
  }


}
