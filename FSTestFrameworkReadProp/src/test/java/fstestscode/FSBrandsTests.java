package fstestscode;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import io.restassured.http.Header;
import io.restassured.http.Headers;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FSBrandsTests {

	Headers headers;
	String baseURI;

	@Before
	public void setup_for_brands_on_the_Fullscript_platform()
			throws MalformedURLException {

		baseURI = ReadPathAndRouteFromPropertyFile.baseURI.trim();

		Header type = new Header("Content-Type",
				ReadConfigFromPropertyFile.getContentType);
		Header apiKey = new Header("X-API-Key",
				ReadConfigFromPropertyFile.getXAPIKey);
		Header clinicKey = new Header("X-FS-Clinic-Key",
				ReadConfigFromPropertyFile.getXFSClinicKey);

		headers = new Headers(type, apiKey, clinicKey);
	}

	// a function to list all brands on the Full script platform
	@Test
	public void test_StatusCode_of_brands_on_the_Fullscript_platform()
			throws MalformedURLException {

		String brandURL = baseURI
				+ ReadPathAndRouteFromPropertyFile.getAllBrands;
		URL url = new URL(brandURL);

		given().headers(headers).get(url).then().assertThat().statusCode(200);
	}

	// Verify one of the items from the brand
	@Test
	public void test_one_of_the_brands_by_id_on_the_Fullscript_platform()
			throws MalformedURLException {
		String brandURL = baseURI
				+ ReadPathAndRouteFromPropertyFile.getAllBrands;
		System.out.println(brandURL);
		URL url = new URL(brandURL);

		given().headers(headers)
				.get(url)
				.then()
				.assertThat()
				.body("brands.id[0]",
						equalTo("590a8746-d8ab-4530-b777-9fe03f73cb7a"));
	}

	// Verify one of the items from the brand
	@Test
	public void test_one_of_the_brands_by_name_on_the_Fullscript_platform()
			throws MalformedURLException {
		String brandURL = baseURI
				+ ReadPathAndRouteFromPropertyFile.getAllBrands;
		URL url = new URL(brandURL);

		given().headers(headers).get(url).then().assertThat()
				.body("brands.name[0]", equalTo("A. Vogel"));
	}

	// Verify one of the items from the brand
	@Test
	public void test_response_time_of_brands_on_the_Fullscript_platform()
			throws MalformedURLException {
		String brandURL = baseURI
				+ ReadPathAndRouteFromPropertyFile.getAllBrands;
		URL url = new URL(brandURL);

		given().headers(headers).get(url).then().assertThat()
				.time(lessThan(1500L));
	}

	// TODO "https://api-us-snd.fullscript.io/api/catalog/brands?available=true"
	// \

	// Verify one of the items from the brand
	@Test
	public void test__brands_not_on_the_Fullscript_platform()
			throws MalformedURLException {
		String available = "?available=false";
		String brandURL = baseURI
				+ ReadPathAndRouteFromPropertyFile.getAllBrands + available;
		URL url = new URL(brandURL);

		given().headers(headers).get(url).then().assertThat().statusCode(200);
	}

	// TODO Retrieves details for an existing brand

	/*
	 * { "brand": { "id": "x0x50x8x-711x-43xx-85xx-5xx80365xxxx", "name":
	 * "BioBrand", "prefix": "BIO", "status": "unavailable" } }
	 * 
	 * URL
	 * "https://api-us-snd.fullscript.io/api/catalog/brands/x0x50x8x-711x-43xx-85xx-5xx80365xxxx"
	 */

	@After
	public void teardown_for_brands_on_the_Fullscript_platform() {
		headers = null;
		baseURI = null;
	}

}
