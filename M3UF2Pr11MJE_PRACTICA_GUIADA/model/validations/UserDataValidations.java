package model.validations;

import exceptions.InvalidDateFormatException;
import exceptions.InvalidNifException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserDataValidations {

    public static void checkId(int typeDoc, String id) throws InvalidNifException {
        if (typeDoc != 1 || id == null || id.length() != 9) {
            throw new InvalidNifException("El NIF debe tener 9 caracteres.");
        }

        String numbersPart = id.substring(0, 8);
        char letterPart = id.charAt(8);

        if (!numbersPart.matches("\d{8}")) {
            throw new InvalidNifException("Los primeros 8 caracteres deben ser numéricos.");
        }

        String validLetters = "TRWAGMYFPDXBNJZSQVHLCKE";
        int number = Integer.parseInt(numbersPart);
        char correctLetter = validLetters.charAt(number % 23);

        if (letterPart != correctLetter) {
            throw new InvalidNifException("Letra incorrecta. Debería ser: " + correctLetter);
        }
    }

    public static void checkFormatDate(String date) throws InvalidDateFormatException {
        if (date == null || date.isEmpty() || date.length() != 10) {
            throw new InvalidDateFormatException("Formato incorrecto. Debe ser dd/mm/yyyy.");
        }

        String[] parts = date.split("/");

        if (parts.length != 3 || !isNumeric(parts[0]) || !isNumeric(parts[1]) || !isNumeric(parts[2])) {
            throw new InvalidDateFormatException("La fecha debe tener partes numéricas.");
        }

        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1880 || year > 2025) {
            throw new InvalidDateFormatException("Fecha fuera de rango válido.");
        }

        if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
            throw new InvalidDateFormatException("El mes tiene solo 30 días.");
        }

        if (month == 2) {
            boolean bisiesto = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            if ((bisiesto && day > 29) || (!bisiesto && day > 28)) {
                throw new InvalidDateFormatException("Febrero no tiene tantos días.");
            }
        }
    }

    public static boolean checkPostalCode(String zip) {
        return zip.length() == 5 && isNumeric(zip);
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkEmail(String email) {
        if (email == null || !email.contains("@")) {
            return false;
        }

        String[] parts = email.split("@");
        if (parts.length != 2) {
            return false;
        }

        String domain = parts[1];
        if (!domain.contains(".")) {
            return false;
        }

        String[] domainParts = domain.split("\.");
        String extension = domainParts[domainParts.length - 1];
        return extension.length() >= 2 && extension.length() <= 3;
    }

    public static boolean checkName(String name) {
        if (name == null || name.isEmpty() || name.length() < 2 || name.length() > 50) {
            return false;
        }

        for (char c : name.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }

        return true;
    }

    public static int calculateAge(String birthDate) {
        String[] parts = birthDate.split("/");
        int birthYear = Integer.parseInt(parts[2]);
        int birthMonth = Integer.parseInt(parts[1]);
        int birthDay = Integer.parseInt(parts[0]);

        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();
        int currentDay = currentDate.getDayOfMonth();

        int age = currentYear - birthYear;
        if (birthMonth > currentMonth || (birthMonth == currentMonth && birthDay > currentDay)) {
            age--;
        }

        return age;
    }
}
