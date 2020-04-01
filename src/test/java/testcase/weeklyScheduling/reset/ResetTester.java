package testcase.weeklyScheduling.reset;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.BaseTester;
import base.CaseDataProvider;

public class ResetTester extends BaseTester{
	@Override
	protected String getCurrentPageName() {
		return "重置条件";
	}
	
  @Test(dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void weeklyScheduling_reset_success_test_case(WeeklySchedulingResetSuccessData resetSuccessData) {
	  to("search_url");
	  click("排课管理");
	  click("一周排课");
	  //切换到内联框架iframe中
	  switchTo("内联框架");
	  Select courseSelect= getSelect("报名课程下拉框");
	  courseSelect.selectByIndex(1);
	  Select termSeleect=getSelect("期数下拉框");
	  termSeleect.selectByIndex(1);
	  type("起始时间", resetSuccessData.getBeginTime());
	  type("终止时间", resetSuccessData.getEndTime());
	  type("标题", resetSuccessData.getTittle());
	  Select teacherSelect=getSelect("老师");
	  teacherSelect.selectByIndex(2);
	  click("重置条件");
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	  assertReset("报名课程下拉框","期数下拉框","起始时间","终止时间","标题","老师");
	  
  }




}