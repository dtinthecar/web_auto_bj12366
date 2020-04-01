package testcase.weeklyScheduling.reset;

import pojo.ExcelObject;

public class WeeklySchedulingResetSuccessData extends ExcelObject{
	//BeginTime	EndTime	Tittle
    private String beginTime;
    private String endTime;
    private String tittle;
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
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	@Override
	public String toString() {
		return "WeeklyschedulingResetSuccessData [beginTime=" + beginTime + ", endTime=" + endTime + ", tittle="
				+ tittle + "]";
	}
    

}
