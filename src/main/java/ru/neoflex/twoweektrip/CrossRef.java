package ru.neoflex.twoweektrip;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
public class CrossRef implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        var country = delegateExecution.getVariable("country");
        System.out.println("The country is " + country);
        String jsonCountry = "{ \"country\": \"" + country + "\"}";
        delegateExecution.setVariable("country", jsonCountry);
    }
}
