package seleniumUtility;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Test;

import io.restassured.RestAssured;

public class RestAssuredManager {

	@Test
	public void testing() {
		RestAssured.baseURI = "https://machinelink2.exostartest.com/";
		RestAssuredManager ra = new RestAssuredManager();
		String data = ra.updateXMLData(ra.readXMLData());

		RestAssured.given().auth().preemptive().basic("pulatiy", "scR@bble").contentType("text/xml").body(data).when()
				.post("/invoke/ExostarCore.processors.other/receive").then().statusCode(200);
	}

	public String readXMLData() {
		String finalData = null;
		TextFileManager reader = new TextFileManager("src/test/resources/data/xmlData.xml");
		finalData = reader.read().trim();
		//System.out.println(finalData);
		return finalData;
	}

	public String updateXMLData(String inputXML) {
		StringBuffer sb = new StringBuffer();
		UtilityLibrary tempLib = new UtilityLibrary(null);
		String time = tempLib.getCurrentTime();
		//System.out.println("lib time: " + time);

		Date curDate = new Date();

		String DateToStr = DateFormat.getDateInstance().format(curDate);
		String a = DateToStr.replaceAll(" ", "").replaceAll(",", "");

		String finalTimeStamp = a + time;
		System.out.println("RFx Created: " + finalTimeStamp);
		TextFileManager writter = new TextFileManager("src/test/resources/user.txt");
		writter.write(finalTimeStamp);				
	
		String tempDate = calculateDate();
		String startDate = tempDate + "T09:00:00";
		String endDate = tempDate + "T23:59:59";
		inputXML = inputXML.replaceAll("erfan123", startDate);
		inputXML = inputXML.replaceAll("erfan111", endDate);
		
		sb.append(inputXML.replaceAll("Mar032117-300", finalTimeStamp)); //jan242017-30
		//System.out.println("online time: " + a);
		//System.out.println("start: " + startDate);
		//System.out.println("end: " + endDate);
		TextFileManager writer = new TextFileManager("C:/test/new123.xml");
		writer.write(sb.toString());
		return sb.toString();
	}
	
	private String calculateDate()
	{		
		UtilityLibrary myLib = new UtilityLibrary(null);
		String preDate = myLib.getCurrentTime("yyyyMMdd");		
		return preDate;
	}
	

	public static void main(String[] args) {
		TextFileManager reader = new TextFileManager("src/test/resources/user.txt");
		String newUser = reader.read();
		System.out.println("data: " + newUser);
	}
	

}