package testNG_Class;

import org.testng.Assert;
import org.testng.annotations.Test;
@Test
public class Test3 {

	void testCase3(){
		
		Assert.assertFalse(true);
		System.out.println("I should be failed_3");
	}
}
