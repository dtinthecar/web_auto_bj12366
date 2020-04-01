package testcase.ywcl.dbsx.saveExcel;

import pojo.ExcelObject;

public class YwclDbsxSaveExcelSuccessData extends ExcelObject{
	//DownloadPath	FileName
	private String downloadPath;
	private String fileName;
	public String getDownloadPath() {
		return downloadPath;
	}
	public void setDownloadPath(String downloadPath) {
		this.downloadPath = downloadPath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "YwclDbsxSaveExcelSuccessData [downloadPath=" + downloadPath + ", fileName=" + fileName + "]";
	}
	

}
