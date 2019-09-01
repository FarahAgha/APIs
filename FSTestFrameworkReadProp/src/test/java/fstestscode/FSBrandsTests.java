package fstestscode;

import io.restassured.http.Header;
import io.restassured.http.Headers;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class FSBrandsTests {
	
	Headers headers;
	String strNavigationURL;
	
	@Before
	public void setup_for_brands_on_the_Fullscript_platform() throws MalformedURLException {

		strNavigationURL = ReadPathAndRouteFromPropertyFile.strNavigationURL.trim();
		
		Header type = new Header("Content-Type",
				ReadConfigFromPropertyFile.getContentType);
		Header apiKey = new Header("X-API-Key",
				ReadConfigFromPropertyFile.getXAPIKey);
		Header clinicKey = new Header("X-FS-Clinic-Key",
				ReadConfigFromPropertyFile.getXFSClinicKey);
		
		headers = new Headers(type,apiKey,clinicKey);
		
	}

	// TODO: Write a function to list all brands on the Fullscript platform
	@Test
	public void test_StatusCode_of_brands_on_the_Fullscript_platform() throws MalformedURLException {

		
		String brandURL = strNavigationURL + ReadPathAndRouteFromPropertyFile.getAllBrands;
		URL url = new URL(brandURL);
		
		given().headers(headers).
			get(url).then()
			.assertThat().statusCode(200);
	}
	
	
	// TODO Unique identifier of the brand

	// TODO "https://api-us-snd.fullscript.io/api/catalog/brands?available=true" \

	// TODO Retrieves details for an existing brand

	/*
	 * { "brand": { "id": "x0x50x8x-711x-43xx-85xx-5xx80365xxxx", 
	 * 				"name": "BioBrand", 
	 * 				"prefix": "BIO", 
	 * 				"status": "unavailable" } }
	 * 
	 * URL "https://api-us-snd.fullscript.io/api/catalog/brands/x0x50x8x-711x-43xx-85xx-5xx80365xxxx"
	 */
}
