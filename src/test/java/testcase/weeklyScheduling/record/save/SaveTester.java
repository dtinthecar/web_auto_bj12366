package testcase.weeklyScheduling.record.save;

import org.testng.annotations.Test;

import base.BaseTester;
import base.CaseDataProvider;

public class SaveTester extends BaseTester {
	@Override
	protected String getCurrentPageName() {
		return "保存录课";
	}

	@Test(dataProvider = "dp", dataProviderClass = CaseDataProvider.class)
	public void weeklyScheduling_record_save_success_test_case(WeeklySchedulingRecordSaveSuccessData recordSaveData) {
		to("search_url");
		windowsMaximize();
		click("排课管理");
		click("一周排课");
		// 切换到内联框架iframe中
		switchTo("内联框架");
		click("我要录课");
		switchTo("内联框架2");
		theadSleep(2000);
//		select("报班课程选择框", 1);
//		select("期数选择框", 1);
		type("课程标题", recordSaveData.getTittle());
//		select("上课老师选择框", 1);
		type("课程开始时间", recordSaveData.getBeginTime());
		type("课程结束时间", recordSaveData.getEndTime());
		click("保存");
		switchTo("内联框架");
		assertSave("机构课程", "期数", "课标题", "课开始时间", "课结束时间", "上课老师", recordSaveData.getExpected1(),
				recordSaveData.getExpected2(), recordSaveData.getTittle(), recordSaveData.getBeginTime(),
				recordSaveData.getEndTime(), recordSaveData.getExpected3());
	}

	

}
