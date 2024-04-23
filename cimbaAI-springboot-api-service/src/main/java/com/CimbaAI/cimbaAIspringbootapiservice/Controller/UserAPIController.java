package com.CimbaAI.cimbaAIspringbootapiservice.Controller;

import com.CimbaAI.cimbaAIspringbootapiservice.Model.HistoryLogs;
import com.CimbaAI.cimbaAIspringbootapiservice.Model.WebsiteRequest;
import com.CimbaAI.cimbaAIspringbootapiservice.Services.APIServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserAPIController {

    @Autowired
    private APIServices apiServices;
    @PostMapping("/summarize")
    public ResponseEntity<String> summarizeUrl(@RequestBody WebsiteRequest request) {

        String summary = apiServices.summarizeUrl(request);
        return ResponseEntity.ok(summary);
    }

    @GetMapping("/history")
    public List<HistoryLogs> getRequestHistory() {
        return apiServices.getRequestHistory();
    }
}
