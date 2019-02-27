/**
 * Solution
 */
class Solution {
    public static int  maxArea(int[] height) {
        int start_index = 0;
        int end_index = height.length -1;
        int start,end;
        int maxArea = 0;
        int tempArea;
        while(end_index>start_index)
        {
            start = height[start_index];
            end = height[end_index];
            if(start>end)  // end 那端是短板
            {
                tempArea = end*(end_index-start_index);
                maxArea = Math.max(maxArea, tempArea);
                end_index--;
            }
            else{          // start 那端是短板
                tempArea = start*(end_index-start_index);
                maxArea = Math.max(maxArea,tempArea);
                start_index++;
            }
        }
        return maxArea;
        
    }
    public static void main(String[] args) {
        int [] test = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(test));
    }    
}