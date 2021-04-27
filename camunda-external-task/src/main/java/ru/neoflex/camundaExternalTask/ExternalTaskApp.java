package ru.neoflex.camundaExternalTask;

import org.camunda.bpm.client.ExternalTaskClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ExternalTaskApp {

    public static void main(String[] args) {
        SpringApplication.run(ExternalTaskApp.class);

        ExternalTaskClient client = ExternalTaskClient.create()
                .baseUrl("http://localhost:8080/engine-rest")
                .asyncResponseTimeout(1000)
                .build();

        client.subscribe("createOrder").handler((externalTask, externalTaskService) -> {
            try {
//                String result = "result";
                Map<String, Object> variables = new HashMap<>();

                variables.put("country", "RF");
                externalTaskService.complete(externalTask, variables);
                System.out.println("The External Task " + externalTask.getId() + " has been completed!");
            } catch (Exception e) {
//                externalTaskService.handleFailure(externalTask, e.getMessage(), e.getStackTrace());
            }
        }).open();
    }
}
