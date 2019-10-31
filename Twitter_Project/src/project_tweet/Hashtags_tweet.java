package project_tweet;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import com.sun.mail.handlers.text_html;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class Hashtags_tweet extends Test_Tweet {//Display top 5 trending Hashtags (#) in India,US=23424977, UK=23424975 and Israel 
		@Test 
		public void triendingTweet() throws Exception {
		
		String[] woeid= {"23424848","23424977", "23424975", "23424852"};
		String[] place= {"India","US", "UK", "Israel"};
		Logger log=Logger.getLogger("triendingTweet");
		PropertyConfigurator.configure("C:\\Users\\Online Test\\git\\SecondProject\\Twitter_Project\\src\\project_tweet\\log4j.properties");
		
		RestAssured.baseURI=url();
		for(int i=0; i<4;i++) {
		Response res= test().
				queryParam("id",woeid[i] ).// Where On Earth IDentification
				when().get("/trends/place.json").then().assertThat().statusCode(200).and().extract().response();
		String Response = res.asString();
		log.info(Response);
		System.out.println(Response);
		JsonPath js = new JsonPath(Response);
		String Hashtags = js.get("trends[0].name").toString();
		log.info(place[i]+"_Hashtags="+Hashtags);
		System.out.println(place[i]+"_Hashtags="+Hashtags);

}
	}
	}
