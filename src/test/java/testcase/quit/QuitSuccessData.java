package testcase.quit;

import pojo.ExcelObject;

public class QuitSuccessData extends ExcelObject{
	private String partialUrl;

	public String getPartialUrl() {
		return partialUrl;
	}

	public void setPartialUrl(String partialUrl) {
		this.partialUrl = partialUrl;
	}

	@Override
	public String toString() {
		return "QuitSuccessData [partialUrl=" + partialUrl + "]";
	}
	

}
