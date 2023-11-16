import java.util.*;
import java.lang.*;
import java.math.*;

class Calculator {
    public static int add(int a, int b) {
        int result = a + b;
        return result;
    }

    public static int sub(int a, int b) {
        return a - b;
    }

    public static double multi(int a, int b) {
        return (double) a * b;

    }

    public static double div(int a, int b) {
        double result = (double) a / b;
        return result;
    }

    public static double modlus(int a, int b) {
        double result = (double) a % b;
        return result;
    }
}

public class ChooseOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! we have \n 1. Toss \n 2.calculator \n what do you choose ?");
        int choice0 = sc.nextInt();
        switch (choice0) {
            case 1:
                System.out.println("let's see.");
                if (toss()) {
                    System.out.println("Heads");
                } else {
                    System.out.println("Tails");
                }
                break;
            case 2:
                System.out.println("Hi and welcome ! Do you want to continue to Basic Calculator ? (Y/N): ");
                char choice;
                choice = sc.next().charAt(0);
                while (choice == 'Y') {
                    System.out.println(
                            "Enter your choice: \n 1. Addition \n 2.Subtraction \n 3.Multiplication \n 4.Division \n 5.Modulus");
                    int val = sc.nextInt();
                    System.out.println("Enter your first number");
                    int num1 = sc.nextInt();
                    System.out.println("Enter your second number : ");
                    int num2 = sc.nextInt();
                    switch (val) {
                        case 1:
                            System.out.println("you have chosen addition");
                            System.out.println("And the result is : " + Calculator.add(num1, num2));
                            break;
                        case 2:
                            System.out.println("You have chosen Subtraction");
                            System.out.println("And the result is :" + Calculator.sub(num1, num2));
                            break;
                        case 3:
                            System.out.println("You have chosen to Multiplication");
                            System.out.println("And the result is :" + Calculator.multi(num1, num2));
                            break;
                        case 4:
                            System.out.println("You have chosen to Division");
                            System.out.println("And the result is :" + Calculator.div(num1, num2));
                            break;
                        case 5:
                            System.out.println("You have chosen to Modulus");
                            System.out.println("And the result is :" + Calculator.modlus(num1, num2));
                            break;

                        default:
                            System.out.println("");
                            break;
                    }
                    System.out.println("Do you want to continue ? (Y/N)");
                    char choice2 = sc.next().charAt(0);
                    choice = choice2;
                }
                sc.close();

            default:
                System.out.println("Invalid choice");
                break;
        }

    }

    public static boolean toss() {
        double val = Math.random();
        if (val >= 0.5) {
            return true;
        } else {
            return false;
        }
    }
}
