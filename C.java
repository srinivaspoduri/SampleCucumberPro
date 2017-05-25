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

}
