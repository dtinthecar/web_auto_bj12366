package testcase.ywcl.dbsx.plqs;

import pojo.ExcelObject;

public class YwclDbsxPlqsSuccessData extends ExcelObject{
	private String num;
	private String tips;
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	@Override
	public String toString() {
		return "YwclDbsxPlqsSuccessData [num=" + num + ", tips=" + tips + "]";
	}

	
	 

}
