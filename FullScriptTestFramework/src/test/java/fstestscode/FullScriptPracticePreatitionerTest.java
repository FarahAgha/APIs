package fstestscode;

import io.restassured.RestAssured;

import java.net.MalformedURLException;
import java.net.URL;

import junit.framework.Assert;

import org.junit.Test;

/**
 * @author Farah Agha
 **/
public class FullScriptPracticePreatitionerTest extends FullScriptBaseClass {

	@Test
	public void getClinicDetails() throws MalformedURLException {

		String strPath = "/api/clinic";
		url = new URL(strURL + strPath);

		request = RestAssured.given();
		setClinicHeader();

		response = getResponse();
		System.out.println(response.asString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test
	public void getAllPractitioners() throws MalformedURLException {

		String strPath = "/api/clinic/practitioners";
		url = new URL(strURL + strPath);

		request = RestAssured.given();
		setClinicHeader();

		response = getResponse();
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test
	public void RetrieveSinglePractitioner() throws MalformedURLException {

		String strPath = "/api/clinic/practitioners/6d45c5d2-a74d-4d31-9a40-862d4f2ce952";
		url = new URL(strURL + strPath);

		request = RestAssured.given();
		setClinicHeader();

		response = getResponse();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
