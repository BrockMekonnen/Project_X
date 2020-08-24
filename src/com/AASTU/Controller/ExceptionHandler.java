package com.AASTU.Controller;

import javafx.scene.control.TextField;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.io.IOException;

public class ExceptionHandler  extends Exception{
    static ValidationSupport validationSupport = new ValidationSupport();
    static boolean validateNum(String numString, TextField textField) throws IOException {
        if(numString.matches("[0-9]+")){
            return true;
        }else {
            validationSupport.registerValidator(textField, Validator.createEmptyValidator("Invalid input, Please Enter Number"));
            return false;
        }
//      try{
//          Integer.parseInt(numString);
//           return true;
//      }catch (NumberFormatException e){
//          return false;
//      }
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
