package base;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.ExcelUtils;

public class CaseDataProvider {
 @DataProvider
 public static Object[][] dp(Method method){
	// 获得执行测试用例的方法名
			String methodName = method.getName();
			// 分割
			String[] array = methodName.split("_");
			String excelPath=null;
			String classPath=null;
			if (array.length==4) {
				String folderName = array[0];
				// 得到检查点的名称、类名的第二部分
				String caseFileName = array[1];
				// 组装出excel的路径:/testcase/login/failure.xlsx
				excelPath = "/testcase/" + folderName + "/" + caseFileName + ".xlsx";
				// 得到类名的第一部分，首字母大写
				String classNamePart1 = (folderName.charAt(0) + "").toUpperCase() + folderName.substring(1);
				// 得到类名的第二部分，首字母大写
				String classNamePart2 = (caseFileName.charAt(0) + "").toUpperCase() + caseFileName.substring(1);
				String totalClassName = classNamePart1 + classNamePart2 + "Data";// LoginFailureData
				classPath = "testcase." + folderName + "." + totalClassName;
//				System.out.println(classPath);
			}else if (array.length==5) {
				String name1 = array[0];
				// 得到检查点的名称、类名的第二部分
				String name2 = array[1];
				String name3=array[2];
				// 组装出excel的路径:/testcase/weeklyScheduling/search/success.xlsx
				excelPath = "/testcase/" + name1 + "/" + name2 + "/"+name3+".xlsx";
				// 得到类名的第一部分，首字母大写
				String classNamePart1 = (name1.charAt(0) + "").toUpperCase() + name1.substring(1);
				// 得到类名的第二部分，首字母大写
				String classNamePart2 = (name2.charAt(0) + "").toUpperCase() + name2.substring(1);
				//得到类名的第三部分
				String classNamePart3 = (name3.charAt(0) + "").toUpperCase() + name3.substring(1);
				String totalClassName = classNamePart1 + classNamePart2 + classNamePart3+"Data";// LoginFailureData
				classPath = "testcase." + name1+"." +name2+ "." + totalClassName;
			}
			else if(array.length==6) {
				String name1 = array[0];
				// 得到检查点的名称、类名的第二部分
				String name2 = array[1];
				String name3=array[2];
				String name4=array[3];
				// 组装出excel的路径:/testcase/weeklyScheduling/search/course/success.xlsx
				excelPath = "/testcase/" + name1 + "/" + name2 + "/"+name3+"/"+name4+".xlsx";
				// 得到类名的第一部分，首字母大写
				String classNamePart1 = (name1.charAt(0) + "").toUpperCase() + name1.substring(1);
				// 得到类名的第二部分，首字母大写
				String classNamePart2 = (name2.charAt(0) + "").toUpperCase() + name2.substring(1);
				//得到类名的第三部分
				String classNamePart3 = (name3.charAt(0) + "").toUpperCase() + name3.substring(1);
				//得到类名的第四部分
				String classNamePart4 = (name4.charAt(0) + "").toUpperCase() + name4.substring(1);
				//拼接类名
				String totalClassName = classNamePart1 + classNamePart2 + classNamePart3+classNamePart4+"Data";
				classPath = "testcase." + name1+"." +name2+ "." +name3+"."+ totalClassName;
			}
			else if (array.length==7) {
				String name1 = array[0];
				// 得到检查点的名称、类名的第二部分
				String name2 = array[1];
				String name3=array[2];
				String name4=array[3];
				String name5=array[4];
				//拼接excel路径
				excelPath = "/testcase/" + name1 + "/" + name2 + "/"+name3+"/"+name4+"/"+name5+".xlsx";
				String classNamePart1 = (name1.charAt(0) + "").toUpperCase() + name1.substring(1);
				String classNamePart2 = (name2.charAt(0) + "").toUpperCase() + name2.substring(1);
				String classNamePart3 = (name3.charAt(0) + "").toUpperCase() + name3.substring(1);
				String classNamePart4 = (name4.charAt(0) + "").toUpperCase() + name4.substring(1);
				String classNamePart5 = (name5.charAt(0) + "").toUpperCase() + name5.substring(1);
				//拼接类名
				String totalClassName = classNamePart1 + classNamePart2 + classNamePart3+classNamePart4+classNamePart5+"Data";
				classPath = "testcase." + name1+"." +name2+ "." +name3+"."+name4+"."+ totalClassName;
			}
			else if (array.length==8) {
				String name1 = array[0];
				// 得到检查点的名称、类名的第二部分
				String name2 = array[1];
				String name3=array[2];
				String name4=array[3];
				String name5=array[4];
				String name6=array[5];
				//拼接excel路径
				excelPath = "/testcase/" + name1 + "/" + name2 + "/"+name3+"/"+name4+"/"+name5+"/"+name6+".xlsx";
				String classNamePart1 = (name1.charAt(0) + "").toUpperCase() + name1.substring(1);
				String classNamePart2 = (name2.charAt(0) + "").toUpperCase() + name2.substring(1);
				String classNamePart3 = (name3.charAt(0) + "").toUpperCase() + name3.substring(1);
				String classNamePart4 = (name4.charAt(0) + "").toUpperCase() + name4.substring(1);
				String classNamePart5 = (name5.charAt(0) + "").toUpperCase() + name5.substring(1);
				String classNamePart6 = (name6.charAt(0) + "").toUpperCase() + name6.substring(1);
				//拼接类名
				String totalClassName = classNamePart1 + classNamePart2 + classNamePart3+classNamePart4+classNamePart5+classNamePart6+"Data";
				classPath = "testcase." + name1+"." +name2+ "." +name3+"."+name4+"."+name5+"."+ totalClassName;
			}
			Class clazz = null;
			try {
				clazz = Class.forName(classPath);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			//得到数据列表
			ArrayList<Object> objs = ExcelUtils.readExcel(excelPath, 0, clazz);
			//组装到object类型的二维数组
			// 创建一个二维数组
			Object[][] datas = new Object[objs.size()][];
			for (int index = 0; index < objs.size(); index++) {
				Object[] itemArray = { objs.get(index) };// 每个LoginFailData对象保存到一个一维数组
				datas[index] = itemArray;// 把每个一维数组放到二维数组对应索引
			}
			
			return datas;
	 
  }
}
