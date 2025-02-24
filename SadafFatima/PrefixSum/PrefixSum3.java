import java.util.*;
class PrefixSum3{

    public void NumsArray(int[] nums,int[] sumArray,int n){
        sumArray[0]=nums[0];

        for(int i=1; i<n; i++){
            sumArray[i]=sumArray[i-1]+nums[i];
        }
    }
    public int sumRange(int[] sumArray, int[] nums, int left,int right){
        if (left == 0) {
            return sumArray[right];
        }
        return sumArray[right] - sumArray[left - 1];

    }


    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n=sc.nextInt();

        int[] sumArray = new int[n];

        int[] nums=new int[n];
        System.out.print("Enter the elements of the array: ");
        for(int i=0; i<n; i++){
            nums[i]=sc.nextInt();
        }

        System.out.print("Enter the number of queries: ");
        int y=sc.nextInt();

        int left=0;
        int right=0;
        
        PrefixSum3 p=new PrefixSum3();
        p.NumsArray(nums,sumArray,n);

        for(int i=0; i<y; i++){
            System.out.print("Enter the left: ");
            left=sc.nextInt();
            System.out.print("Enter the right: ");
            right=sc.nextInt();

            int result=p.sumRange(sumArray,nums,left,right);
            System.out.println("The sum of elements between indices "+left+" and "+right+ " is: "+result);

        }

    }
}