package fstestscode;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FSPatientsTests {

	String basePatientURI;
	Headers headers;

	JSONObject jsonAsMap;

	@Before
	public void setup_before_patient_tests_execution() {
		Header type = new Header("Content-Type",
				ReadConfigFromPropertyFile.getContentType);
		Header key = new Header("X-API-Key",
				ReadConfigFromPropertyFile.getXAPIKey);
		Header clinicKey = new Header("X-FS-Clinic-Key",
				ReadConfigFromPropertyFile.getXFSClinicKey);
		headers = new Headers(type, key, clinicKey);

		basePatientURI = ReadPathAndRouteFromPropertyFile.baseURI.trim() + ReadPathAndRouteFromPropertyFile.getAllPatients;;

		jsonAsMap = new JSONObject();



	}
	
	@Test 
	public void test_response_when_email_already_exists_in_the_system() throws MalformedURLException{

		Response response = given().headers(headers).body(jsonAsMap.toJSONString()).post(basePatientURI);
		int statusCode = response.getStatusCode();
//		String message = response.asString();
//		System.out.println("----------------- LOGGING ERROR -----------------");
//		System.out.println("The status code recieved: " + statusCode);
	
		Assert.assertEquals(422, statusCode); 
	}
	
	@Test
	public void test_the_name_of_the_patient_for_existing_email()
			throws MalformedURLException {
		String strURL = ReadPathAndRouteFromPropertyFile.baseURI.trim() + ReadPathAndRouteFromPropertyFile.searchAPatient.trim();

		URL url = new URL ( strURL +"?query=avaafra@power2practice.com");
		Response response = given().headers(headers).get(url);
		Assert.assertTrue(response.jsonPath().getList("patients.first_name").contains("Ava"));
		
		/*
		 * {"patients":[
		 *
		 * {"id":"30adc95c-cab3-426f-8180-409cbcce30ce","first_name":"Justin","last_name":"Farah",
		 * "email":"fagha@power2practice.com"},
		 * 
		 * {"id":"759d71b5-7929-4ab9-a651-545adf3661e7","first_name":"Michael","last_name":"Farah",
		 * "email":"mikefarahfagha123@power2practice.com"},
		 * 
		 * {"id":"78dd7284-56a0-49aa-bca2-cd6a0c82d61e","first_name":"Ava","last_name":"Afra",
		 * "email":"avaafra@power2practice.com"},
		 * 
		 * {"id":"5a925815-f874-49d3-b274-c66bca561347","first_name":"Edward","last_name":"Afra",
		 * "email":"edwardafra@power2practice.com"},
		 * 
		 * {"id":"9628390c-485c-4d2c-b957-aabd85832f87","first_name":"Harvey","last_name":"Afra",
		 * "email":"harveyafra@power2practice.com"},
		 */	
		
	}

	@Test
	public void test_create_a_new_patient_with_eixiting_email_address()
			throws MalformedURLException {
		
		URL url = new URL(basePatientURI);

		given().headers(headers).body(jsonAsMap.toJSONString()).post(url)
				.then().assertThat().statusCode(422);
	}

	@Test
	public void test_create_a_new_patient_with_unique_email_address()
			throws MalformedURLException {
		
		jsonAsMap.put("first_name", "Bob");
		jsonAsMap.put("last_name", "Bob");
		//email should be unique
		jsonAsMap.put("email", "BobBobBob2Patient@power2practice.com");
		jsonAsMap.put("date_of_birth", "1977-01-12");
		jsonAsMap.put("external_ref", "9999-9999-9999");
		jsonAsMap.put("mobile_number", "+13122333444");
		jsonAsMap.put("discount", "10");
		jsonAsMap.put("gender", "male");
		jsonAsMap.put("send_welcome_email", "false");
		
		URL url = new URL(basePatientURI);

		given().headers(headers).body(jsonAsMap.toJSONString()).post(url)
				.then().assertThat().statusCode(201);
	}

	@Test
	public void test_list_all_patients_response_time() throws MalformedURLException {
		
		URL url = new URL(basePatientURI);
		given().headers(headers).get(url).then().assertThat()
				.time(lessThan(1200L));
	}



}
