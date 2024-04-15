package com.CimbaAI.cimbaAIspringbootapiservice.Controller;

import com.CimbaAI.cimbaAIspringbootapiservice.Model.WebsiteRequest;
import com.CimbaAI.cimbaAIspringbootapiservice.Services.APIServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> getRequestHistory() {
        String history = apiServices.getRequestHistory();
        return ResponseEntity.ok(history);
    }
}
