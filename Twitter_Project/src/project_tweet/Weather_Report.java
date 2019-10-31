package project_tweet;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class Weather_Report extends Test_Tweet {
		@Test 
		public void usernameTweet() throws Exception {//Weather report
			Logger log=Logger.getLogger("usernameTweet");
			PropertyConfigurator.configure("C:\\Users\\Online Test\\git\\SecondProject\\Twitter_Project\\src\\project_tweet\\log4j.properties");
			RestAssured.baseURI=url();
				Response res= test().
				queryParam("q", "Bangalore, weather").
				when().get("/search/tweets.json").then().assertThat().statusCode(200).and().extract().response();
		String Response = res.asString();
		log.info(Response);
		//System.out.println(Response);
		JsonPath js = new JsonPath(Response);
		String text = js.get("statuses[0].text").toString();
		
		if(text.contains("weather")) {
		//System.out.println("Weather_Report="+text);
		log.info("Weather_Report="+text);
		}
}}
