package com.CimbaAI.cimbaAIspringbootapiservice.Services;

import com.CimbaAI.cimbaAIspringbootapiservice.Model.HistoryLogs;
import com.CimbaAI.cimbaAIspringbootapiservice.Model.WebsiteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class APIServices {

    @Autowired
    private RestTemplate restTemplate;

    public String summarizeUrl(WebsiteRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<WebsiteRequest> requestEntity = new HttpEntity<>(request,headers);

        System.out.println("summarize api call "+request);
        // Call your Scala library microservices here and return the summary
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:9000/summary", requestEntity, String.class);
        return response.getBody();
    }

    public List<HistoryLogs> getRequestHistory() {
        // Retrieve request history from the database
        ResponseEntity<HistoryLogs[]> responseEntity = restTemplate.exchange(
                "http://localhost:9000/history",
                HttpMethod.GET,
                null,
                HistoryLogs[].class
        );
        HistoryLogs[] historyLogsArray = responseEntity.getBody();
        assert historyLogsArray != null;
        return Arrays.asList(historyLogsArray);
    }

}
