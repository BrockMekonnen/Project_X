package com.AASTU.Controller;

import java.io.IOException;

public class ExceptionHandler  extends Exception{

    static boolean validateNum(String numString) throws IOException {
        if(numString.matches("[0-9]+")){
            return true;
        }else {
            return false;
        }
//      try{
//          Integer.parseInt(numString);
//           return true;
//      }catch (NumberFormatException e){
//          return false;
//      }
  }

  static boolean ValidatePhone(String ph) throws IOException {
      if (ph.charAt(0) == '9' && ph.length() == 9 && ph.matches("[0-9]+")) {
             return true;
          } else {
          return false;
      }
  }

  public static boolean isLetter(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }

}
