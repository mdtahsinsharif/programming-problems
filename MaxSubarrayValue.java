public class MaxSubarray {
    public static int max_subarray_sum(int[] arr){
        int max_upto_here = 0, max_so_far = 0;
        for(int i=0; i<arr.length; i++){
            max_upto_here = max_upto_here + arr[i];
            if(max_upto_here < 0)
                max_upto_here = 0;
                
            if(max_so_far < max_upto_here)
                max_so_far = max_upto_here;
        }
        return max_so_far;
    }
    
    public static void main(String args[]) {
        int[] arr = new int[]{-2, -3, 4, -1, -2, 1, 5, -3, -2, -1, 8, 9, 8, -1};
        System.out.println("Max subarray sum = " + max_subarray_sum(arr));
    }
}
