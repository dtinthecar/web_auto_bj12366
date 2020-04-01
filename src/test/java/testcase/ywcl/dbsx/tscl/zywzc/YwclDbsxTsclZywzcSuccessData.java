package testcase.ywcl.dbsx.tscl.zywzc;

import pojo.ExcelObject;

public class YwclDbsxTsclZywzcSuccessData extends ExcelObject{
//	Ywlb	Suggestion

	private String ywlb;
	private String suggestion;
	private String dqhj;
	private String clfs;
	private String expectedDqhj;
	
	
	public String getExpectedDqhj() {
		return expectedDqhj;
	}
	public void setExpectedDqhj(String expectedDqhj) {
		this.expectedDqhj = expectedDqhj;
	}
	public String getClfs() {
		return clfs;
	}
	public void setClfs(String clfs) {
		this.clfs = clfs;
	}
	public String getDqhj() {
		return dqhj;
	}
	public void setDqhj(String dqhj) {
		this.dqhj = dqhj;
	}
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
	@Override
	public String toString() {
		return "YwclDbsxTsclZywzcSuccessData [ywlb=" + ywlb + ", suggestion=" + suggestion + ", dqhj=" + dqhj
				+ ", clfs=" + clfs + ", expectedDqhj=" + expectedDqhj + "]";
	}

	
	

}
