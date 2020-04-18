package com.society.societymgmt;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.society.societymgmt.model.SocietyMember;
import com.society.societymgmt.model.SocietyTenant;

@SpringBootTest(classes = SocietyAppApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SocietyAppApplicationTests {

	
	@Value(value = "${ec2.url}")
    private String urlName;

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;
	
	private String getRootUrl() {
 		return urlName.trim()+ ":" + port;
	}
	
	@Test
	void contextLoads() {
	}

	@Test
	public void testSaveMember() {
		SocietyMember member = new SocietyMember("A3", "401", "", "Mr.unni thamburan", "9852365782","xyz@gmail.com", 
				true);
		ResponseEntity<SocietyMember> postResponse = restTemplate.postForEntity(getRootUrl() + "/member/saveMember",
				member, SocietyMember.class);

		assertNotNull(postResponse.getBody());
	}

	
	@Test
	public void testGetAllMembers() {
		HttpHeaders headers = new HttpHeaders();

		LinkedMultiValueMap<String, String> allRequestParams = new LinkedMultiValueMap<>();
		allRequestParams.add("_limit","10");
		allRequestParams.add("_page","1");
		allRequestParams.add("_order","asc");
		allRequestParams.add("_sort","building");
		
		
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
	   UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(getRootUrl() + "/member/allMembers") // getRootUrl = http://example.com/hotels
	            .queryParams(
	                    (LinkedMultiValueMap<String, String>) allRequestParams); // The allRequestParams must have been built for all the query params
	    UriComponents uriComponents = builder.build().encode(); // encode() is to ensure that characters like {, }, are preserved and not encoded. Skip if not needed.

		ResponseEntity<String> response = restTemplate.exchange(uriComponents.toUri(), HttpMethod.GET,
				entity, String.class);
		// System.out.println("ALL members --" + response.getBody());
		assertNotNull(response.getBody());
	}

	@Test
	public void testGetMemberById() {
		SocietyMember member = restTemplate.getForObject(getRootUrl() + "/member/byMember/A3401", SocietyMember.class);
		// System.out.println("the member name is :" + member.getBuilding() +"-" +
		// member.getFlatNo() + "-" + member.getMemberName());
		assertNotNull(member);
	}


	
	  @Test 
	  public void testSaveTenant() {
		  System.out.println("inside the test save tenant-----");
		  
		  SocietyTenant tenant = new SocietyTenant("A2","402","",false, "Mr.abchid", "Mr. sadi shdikdj", "9852512542","dfsdf@gnak.com");
		  
		  ResponseEntity<SocietyTenant> postResponse = restTemplate.postForEntity(getRootUrl() + "/tenant/saveTenant", tenant, SocietyTenant.class);
		  
		  assertNotNull(postResponse.getBody()); 
	}
	 

}
