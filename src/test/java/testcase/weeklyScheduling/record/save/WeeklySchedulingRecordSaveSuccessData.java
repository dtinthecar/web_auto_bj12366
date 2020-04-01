package testcase.weeklyScheduling.record.save;

import pojo.ExcelObject;

public class WeeklySchedulingRecordSaveSuccessData extends ExcelObject{
	//BeginTime	EndTime	Tittle
	private String beginTime;
	private String endTime;
	private String tittle;
	private String expected1;
	private String expected2;
	private String expected3;

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
	
	public String getExpected1() {
		return expected1;
	}
	public void setExpected1(String expected1) {
		this.expected1 = expected1;
	}
	public String getExpected2() {
		return expected2;
	}
	public void setExpected2(String expected2) {
		this.expected2 = expected2;
	}
	public String getExpected3() {
		return expected3;
	}
	public void setExpected3(String expected3) {
		this.expected3 = expected3;
	}
	@Override
	public String toString() {
		return "weeklySchedulingRecordSaveData [beginTime=" + beginTime + ", endTime=" + endTime + ", tittle=" + tittle
				+ ", expected1=" + expected1 + ", expected2=" + expected2 + ", expected3=" + expected3 + "]";
	}
	


}
