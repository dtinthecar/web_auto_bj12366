package testcase.ywcl.dbsx.tscl.bj;

import pojo.ExcelObject;

public class YwclDbsxTsclBjSuccessData extends ExcelObject{
	//Ywlb	Suggestion	Dqhj	Clfs	Expected	Sql	Key
	private String ywlb;
	private String suggestion;
	private String dqhj;
	private String clfs;
	private String expected;
	private String sql;
	private String key;
	public String getYwlb() {
		return ywlb;
	}
	public void setYwlb(String ywlb) {
		this.ywlb = ywlb;
	}
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	public String getDqhj() {
		return dqhj;
	}
	public void setDqhj(String dqhj) {
		this.dqhj = dqhj;
	}
	public String getClfs() {
		return clfs;
	}
	public void setClfs(String clfs) {
		this.clfs = clfs;
	}
	public String getExpected() {
		return expected;
	}
	public void setExpected(String expected) {
		this.expected = expected;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	@Override
	public String toString() {
		return "YwclDbsxTsclBjSuccessData [ywlb=" + ywlb + ", suggestion=" + suggestion + ", dqhj=" + dqhj + ", clfs="
				+ clfs + ", expected=" + expected + ", sql=" + sql + ", key=" + key + "]";
	}


}
