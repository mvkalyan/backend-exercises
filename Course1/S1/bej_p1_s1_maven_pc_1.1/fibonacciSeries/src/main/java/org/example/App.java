package org.example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "-----------Welcome to Fibonacci Series-------------" );
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number: ");
        int choice=sc.nextInt();
        App.fibo(choice);
    }

    public static boolean fibo(int choice){
        int sum;
        int num=0;
        int next=1;
        if(choice<=0){
            System.out.println("Fibonacci Cannot be Applied for Non-Positive numbers :(");
            return false;
        }
        else{
            System.out.println(next);
            for (int i=0;i<choice-1;i++){
                sum=num+next;
                System.out.println(sum);
                num=next;
                next=sum;
            }
        }
        return true;
    }
}
