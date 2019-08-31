package fstestscode;

import java.util.Properties;

public class ReadPathAndRouteFromPropertyFile {
	static Properties configProp = ReadPropertiesFileStream
			.readProperties("src/test/resources/config.properties");
	static Properties prop = ReadPropertiesFileStream
			.readProperties("src/test/resources/route.properties");

	static String strNavigationURL = prop.getProperty("navigationURL");

	static String getContentType = configProp.getProperty("Content-Type");
	static String getXAPIKey = configProp.getProperty("X-API-Key");
	static String getXFSClinicKey = configProp.getProperty("X-FS-Clinic-Key");
	static String getfsLoginPage = prop.getProperty("fsLoginPage");

	// getAllPatients
	static String getAllPatients = prop.getProperty("getAllPatients");

	// getOnePatient
	static String getOnePatient = prop.getProperty("getOnePatient");

	// UpdateAPatient
	static String getUpdateAPatient = prop.getProperty("UpdateAPatient");

	// getOnePatientsAddress
	static String getOnePatientsAddress = prop
			.getProperty("getOnePatientsAddress");

	// createAPatient
	static String getcreateAPatient = prop.getProperty("createAPatient");

	// getVarient
	static String getVarient = prop.getProperty("getVarient");

	// getAllBrands
	static String getAllBrands = prop.getProperty("getAllBrands");

	// getSingleBrand
	static String getSingleBrand = prop.getProperty("getSingleBrand");

	// getAllProducts
	static String getAllProducts = prop.getProperty("getAllProducts");

	// getSingleProduct
	static String getAProduct = prop.getProperty("getAProduct");

	// getClinicDetails
	static String getClinicDetails = prop.getProperty("getClinicDetails");

	// getAllPractitioners
	static String getAllPractitioners = prop
			.getProperty("getAllPractitioners");

	// RetrieveSinglePractitioner
	static String getRetrieveSinglePractitioner = prop
			.getProperty("RetrieveSinglePractitioner");

}
