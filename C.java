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

}
