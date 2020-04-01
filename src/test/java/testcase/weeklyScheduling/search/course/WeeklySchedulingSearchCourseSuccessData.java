package testcase.weeklyScheduling.search.course;

import pojo.ExcelObject;

public class WeeklySchedulingSearchCourseSuccessData extends ExcelObject{
	
	private String expected;

	public String getExpected() {
		return expected;
	}
	public void setExpected(String expected) {
		this.expected = expected;
	}
	@Override
	public String toString() {
		return "WeeklySchedulingSearchSuccessData [expected=" + expected + "]";
	}
	
	
	

}
