package testcase.weeklyScheduling.search.date;

import org.testng.annotations.Test;

import base.BaseTester;
import base.CaseDataProvider;

public class DateTester extends BaseTester{
	@Override
	protected String getCurrentPageName() {
		return "一周排课时间搜索";
	}
  @Test(dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void weeklyScheduling_search_date_success_test_case(WeeklySchedulingSearchDateSuccessData searchSuccessData) {
	  to("search_url");	 
	  click("排课管理");
	  click("一周排课");
	  //切换到内联框架iframe中
	  switchTo("内联框架");
	  type("起始时间", searchSuccessData.getBeginTime());
	  type("终止时间", searchSuccessData.getEndTime());
	  click("搜索按钮");
	  try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	  assertDateIn("开始时间","结束时间",searchSuccessData.getBeginTime(),searchSuccessData.getEndTime());
  }

}
