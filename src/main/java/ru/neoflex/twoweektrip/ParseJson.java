package ru.neoflex.twoweektrip;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ParseJson implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        var jsonResponse = (String) delegateExecution.getVariable("response");
        System.out.println(jsonResponse);
        JsonNode jsonNode = objectMapper.readTree(jsonResponse);
        String temp = jsonNode.get("main").get("temp").asText();
        System.out.println(temp);
    }
}
