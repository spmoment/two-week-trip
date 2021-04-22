package ru.neoflex.twoweektrip.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CapitalController {


    @GetMapping("/capital")
    public String getCapital(@RequestBody String jsonWithCountry) throws JsonProcessingException {
        System.out.println("*** " + jsonWithCountry);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonWithCountry);
        String country = jsonNode.get("country").asText();
        System.out.println(country);
        return getCapitalOfCountry(country);
    }

    private String getCapitalOfCountry(String country) {
        Map<String, String> capitalOfState = new HashMap<>();
        capitalOfState.put("France", "Paris");
        capitalOfState.put("RF", "Moscow");
        capitalOfState.put("China", "Beijing");
        System.out.println(capitalOfState.get(country));
        return capitalOfState.get(country);
    }
}
