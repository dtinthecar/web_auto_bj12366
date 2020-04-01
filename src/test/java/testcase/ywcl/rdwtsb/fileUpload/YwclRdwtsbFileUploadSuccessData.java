package testcase.ywcl.rdwtsb.fileUpload;

import pojo.ExcelObject;

public class YwclRdwtsbFileUploadSuccessData extends ExcelObject{
	private String uploadPath;

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	@Override
	public String toString() {
		return "YwclRswtsbFileUploadSuccessData [uploadPath=" + uploadPath + "]";
	}
	

}
