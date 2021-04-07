package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class GettheWeather {

	public static void getWeather(weatherBean wBean) throws IOException {
		
		
	// String URLtoSend ="https://api.openweathermap.org/data/2.5/weather?q=malmo,se&appid=faee67436db5d28429dca9f44ba2eff9&mode=xml";
	
	String URLtoSend = "https://api.openweathermap.org/data/2.5/weather?q=" + wBean.getCityStre()+","
	+ wBean.getCloudsStr()+ "&appid=faee67436db5d28429dca9f44ba2eff9&mode=xml";
	
	System.out.println(URLtoSend);
	
	
	
	URL line_api_url = new URL(URLtoSend);
	
	
	HttpURLConnection linec = (HttpURLConnection) line_api_url.openConnection();
	
	
	linec.setDoInput(true);
	linec.setDoOutput(true);
	
	linec.setRequestMethod("GET");
	
	
	BufferedReader in = new BufferedReader(new InputStreamReader(linec.getInputStream()));
	
	
	String inputLine;
	String ApiResponse = "";
	
	
	while((inputLine=in.readLine())!=null) {
		
		//System.out.println(inputLine);
		
		
		ApiResponse+=inputLine;
		
	}
	
	
	in.close();
	
	System.out.println(ApiResponse);
	
	Document doc = convertStringtoXMLDocument(ApiResponse);
	
	doc.getDocumentElement().normalize();
	
	
	System.out.println("Root element:"+doc.getDocumentElement().getNodeName());
	
	NodeList nList = doc.getElementsByTagName("clouds");
	
	
	for(int temp=0;temp<nList.getLength();temp++) {
		
		Node node = nList.item(temp);
	
	
	if(node.getNodeType()== Node.ELEMENT_NODE) {
		
	Element element = (Element) node;
	
	String XMLClouds=element.getAttribute("name");
	
	System.out.println(XMLClouds);
	
	wBean.setCloudsStr(XMLClouds);
	}
	
	
	
	
	
	}
	
	
NodeList date = doc.getElementsByTagName("lastupdate");
	
	
	for(int temp=0;temp<date.getLength();temp++) {
		
		Node node1 = date.item(temp);
	
	
	if(node1.getNodeType()== Node.ELEMENT_NODE) {
		
	Element element1 = (Element) node1;
	
	String XMLDate=element1.getAttribute("value");
	
	System.out.println(XMLDate);
	
	wBean.setDateStr(XMLDate);
	}
	
	
	
	
	
	}
	
	
	}

	private static Document convertStringtoXMLDocument(String XMLString) {
		
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		
		DocumentBuilder builder = null;
		
		try {
			
		
		builder = factory.newDocumentBuilder();
		
		Document doc = builder.parse(new InputSource(new StringReader(XMLString)));
		
		return doc;
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}

}
