package project_tweet;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Create_tweet extends Test_Tweet{
		@Test 
		public void postTweet() throws Exception  {  //create the tweet 
		Logger log=Logger.getLogger("Create_tweet");
		PropertyConfigurator.configure("C:\\Users\\Online Test\\git\\SecondProject\\Twitter_Project\\src\\project_tweet\\log4j.properties");
		RestAssured.baseURI=url();
		Response res= test().queryParam("status", tweet())
		.when().post("/statuses/update.json").then().assertThat().statusCode(200).and().extract().response();
		String Response = res.asString();
		log.info(Response);
		JsonPath js = new JsonPath(Response);
		String id = js.get("id").toString();
		log.info("id="+id);
		//System.out.println("creating_id="+id);
		String text = js.get("text").toString();
		log.info("Created_tweet="+text);
		//System.out.println("creating_tweet="+text);
		
		//deleting tweet
		Response re=test().
		when().post("/statuses/destroy/"+id+".json").then().assertThat().statusCode(200).and().extract().response();
		String Response_d = re.asString();
		System.out.println(Response_d);
		log.info("Deleted_tweet="+Response_d);
	
	}
	}
	






























		/*
		  String ConsumerKey = "2Xtd4ILUtinfACHehAvCNcbjW";
		String ConsumerSecret = "pIHDmJy9fgKlLVuAgG4AuP5rRkaOy6TtWqxLqjVeJ2MywdcGJp";
		String Token = "839104214-h1Kaf8iJW2FAyXzNCZNicI1a4Xb8BMw7ZkFKGzmJ";
		String TokenSecret = "PTvXawkmrK3EZWeLSSmqtD7hisogRC3nqG48FYzNcLfQy";
		
		RestAssured.baseURI="https://api.twitter.com/1.1/statuses/";
		Response res = given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret).
				queryParam("status", "First_tweet using API")
				.when().post("/update.json").then().extract().response();
		String Response = res.asString();
		System.out.println(Response);
		JsonPath js = new JsonPath(Response);
		String id = js.get("id").toString();
		System.out.println(id);
		String text = js.get("text").toString();
		System.out.println(text);
		
		given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret).
		when().post("/destroy/"+id+".json").then().assertThat().statusCode(200);
		*/
	



