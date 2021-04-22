package ru.neoflex.twoweektrip;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
public class CrossRef implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("The country is " + delegateExecution.getVariable("country"));
        var country = delegateExecution.getVariable("country");
        delegateExecution.setVariable("country", country);
    }
}
