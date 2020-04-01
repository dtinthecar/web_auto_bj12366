package testcase.query.ywjlCx.dateCx;

import pojo.ExcelObject;

public class QueryYwjlCxDateCxSuccessData extends ExcelObject{
	private String beginTime;
	private String endTime;
	private String sql;
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
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	@Override
	public String toString() {
		return "QueryYwjlCxDateCxSuccessData [beginTime=" + beginTime + ", endTime=" + endTime + ", sql=" + sql + "]";
	}
	

}
