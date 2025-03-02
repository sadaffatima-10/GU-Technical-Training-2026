import java.util.*;
public class PrefixSum5 {
    public int pivotIndex(int[] nums,int n){
        int total=0;
        for(int i=0; i<n; i++){
            total +=nums[i];
        }
        int leftTotal=0;
        for(int i=0;i<n;i++){
            int rightTotal=total-leftTotal-nums[i];
            if(rightTotal==leftTotal){
                return i;
            }else{
                leftTotal +=nums[i];
            }
        }
        return -1;
    }

    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n=sc.nextInt();
        int[] nums=new int[n];
        System.out.print("Enter the elements of array: ");
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        PrefixSum5 p= new PrefixSum5();
        System.out.print("The pivot index is: "+p.pivotIndex(nums, n));
    }
}
