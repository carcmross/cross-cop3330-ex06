package base;

import java.time.Clock;
import java.util.Scanner;
import java.util.Calendar;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 first_name last_name
 */

/*
 * Your computer knows what the current year is, which means you can incorporate that into your programs. You just have
 * to figure out how your programming language can provide you with that information.
 *
 * Create a program that determines how many years you have left until retirement and the year you can retire. It should
 * prompt for your current age and the age you want to retire and display the output as shown in the example
 * that follows.
 * Example Output
 *
 * What is your current age? 25
 * At what age would you like to retire? 65
 * You have 40 years left until you can retire.
 * It's 2015, so you can retire in 2055.
 *
 * Constraints
 *
 *     Again, be sure to convert the input to numerical data before doing any math.
 *     Don’t hard-code the current year into your program. Get it from the system time via your programming language.
 *
 * Challenge
 *
 *     Handle situations where the program returns a negative number by stating that the user can already retire.
 *
 */

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();
        String cur_age = myApp.getAge();
        String retirement_age = myApp.getRetirementAge();
        String years_left = myApp.calc_years_left(cur_age, retirement_age);
        String cur_year = myApp.getYear();
        String retirement_year = myApp.calc_retirement_year(cur_year, years_left);
        String outputString = myApp.generateOutput(years_left, cur_year, retirement_year);
        myApp.printOutput(outputString);
    }

    private void printOutput(String outputString) {
        System.out.println(outputString);
    }

    private String getYear() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return Integer.toString(year);
    }

    private String generateOutput(String years_left, String cur_year, String retirement_year) {
        return "You have " + years_left + " years left until you can retire.\n"
                + "It's " + cur_year + ", so you can retire in " + retirement_year + ".";
    }

    private String calc_retirement_year(String cur_year, String years_left) {
        return Integer.toString(Integer.parseInt(cur_year) + Integer.parseInt(years_left));
    }

    private String getAge() {
        System.out.print("What is your current age? ");
        String age = in.nextLine();
        return age;
    }

    private String getRetirementAge() {
        System.out.print("At what age would you like to retire? ");
        String retirement_age = in.nextLine();
        return retirement_age;
    }

    private String calc_years_left(String cur_age, String retirement_age) {
        return Integer.toString(Integer.parseInt(retirement_age) - Integer.parseInt(cur_age));
    }
}
