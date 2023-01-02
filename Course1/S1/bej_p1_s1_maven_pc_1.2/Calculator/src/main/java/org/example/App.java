package org.example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    static Scanner sc=new Scanner(System.in);
    public static void main( String[] args )
    {
        int n1,n2;
        System.out.println("Enter the Choice:\n1.Addition\n2.Subtraction\n3.Multiplication\n4.Division");
        while (true){
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter the number1: ");
                    n1=sc.nextInt();
                    System.out.println("Enter the number2: ");
                    n2=sc.nextInt();
                    System.out.println(App.addition(n1,n2));
                        break;
                case 2:
                    System.out.println("Enter the number1: ");
                    n1=sc.nextInt();
                    System.out.println("Enter the number2: ");
                    n2=sc.nextInt();
                    System.out.println(App.subtraction(n1,n2));
                        break;
                case 3:
                    System.out.println("Enter the number1: ");
                    n1=sc.nextInt();
                    System.out.println("Enter the number2: ");
                    n2=sc.nextInt();
                    System.out.println(App.multiplication(n1,n2));
                        break;
                case 4:
                    System.out.println("Enter the number1: ");
                    n1=sc.nextInt();
                    System.out.println("Enter the number2: ");
                    n2=sc.nextInt();
                    System.out.println(App.division(n1,n2));
                        break;
                default:
                    System.out.println("Enter a valid choice :)");
            }
        }
    }

    public static int addition(int n1,int n2){
        return n1+n2;
    }

    public static int subtraction(int n1,int n2){
        return n1-n2;
    }

    public static int multiplication(int n1,int n2){
        return n1*n2;
    }

    public static int division(int n1,int n2){
        return n1/n2;
    }
}
