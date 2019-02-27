class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length+nums2.length;
        int [] result = new int[len];
        int j=0;
        int k=0;
        int i=0;
        double median = 0.0;
        // 不存在两个数组同时为零
        // 当某个数组长度为0
        if(nums1.length==0)
        {
            return nums2.length%2==1?nums2[len/2]:(double)(nums2[len/2-1] + nums2[len/2])/2;
        }
        if(nums2.length==0)
        {
            return nums1.length%2==1?nums1[len/2]:(double)(nums1[len/2-1] + nums1[len/2])/2;
        }
        // while循环类似 归并排序 中的整合部分代码
        while(i<=len/2){
            result[i++] = nums1[j]<nums2[k]? nums1[j++]:nums2[k++];
            if(k==nums2.length)
            {
                while(j<nums1.length)
                {
                    result[i++] = nums1[j++]; 
                }
            }
            if(j==nums1.length)
            {
                while(k<nums2.length)
                {
                    result[i++] = nums2[k++]; 
                }
            }
        }
        // boolean isodd = ();
        if (len%2==1) {
            median = result[len/2];
            
        } else {
            median = (double)(result[len/2-1] + result[len/2])/2;
            
        }
        
        return median;

        
        
    }
    // 测试代码
    public static void main(String[] args) {
        int [] a1 = {};
        int [] a2 = {5};
        double med = findMedianSortedArrays(a2,a1);
        System.out.println(med);
    }
}