//Questsion 13
import java.util.Scanner;
public class LargsetNumberAmongThreeNUmbers {
    public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter number 1");
    int number1=sc.nextInt();
    System.out.println("Enter number 2");
    int number2=sc.nextInt();
    System.out.println("Enter number 3");
    int number3=sc.nextInt();
    if(number1<number2){
        System.out.println("Number 2 is greater");
    }
    else if(number2<number3){
        System.out.println("Number 3 is greater.");
    }
    else
    {
        System.out.println("Number 1 is greater");
    }
    
    
    sc.close();

    }
}
