package hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.management.*;

import javax.management.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.HttpURLConnection;
import java.util.*;

@CrossOrigin
@RestController
public class GreetingController {

	private static final Logger LOG = LoggerFactory.getLogger(GreetingController.class);
	private static final String KAIROSDB_IP_ADDRESS = "52.8.104.253";
	private static final Integer PORT = 4343;

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	// public static Map<BadKey,String> leakMap = new HashMap<>();
	public static Map<BadKey, String> BAD_KEY_MAP = new HashMap<BadKey, String>();
	public static String MEMORY_LEAK_TEST_STRING = "";

	private static final String PREFIX = "put ";

	public static long TIMESTAMP = 0;
	public static int POSTGRES_NUM_OPS_METRIC_COUNT = 0;

	public static final String JDBC_DRIVER = "org.postgresql.Driver";  
	public static final String DB_URL = "jdbc:postgresql://35.196.17.143:5432/opsmx";//172.9.239.1xx

	public static final String USER = "postgres";
	public static final String PASS = "networks123";
	public static String testData = "latency";


	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		LOG.debug("BEGIN: greeting api");  
		//System.out.println("Trigger test: ");
		//LOG.error("Encountered java.lang.InterruptedException while reading the images in the method : /greeting");
		//LOG.error("Unable to find properties file : java.io.FileNotFoundException at void hello line number ");

		// ***** memory leakdemonstrating  ******//
	/*      LOG.info("Memeroy Leak enabled:");
		if (MEMORY_LEAK_TEST_STRING == null || MEMORY_LEAK_TEST_STRING.length() == 0) {
			for (int i = 0; i < 10000; i++) {
				String test = "" + i + "" + i + "" + i;
				MEMORY_LEAK_TEST_STRING += testData;
		         }
		 } else {
		      String suffix = "0a1b2c3d4e5";
		      MEMORY_LEAK_TEST_STRING += suffix;
		}
		BadKey badKey = new BadKey("");
		badKey = new BadKey("" + (new Date().getTime()));
	*/
		    //Commented the following line, causes problems with mem util 
	        //BAD_KEY_MAP.put(badKey, "" + (new Date().getTime()) + "-" + (new Date().getTime()) + MEMORY_LEAK_TEST_STRING);		  
	    
		//***End of Memory leak code ****//

		//Demonstrating Architectural Regression/*	POSTGRES_NUM_OPS_METRIC_COUNT += 1;
		//Architectural Regression implementation has been shifted to ArchRegress.java, here only calling thread class.
		// test code

		//ArchRegress test = new ArchRegress();
		// //Thread th = new Thread(test);

		try{
			Thread th = new Thread();
			th.sleep(40);
			LOG.info("Greeting-Latency ");
			th.start();
		}catch(Exception ex) {
			LOG.error("Error: ", ex);
		}	
		// **** End of architectural regression code ***//

		/*if (Long.compare(TIMESTAMP, 0l) == 0
				|| Long.compare(((new Date()).getTime() - TIMESTAMP), 5000) >= 0) {
			TIMESTAMP = (new Date()).getTime();

			try (Socket clientSocket = new Socket(KAIROSDB_IP_ADDRESS, PORT);
					PrintWriter out = (clientSocket.isConnected()) ? new PrintWriter(
							clientSocket.getOutputStream(), true) : null;) {
				if (out != null) {
					LOG.info("Connected with the server : {} with port : {}",
							clientSocket.getInetAddress().getHostName(),
							clientSocket.getPort());
					writeIntoKairosDB(out, "tomcat.dbOperations", ""+ POSTGRES_NUM_OPS_METRIC_COUNT);
					// writeIntoKairosDB(out, "elasticsearch.num_of_calls",
					// "1");
				}
			} catch (IOException ex) {
				LOG.error("Error: ", ex);
			}
		}*/
		LOG.info("Hello spark :: Inside greeting API");
		//System.out.println("Hello spark + Inside greeting API");

		// System.out.println("HashMap size : "+ leakMap.size());
		// new Greeting(MetricsRegistryClient.client().incrRequestCount(),String.format(template, name))
		//return "HashMap size  : "+ BAD_KEY_MAP.size() + "\n String length  : " + MEMORY_LEAK_TEST_STRING.length() +"\n ";
		String query;
		StringBuffer sb = new StringBuffer();
		String query2;
		StringBuffer sb2 = new StringBuffer();

		ClassLoader cl = GreetingController.class.getClassLoader();
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(cl.getResource("testpage.html").openStream()));
			while((query=br.readLine())!=null)
				sb.append(query);	
			br.close();

			String whichdog = "dog1";

			/* Introducing Arch. regression*/

			// whichdog = "dog2";
			/*till here*/

			BufferedReader br2 = new BufferedReader(new InputStreamReader(cl.getResource(whichdog).openStream()));
			while((query2=br2.readLine())!=null)
				sb2.append(query2);	
			br2.close();


		}
		catch(Exception e){ 
			e.printStackTrace();
			LOG.error("Error: " + e);
		}

		String greetResponse = sb.length()>0 ? sb.toString().replace("##dogimage##", sb2.toString()) : " No page found";
		//LOG.debug("END: greeting" + "\n" + greetResponse);
		return greetResponse;
		// 	return "POSTGRES_NUM_OPS_METRIC_COUNT : "+ POSTGRES_NUM_OPS_METRIC_COUNT;
	}


	/*public void getAllUsersFromDB(){
		       Connection c = null;
		       Statement stmt = null;
		       try {
		       Class.forName(JDBC_DRIVER);
		         c = DriverManager.getConnection(DB_URL,USER, PASS);
		         c.setAutoCommit(false);
		         stmt = c.createStatement();
		         ResultSet rs = stmt.executeQuery( "select * from UserLoginDetails" );
		         while(rs.next())  {
		        	 System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		        	 break;
		         }
		         rs.close();
		         stmt.close();
		         c.close();
		       } catch ( Exception e ) {
		         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		         System.exit(0);
		       }
		       System.out.println("Operation done successfully");

	  }*/

	@RequestMapping("/dogcount")
	public String dogCount() {
		LOG.debug("BEGIN: dogCount");
		try{
			Thread dh = new Thread();
			dh.sleep(30);
			writeException1();
			LOG.info("dogcount-Latency ");
		}catch(Exception ex) {
			LOG.error("Error: ", ex);
		}	
		String response = "{ \"dogCount\": 2.0 }";
		LOG.debug("END: dogCount" + "\n" + response);
		return response;
	}
	public String writeException1() {
		try
		{ 
			throw new NullPointerException("Animals count: null"); 
		} 
		catch(NullPointerException e) 
		{ 
			LOG.error("Encountered java.lang.InterruptedException while reading the images {}" , e.getMessage());
			LOG.error("Unable to find properties file : java.io.FileNotFoundException at void hello line number: {}", e.getMessage());
			//LOG.error("ERROR ",e);
		} 
		return  "Generating Exceptions like java.lang.InterruptedException and java.io.FileNotFoundException";
	}
	@RequestMapping("/generateException")
	public String writeException() {
		try
		{ 
			throw new NullPointerException("Animals count: null"); 
		} 
		catch(NullPointerException e) 
		{ 
			LOG.error("Encountered java.lang.InterruptedException while reading the images {}" , e.getMessage());
			LOG.error("Unable to find properties file : java.io.FileNotFoundException at void hello line number: {}", e.getMessage());
			//LOG.error("ERROR ",e);
		} 
		return  "Generating Exceptions like java.lang.InterruptedException and java.io.FileNotFoundException";
	}

	@RequestMapping("/readfile")
	public String readFile(@RequestParam("id") String id, @RequestParam("version") String version, @RequestParam("filename") String fileName) {
		try {
			String file = "/logs/"+ id + "/" + version + "/" + fileName;
			try (InputStream is = this.getClass().getResourceAsStream(file);) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(is));
				while(reader.ready()) {
					System.out.println(reader.readLine());
				}
			} catch (IOException e) {
				return e.getMessage();
			}


		}catch(Exception ee) {
			return "fail";
		}
		return "success";
	}

	@RequestMapping("/writeLogs")
	public String writeLogs(@RequestParam("filename") String fileName) {
		String file = "/opt/" + fileName;
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
		}  catch (Exception ee) {
			ee.printStackTrace();
			return "fail";
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return "success";
	}

	@RequestMapping("/catcount")
	public String catCount() {
		LOG.info("BEGIN: catCount");
		String result="{ \"catCount\": 1.0 }";

		try{
			Thread ch = new Thread();
			ch.sleep(30);
			//throw new Exception(); 
			 LOG.info("catcount-Latency ");
		}catch(Exception ex) {
			LOG.error("ERROR: ", ex);
		}

		/*Code for Architectural Regression, prerequisite is to have restapp running on k8 pod */
		/*try{
			for (int i=0; i<=1000; i++)
			{
				URL url = new URL("http://35.192.98.201:8080/catcount");
				HttpURLConnection con = (HttpURLConnection)url.openConnection();
				con.setRequestMethod("GET");
				con.setDoOutput(true);
				con.setInstanceFollowRedirects(false);

				System.out.println("con.getResponseCode() ::"+con.getResponseCode());
				System.out.println(con.getResponseMessage());

				BufferedReader br2 = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String response2; StringBuffer res2 = new StringBuffer();
				while ((response2=br2.readLine())!=null)
					res2.append(response2);

				System.out.println(res2);
				if (!res2.toString().isEmpty())
					result=res2.toString();
			}

		}catch(MalformedURLException mue){
			mue.printStackTrace();
		}catch(IOException io){
			io.printStackTrace();
		}
		/* till here */

		LOG.debug("END: catCount" + "\n" + result);
		return result;
	}

	@RequestMapping("/status")
	public String getStatus() {
		LOG.debug("BEGIN: getStatus");
		String response = " @@@@@@ Welcome to  Strategy World  @@@@@@";
		LOG.debug("END: getStatus" + "\n" + response);
		return response;
	}

	@RequestMapping(value = "/mbeans")
	public void mbeans() throws Exception {
		LOG.debug("BEGIN: mbeans");
		System.out.println("New changes in mbeans");
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
		//		Set mbeans = server.queryNames(null, null);
		/*
		 * for (Object mbean : mbeans) { WriteAttributes(server,
		 * (ObjectName)mbean); }
		 */

		// RequestProcessor
		ObjectName requestObjName = new ObjectName(
				"Tomcat:type=GlobalRequestProcessor,name=*");
		Set<ObjectName> requestObjNameSet = server.queryNames(requestObjName,
				null);
		Long maxProcessingTime = 0L;
		Long processingTime = 0L;
		Long requstCount = 0L;
		Long errorCount = 0L;
		BigDecimal bytesReceived = BigDecimal.ZERO;
		BigDecimal bytesSend = BigDecimal.ZERO;
		for (ObjectName obj : requestObjNameSet) {
			long nowMaxProcessingTime = Long.parseLong(server.getAttribute(obj,
					"maxTime").toString());
			if (maxProcessingTime < nowMaxProcessingTime)
				maxProcessingTime = nowMaxProcessingTime;
			processingTime += Long.parseLong(server.getAttribute(obj,
					"processingTime").toString());
			requstCount += Long.parseLong(server.getAttribute(obj,
					"requestCount").toString());
			errorCount += Long.parseLong(server.getAttribute(obj, "errorCount")
					.toString());
			bytesReceived = bytesReceived.add(new BigDecimal(server
					.getAttribute(obj, "bytesReceived").toString()));
			bytesSend = bytesSend.add(new BigDecimal(server.getAttribute(obj,
					"bytesSent").toString()));
			System.out.println(processingTime + " : " + requstCount + " : "
					+ bytesReceived + " : " + bytesSend);
		}
		LOG.debug("END: mbeans");
	}

	//@RequestMapping("/configuration")
	@RequestMapping(value="/configuration", produces = "text/plain")
	public String configuration() throws IOException {
		LOG.debug("BEGIN: configuration");
		StringBuffer content = new StringBuffer();
		try {
			InputStream is = GreetingController.class.getResourceAsStream("/application.properties");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String s;
			while((s = br.readLine()) != null) {
				content.append(s + "\n");
			}
		}
		catch (IOException ioe){
			LOG.error("IOError: file could not be read", ioe);
		}
		LOG.info("Content:\n" + content.toString());
		LOG.debug("END: configuration");
		return content.toString();
	}



	private void writeIntoKairosDB(PrintWriter out, String metricName,String value) {

		if (metricName != null) {
			LOG.debug("The metric name and the key is : {}, {}", metricName,
					value);
			System.out.println("The metric name and the key is : " + metricName
					+ ", " + value);
			if (value == null) {
				LOG.warn("Skipping write to Kairos as the response has no data for '{}' url",metricName);
				return;
			}

			StringBuilder putCommand = new StringBuilder();
			Long timeStamp = System.currentTimeMillis() / 1000;
			putCommand.append(PREFIX);
			putCommand.append(metricName + " ");
			putCommand.append(timeStamp + " ");
			putCommand.append(value + " ");

			String hostname = "Unknown";
			try
			{
				InetAddress addr;
				addr = InetAddress.getLocalHost();
				hostname = addr.getHostName();
			}
			catch (UnknownHostException ex)
			{
				System.out.println("Hostname cannot be resolved.");
			}

			putCommand.append("host="+hostname+" \n");

			// LOG.info("Writing to KairosDb : {}", putCommand.toString());
			System.out.println("Writing to KairosDb : {}"
					+ putCommand.toString());
			out.write(putCommand.toString());

		}
		out.close();
	}

	//	private void WriteAttributes(final MBeanServer mBeanServer,
	//			final ObjectName http) throws InstanceNotFoundException,
	//			IntrospectionException, ReflectionException {
	//		MBeanInfo info = mBeanServer.getMBeanInfo(http);
	//		MBeanAttributeInfo[] attrInfo = info.getAttributes();
	//
	//		System.out.println("Attributes for object: " + http + ":\n");
	//		for (MBeanAttributeInfo attr : attrInfo) {
	//			System.out.println("  " + attr.getName() + "\n");
	//		}
	//	}

	static class BadKey {
		// no hashCode or equals();
		public final String key;

		public BadKey(String key) {
			this.key = key;
		}
	}

}
