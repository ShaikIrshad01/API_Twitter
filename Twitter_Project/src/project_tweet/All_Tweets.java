package project_tweet;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class All_Tweets extends Test_Tweet{
	Logger log=Logger.getLogger("All_Tweets");
		@Test 
		public void allTweets() throws Exception {// all tweets by a user
		
		PropertyConfigurator.configure("C:\\Users\\Online Test\\git\\SecondProject\\Twitter_Project\\src\\project_tweet\\log4j.properties");
		RestAssured.baseURI=url();
		Response res= test().
		queryParam("count", "15").
		when().get("/statuses/home_timeline.json").then().assertThat().statusCode(200).and().extract().response();
		String Response = res.asString();
		log.info(Response);
		JsonPath js = new JsonPath(Response);
		String id = js.get("id").toString();
		log.info("id="+id);
		String text = js.get("text").toString();
		log.info("All_tweets="+text);
	}
}
