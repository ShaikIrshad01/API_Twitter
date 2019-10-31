package project_tweet;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class Search_Tweet extends Test_Tweet  {//Search for tweets 
		@Test 
		public void searchTweet() throws Exception {
		Logger log=Logger.getLogger("Search_Tweet");
		PropertyConfigurator.configure("C:\\Users\\Online Test\\git\\SecondProject\\Twitter_Project\\src\\project_tweet\\log4j.properties");
		
		RestAssured.baseURI=url();
		Response res= test().
		queryParam("q", "#Qualitest").
		when().get("search/tweets.json").then().assertThat().statusCode(200).and().extract().response();
		String Response = res.asString();
		log.info(Response);
		//System.out.println(Response);
		JsonPath js = new JsonPath(Response);
		String text = js.get("statuses[0].text").toString();
		log.info("search_tweets="+text);
		if(text.contains("#Qualitest")) {
			log.info("testcase=pass");
			
			}else
			{
				log.info("testcase=fail");
			}
		
	}

}
