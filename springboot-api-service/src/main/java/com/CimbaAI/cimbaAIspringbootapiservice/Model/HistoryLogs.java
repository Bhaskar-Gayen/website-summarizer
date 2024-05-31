package com.CimbaAI.cimbaAIspringbootapiservice.Model;

import java.time.LocalDate;

public class HistoryLogs {
    private LocalDate timestamp;
    private String website;

    public HistoryLogs() {
    }

    public HistoryLogs(LocalDate timestamp, String website) {
        this.timestamp = timestamp;
        this.website = website;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
