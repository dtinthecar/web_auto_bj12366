package base;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.apache.bcel.generic.NEW;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.steadystate.css.util.ThrowCssExceptionErrorHandler;

import pojo.Locator;
import util.DbUtils;
import util.LocatorUtils;
import util.ParamUtils;
import util.PropertiesFileUtils;
import util.WebAutoUtils;

public abstract class BaseTester {
	private static Logger logger = Logger.getLogger(BaseTester.class);
	private String pageName;
	public static WebDriver driver = null;
	private static String ywbh;
	protected static ArrayList<String> cyhList = new ArrayList<>();

	// 断言失败用
	public static boolean flag = true;
	public static List<Error> errors = new ArrayList<>();

	protected abstract String getCurrentPageName();

	public static WebDriver getDriver() {
		return driver;
	}

	// @BeforeSuite
	// @Parameters({"browserName","seleniumVersion"})
	// public void beforeSuite(String browserName,String seleniumVersion) {
	// driver = WebAutoUtils.getWebDriver(browserName, seleniumVersion);
	// }

	@BeforeSuite
	public void BeforeSuite() {
		driver = WebAutoUtils.getWebDriver("chrome", "2.x");
	}

	@BeforeSuite
	public void setCookie() {
		driver.get(PropertiesFileUtils.get("url"));
		Options options = driver.manage();
		options.addCookie(new Cookie("_u", PropertiesFileUtils.get("_u")));
		options.addCookie(new Cookie("bj12366_5555", PropertiesFileUtils.get("bj12366_5555")));

	}

	@AfterSuite
	public void afterSuite() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

	/**
	 * 硬性等待
	 * 
	 * @param long1
	 */
	protected void theadSleep(long long1) {
		try {
			Thread.sleep(long1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * string转换成int
	 * 
	 * @param string
	 * @return
	 */
	protected int stringToInt(String string) {
		return Integer.parseInt(string);
	}

	/**
	 * js语句执行方法
	 * 
	 * @param jString
	 */
	protected void jsExcute(String jString) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript(jString);
	}

	// ------------------------------------------------------寻找元素begin-------------------------------------------------------------------
	/**
	 * 窗口最大化
	 */
	protected void windowsMaximize() {
		driver.manage().window().maximize();
	}

	protected WebElement getElement(By by) {
		return getElement(by, 5L);
	}

	/**
	 * 通过选项名和定位名来选择某一个选项
	 * 
	 * @param Name
	 */
	protected void select1(String locatorName, String SelectorName) {
		List<WebElement> list = getElements(locatorName);
		for (WebElement webElement : list) {
			if (SelectorName.equals(webElement.getText())) {
				webElement.click();
			}
		}

	}

	/**
	 * 通过定位名，选择框选项索引选择选项
	 * 
	 * @param locatorName
	 * @param index
	 */
	protected void select(String locatorName, String index) {
		Select select = getSelect(locatorName);
		// 将字符串转成整型
		int index1 = Integer.parseInt(index);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		select.selectByIndex(index1);
	}

	/**
	 * 元素的清空操作
	 * 
	 * @param locatorName
	 */
	protected void clear(String locatorName) {
		logger.info("开始清空操作");
		getElement(getCurrentPageName(), locatorName).clear();
	}

	protected void clear(String pageName, String locatorName) {
		getElement(pageName, locatorName).clear();
	}

	/**
	 * 通过页面名和定位名获取元素
	 * 
	 * @param pageName
	 * @param locatorName
	 * @return
	 */
	protected WebElement getElement(String pageName, String locatorName) {
		Locator locator = LocatorUtils.getLocatorByPageNameAndLocatorName(pageName, locatorName);
		return getElement(locator);

	}

	/**
	 * 通过定位名获取元素
	 * 
	 * @param locatorName
	 * @return
	 */
	protected WebElement getElement(String locatorName) {
		return getElement(getCurrentPageName(), locatorName);

	}

	protected WebElement getElement(Locator locator) {
		return getElement(locator, 10L);
	}

	protected WebElement getElement(Locator locator, Long timeOutInseconds) {
		
		WebDriverWait driverWait = new WebDriverWait(driver, timeOutInseconds);
		final By by2 = getBy(locator);
		WebElement element = driverWait.until(new ExpectedCondition<WebElement>() {

			@Override
			public WebElement apply(WebDriver input) {
				// TODO Auto-generated method stub
				return driver.findElement(by2);// dom结构中存在
			}
		});
		return element;
		
		
	}

	protected WebElement getElement(By by, Long timeOutInseconds) {
		WebDriverWait driverWait = new WebDriverWait(driver, timeOutInseconds);

		WebElement element = driverWait.until(new ExpectedCondition<WebElement>() {

			@Override
			public WebElement apply(WebDriver input) {
				// TODO Auto-generated method stub
				return driver.findElement(by);// dom结构中存在
			}
		});
		return element;
	}

	/**
	 * 智能等待，通过页面名定位名获取元素列表
	 * 
	 * @param pageName
	 * @param locatorName
	 * @return
	 */
	protected List<WebElement> getElements(String pageName, String locatorName) {
		Locator locator = LocatorUtils.getLocatorByPageNameAndLocatorName(pageName, locatorName);
		WebDriverWait wait = new WebDriverWait(driver, 5L);
		final By by2 = getBy(locator);
		List<WebElement> elements = wait.until(new ExpectedCondition<List<WebElement>>() {

			@Override
			public List<WebElement> apply(WebDriver input) {
				return driver.findElements(by2);
			}
		});
		logger.info("得到的列表是：" + elements);
		return elements;
	}

	/**
	 * 智能等待，通过定位名获取元素列表
	 * 
	 * @param locatorName
	 * @return
	 */
	protected List<WebElement> getElements(String locatorName) {
		return getElements(getCurrentPageName(), locatorName);
	}

	/**
	 * 智能等待去获取元素的文本，只有当元素文本长度大于0的时候返回
	 * 
	 * @param by
	 * @return
	 */
	public String getElementTextNotNull(String pageName, String locatorName) {
		Locator locator = LocatorUtils.getLocatorByPageNameAndLocatorName(pageName, locatorName);
		WebDriverWait wait = new WebDriverWait(driver, 5L);
		final By by2 = getBy(locator);
		String elementText = wait.until(new ExpectedCondition<String>() {

			@Override
			public String apply(WebDriver input) {
				// 先获取这个元素
				WebElement element = driver.findElement(by2);
				// 如果元素不为空，并且元素文本不为空且长度大于0
				if (element != null && element.getText() != null && element.getText().length() > 0) {
					logger.info("文本内容为:" + element.getText());
					return element.getText();

				}
				return null;
			}
		});
		return elementText;
	}

	public String getElementTextNotNull(String locatorName) {
		return getElementTextNotNull(getCurrentPageName(), locatorName);
	}

	private By getBy(Locator locator) {
		String type = locator.getType();
		String value = locator.getValue();
		By by = null;
		if ("id".equalsIgnoreCase(type)) {
			by = By.id(value);
		} else if ("name".equalsIgnoreCase(type)) {
			by = By.name(value);
		} else if ("className".equalsIgnoreCase(type)) {
			by = by.className(value);
		} else if ("xpath".equalsIgnoreCase(type)) {
			by = By.xpath(value);
		} else if ("cssSelector".equalsIgnoreCase(type)) {
			by = By.cssSelector(value);
		} else if ("linkText".equalsIgnoreCase(type)) {
			by = By.linkText(value);
		} else if ("partialLinkText".equalsIgnoreCase(type)) {
			by = By.partialLinkText(value);
		} else if ("tagName".equalsIgnoreCase(type)) {
			by = By.tagName(value);
		} else {
			throw new RuntimeException("没有这种定位方式！");
		}
		final By by2 = by;
		return by2;
	}

	protected WebElement getElementToBeClickable(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	// --------------------------------------------找元素方法-----------------------------------------------------------------------------------
	// protected void click(By by) {
	// getElement(by).click();
	// }
	/**
	 * 获取所有的窗口句柄
	 * 
	 * @return
	 */
	protected ArrayList<String> getAllWindowHandles() {
		Set<String> set = driver.getWindowHandles();
		ArrayList<String> arrayList = new ArrayList<>(set);
		return arrayList;
	}

	/**
	 * 通过窗口句柄，切换到某个新打开的页面
	 * 
	 * @param index
	 */
	protected void switchToHandle(int index) {
		ArrayList<String> arrayList = getAllWindowHandles();
		logger.info("句柄列表：" + arrayList);
		String handle = arrayList.get(index);
		driver.switchTo().window(handle);
		theadSleep(1000);
	}

	/**
	 * 通过定位名获取列表数
	 * 
	 * @param locatorName
	 * @return
	 */
	protected int getListNum(String locatorName) {
		return getListNum(getCurrentPageName(), locatorName);
	}

	/**
	 * 通过页面名和定位名获取列表数
	 * 
	 * @param pageName
	 * @param locatorName
	 * @return
	 */
	protected int getListNum(String pageName, String locatorName) {
		List<WebElement> list = getElements(locatorName);
		logger.info("列表数量为：" + list.size());
		return list.size();
	}

	/**
	 * 通过页面名和定位名进行点击
	 * 
	 * @param pageName
	 * @param locatorName
	 */
	protected void click(String pageName, String locatorName) {		
			Locator locator = LocatorUtils.getLocatorByPageNameAndLocatorName(pageName, locatorName);
			getElement(locator).click();
		
		
	}

	/**
	 * 通过定位名进行点击
	 * 
	 * @param locatorName
	 */
	protected void click(String locatorName) {
		click(getCurrentPageName(), locatorName);

	}

	/*
	 * 通过定位名移动鼠标到元素位置
	 */
	protected void moveToElement(String locatorName) {
		moveToElement(getCurrentPageName(), locatorName);
	}

	protected void moveToElement(String pageName, String locatorName) {
		Actions actions = new Actions(driver);
		actions.moveToElement(getElement(locatorName)).perform();
	}

	// protected void type(By by, String content) {
	// getElement(by).sendKeys(content);
	// }
	/**
	 * 切换到内联框架方法
	 * 
	 * @param locatorName
	 */
	protected void switchTo(String locatorName) {
		switchTo(getCurrentPageName(), locatorName);
		theadSleep(2000);
	}

	protected void switchTo(String pageName, String locatorName) {
		Locator locator = LocatorUtils.getLocatorByPageNameAndLocatorName(pageName, locatorName);
		driver.switchTo().frame(getElement(locator));
	}

	protected void alertAccept() {
		getAlert().accept();
	}

	/**
	 * 回到默认页面内容
	 */
	protected void switchToDefalut() {
		driver.switchTo().defaultContent();
	}

	/**
	 * 输入内容方法
	 * 
	 * @param pageName
	 * @param locatorName
	 * @param content
	 */
	protected void type(String pageName, String locatorName, String content) {
		
			Locator locator = LocatorUtils.getLocatorByPageNameAndLocatorName(pageName, locatorName);
			getElement(locator).sendKeys(content);

	}

	protected void type(String locatorName, String content) {
		type(getCurrentPageName(), locatorName, content);

	}

	protected void type(Locator locator, String content) {
		getElement(locator).sendKeys(content);

	}

	/**
	 * 输入定位名，得到下拉框
	 * 
	 * @param locatorName
	 */
	protected Select getSelect(String locatorName) {
		return getSelect(getCurrentPageName(), locatorName);

	}

	/**
	 * 输入定位名和页面名，得到下拉框
	 * 
	 * @param locatorName，pageName
	 */
	protected Select getSelect(String pageName, String locatorName) {
		Locator locator = LocatorUtils.getLocatorByPageNameAndLocatorName(pageName, locatorName);
		Select select = new Select(getElement(locator));
		return select;

	}

	// protected String gText(By by) {
	// return getElement(by).getText();
	// }

	protected String gText(String pageName, String locatorName) {
		Locator locator = LocatorUtils.getLocatorByPageNameAndLocatorName(pageName, locatorName);
		return getElement(locator).getText();
	}

	protected void to(String urlKey) {
		driver.get(PropertiesFileUtils.get(urlKey));

	}

	/**
	 * checkBox勾选方法
	 * 
	 * @param locatorName
	 * @param num
	 */
	protected void clickCheckBox(String locatorName, String num) {

		List<WebElement> list = getElements(locatorName);
		if (num != null) {
			int a = Integer.parseInt(num);
			int sum = 1;
			for (int i = 0; i < list.size(); i++) {
				if (sum < a) {
					list.get(i).click();
					sum += i;
				}
			}
		}

	}

	/**
	 * 得到checkbox和常用语列表，勾选了那几个checkbox就记录对应的常用语到list,用于后面断言勾选的常用语和处理意见是否一致
	 * 
	 * @param locatorName1
	 * @param locatorName2
	 * @param num
	 */
	protected void clickCheckBox(String locatorName1, String locatorName2, String num) {

		List<WebElement> list = getElements(locatorName1);
		List<WebElement> nrList = getElements(locatorName2);
		if (num != null) {
			int a = Integer.parseInt(num);
			int sum = 1;
			for (int i = 0; i < list.size(); i++) {
				if (sum < a) {
					list.get(i).click();
					String nr = nrList.get(i).getText();
					cyhList.add(nr);
					sum += i;
				}
			}
		}

	}

	/**
	 * 通过2个索引选择checkbox
	 * 
	 * @param locatorName
	 * @param index1
	 * @param index2
	 */
	protected void clickCheckBoxByIndex(String locatorName, String index1, String index2) {
		List<WebElement> list = getElements(locatorName);
		logger.info("checkBox列表大小为：" + list.size());
		int a = Integer.parseInt(index1);
		int b = Integer.parseInt(index2);
		list.get(a).click();
		list.get(b).click();
	}

	/**
	 * 通过一个索引选择checkBox
	 * 
	 * @param locatorName
	 * @param index1
	 */
	protected void clickCheckBoxByIndex(String locatorName, String index1) {
		List<WebElement> list = getElements(locatorName);
		if (index1 != null) {
			int a = Integer.parseInt(index1);
			list.get(a).click();
		}

	}

	/**
	 * 选择某一个radio
	 * 
	 * @param locatorName
	 * @param num
	 *            第几个索引的radio,num为页面上第几个radio-1,因为list索引从0开始
	 */
	protected void clickRadio(String locatorName, String num) {
		List<WebElement> list = getElements(locatorName);
		int a = Integer.parseInt(num);
		list.get(a).click();
	}

	/**
	 * 根据文本内容匹配点击radio
	 * 
	 * @param locatorName
	 * @param text
	 */
	protected void clickRadioByText(String locatorName, String text) {
		List<WebElement> list = getElements(locatorName);
		for (WebElement webElement : list) {
			if (webElement.getText().equals(text)) {
				webElement.click();
			}
		}
	}

	/**
	 * 通过匹配到当前环节名，点击对应的处理按钮，且只处理一条工单，并把当前工单casebh添加到ParamUtils的全局数据池
	 * 
	 * @param locatorName1
	 *            当前环节列表
	 * @param locatorName2
	 *            处理按钮列表
	 * @param dqhjName
	 *            excel中当前环节名
	 * @param loccatorName3
	 *            业务编号列表
	 */
	protected void clickHandle(String locatorName1, String locatorName2, String locatorName3, String dqhjName) {
		int num = 0;
		List<WebElement> dqhjList = getElements(locatorName1);
		List<WebElement> handleList = getElements(locatorName2);
		// 业务编号列表
		List<WebElement> ywbhList = getElements(locatorName3);
		for (int i = 0; i < dqhjList.size(); i++) {
			if (dqhjName.equals(dqhjList.get(i).getText()) && num < 1) {
				handleList.get(i).click();
				ywbh = ywbhList.get(i).getText();
				ParamUtils.addGlobalData("casebh", ywbh);
				num += 1;
				System.out.println(num);

			}
		}
	}

	protected void clickHandle(String locatorName1, String locatorName2, String dqhjName) {
		int num = 0;
		List<WebElement> dqhjList = getElements(locatorName1);
		List<WebElement> handleList = getElements(locatorName2);
		for (int i = 0; i < dqhjList.size(); i++) {
			if (dqhjName.equals(dqhjList.get(i).getText()) && num < 1) {
				handleList.get(i).click();
				num += 1;
				System.out.println(num);

			}
		}
	}

	/**
	 * 当ywbh列表中的ywbh与变量ywbh匹配时，点击对应索引的处理按钮
	 * 
	 * @param locatorName1
	 *            ywbh列表
	 * @param locatorName2
	 *            处理按钮列表
	 */
	protected void clickHandle(String locatorName1, String locatorName2) {
		List<WebElement> ywbhList = getElements(locatorName1);
		List<WebElement> handleList = getElements(locatorName2);
		for (int i = 0; i < ywbhList.size(); i++) {
			if (ywbhList.get(i).getText() != null && ywbhList.get(i).getText().equals(ywbh)) {
				handleList.get(i).click();
			}
		}
	}

	/**
	 * 获取alert框
	 * 
	 * @return
	 */
	protected Alert getAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 5L);
		return wait.until(new ExpectedCondition<Alert>() {

			@Override
			public Alert apply(WebDriver input) {
				return driver.switchTo().alert();

			}
		});
	}

	/**
	 * 获取alert框文本内容
	 * 
	 * @return
	 */
	protected String getAlertText() {
		Alert alert = getAlert();
		WebDriverWait wait = new WebDriverWait(driver, 10L);
		String text = wait.until(new ExpectedCondition<String>() {

			@Override
			public String apply(WebDriver input) {
				if (alert.getText() != null && alert.getText().length() > 0) {
					logger.info("Allert文本内容为：" + alert.getText());
					return alert.getText();

				}
				return null;
			}

		});
		alert.accept();
		return text;

	}

	protected boolean isAlertPresent() {
		try {

			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}

	protected String getInputValue(String locatorName) {
		String value = getElement(locatorName).getAttribute("value");
		// 去除内容中的换行并返回
		return value.replace("\n", "");
	}

	// ------------------------------------------------------寻找元素end-------------------------------------------------------------------

	// ------------------------------------------------------断言方法begin-------------------------------------------------------------------
	/**
	 * 断言指定页面某元素不为空，并且和期望值相等
	 * 
	 * @param locatorName
	 *            元素的名称
	 * @param expected
	 *            期望值
	 */
	protected void assertElementTextEquls(String locatorName, String expected) {
		
			String actual = getElementTextNotNull(locatorName);			
			Assert.assertEquals(actual, expected);	
		
	}

	
	/**
	 * 断言跳转后的url是否包含某一部分
	 * 
	 * @param partialUrl
	 *            部分url
	 */
	protected void assertPageUrlContains(String partialUrl) {
		Assert.assertTrue(CurrentPageUrlContains(partialUrl));
	}

	// 判断跳转后的页面是否包含部分url
	protected boolean CurrentPageUrlContains(String partialUrl) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				String currentUrl = driver.getCurrentUrl();
				return currentUrl != null && currentUrl.contains(partialUrl);

			}
		});

	}

	/**
	 * 断言搜索结果的正确性
	 * 
	 * @param string
	 * @param expected
	 */
	protected void assertSearchResult(String locatorName, String expected) {
		List<WebElement> elements = getElements(locatorName);
		for (WebElement webElement : elements) {
			String actual = webElement.getText();
			// System.out.println(actual);
			assertEquals(actual, expected);
		}

	}

	/**
	 * 断言开始和结束时间是否在时间搜索范围内
	 * 
	 * @param beginTime
	 * @param endTime
	 * @param expectedBeginTime
	 * @param expectedEndTime
	 */
	protected void assertDateIn(String beginTime, String endTime, String assertBeginTime, String assertEndTime) {
		List<WebElement> beginTimes = getElements(beginTime);
		List<WebElement> endTimes = getElements(endTime);
		if (beginTimes != null) {
			for (WebElement webElement : beginTimes) {
				String actual = webElement.getText();
				// System.out.println(actual);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = null;
				try {
					date = sdf.parse(actual);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				Date date2 = null;
				try {
					date2 = sdf.parse(assertBeginTime);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				int result = date.compareTo(date2);
				// System.out.println(result);
				assertEquals(result, 1);
			}
		}

		if (endTimes != null) {
			for (WebElement webElement : endTimes) {
				String actual = webElement.getText();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = null;
				try {
					date = sdf.parse(actual);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				Date date2 = null;
				try {
					date2 = sdf.parse(assertEndTime);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				int result = date.compareTo(date2);
				assertEquals(result, -1);
			}
		}

	}

	/**
	 * 断言重置条件
	 * 
	 * @param courseName
	 * @param termName
	 * @param beginTimeName
	 * @param endTimeName
	 * @param tittleName
	 * @param teacherName
	 */
	protected void assertReset(String courseName, String termName, String beginTimeName, String endTimeName,
			String tittleName, String teacherName) {
		// 断言课程下拉框
		Select courseSelect = getSelect(courseName);
		WebElement element = courseSelect.getFirstSelectedOption();
		String text = element.getText();
		assertEquals(text, "--请选择--");
		// 断言期数下拉框
		Select termSelect = getSelect(termName);
		WebElement element1 = termSelect.getFirstSelectedOption();
		String text1 = element1.getText();
		assertEquals(text1, "--请选择--");
		// 断言开始时间
		WebElement beginElement = getElement(beginTimeName);
		String actual = beginElement.getAttribute("value");
		assertEquals(actual, "");
		// 断言结束时间
		WebElement endElement = getElement(endTimeName);
		String actual1 = endElement.getAttribute("value");
		assertEquals(actual1, "");
		// 断言标题
		WebElement tittleElement = getElement(tittleName);
		String actual2 = tittleElement.getAttribute("value");
		assertEquals(actual2, "");
		// 断言老师
		Select teacherSelect = getSelect(courseName);
		WebElement element2 = teacherSelect.getFirstSelectedOption();
		String text2 = element2.getText();
		assertEquals(text2, "--请选择--");

	}

	protected void assertSave(String locator1, String locator2, String locator3, String locator4, String locator5,
			String locator6, String expected1, String expected2, String tittle, String beginTime, String endTime,
			String expected3) {
		int sum = 0;
		List<WebElement> list1 = getElements(locator1);
		List<WebElement> list2 = getElements(locator2);
		List<WebElement> list3 = getElements(locator3);
		List<WebElement> list4 = getElements(locator4);
		List<WebElement> list5 = getElements(locator5);
		List<WebElement> list6 = getElements(locator6);
		for (WebElement webElement : list1) {
			if (expected1.equals(webElement.getText())) {
				sum = sum + 1;
			}
		}
		for (WebElement webElement : list2) {
			if (expected2.equals(webElement.getText())) {
				sum = sum + 1;
			}
		}
		for (WebElement webElement : list3) {
			if (tittle.equals(webElement.getText())) {
				sum = sum + 1;
			}
		}
		for (WebElement webElement : list4) {
			if (beginTime.equals(webElement.getText())) {
				sum = sum + 1;
			}
		}
		for (WebElement webElement : list5) {
			if (endTime.equals(webElement.getText())) {
				sum = sum + 1;
			}
		}
		for (WebElement webElement : list6) {
			if (expected3.equals(webElement.getText())) {
				sum = sum + 1;
			}
		}
		assertEquals(sum, 6);
	}

	/**
	 * 断言int类型的数量是否相等
	 * 
	 * @param num1
	 * @param num2
	 */
	protected void assertNum(int num1, int num2) {
		assertEquals(num1, num2);
	}

	protected void assertNum(String locatorName, String sql) {
		int a = getListNum(locatorName);
		String actual = a + "";
		logger.info("actural值为：" + actual);
		List<LinkedHashMap<String, Object>> allResultSet = DbUtils.excuteQuery(sql);
		Object dbNum = 0;
		for (LinkedHashMap<String, Object> linkedHashMap : allResultSet) {
			dbNum = linkedHashMap.get("COUNT(1)");
		}
		String expected = dbNum.toString();
		logger.info("数据库查询到的数量为：" + dbNum);
		assertEquals(actual, expected);
	}

	/**
	 * 断言元素是否可编辑（点击，输入等）
	 * 
	 * @param locatorName
	 */
	protected void assertEnabled(String locatorName) {
		WebElement element = getElement(locatorName);
		Boolean flag = element.isEnabled();
		assertTrue(flag);
	}

	/**
	 * 断言元素是否可见
	 * 
	 * @param locatorName
	 */
	protected void assertIsDisplayed(String locatorName) {
		boolean flag = getElement(locatorName).isDisplayed();
		logger.info("开始断言元素是否可见");
		assertTrue(flag);
	}

	/**
	 * 断言文件下载是否成功
	 * 
	 * @param downloadPath
	 * @param fileName
	 */
	protected void assertIsFileDownLoad(String downloadPath, String fileName) {
		boolean flag = isFileDownloaded(downloadPath, fileName);
		assertTrue(flag);
	}

	protected boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();
		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals(fileName))
				return flag = true;
		}

		return flag;
	}

	/**
	 * 断言工单流转提交后是否流转到指定环节
	 * 
	 * @param locatorName1
	 *            业务编号列表定位名
	 * @param locatorName2
	 *            当前环节列表定位名
	 * @param expectedDqhj
	 *            excel中期望流转环节名
	 */
	protected void assertGdTansferSubmit(String locatorName1, String locatorName2, String expectedDqhj) {
		// 业务编号列表
		List<WebElement> ywbhList = getElements(locatorName1);
		// 当前环节列表
		List<WebElement> dqhjList = getElements(locatorName2);
		for (int i = 0; i < ywbhList.size(); i++) {
			if (ywbh != null && ywbh.equals(ywbhList.get(i).getText())) {
				{
					assertEquals(dqhjList.get(i).getText(), expectedDqhj);
				}

			}
		}
	}

	/**
	 * 断言工单流转提交时的alert框提示内容
	 * 
	 * @param expectedAlertText
	 */
	protected void assertAlertText(String expectedAlertText) {
		String actualAlertText = getAlertText();
		assertEquals(actualAlertText, expectedAlertText);

	}
	
	protected void assertAlertTextContains(String expectedAlertText){
		String actualAlertText = getAlertText();
		
	}

	/**
	 * 断言工单转外部系统后流转方式与数据库是否匹配
	 * 
	 * @param sql
	 * @param key
	 * @param expected
	 */
	protected void assertClfsInDataBase(String sql, String key, String expected) {
		// 替换casebh
		String replaceSql = ParamUtils.getReplacedStr(sql);
		logger.info("替换后的sql为：" + replaceSql);
		List<LinkedHashMap<String, Object>> dbList = DbUtils.excuteQuery(replaceSql);
		for (LinkedHashMap<String, Object> linkedHashMap : dbList) {
			// 得到casewbxt
			Object value = linkedHashMap.get(key);
			String valueString = value.toString();
			logger.info("casewbxt实际值为" + valueString);
			assertEquals(valueString, expected);

		}
	}

	/**
	 * 断言多选的常用语和处理意见是否一致
	 * 
	 * @param locatorName
	 */
	protected void assertStringEquals(String locatorName) {
		// 将list中的常用语格式化成string
		String expected = String.join("", cyhList);
		assertEquals(getInputValue(locatorName), expected);
	}

	// ------------------------------------------------------断言方法end-------------------------------------------------------------------
}
