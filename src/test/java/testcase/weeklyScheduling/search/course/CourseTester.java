package testcase.weeklyScheduling.search.course;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.GetCookie;

import base.BaseTester;
import base.CaseDataProvider;

public class CourseTester extends BaseTester{
	@Override
	protected String getCurrentPageName() {
		return "一周排课课程搜索";
	}
	
  @Test(dataProvider="dp",dataProviderClass=CaseDataProvider.class)
  public void weeklyScheduling_search_course_success_test_case(WeeklySchedulingSearchCourseSuccessData searchSuccessData) {

	  to("search_url");	 
	  click("排课管理");
	  click("一周排课");
	  //切换到内联框架iframe中
	  switchTo("内联框架");

	  Select courseSelect= getSelect("报名课程下拉框");
	  courseSelect.selectByIndex(3);
//	  Select termSeleect=getSelect("期数下拉框");
//	  termSeleect.selectByIndex(0);
//	  type("起始时间", searchSuccessData.getBeginTime());
//	  type("终止时间", searchSuccessData.getEndTime());
//	  type("标题", searchSuccessData.getTittle());
//	  Select teacherSelect=getSelect("老师");
//	  teacherSelect.selectByIndex(0);
	  click("搜索按钮");
	  try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	  assertSearchResult("课程",searchSuccessData.getExpected());
  }





}
