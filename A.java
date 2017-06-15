package one;

import org.testng.annotations.Test;

public class A {

	public static String ID;
	@Test
	public void test1()
	{
		ID = "INDIAN";
	}
}


<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.jbehave</groupId>
		<artifactId>jbehave</artifactId>
		<version>4.1.1</version>
	</parent>
	<artifactId>oneplan-jbehave-automation-suite</artifactId>
	<name>Oneplan TestCases Execution in JBehave</name>

	<dependencies>
		<dependency>
			<groupId>org.jbehave</groupId>
			<artifactId>jbehave-core</artifactId>
			<version>${project.version}</version>
		</dependency>
		<!-- <dependency> <groupId>org.codehaus.groovy</groupId> <artifactId>groovy-all</artifactId> 
			<version>2.4.6</version> </dependency> -->
		<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>2.53.1</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.jbehave.web/jbehave-web-selenium -->
		<dependency>
			<groupId>org.jbehave.web</groupId>
			<artifactId>jbehave-web-selenium</artifactId>
			<version>3.3</version>
		</dependency>

		<dependency>
			<groupId>com.verizon.nts.qe.traceability</groupId>
			<artifactId>TestLogger</artifactId>
			<version>4.0.4</version>
			<classifier>jar-with-dependencies</classifier>
		</dependency>

		<dependency>
			<groupId>org.openqa.selenium.core</groupId>
			<artifactId>selenium-core</artifactId>
			<version>1.0-20080914.225453</version>
		</dependency>
		<dependency>
			<groupId>org.openqa.selenium.server</groupId>
			<artifactId>selenium-server</artifactId>
			<version>1.0-20081010.060147</version>
		</dependency>
		<dependency>
			<groupId>org.testng</groupId>
			<artifactId>testng</artifactId>
			<version>6.9.9</version>
		</dependency>
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi</artifactId>
			<version>3.9</version>
		</dependency>


		<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml-schemas -->
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi-ooxml-schemas</artifactId>
			<version>3.16</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi-ooxml</artifactId>
			<version>3.16</version>
		</dependency>
		<dependency>
			<groupId>com.relevantcodes</groupId>
			<artifactId>extentreports</artifactId>
			<version>2.41.1</version>
		</dependency>
	</dependencies>

	<repositories>
		<repository>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
			<id>central</id>
			<name>libs-release</name>
			<url>https://oneartifactory.verizon.com/artifactory/repo1</url>
		</repository>
		<repository>
			<snapshots />
			<id>snapshots</id>
			<name>libs-snapshot</name>
			<url>http://oneartifactory.verizon.com/artifactory/libs-snapshot</url>
		</repository>



		<repository>
			<id>Verizon_Artifactory</id>
			<name>Verizon_Artifactory-releases</name>
			<url>https://oneartifactory.verizon.com/artifactory/TCEV_REGIONALQE</url>
		</repository>
	</repositories>

	<properties>
		<maven.compiler.source>1.8</maven.compiler.source>
		<maven.compiler.target>1.8</maven.compiler.target>
		<embeddables>**/JbehaveExecutor.java</embeddables>
		<ignore.failure.in.stories>true</ignore.failure.in.stories>
		<meta.filter>+Run -noRun</meta.filter>
		<threads>${Pthreads}</threads>
		<stories.to.execute>${stories}</stories.to.execute>
		<story.timeout.in.secs>4500</story.timeout.in.secs>
	</properties>

	<build>

		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.6.1</version>
				<configuration>
					<source>1.8</source>
					<target>1.8</target>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.jbehave</groupId>
				<artifactId>jbehave-maven-plugin</artifactId>
				<version>4.1.1</version>
				<configuration>
					<maven.compiler.source>1.8</maven.compiler.source>
					<maven.compiler.target>1.8</maven.compiler.target>
				</configuration>
				<executions>
					<execution>
						<id>unpack-view-resources</id>
						<phase>pre-integration-test</phase>
						<goals>
							<goal>unpack-view-resources</goal>
						</goals>
					</execution>
					<execution>
						<id>embeddable-stories</id>
						<phase>integration-test</phase>
						<configuration>
							<includes>
								<include>${embeddables}</include>
							</includes>
							<excludes />
							<skip>${skip}</skip>
							<batch>false</batch>
							<threads>${threads}</threads>
							<storyTimeoutInSecs>${story.timeout.in.secs}</storyTimeoutInSecs>
							<generateViewAfterStories>true</generateViewAfterStories>
							<ignoreFailureInStories>${ignore.failure.in.stories}</ignoreFailureInStories>
							<ignoreFailureInView>true</ignoreFailureInView>
							<metaFilters>
								<metaFilter>${meta.filter}</metaFilter>
							</metaFilters>
						</configuration>
						<goals>
							<goal>run-stories-as-embeddables</goal>
						</goals>
					</execution>
				</executions>
				<dependencies>
					<!-- Only needed if groovy-based MetaFilters are used -->
					<!-- <dependency> <groupId>org.codehaus.groovy</groupId> <artifactId>groovy-all</artifactId> 
						<version>1.8.4</version> </dependency> -->
				</dependencies>
			</plugin>
		</plugins>
	</build>

	<profiles>
		<profile>
			<id>fail-fast</id>
			<properties>
				<ignore.failure.in.stories>false</ignore.failure.in.stories>
			</properties>
		</profile>
	</profiles>
</project>


---------------------------------------
package com.verizon.oneplan.jbehaveexecutor;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.embedder.StoryTimeouts.TimeoutParser;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import com.verizon.oneplan.steps.commonsteps.GenericSteps;
import com.verizon.oneplan.steps.fios.FiOS_Service_Actuals_Report;
import com.verizon.oneplan.steps.fios.FiOS_WC_Relationship;
import com.verizon.oneplan.steps.fios.FiOS_WC_Splitter;

public class JbehaveExecutor extends JUnitStories {

	public JbehaveExecutor() {
		Embedder embedder = configuredEmbedder();
		System.out.println("number of threads Before" + embedder.embedderControls().threads());

		embedder.embedderControls().doGenerateViewAfterStories(true).doIgnoreFailureInStories(true)
				.doIgnoreFailureInView(true).doVerboseFiltering(true).useStoryTimeouts("7secs")
				.doFailOnStoryTimeout(false);
		embedder.useMetaFilters(Arrays.asList("groovy: story_path ==~ /.*long.*/"));
		embedder.useTimeoutParsers(new CustomTimeoutParser());
		System.out.println("number of threads After" + embedder.embedderControls().threads());

	}

	@Override
	public Configuration configuration() {
		Class<? extends Embeddable> embeddableClass = this.getClass();
		return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath(embeddableClass))
				.useStoryControls(new StoryControls().useStoryMetaPrefix("story_").useScenarioMetaPrefix("scenario_")) // optional
																														// prefixes
				.useStoryReporterBuilder(new StoryReporterBuilder()
						.withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass)).withDefaultFormats()
						.withFormats(CONSOLE, HTML).withFailureTrace(true).withFailureTraceCompression(true));
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new GenericSteps(), new FiOS_WC_Relationship(),
				new FiOS_WC_Splitter(), new FiOS_Service_Actuals_Report());
	}

	@Override
	protected List<String> storyPaths() {
		System.out.println("stories.to.execute value from POM file :" + System.getProperty("stories.to.execute"));

		if (System.getProperty("stories.to.execute") == null) {
			return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/FIOS_WC_Splitter.story", "");
		} else {
			return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()),
					System.getProperty("stories.to.execute"), "");
		}
	}

	public static class CustomTimeoutParser implements TimeoutParser {

		public boolean isValid(String timeout) {
			return timeout.matches("(\\d+)secs");
		}

		public long asSeconds(String timeout) {
			return Long.parseLong(StringUtils.substringBefore(timeout, "secs"));
		}

	}

}
--------------------------------------------------------------------
	
	package com.verizon.oneplan.base;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Named;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.verizon.oneplan.commons.OnePlan_Util;
import com.verizon.oneplan.commons.Print_Util;
import com.verizon.oneplan.commons.WebDriverGenerics;
import com.verizon.oneplan.commons.WebDriverUtil;
import com.verizon.oneplan.extentreport.ExtentReports;
import com.verizon.oneplan.steps.commonsteps.GenericSteps;
import com.verizon.qe.traceability.TestLogger;

public class driverInitialization {
	// public ExtentReports extent = new
	// ExtentReports("C:\\Jenkins_Slave\\workspace\\NTS.NUAV.RQNUUI_Automation.Selenium.MasterSuite\\RQN-UUI-AutomationSuiteExtentReportsTestNG.html",
	// false);
	// public ExtentTest test;
	private static ThreadLocal<RemoteWebDriver> driver1 = new ThreadLocal<RemoteWebDriver>();
	public static ThreadLocal<HashMap<String, String>> hm = new ThreadLocal<HashMap<String, String>>();
	public WebDriverUtil WebDriverUtil = new WebDriverUtil();
	OnePlan_Util OnePlan_Util = new OnePlan_Util();
	ExtentReports ExtentReports = new ExtentReports();
	Print_Util Print_Util = new Print_Util();
	static String CurrentUrl;
	 public static String ApplPropFilePath = System.getProperty("user.dir")
	 +
	 "/src/main/java/com/verizon/oneplan/commons/Application.properties";
	//public static String ApplPropFilePath = "**/Application.properties";

	@BeforeStories
	public void beforeStoriess() {

		System.out.println("starting the extent report ");
		ExtentReports.startExtentReport();
	}

	@BeforeStory
	public void beforeClass() {
		RemoteWebDriver driver = null;
		try {
			System.out.println("driverInitialization  ");
			ExtentReports.startExtentTestCase("Application Launch", "Launching the Application");
			System.out.println("ApplPropFilePath" + ApplPropFilePath);
			String enviornment = OnePlan_Util.getPropValuesFromFile(ApplPropFilePath, "MachineEnviornment");
			switch (enviornment) {
			case "Local":

				String nodeUrl = "https://vplansit.ebiz.verizon.com/";
				File file = new File("C://Users//IEDriverServer.exe"); // ***
				System.out
						.println("SystemPath--------------" + System.getProperty("user.dir") + "\\IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\IEDriverServer.exe");
				// System.setProperty("webdriver.ie.driver",
				// file.getAbsolutePath() );
				DesiredCapabilities descap1 = DesiredCapabilities.internetExplorer();
				System.out.println(descap1);

				System.out.println("setWebDriverd");

				descap1.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				descap1.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				driver = new InternetExplorerDriver(descap1);
				break;

			case "Grid":
				System.setProperty("webdriver.ie.driver", "C:\\SeleniumGrid\\IEDriverServer.exe");
				DesiredCapabilities cap = DesiredCapabilities.internetExplorer();

				Print_Util.logDebug("Starting RemoteDriver ......Running in  Grid Machine");
				cap.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
				cap.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
				cap.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
				cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				cap.setJavascriptEnabled(true);
				cap.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
				cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
				cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				cap.setBrowserName("internet explorer");
				cap.setPlatform(Platform.ANY);
				driver = new RemoteWebDriver(new URL("http://dockerselenium.ebiz.verizon.com/wd/hub"), cap);
				break;

			}

			// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			setWebDriver(driver);
			HashMap<String, String> hm1 = new HashMap<String, String>();

			setHM(hm1);

			System.out.println("driver::" + getDriver());

			System.out.println("driverf::" + driver);

			driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

			Print_Util.logDebug("Got IE Web Driver Instance ..");
			Print_Util.logMessage("Opening browser------");

			// NAvigating to URL
			driver.manage().window().maximize();

			String OnePlanURL = OnePlan_Util.getPropValuesFromFile(ApplPropFilePath, "OnePlanUrl_SIT");

			Print_Util.logMessage("Application URL is :" + OnePlanURL);
			driver.get(OnePlanURL);
			Thread.sleep(10000);
			// WebDriverUtil.waitForPageLoaded(driver);
			Print_Util.logMessage("URL Successfully Launched...!");
			GenericSteps commonStep = new GenericSteps();
			if (!commonStep.login_Junit(driver)) {
				// when exception occurs while login
				Print_Util.logError("Not Able to login into Oneplan ");
				Assert.fail("Not Able to login into Oneplan");
			} else {
				WebDriverUtil.waitForPageLoaded(driver);
				OnePlan_Util.click(driver, By.id("oneplan"));
				WebDriverUtil.waitForPageLoaded(driver);
				OnePlan_Util.click(driver, By.name("myButton"));
				WebDriverUtil.waitForPageLoaded(driver);
				// WebDriverGenerics.verifyPageTitle("Oneplan Home");
				CurrentUrl = driver.getCurrentUrl();
				Print_Util.logDebug(
						"-------------------------------------------------------------------------------------------------------------------");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WebDriver getDriver() {
		return driver1.get();
	}

	public HashMap<String, String> getHM() {
		return hm.get();
	}

	public void setHM(HashMap<String, String> hm1) {
		System.out.println("HM...");
		hm.set(hm1);
		System.out.println(hm);
	}

	public void setWebDriver(RemoteWebDriver driver5) {
		System.out.println("setWebDriver");
		driver1.set(driver5);
		System.out.println(driver1);
	}

	@BeforeScenario
	public void BeforeScenario(@Named("UserStoryID") String UserStoryID, @Named("JiraTestCaseID") String JiraTestCaseID,
			@Named("TestCaseName") String TestCaseName, @Named("TestDescription") String TestDescription) {
		System.err.println("@BeforeScenario");
		// WebDriverGenerics.resultSet = new ArrayList<Boolean>(); // Collect
		// all
		// testStatus
		WebDriverGenerics WebDriverGenerics = new WebDriverGenerics(); // value
																		// in
																		// list
		ExtentReports.startExtentTestCase(TestCaseName, TestDescription);
		WebDriverGenerics.navigateToURL(getDriver(), CurrentUrl);
		// testStatus = true;

	}

	@AfterScenario
	public void AfterScenario(@Named("UserStoryID") String UserStoryID, @Named("JiraTestCaseID") String JiraTestCaseID)
			throws Exception {

		System.err.println("@AfterScenario");
		System.err.println("Test Validation status :: " + WebDriverGenerics.resultSet);
		updateResultTestLogger(UserStoryID, JiraTestCaseID);

		
		ExtentReports.endExtentReport();
		Print_Util.logDebug(
				"-------------------------------------------------------------------------------------------------------------------");
	}

	@AfterStory
	public void afterClass() {
		// ExtentReports.startExtentTestCase("Application Close", "Closing the
		// Application");
		System.err.println("Inside @AfterStory");
		getDriver().quit();

		Print_Util.logDebug(
				"-------------------------------------------------------------------------------------------------------------------");

		// driver1.set(null);
	}

	@AfterStories
	public void afterstoriess() {
		ExtentReports.endExtentFlush();
	}
	
	public  boolean updateResultTestLogger(String UserStoryID, String JiraTestCaseID) throws Exception {
		System.out.println("updateResultDB method");
		boolean value = false;
		String[] multipleTestcaseIDs = null;
		try {
			if (JiraTestCaseID.contains(",")) {
				multipleTestcaseIDs = JiraTestCaseID.split(",");
			} else {
				multipleTestcaseIDs = new String[] { JiraTestCaseID };
			}
			for (int i = 0; i < multipleTestcaseIDs.length; i++) {
				Print_Util.logDebug("multipleTestcaseID and result:"+multipleTestcaseIDs[i]+" "+ WebDriverGenerics.resultSet.toString());
				Print_Util.logDebug("UserStoryID: "+UserStoryID);
				if (!WebDriverGenerics.resultSet.contains(false) && !WebDriverGenerics.resultSet.isEmpty()) {
					TestLogger.postUrl(UserStoryID, multipleTestcaseIDs[i].trim(), "PASSED", "BeforeAfter.class");
					Assert.assertTrue(true);
					Print_Util.logMessage("Scenario Passed");
				} else {
					TestLogger.postUrl(UserStoryID, multipleTestcaseIDs[i].trim(), "FAILED", "BeforeAfter.class");
					Assert.assertFalse(false);
					Print_Util.logError("Scenario Failed");
				}

			}

			Print_Util.ts_debug("Successfully Updated Test results into DashBoard though test Logger: ");

		} catch (Exception e) {
			e.printStackTrace();
			Print_Util.ts_debug("Failed in Updating Test results into DashBoard though Test Logger: ");
		}
		return value;

	}
}
