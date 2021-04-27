//package ru.neoflex.camundaMain;
//
//import org.camunda.bpm.engine.delegate.DelegateExecution;
//import org.camunda.bpm.engine.delegate.JavaDelegate;
//
//public class SaveToDB implements JavaDelegate {
//
//    @Override
//    public void execute(DelegateExecution delegate) throws Exception {
//        String saveResponseToDB = (String) delegate.getVariable("response");
//        System.out.println("SaveToDB class. saveResponseToDB is " + saveResponseToDB);
//    }
//}
