package Atishay_Jain;

import java.util.*;

public class Difference {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter first number: ");
        int num1=sc.nextInt();

        System.out.println("Enter second number: ");
        int num2=sc.nextInt();
        
        if(num1>num2){
            System.out.println("Difference of two number: "+(num1-num2));
        }
        else{
            System.out.println("Difference of two number: "+(num2-num1));
        }
    }
}
