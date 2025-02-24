import java.util.*;
class PrefixSum2{

    public int  minStartValue(int[] nums,int n){
        int[] sum = new int[n];
        sum[0]=nums[0];
        int min=0;
        for(int i=1; i<n; i++){
            sum[i]=sum[i-1]+nums[i];
            min=Math.min(min,sum[i]);
        }
        if(min<0){
            return (-(min)+1);
        }
        else{
            return 1;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n=sc.nextInt();
        int[] nums=new int[n];
        System.out.print("Enter the elements of the array: ");
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        PrefixSum2 p=new PrefixSum2();
        System.out.print(p.minStartValue(nums,n));
    }
}