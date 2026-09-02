package com.research.assistant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeminiResponse {
    public List<Step> steps;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Step {
        private List<Content> content;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Content {
        private String text;
    }
}
