package fstestscode;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.net.URL;

public class FullScriptBaseClass {

	URL url;
	RequestSpecification request;
	String strURL = "https://dummyfullscripturldummy.com";
	Response response;

	public void setFSHeader() {
		request.header("Content-Type", "application/json; charset=utf-8");
		request.header("API-Key", "DummyXXF3OOBXXX9vpA8F3OOBYvjBN99aF3OOB9QkA7SaZDummy");
	}
	
	public void setClinicHeader() {
		setFSHeader();
		request.header("Clinic-Key", "DummyGJLRHawm2153cJAJkXUDummy");
	}

	public Response getResponse() {
		response = request.get(url);
		return response;
	}
}
