package testcase.weeklyScheduling.delate;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import base.BaseTester;

public class DelateTester extends BaseTester {
	@Override
	protected String getCurrentPageName() {
		return "删除";
	}

	@Test
	public void weeklyScheduling_delate_success_test_case() {
		to("search_url");
		windowsMaximize();
		click("排课管理");
		click("一周排课");
		// 切换到内联框架iframe中
		switchTo("内联框架");
		//获取删除前列表数量
		int num=getListNum("课程");
		click("删除按钮");
		theadSleep(2000);
		click("确认按钮");
		theadSleep(2000);
		//获取删除后列表数量
		int num1=getListNum("课程");
		assertNum(num, num1+1);
	}
	
	@Test(enabled=false)
	public void weeklyScheduling_delate_failure_test_case() {
		to("search_url");
		windowsMaximize();
		click("排课管理");
		click("一周排课");
		// 切换到内联框架iframe中
		switchTo("内联框架");
		//获取列表数量
		int num=getListNum("课程");
		click("删除按钮");
		theadSleep(2000);
		click("取消按钮");
		int num1=getListNum("课程");
		assertNum(num, num1);
	}

}
