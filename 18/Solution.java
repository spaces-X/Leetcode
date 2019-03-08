import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        String str = "abc";
        List<List<Integer>> results = new ArrayList<>();
        HashMap<Integer,List<List<Integer>>> sum1 = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sum = nums[i]+nums[j];
                if(sum1.containsKey(sum)){
                    ArrayList<Integer> newAnswer = new ArrayList<>();
                    newAnswer.add(i);
                    newAnswer.add(j);
                    sum1.get(sum).add(newAnswer);
                }
                else{
                    List<List<Integer>> answers = new ArrayList<>();
                    List<Integer> newAnswer = new ArrayList<>(Arrays.asList(i,j));
                    answers.add(newAnswer);
                    sum1.put(sum,answers);
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length-2; j++) {
                int sum = target - nums[i] - nums[j];
                if(sum1.containsKey(sum))
                {
                    for (List<Integer> temp : sum1.get(sum)) {
                        if(temp.get(0)>j && !results.contains(Arrays.asList(nums[i],nums[j],nums[temp.get(0)],nums[temp.get(1)])))
                        {
                            results.add(Arrays.asList(nums[i],nums[j],nums[temp.get(0)],nums[temp.get(1)]));
                        }
                    }
                }
            }
        }
        return results;
    }
    public static void main(String[] args) {
        int [] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(nums, 0));
    }
}