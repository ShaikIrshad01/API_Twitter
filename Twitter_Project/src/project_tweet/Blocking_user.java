package project_tweet;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class Blocking_user extends Test_Tweet {
	
	static Logger log=Logger.getLogger("Blocking_user");
		@Test 
		public void getTweet() throws Exception {//blocking a user	
		PropertyConfigurator.configure("C:\\Users\\Online Test\\git\\SecondProject\\Twitter_Project\\src\\project_tweet\\log4j.properties");
		RestAssured.baseURI=url();
		Response res= test().
		queryParam("screen_name", "Shaik_Irshad0").
		when().post("/blocks/create.json").then().assertThat().statusCode(200).and().extract().response();		
		String Response = res.asString();
		log.info("Blocking="+Response);
		//System.out.println("Blocking="+Response);
		}
		
		//unblocking
		@AfterTest
		public static void blocking() throws Exception {
		RestAssured.baseURI=url();
		Response res1=test().
		queryParam("screen_name", "Shaik_Irshad0").
		when().post("/blocks/destroy.json").then().assertThat().statusCode(200).and().extract().response();
		String Response1 = res1.asString();
		log.info("Unblocking="+Response1);
		//System.out.println("Unblocking="+Response1);
		}

}