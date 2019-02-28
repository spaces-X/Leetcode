class Solution {
    public static int trap(int[] height) {
        if(height.length<3)
        {
            return 0;
        }
        int len = height.length;
        int r_max = height[len-1];
        int l_max = height[0];
        int l_current = 1;
        int r_current = len-2;
        int result = 0;
        while(l_current<=r_current)
        {
            // 左侧高   而且过后更新左侧最高后只会更加的高  所以左侧一定能够挡住 此时短板是右侧
            if(l_max>r_max){
                if (height[r_current]<r_max) {  // 右侧最高高于当前还能挡住
                    result += r_max - height[r_current];    // 盛水量增加
                }
                else{                            // 右侧没有比当前还高的了  此时右侧挡不住当前  当前值成了右侧最高的挡板 更新右侧最高值
                    r_max = height[r_current];
                    // 盛水量不变
                }
                r_current--;                     // 向中间靠拢
            }
            // 右侧高   而且过后更新右侧最高后只会更加的高  所以右侧一定能够挡住 此时短板是左侧
            else{
                if (height[l_current]<l_max) {          // 左侧最高高于当前还能挡住
                    result += l_max - height[l_current];
                }
                else{                               // 左侧没有比当前还高的了  此时左侧挡不住当前  当前值成了左侧最高的挡板 更新左侧最高值
                    l_max = height[l_current];
                }
                l_current++;                       // 向中间靠拢           
            } 
        }
        return result;
    }

    public static void main(String[] args) {
        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }


}