package Atishay_Jain;

import java.util.*;

public class VowelOrConsonant {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter a character: ");
        char c=sc.next().charAt(0);

        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U'){
            System.out.println("It is a vowel.");
        }
        else{
            System.out.println("It is a consonent.");
        }
    }
}
