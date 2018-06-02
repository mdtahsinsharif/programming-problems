import java.util.HashMap;

/*
Find a 2 numbers in O(n) time that multiply to NUM
*/

public class FindMultipliers{
    
    static int NUM = 198;
    public static int[] multiply_to_num(int[]arr)
    {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<arr.length; i++)
        {    
            if(map.containsKey((NUM/arr[i])))
            {
                return new int[]{map.get(NUM/arr[i]),arr[i]};
            } 
            else 
            {
                map.put(arr[i], arr[i]);
            }
        }
        return null; 
    }

     public static void main(String []args)
     {
        int[] arr = {2,3,4,5,6,7,7,8,99,0,0};
        System.out.println("First num: " + multiply_to_num(arr)[0] + " Second num: " + multiply_to_num(arr)[1]);
     }
}