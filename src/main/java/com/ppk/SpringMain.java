/**
 * Copyright 2016 Phani, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ppk;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spinakar")
@SpringBootApplication
public class SpringMain {

    @RequestMapping(value ="/appjson", method=RequestMethod.GET ,produces = {"application/json"})
    String home() {
    	 	System.out.println("Hello spring boot World with Phani!");
    	   	   	
    	return " {\"apps\":[{\"appName\":\"ADC\",\"appVersions\":[{\"versionEndTime\":\"12 Jul 2016 08:27:00 GMT\",\"versionId\":1,\"versionName\":\"v1.0\",\"versionStartTime\":\"12 Jul 2016 06:26:00 GMT\"},{\"versionEndTime\":\"12 Jul 2016 09:22:00 GMT\",\"versionId\":2,\"versionName\":\"v1.1\",\"versionStartTime\":\"12 Jul 2016 08:52:00 GMT\"},{\"versionEndTime\":\"14 Jul 2016 10:15:00 GMT\",\"versionId\":3,\"versionName\":\"v1.2\",\"versionStartTime\":\"14 Jul 2016 08:30:00 GMT\"},{\"versionEndTime\":\"14 Jul 2016 11:33:00 GMT\",\"versionId\":4,\"versionName\":\"v1.3\",\"versionStartTime\":\"14 Jul 2016 10:25:00 GMT\"},{\"versionEndTime\":\"25 Jul 2016 11:00:00 GMT\",\"versionId\":5,\"versionName\":\"v1.4\",\"versionStartTime\":\"25 Jul 2016 10:00:00 GMT\"},{\"versionEndTime\":\"25 Jul 2016 13:15:00 GMT\",\"versionId\":6,\"versionName\":\"v1.5\",\"versionStartTime\":\"25 Jul 2016 12:15:00 GMT\"}],\"appId\":1},{\"appName\":\"Staging-ADC\",\"appVersions\":[{\"versionEndTime\":\"12 Jul 2016 08:27:00 GMT\",\"versionId\":1,\"versionName\":\"v1.0\",\"versionStartTime\":\"12 Jul 2016 06:26:00 GMT\"},{\"versionEndTime\":\"12 Jul 2016 09:22:00 GMT\",\"versionId\":2,\"versionName\":\"v1.1\",\"versionStartTime\":\"12 Jul 2016 08:52:00 GMT\"},{\"versionEndTime\":\"14 Jul 2016 10:15:00 GMT\",\"versionId\":3,\"versionName\":\"v1.2\",\"versionStartTime\":\"14 Jul 2016 08:30:00 GMT\"},{\"versionEndTime\":\"14 Jul 2016 11:33:00 GMT\",\"versionId\":4,\"versionName\":\"v1.3\",\"versionStartTime\":\"14 Jul 2016 10:25:00 GMT\"}],\"appId\":2},{\"appName\":\"Cloud DVR\",\"appVersions\":[{\"versionEndTime\":\"12 Jul 2016 08:27:00 GMT\",\"versionId\":1,\"versionName\":\"v1.0\",\"versionStartTime\":\"12 Jul 2016 06:26:00 GMT\"},{\"versionEndTime\":\"12 Jul 2016 09:22:00 GMT\",\"versionId\":2,\"versionName\":\"v1.1\",\"versionStartTime\":\"12 Jul 2016 08:52:00 GMT\"}],\"appId\":3}]} +\n+ {\"apps2\":[{\"appName\":\"ADC\",\"appVersions\":[{\"versionEndTime\":\"12 Jul 2016 08:27:00 GMT\",\"versionId\":1,\"versionName\":\"v1.0\",\"versionStartTime\":\"12 Jul 2016 06:26:00 GMT\"},{\"versionEndTime\":\"12 Jul 2016 09:22:00 GMT\",\"versionId\":2,\"versionName\":\"v1.1\",\"versionStartTime\":\"12 Jul 2016 08:52:00 GMT\"},{\"versionEndTime\":\"14 Jul 2016 10:15:00 GMT\",\"versionId\":3,\"versionName\":\"v1.2\",\"versionStartTime\":\"14 Jul 2016 08:30:00 GMT\"},{\"versionEndTime\":\"14 Jul 2016 11:33:00 GMT\",\"versionId\":4,\"versionName\":\"v1.3\",\"versionStartTime\":\"14 Jul 2016 10:25:00 GMT\"},{\"versionEndTime\":\"25 Jul 2016 11:00:00 GMT\",\"versionId\":5,\"versionName\":\"v1.4\",\"versionStartTime\":\"25 Jul 2016 10:00:00 GMT\"},{\"versionEndTime\":\"25 Jul 2016 13:15:00 GMT\",\"versionId\":6,\"versionName\":\"v1.5\",\"versionStartTime\":\"25 Jul 2016 12:15:00 GMT\"}],\"appId\":1},{\"appName\":\"Staging-ADC\",\"appVersions\":[{\"versionEndTime\":\"12 Jul 2016 08:27:00 GMT\",\"versionId\":1,\"versionName\":\"v1.0\",\"versionStartTime\":\"12 Jul 2016 06:26:00 GMT\"},{\"versionEndTime\":\"12 Jul 2016 09:22:00 GMT\",\"versionId\":2,\"versionName\":\"v1.1\",\"versionStartTime\":\"12 Jul 2016 08:52:00 GMT\"},{\"versionEndTime\":\"14 Jul 2016 10:15:00 GMT\",\"versionId\":3,\"versionName\":\"v1.2\",\"versionStartTime\":\"14 Jul 2016 08:30:00 GMT\"},{\"versionEndTime\":\"14 Jul 2016 11:33:00 GMT\",\"versionId\":4,\"versionName\":\"v1.3\",\"versionStartTime\":\"14 Jul 2016 10:25:00 GMT\"}],\"appId\":2},{\"appName\":\"Cloud DVR\",\"appVersions\":[{\"versionEndTime\":\"12 Jul 2016 08:27:00 GMT\",\"versionId\":1,\"versionName\":\"v1.0\",\"versionStartTime\":\"12 Jul 2016 06:26:00 GMT\"},{\"versionEndTime\":\"12 Jul 2016 09:22:00 GMT\",\"versionId\":2,\"versionName\":\"v1.1\",\"versionStartTime\":\"12 Jul 2016 08:52:00 GMT\"}],\"appId\":3}]}" ;
    }
    
    @RequestMapping(value ="/list" ,method=RequestMethod.GET)
    public String getList()
    {
    	ArrayList<String> crunchifyList = new ArrayList<String>();
    	 
    	crunchifyList.add("Google");
		crunchifyList.add("EBay");
		crunchifyList.add("Paypal");
		crunchifyList.add("Facebook");
		crunchifyList.add("Yahoo");
 
		return "This is List method : \n "+ crunchifyList;
    	
    }
    public static void main(String[] args) throws Exception {
    	
        SpringApplication.run(SpringMain.class, args);
        System.out.println("Spring-boot Application started ::");
    }

}
