package com.CimbaAI.cimbaAIspringbootapiservice.Services;

import com.CimbaAI.cimbaAIspringbootapiservice.Model.WebsiteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;


@Service
public class APIServices {

    @Autowired
    private RestTemplate restTemplate;

    public String summarizeUrl(WebsiteRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(request.getWeblink(),headers);

        System.out.println("summarize api call ");
        // Call your Scala library here and return the summary
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:9000/summary", requestEntity, String.class);
        return response.getBody();
    }

    public String getRequestHistory() {
        // Retrieve request history from the database
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:9000/history", String.class);
        return response.getBody();

    }

}
