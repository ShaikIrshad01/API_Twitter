package project_tweet;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.util.Properties;
public class Twitter extends Test_Tweet {
@Test
public void getTweet() throws Exception {
	
	//creating tweet
	
	RestAssured.baseURI=url();
	/*
	Response res= test().
	queryParam("status", tweet())
	.when().post("/statuses/update.json").then().assertThat().statusCode(200).and().extract().response();
	String Response = res.asString();
	System.out.println(Response);
	JsonPath js = new JsonPath(Response);
	String id = js.get("id").toString();
	System.out.println("creating_id="+id);
	String text = js.get("text").toString();
	System.out.println("creating_tweet="+text);
	
	// deleting tweet
	Response re=test().
	when().post("/statuses/destroy/"+id+".json").then().assertThat().statusCode(200).and().extract().response();
	String Response_d = re.asString();
	System.out.println(Response_d);
	JsonPath js_d = new JsonPath(Response_d);
	String id_d = js_d.get("id").toString();
	System.out.println("deleting_id="+id_d);
	
	String delete = js.get("text").toString();
	System.out.println("deleting_tweet="+delete);
	*/
	//searching
	Response res1= test().
		queryParam("q", "#Qualitest").
		when().get("search/tweets.json").then().assertThat().statusCode(200).and().extract().response();
		String Response1 = res1.asString();
		System.out.println(Response1);
		JsonPath js1 = new JsonPath(Response1);
		String text1 = js1.get("statuses[0].text").toString();
		if(text1.contains("#Qualitest")) {
			System.out.println("text="+text1);
			}
		
	// displaying user name
		String username=js1.get("statuses[0].user.name").toString();
		System.out.println("username="+username);
	/*	
	// displaying weather_Report
		 Response res2=test().
				queryParam("q", "Bangalore, weather").
				when().get("/search/tweets.json").then().assertThat().statusCode(200).and().extract().response();
		String Response2 = res2.asString();
		System.out.println(Response2);
		JsonPath js2 = new JsonPath(Response2);
		String weather = js2.get("statuses[0].text").toString();
		if(text.contains("weather")) {
			System.out.println("Weather_Report="+text);
			}
		
		//all tweets of a user
		 Response res3= test().
		//queryParam("count", "100").
		when().get("/statuses/home_timeline.json").then().assertThat().statusCode(200).and().extract().response();
		String Response3 = res3.asString();
		System.out.println(Response3);
		JsonPath js3 = new JsonPath(Response3);
		String id3 = js3.get("id").toString();
		System.out.println("id="+id3);
		String text3 = js.get("text").toString();
		System.out.println("text3="+text3);
		
	// Trending Hashtags (#) in India,US=23424977, UK=23424975 and Israel 
		String[] woeid= {"23424848","23424977", "23424975", "23424852"};
		String[] place= {"India","US", "UK", "Israel"};
		 for(int i=0; i<4;i++) {
		Response res4= test().
				queryParam("id",woeid[i] ).// Where On Earth IDentification
				when().get("/trends/place.json").then().extract().response();
		String Response4 = res4.asString();
		System.out.println(Response4);
		JsonPath js4 = new JsonPath(Response4);
		String Hashtags = js4.get("trends[0].name").toString();
		System.out.println(place[i]+"_Hashtags="+Hashtags);
		}
		 
		//blocking  
		Response res5= test().
		queryParam("screen_name", "Shaik_Irshad0").
		when().post("/blocks/create.json").then().assertThat().statusCode(200).and().extract().response();
		
		String Response5 = res5.asString();
		System.out.println("Blocking="+Response5);
	
		//unblocking a user
		Response res6=test().
		queryParam("screen_name", "Shaik_Irshad0").
		when().post("/blocks/destroy.json").then().assertThat().statusCode(200).and().extract().response();
		String Response6 = res6.asString();
		System.out.println("unBlocking="+Response6);*/
		 }
		 
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*Test_Tweet t= new Test_Tweet();
	RestAssured.baseURI="https://api.twitter.com/1.1/statuses/";
	Response res= ((RequestSpecification) t.test()).queryParam("count", "100")
			.when().get("/home_timeline.json").then().extract().response();
	String Response = res.asString();
	System.out.println(Response);
	JsonPath js = new JsonPath(Response);
	String id = js.get("id").toString();
	System.out.println("id="+id);
	String text = js.get("text").toString();
	System.out.println("text="+text);*/

