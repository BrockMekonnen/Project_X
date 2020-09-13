package com.AASTU.Controller;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.chrono.EthiopicChronology;

import java.io.IOException;
import java.time.LocalDate;

public class ExceptionHandler  extends Exception{
    static ValidationSupport validationSupport = new ValidationSupport();
    static boolean validateNum(String numString, TextField textField) throws IOException {
        try {
            Double.parseDouble(numString);
            return true;
        }catch (NumberFormatException e) {
            validationSupport.registerValidator(textField, Validator.createEmptyValidator("Invalid input, Please Enter Number"));
            return false;
        }
    }

    static boolean ValidatePhone(String ph, TextField textField) throws IOException {
        if (ph.charAt(0) == '9' && ph.length() == 9 && ph.matches("[0-9]+")) {
            return true;
        } else {
            validationSupport.registerValidator(textField, Validator.createEmptyValidator("Invalid Phone Number"));
            return false;
        }
    }

    public static boolean isLetter(String name, TextField textField) {
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if(!Character.isLetter(c) && !Character.isSpaceChar(c)) {
                validationSupport.registerValidator(textField, Validator.createEmptyValidator("Invalid Input, Please Enter Only Characters"));
                return false;
            }
        }
        return true;
    }

    public static boolean isValidDate(ComboBox<String> cal, ComboBox<Integer> year){
        if(cal.getValue().equals("E.C")){
            DateTime ethioDate = new DateTime(EthiopicChronology.getInstance());
            if(year.getValue() <= ethioDate.getYear()){
                return true;
            }else {
                return false;
            }
        }
        return true;
    }

   public static boolean validateOutPatientDate(LocalDate start, LocalDate end){
        int startDay = start.getDayOfMonth(),startMonth = start.getMonthValue(), startYear = start.getYear();
        int endDay = end.getDayOfMonth(), endMonth = end.getMonthValue(), endYear = end.getYear();

        if(startDay <=endDay && startMonth <= endMonth && startYear <= endYear){
            if(LocalDate.now().getYear() <= startYear && LocalDate.now().getMonthValue() <= startMonth && LocalDate.now().getDayOfMonth() <= startDay){
                if(endDay - startDay > 1){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean validatUserInput(String firstName, String lastName, String password, String gender, String phone, String city, String userName) throws IOException {
        if(firstName.isEmpty() || firstName.trim().isEmpty() || lastName.isEmpty() ||
                lastName.trim().isEmpty() || password.isEmpty()||password.trim().isEmpty() ||
                gender.isEmpty()|| gender.trim().isEmpty() ||phone.isEmpty() ||
                phone.trim().isEmpty() || city.isEmpty() || city.trim().isEmpty() ||
                userName.isEmpty() || userName.trim().isEmpty()) {
            return false;
        }
        return true;
    }

}
