package testcase.welcome.noticeCollect;

import pojo.ExcelObject;

public class WelcomeNoticeCollectSuccessData extends ExcelObject{
	private String collectName;
	private String tips;
	public String getCollectName() {
		return collectName;
	}
	public void setCollectName(String collectName) {
		this.collectName = collectName;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	@Override
	public String toString() {
		return "WelcomeNoticeCollectSuccessData [collectName=" + collectName + ", tips=" + tips + "]";
	}

	
	

}
