package testcase.ywsl.xcsl.scfj;

import pojo.ExcelObject;

public class YwslXcslScfjSuccessData extends ExcelObject{
	//Path	Tips
	private String  path;
	private String  tips;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	@Override
	public String toString() {
		return "YwslXcslScfjSuccessData [path=" + path + ", tips=" + tips + "]";
	}
	
}
