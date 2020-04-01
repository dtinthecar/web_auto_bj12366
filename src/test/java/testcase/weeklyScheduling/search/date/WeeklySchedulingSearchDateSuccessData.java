package testcase.weeklyScheduling.search.date;

import pojo.ExcelObject;

public class WeeklySchedulingSearchDateSuccessData extends ExcelObject{
	//BeginTime	EndTime	Expected

	private String beginTime;
	private String endTime;
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "WeeklySchedulingSearchDateSuccessData [beginTime=" + beginTime + ", endTime=" + endTime + "]";
	}
	

}
