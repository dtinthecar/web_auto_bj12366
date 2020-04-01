package util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseTester;

public class ScreenShootUtils {
	public static File getScreenShoot(String filePath) {
		//把driver强转成TakesScreenshot
		TakesScreenshot takesScreenshot=(TakesScreenshot) BaseTester.getDriver();
		//截屏为一个文件对象，此为源文件
		File srcFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		//创建一个目标文件
		File destFile=new File(filePath);
		//利用工具拷贝源文件到目标文件
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile;
	}

}
