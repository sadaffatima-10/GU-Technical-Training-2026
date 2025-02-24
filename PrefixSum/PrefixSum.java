import java.util.*;
public class PrefixSum{
    public int[] runningSum(int[] nums){
        int n=nums.length;
        int[] sum=new int[n];
        sum[0]=nums[0];
        for(int i=1;i<n;i++){
            sum[i]=nums[i]+sum[i-1];
        }
        return sum;
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
        PrefixSum s=new PrefixSum();
        int[] result=s.runningSum(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}