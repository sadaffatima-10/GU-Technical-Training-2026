import java.util.*;
public class PrefixSum1{
    public int largestAltitude(int[] gain,int n){
        int[] altitude=new int[n+1];
        altitude[0]=0;
        int highestAltitude=0;
        for(int i=1;i<altitude.length;i++){
            altitude[i]=altitude[i-1]+gain[i-1];
            highestAltitude=Math.max(highestAltitude,altitude[i]);
        }
        return highestAltitude;

        
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the array gain: ");
        int n=sc.nextInt();
        int[] gain=new int[n];
        System.out.print("Enter the gains in the altitude: ");

        for(int i=0; i<n; i++){
            gain[i]=sc.nextInt();
        }
        PrefixSum1 q=new PrefixSum1();
        int result= q.largestAltitude(gain,n);
        System.out.print("highest altitude of a point: " + result);


    }
}