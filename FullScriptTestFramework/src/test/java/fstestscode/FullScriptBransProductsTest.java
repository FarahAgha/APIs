package fstestscode;

import io.restassured.RestAssured;

import java.net.MalformedURLException;
import java.net.URL;

import junit.framework.Assert;

import org.junit.Test;

/**
 * @author Farah Agha
 **/
public class FullScriptBransProductsTest extends FullScriptBaseClass {



	@Test
	public void getVarient() throws MalformedURLException {

		String strPath = "/api/catalog/variants/45ddb314-b491-469e-b073-c8151ea99b91";
		url = new URL(strURL + strPath);

		request = RestAssured.given();
		setFSHeader();

		response = getResponse();

		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test
	public void getAllBrands() throws MalformedURLException {

		String strPath = "/api/catalog/brands?available=true";
		url = new URL(strURL + strPath);

		request = RestAssured.given();
		setFSHeader();

		response = getResponse();
		int resCode = response.getStatusCode();
		Assert.assertEquals(resCode, 200);
		Assert.assertTrue(response.getTime() < 3000);
	}

	@Test
	public void getSingleBrand() throws MalformedURLException {

		String strPath = "/api/catalog/brands/97be161e-1936-4e4c-a233-bfb49303542d";
		url = new URL(strURL + strPath);

		request = RestAssured.given();
		setFSHeader();

		response = getResponse();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test
	public void getAllProducts() throws MalformedURLException {

		String strPath = "/api/catalog/products?available=true";
		url = new URL(strURL + strPath);

		request = RestAssured.given();
		setFSHeader();

		response = getResponse();
		int resCode = response.getStatusCode();
		Assert.assertEquals(resCode, 200);
		Assert.assertTrue(response.getTime() < 3000);
	}

	@Test
	public void getSingleProduct() throws MalformedURLException {

		String strPath = "/api/catalog/products/a4a052a4-9b7f-4ae8-8160-4ec2ebffaa62";
		url = new URL(strURL + strPath);

		request = RestAssured.given();
		setFSHeader();

		response = getResponse();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
