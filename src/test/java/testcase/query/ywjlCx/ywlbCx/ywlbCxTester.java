package testcase.query.ywjlCx.ywlbCx;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseTester;
import base.CaseDataProvider;

public class ywlbCxTester extends BaseTester {
	@Override
	protected String getCurrentPageName() {
		return "业务类别查询页面";
	}

	@Test(dataProvider = "dp", dataProviderClass = CaseDataProvider.class)
	public void query_ywjlCx_ywlbCx_success_test_case(QueryYwjlCxYwlbCxSuccessData YwlbCxSuccessData) {
		to("login_after_url");
		windowsMaximize();
		click("综合查询");
		click("业务记录查询");
		switchTo("业务记录查询内联框架");
		theadSleep(2000);
		click("业务类别选择框");
		select1("业务类别选择列表", YwlbCxSuccessData.getYwlb());
		click("个税汇缴类型选择框");
		select1("个税汇缴类型选择列表", YwlbCxSuccessData.getGshjlx());
		click("查询按钮");
		//断言查询结果数量与数据库是否一致
		assertNum("查询结果", YwlbCxSuccessData.getSql());
		//断言查询结果是否都是同一个类别
		assertSearchResult("查询结果", YwlbCxSuccessData.getYwlb());

	}

}
