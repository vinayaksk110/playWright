package TestBase;

import org.testng.Assert;



public class Test extends TestBase{
	
	@org.testng.annotations.Test
	public void test1() throws InterruptedException {
		log.info("PASS");
		Thread.sleep(2000);
		log.info("from test1: ");
		Assert.assertTrue(true);
		log.info("from test1 testresultstatus: ");
	}
	
	@org.testng.annotations.Test
	public void test2() throws InterruptedException {
		log.info("FAIL");
		Thread.sleep(5000);

		log.info("from test2: ");
		log.error("test error");
		Assert.assertTrue(false);
	}
	
	@org.testng.annotations.Test
	public void test3() throws InterruptedException {
		log.info("PASS");
		Thread.sleep(2000);
		log.info("from test3: ");
		Assert.assertTrue(true);
	}

}
