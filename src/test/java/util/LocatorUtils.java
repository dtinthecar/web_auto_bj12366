package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import pojo.Locator;

public class LocatorUtils {
	private static Map<String, Map<String,Locator>> allPagesMap=new HashMap<>();
	/**
	 * 只加载一次xml
	 */
	static {
		String pagePath=LocatorUtils.class.getClassLoader().getResource("page").getPath();
		readFoldersXmlFiles(pagePath);
	}
	
	/**
	 * 通过pageName获取它的所有locator
	 * @param pageName
	 * @return
	 */
	public static Map<String, Locator> getLocatorsByPageName(String pageName){
		return allPagesMap.get(pageName);
	}
	
	/**
	 * 通过pageName和locatorName获取某个locator信息
	 * @param pageName
	 * @param locatorName
	 * @return
	 */
	public static Locator getLocatorByPageNameAndLocatorName(String pageName,String locatorName) {
		return allPagesMap.get(pageName).get(locatorName);
	}
	
	private static void readXml(String path)  {
		SAXReader saxReader=new SAXReader();
		InputStream inputStream=null;
		Document document=null;
		try {
			inputStream = new FileInputStream(path);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			document = saxReader.read(inputStream);
		} catch (DocumentException e) {
			e.printStackTrace();
		}		
		    Element element=document.getRootElement();
			List<Element> locatorElements=element.elements("locator");	
			String pageName=element.attributeValue("pageName");
			Map<String, Locator> locatorMap =new HashMap<String, Locator>();
			for (Element element2 : locatorElements) {
				
				String name=element2.attributeValue("name");
				String type=element2.attributeValue("type");
				String value=element2.attributeValue("value");
				Locator locator=new Locator(name, type, value);
				locatorMap.put(name, locator);				
			}
			allPagesMap.put(pageName,locatorMap );
			
		}
	
	
	public static void readFoldersXmlFiles(String foldersPath) {
		File file=new File(foldersPath);
		File[] files=file.listFiles();
	   for (File file2 : files) {
           	//子文件的完整路径
			String subfilePath=file2.getAbsolutePath();
			if (file2.isFile()&&subfilePath.endsWith(".xml")) {
				readXml(subfilePath);
			}else {
				readFoldersXmlFiles(subfilePath);
			}
		}
	}
	public static void main(String[] args) {
		Locator locator=getLocatorByPageNameAndLocatorName("登陆页面", "手机号码输入框");
		System.out.println(locator);
	}

}
