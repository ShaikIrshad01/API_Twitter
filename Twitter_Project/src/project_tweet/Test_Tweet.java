package project_tweet;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.util.Properties;

import io.restassured.response.Response;
import io.restassured.specification.RequestSenderOptions;
import io.restassured.specification.RequestSpecification;

public class Test_Tweet {
	
	public static RequestSpecification test() throws Exception {
		Properties prop = new Properties();
		FileInputStream  fis = new FileInputStream("C:\\Users\\Online Test\\git\\SecondProject\\Twitter_Project\\src\\Files\\base.properties");
		prop.load(fis);
		return given().auth().oauth(prop.getProperty("CKey"), prop.getProperty("CS"), prop.getProperty("T"), prop.getProperty("TS"));
	}
	public static String url() {
		return "https://api.twitter.com/1.1";
	}
	public static String tweet() {
		return "I am(S_Irshad2) learning API testing using RestAssured my Java #Qualitest";
	}
}
