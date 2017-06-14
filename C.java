package one;

import org.testng.annotations.Test;

public class C {
	
	@Test
	public void test3()
	{
		System.out.println("in test3 method in class C");
		A objA = new A();
		System.out.println(objA.ID);
	}
	<project name="VPlan_Automation" basedir=".">
	<property name="src.dir" value="${basedir}/src" />
	<property name="build.dir" value="${basedir}/bin" />
		
	<property name="testng_output.dir" value="${basedir}/test-output" />
	<property name="lib.dir" value="${basedir}/lib" />

	<!-- get class path, used for build -->
	<path id="classpath">
	<pathelement location="${build.dir}" />
	<fileset dir="${lib.dir}" includes="*.jar"/>
	</path>

	<!-- create build folder, testng_output folder and remove old log file -->
	<target name="init">
	<delete dir="${basedir}/bin" />
	<delete dir="${basedir}/test-output" />
	<delete dir="${basedir}/Screenshot" />
	<delete dir="${basedir}/testng-xslt" />
	<mkdir dir="${basedir}/test-output" />
	<mkdir dir="${basedir}/Screenshot" />
	<mkdir dir="${basedir}/bin" />
	</target>

	<!-- build all java file to class binary -->
	<target name="compile" depends="init"  >
	<javac srcdir="${src.dir}" destdir="${build.dir}" classpathref="classpath" includeantruntime="false" debug="true" fork="true">
	</javac>
	
	<echo> /* Compiled Directory Classes */ </echo>
	</target>
	
 	<!-- Config for HealthCheck -->
	<taskdef name="testng" classname="org.testng.TestNGAntTask" classpathref="classpath" >
	<classpath>
	<!-- locate testng jar file-->
     <pathelement location="${lib.dir}/testng-6.9.13.6.jar"/>
     </classpath>
    </taskdef>

	<!-- execute testng after compile, then generate report -->
	<target name="Run" depends="compile" >
	<!-- config testng -->
	<testng outputdir="${testng_output.dir}" classpathref="classpath" useDefaultListeners="true">
	<!-- execute testcase follow testng.xml -->
	 <!--<xmlfileset dir="${basedir}" includes="VPlan_HealthCheck.xml"/>-->	
		
	<xmlfileset dir="${basedir}" includes="FiOS.xml"/>
	<xmlfileset dir="${basedir}" includes="LDP.xml"/>
	<xmlfileset dir="${basedir}" includes="DART.xml"/>
	<xmlfileset dir="${basedir}" includes="vPM.xml"/>
	<xmlfileset dir="${basedir}" includes="DynamicBW.xml"/>
	<xmlfileset dir="${basedir}" includes="TransNet.xml"/>
	<xmlfileset dir="${basedir}" includes="SAVOptimization.xml"/>
	<xmlfileset dir="${basedir}" includes="TPlanning.xml"/>
	<xmlfileset dir="${basedir}" includes="CNET.xml"/>	
	<xmlfileset dir="${basedir}" includes="VTF.xml"/>
	<xmlfileset dir="${basedir}" includes="TSF.xml"/>
	<xmlfileset dir="${basedir}" includes="ICET.xml"/>
		
		
	<!-- generate report title -->
	<sysproperty key="org.uncommons.reportng.title" value="VPLAN Automation" />
	<sysproperty key="org.uncommons.reportng.escape-output" value="false" />
	</testng>
	</target>

	<target name="FiOS" depends="compile" >
	<!-- config testng -->
	<testng outputdir="${testng_output.dir}" classpathref="classpath" useDefaultListeners="true">
	<!-- execute testcase follow testng.xml -->
	<xmlfileset dir="${basedir}" includes="FiOS.xml"/>
	<!-- generate report title -->
	<sysproperty key="org.uncommons.reportng.title" value="VPLAN Automation" />
	<sysproperty key="org.uncommons.reportng.escape-output" value="false" />
	</testng>
	</target>
	
	<target name="DART" depends="compile" >
	<!-- config testng -->
	<testng outputdir="${testng_output.dir}" classpathref="classpath" useDefaultListeners="true">
	<!-- execute testcase follow testng.xml -->
	<xmlfileset dir="${basedir}" includes="DART.xml"/>
	<!-- generate report title -->
	<sysproperty key="org.uncommons.reportng.title" value="VPLAN Automation" />
	<sysproperty key="org.uncommons.reportng.escape-output" value="false" />
	</testng>
	</target>
	
	<target name="VPM" depends="compile" >
	<!-- config testng -->
	<testng outputdir="${testng_output.dir}" classpathref="classpath" useDefaultListeners="true">
	<!-- execute testcase follow testng.xml -->
	<xmlfileset dir="${basedir}" includes="vPM.xml"/>
	<!-- generate report title -->
	<sysproperty key="org.uncommons.reportng.title" value="VPLAN Automation" />
	<sysproperty key="org.uncommons.reportng.escape-output" value="false" />
	</testng>
	</target>
	
	<target name="DynamicBW" depends="compile" >
	<!-- config testng -->
	<testng outputdir="${testng_output.dir}" classpathref="classpath" useDefaultListeners="true">
	<!-- execute testcase follow testng.xml -->
	<xmlfileset dir="${basedir}" includes="DynamicBW.xml"/>
	<!-- generate report title -->
	<sysproperty key="org.uncommons.reportng.title" value="VPLAN Automation" />
	<sysproperty key="org.uncommons.reportng.escape-output" value="false" />
	</testng>
	</target>
	
	<target name="CNet" depends="compile" >
	<!-- config testng -->
	<testng outputdir="${testng_output.dir}" classpathref="classpath" useDefaultListeners="true">
	<!-- execute testcase follow testng.xml -->
	<xmlfileset dir="${basedir}" includes="CNET.xml"/>
	<!-- generate report title -->
	<sysproperty key="org.uncommons.reportng.title" value="VPLAN Automation" />
	<sysproperty key="org.uncommons.reportng.escape-output" value="false" />
	</testng>
	</target>
	
	<target name="TPlanning" depends="compile" >
	<!-- config testng -->
	<testng outputdir="${testng_output.dir}" classpathref="classpath" useDefaultListeners="true">
	<!-- execute testcase follow testng.xml -->
	<xmlfileset dir="${basedir}" includes="TPlanning.xml"/>
	<!-- generate report title -->
	<sysproperty key="org.uncommons.reportng.title" value="VPLAN Automation" />
	<sysproperty key="org.uncommons.reportng.escape-output" value="false" />
	</testng>
	</target>
		
	<target name="SAV Optimization" depends="compile" >
	<!-- config testng -->
	<testng outputdir="${testng_output.dir}" classpathref="classpath" useDefaultListeners="true">
	<!-- execute testcase follow testng.xml -->
	<xmlfileset dir="${basedir}" includes="SAVOptimization.xml"/>
	<!-- generate report title -->
	<sysproperty key="org.uncommons.reportng.title" value="VPLAN Automation" />
	<sysproperty key="org.uncommons.reportng.escape-output" value="false" />
	</testng>
	</target>
	
	<target name="TransNet" depends="compile" >
	<!-- config testng -->
	<testng outputdir="${testng_output.dir}" classpathref="classpath" useDefaultListeners="true">
	<!-- execute testcase follow testng.xml -->
	<xmlfileset dir="${basedir}" includes="TransNet.xml"/>	
	<!-- generate report title -->
	<sysproperty key="org.uncommons.reportng.title" value="VPLAN Automation" />
	<sysproperty key="org.uncommons.reportng.escape-output" value="false" />
	</testng>
	</target>
	
	<target name="LDP" depends="compile" >
	<!-- config testng -->
	<testng outputdir="${testng_output.dir}" classpathref="classpath" useDefaultListeners="true">
	<!-- execute testcase follow testng.xml -->
	<xmlfileset dir="${basedir}" includes="LDP.xml"/>
	<!-- generate report title -->
	<sysproperty key="org.uncommons.reportng.title" value="VPLAN Automation" />
	<sysproperty key="org.uncommons.reportng.escape-output" value="false" />
	</testng>
	</target>
	
	<target name="TSF" depends="compile" >
	<!-- config testng -->
	<testng outputdir="${testng_output.dir}" classpathref="classpath" useDefaultListeners="true">
	<!-- execute testcase follow testng.xml -->
	<xmlfileset dir="${basedir}" includes="TSF.xml"/>
	<!-- generate report title -->
	<sysproperty key="org.uncommons.reportng.title" value="VPLAN Automation" />
	<sysproperty key="org.uncommons.reportng.escape-output" value="false" />
	</testng>
	</target>
	
	<target name="VTF" depends="compile" >
	<!-- config testng -->
	<testng outputdir="${testng_output.dir}" classpathref="classpath" useDefaultListeners="true">
	<!-- execute testcase follow testng.xml -->
	<xmlfileset dir="${basedir}" includes="VTF.xml"/>
	<!-- generate report title -->
	<sysproperty key="org.uncommons.reportng.title" value="VPLAN Automation" />
	<sysproperty key="org.uncommons.reportng.escape-output" value="false" />
	</testng>
	</target>
	
	<target name="ICET" depends="compile" >
	<!-- config testng -->
	<testng outputdir="${testng_output.dir}" classpathref="classpath" useDefaultListeners="true">
	<!-- execute testcase follow testng.xml -->
	<xmlfileset dir="${basedir}" includes="ICET.xml"/>
	<!-- generate report title -->
	<sysproperty key="org.uncommons.reportng.title" value="VPLAN Automation" />
	<sysproperty key="org.uncommons.reportng.escape-output" value="false" />
	</testng>
	</target>

</project>
echo "Running ant all.."
/usr/share/ant/bin/ant  $XML_To_Execute 
		
		-------------------------------------------------------------------------------
		
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

		

}
