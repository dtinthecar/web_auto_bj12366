package testcase.query.ywjlCx.ywlbCx;

import pojo.ExcelObject;

public class QueryYwjlCxYwlbCxSuccessData extends ExcelObject{
	//YwlbIndex	GshjlxIndex	Sql
	private String ywlb;
	private String gshjlx;
	private String sql;
	public String getYwlb() {
		return ywlb;
	}
	public void setYwlb(String ywlb) {
		this.ywlb = ywlb;
	}
	public String getGshjlx() {
		return gshjlx;
	}
	public void setGshjlx(String gshjlx) {
		this.gshjlx = gshjlx;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	@Override
	public String toString() {
		return "QueryYwjlCxYwlbCxSuccessData [ywlb=" + ywlb + ", gshjlx=" + gshjlx + ", sql=" + sql + "]";
	}
	
}
