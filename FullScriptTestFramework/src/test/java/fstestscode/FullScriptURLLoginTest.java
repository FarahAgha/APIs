package fstestscode;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.net.URL;

import junit.framework.Assert;

import org.junit.Test;

/**
 * @author Farah Agha
 **/
public class FullScriptURLLoginTest extends FullScriptBaseClass {

	@Test
	public void fullScritURL() throws Exception {

		url = new URL(strURL);
		Response response = RestAssured.get(url);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test
	public void fsLoginPage() throws Exception {
		String strPath = "/login";
		url = new URL(strURL + strPath);
		response = RestAssured.get(url);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
