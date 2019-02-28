import java.util.Arrays;

class Solution {
    public static int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        long closestTarget=Integer.MAX_VALUE;
        Arrays.sort(nums);
        int index = 0;
        for (int i = 0; i < len-2; i++) {
            for (int j = i+1; j < len-1; j++) {
                int otherTarget = target-nums[i]-nums[j];
                index = Arrays.binarySearch(nums, j+1, len, otherTarget);
                if (0<=index&&index<=j)
                    continue;
                else if(index>j)   // 找到合适的了
                {
                    closestTarget = target;
                    return (int)closestTarget;
                }
                else{
                    int temp ;
                    index = -index-1;
                    if(index==0||index == len)
                    {
                        temp = nums[i] + nums[j] + (index>0?nums[index-1]:nums[index]);
                        closestTarget = Math.abs(temp-target)<Math.abs(closestTarget-target)?temp:closestTarget;
                    }
                    else{
                        int temp_change;
                        if(index-1==j)
                            temp_change = nums[index]-otherTarget;
                        else
                            temp_change = Math.abs(nums[index-1]-otherTarget)<Math.abs(nums[index]-otherTarget)?(nums[index-1]-otherTarget):(nums[index]-otherTarget);
                        if (Math.abs(temp_change)<Math.abs(closestTarget - target))
                        {
                            closestTarget = temp_change+target;
                        }
                    }
                }
            }
        }
        return (int)closestTarget;

    }
    public static void main(String[] args) {
        int [] a = {-3,-2,-5,3,-4};
        System.out.println(threeSumClosest(a, -1));  
    }
}

