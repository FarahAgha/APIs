package fstestscode;

import io.restassured.RestAssured;

import java.net.MalformedURLException;
import java.net.URL;

import junit.framework.Assert;

import org.json.simple.JSONObject;
import org.junit.Test;

/**
 * @author Farah Agha
 **/
public class FullScriptPatientsTest extends FullScriptBaseClass {

	@Test
	public void getAllPatients() throws MalformedURLException {

		String strPath = "/api/clinic/patients/";
		url = new URL(strURL + strPath);

		request = RestAssured.given();
		setClinicHeader();

		response = getResponse();
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test
	public void getOnePatient() throws MalformedURLException {

		String strPath = "/api/clinic/patients/30adc95c-cab3-426f-8180-409cbcce30ce";
		url = new URL(strURL + strPath);

		request = RestAssured.given();
		setClinicHeader();

		response = getResponse();
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@SuppressWarnings("unchecked")
	@Test
	public void patchUpdateAPatient() throws MalformedURLException {

		String strPath = "/api/clinic/patients/c8401dfc-b6ea-456f-8166-824cd9d6dd19";
		url = new URL(strURL + strPath);

		request = RestAssured.given();
		setClinicHeader();

		JSONObject jObj = new JSONObject();
		jObj.put("first_name", "HelloBbobb");
		jObj.put("mobile_number", "+13122404404");

		request.body(jObj.toJSONString());

		response = request.patch(url);
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@SuppressWarnings("unchecked")
	@Test
	public void putUpdateAPatient() throws MalformedURLException {

		String strPath = "/api/clinic/patients/c8401dfc-b6ea-456f-8166-824cd9d6dd19";
		url = new URL(strURL + strPath);

		request = RestAssured.given();
		setClinicHeader();

		JSONObject jObj = new JSONObject();
		jObj.put("first_name", "Putt");
		jObj.put("last_name", "Bbobb");
		jObj.put("mobile_number", "+13122404404");

		request.body(jObj.toJSONString());

		response = request.put(url);
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test
	public void getOnePatientsAddress() throws MalformedURLException {

		String strPath = "/api/clinic/patients/30adc95c-cab3-426f-8180-409cbcce30ce/addresses";
		url = new URL(strURL + strPath);
		request = RestAssured.given();
		setClinicHeader();

		response = getResponse();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void createAPatient() throws MalformedURLException {

		String strPath = "/api/clinic/patients";
		url = new URL(strURL + strPath);
		request = RestAssured.given();
		setClinicHeader();

		JSONObject jObj = new JSONObject();
		jObj.put("first_name", "Bob");
		jObj.put("last_name", "Bob");
		jObj.put("email", "BobBob4@helloworld.com");
		jObj.put("date_of_birth", "1977-07-07");
		jObj.put("external_ref", "9999-9999-9999");
		jObj.put("mobile_number", "+13124040404");
		jObj.put("discount", "10");
		jObj.put("gender", "male");
		jObj.put("send_welcome_email", "false");
		/*  UnComment -- This is commented to not to create a patient every test execution*/
		// request.body(jObj.toJSONString());
		// response = request.post(url);
		// int resCode = response.getStatusCode();
		// System.out.println(resCode);
		// Assert.assertEquals(resCode, 201);

	}

}
