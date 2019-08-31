package fstestscode;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import io.restassured.http.Header;
import io.restassured.http.Headers;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;

public class FSClinicsTests {
	Headers headers;
	String strNavigationURL;

	@Before
	public void setClinicHeader() throws MalformedURLException {

		Header first = new Header("Content-Type",
				ReadPathAndRouteFromPropertyFile.getContentType);
		Header second = new Header("X-API-Key", ReadPathAndRouteFromPropertyFile.getXAPIKey);
		Header third = new Header("X-FS-Clinic-Key",
				ReadPathAndRouteFromPropertyFile.getXFSClinicKey);

		headers = new Headers(first, second, third);

		strNavigationURL = ReadPathAndRouteFromPropertyFile.strNavigationURL;

	}

	@Test
	public void test_Clinic_id_is_correct() throws MalformedURLException {

		String strURL = strNavigationURL + ReadPathAndRouteFromPropertyFile.getClinicDetails;
		URL url = new URL(strURL);

		given().headers(headers)
				.get(url)
				.then()
				.statusCode(200)
				.body("clinic.id",
						equalTo("beb58aed-cb5a-40b2-a70e-769936504b61"));
	}

	@Test
	public void test_URL_Correctness_With_Status_Code()
			throws MalformedURLException {

		String strURL = strNavigationURL + ReadPathAndRouteFromPropertyFile.getClinicDetails;
		URL url = new URL(strURL);

		given().headers(headers).get(url).then().statusCode(200);

	}

	@Test
	public void test_Clinic_Name_is_correct() throws MalformedURLException {

		String strURL = strNavigationURL + ReadPathAndRouteFromPropertyFile.getClinicDetails;
		URL url = new URL(strURL);

		given().headers(headers).get(url).then().statusCode(200)
				.body("clinic.name", equalTo("First Last's Dispensary"));

	}

	// @Test
	// public void test_Clinic_dispensary_url_is_correct() throws
	// MalformedURLException{
	//
	// String strURL = strNavigationURL + ReadPathProperties.getClinicDetails;
	// URL url = new URL(strURL);
	//
	// given().
	// headers(headers).
	// get(url).
	// then().
	// statusCode(200).
	// body("dispensary_url",contains("/flast"));
	//
	// }

	@Test
	public void test_Clinic_page_response_time_lessThan_2Second()
			throws MalformedURLException {

		String strURL = strNavigationURL + ReadPathAndRouteFromPropertyFile.getClinicDetails;
		URL url = new URL(strURL);

		given().headers(headers).get(url).then().time(lessThan(2000L));
	}

}
