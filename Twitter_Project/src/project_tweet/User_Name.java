package project_tweet;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class User_Name extends Test_Tweet {//printing user name
		@Test 
		public void usernameTweet() throws Exception {
			Logger log=Logger.getLogger("usernameTweet");
			PropertyConfigurator.configure("C:\\Users\\Online Test\\git\\SecondProject\\Twitter_Project\\src\\project_tweet\\log4j.properties");		
		RestAssured.baseURI=url();
		Response res= test().
		queryParam("q", "#Qualitest").
		when().get("/search/tweets.json").then().assertThat().statusCode(200).and().extract().response();
		String Response = res.asString();
		log.info(Response);
		//System.out.println(Response);
		JsonPath js = new JsonPath(Response);
		String username=js.get("statuses[0].user.name").toString();
		log.info("username="+username);
		//System.out.println("username="+username);
		String id=js.get("statuses[0].id").toString();
		log.info("user_id="+id);
		//System.out.println("user_id="+id);
	}

}
