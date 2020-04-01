package testcase.welcome.notice;

import pojo.ExcelObject;

public class WelcomeNoticeSuccessData extends ExcelObject{
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "WelcomeNoticeSuccessData [title=" + title + "]";
	} 
	

}
