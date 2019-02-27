
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for(int j = i+1;j<nums.length;j++)
            {
                if(Arrays.binarySearch(nums, j+1, nums.length, -nums[i]-nums[j])>j)
                {
                    boolean isUnique = true;
                    for (List<Integer> var : result) {
                        if(var.get(0)==nums[i] && var.get(1)==nums[j])
                        {
                            isUnique = false;
                        }
                    }
                    if(isUnique){
                        result.add(Arrays.asList(nums[i],nums[j],-nums[i]-nums[j]));
                    }
                }
            }
            
        }
        return result;
    }
    
    public static void main(String[] args) {
        int [] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}