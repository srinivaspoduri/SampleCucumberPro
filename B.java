package one;

import org.testng.annotations.Test;

public class B {
	
	
	@Test
	public void test2()
	{
		System.out.println("in test2 method class B");
		System.out.println(A.ID);
	}

}


/*


java -jar "jar name " -role hub

java -Dwebdriver.ie.driver="C:\Users\PODURSR\Desktop\Automation\IEDriverServer.exe" -jar selenium-server-standalone-2.41.0 -role node -hub http://locahost:4444/grid/register/


no need to set system property as we are passing it through DWebdriver in crating node it slef.

*/
