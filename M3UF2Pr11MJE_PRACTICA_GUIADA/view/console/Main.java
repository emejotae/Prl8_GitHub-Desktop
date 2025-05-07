/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.console;

import java.util.Scanner;
import model.validations.UserDataValidations;

/**
 *
 * @author martinjunesp
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
      sc.useDelimiter("\n");
      String option;
      do {
          System.out.println("TESTER FUNCIONES UserdataValidations: ");
          System.out.println("1.-testcheckId ");
          System.out.println("2.-checkFormatDate ");
          System.out.println("3.-calculateAge ");
          System.out.println("4.-checkPostalCode ");
          System.out.println("5.-isNumeric ");
          System.out.println("6.-isAlphabetic ");
          System.out.println("7.-checkEmail ");
          System.out.println("8.-checkName ");
          System.out.println("z.-SALIR ");
          
          System.out.print("Option: ");
          option = sc.next();
          
          switch (option) {
              case "1":
                  testCheckId();
                  break;
              case "2":
                  testCheckFormatDate();
                  break;
              case "3":
                  calculateAge();
                  break;
              case "4":
                  checkPostalCode();
                  break;
              case "5":
                  isNumeric();
                  break;
              case "6":
                  isAlphabetic();
                  break;
              case "7":
                  checkEmail();
                  break;
              case "8":
                  checkName();
                  break;
              case "z":
                  System.out.println("SALIR");
                  break;
              default:
                  System.out.println("Incorrect option");
          }
    
      } while (!option.equals("z"));
    }
    
    static void testCheckId(){
        System.out.print("Enter your id: ");
        String id = sc.next();
        boolean nifOk = UserDataValidations.checkId(1, id);
        if (nifOk){
            System.out.println("The id is correct");
        }
        else{
            System.out.println("Wrong id");
        }
    }

    static void testCheckFormatDate(){
        System.out.print("Enter your date: ");
        String date = sc.next();
        boolean dateOk = UserDataValidations.checkFormatDate(date);
           if (dateOk) {
            System.out.println("The date format is correct");
        } else {
            System.out.println("Wrong date format");
    }
}
    
   static void calculateAge(){
        System.out.println("Enter your birthdate (dd/mm/yyyy): ");
        String birthDate = sc.next();
        int age = UserDataValidations.calculateAge(birthDate);
        if (age == -1) {
            System.out.println("Invalid date.");
        } else {
            System.out.println("Your age is: " + age);
        }
    } 
   
   static void checkPostalCode(){
        System.out.println("Enter your postal code (5 digits): ");
        String zip = sc.next();
        boolean zipOk = UserDataValidations.checkPostalCode(zip);
        if (zipOk) {
            System.out.println("The postal code is correct.");
        } else {
            System.out.println("Wrong postal code.");
        }
    }
    static void isNumeric(){
        System.out.println("Enter a numeric value: ");
        String value = sc.next();
        boolean isNumeric = UserDataValidations.isNumeric(value);
        if (isNumeric) {
            System.out.println("The value is numeric.");
        } else {
            System.out.println("The value is not numeric.");
        }
    }
    static void isAlphabetic(){
        System.out.println("Enter a string to check if it contains only letters: ");
        String value = sc.next();
        boolean isAlphabetic = UserDataValidations.isAlphabetic(value);
        if (isAlphabetic) {
            System.out.println("The string contains only letters.");
        } else {
            System.out.println("The string contains non-alphabetic characters.");
        }
    }
    static void checkEmail(){
        System.out.println("Enter your email: ");
        String email = sc.next();
        boolean emailOk = UserDataValidations.checkEmail(email);
        if (emailOk) {
            System.out.println("The email is correct.");
        } else {
            System.out.println("Wrong email format.");
        }
    }
    static void checkName(){
        System.out.println("Enter your name: ");
        String name = sc.next();
        boolean nameOk = UserDataValidations.checkName(name);
        if (nameOk) {
            System.out.println("The name is valid.");
        } else {
            System.out.println("Wrong name format.");
        }
    }
    
}
