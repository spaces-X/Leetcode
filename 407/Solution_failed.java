/**
 * Solution
 */
import java.lang.Math;
import java.util.*;
class Solution1 {
    public static int[][] trapRainWater(int[][] heightMap) {
        // if(heightMap.length<3)
        //     return 0;
        // if(heightMap[0].length<3)
        //     return 0;
        int verticalLen= heightMap.length;
        int horzontalLen = heightMap[0].length;
        int [][] heightMax = new int [verticalLen][horzontalLen];
        for (int i = 0;i < verticalLen;i++)
        {
            int left = 0,right = horzontalLen-1;
            int left_max = 0,right_max=0;
            while(left<=right)
            {
                if(heightMap[i][left]<heightMap[i][right])
                {
                    
                    heightMax[i][left] = heightMap[i][left] >= left_max ? (left_max=heightMap[i][left]) : left_max;
                    left++;
                }
                else{
                    
                    heightMax[i][right] = heightMap[i][right] >= right_max ? (right_max = heightMap[i][right]) :right_max;
                    right--;
                }
            }
        }
        int sum = 0;
        for (int j = 0; j < horzontalLen; j++) {
            int left = 0,right = verticalLen-1;
            int left_max = 0,right_max=0;
            while(left<=right)
            {
                if(heightMap[left][j]<heightMap[right][j])
                {
                    // heightMap[left][j] >= left_max ? left_max=heightMap[left][j]:(heightMax[left][j]=min(left_max-heightMap[left][j],heightMax[left][j]));


                    int temp = heightMap[left][j]>=left_max? left_max=heightMap[left][j]:left_max;
                    heightMax[left][j] = Math.min(temp,heightMax[left][j]);


                    left++;
                }
                else{
                    // height[right][j] >= right_max ? (right_max = height[right][j]) : (heightMax[right][j]=min(right_max-heightMap[right][j],heightMax[right][j]));



                    int temp = heightMap[right][j]>=right_max?(right_max = heightMap[right][j]):right_max;
                    heightMax[right][j] = Math.min(temp, heightMax[right][j]);
                    right--;
                }
            }
            
        }
        for (int i = 1; i < heightMap.length-1 ; i++) {
            for (int j = 1; j < heightMap[0].length-1; j++) {
                int minMaxValue = Math.min(Math.min(heightMax[i-1][j], heightMax[i+1][j]), Math.min(heightMax[i][j-1], heightMax[i][j+1]));
                if (heightMap[i][j]<minMaxValue) {
                    sum+=minMaxValue-heightMap[i][j];
                }
            }
        }
        return heightMax;
            
        
    }
    public static void main(String[] args) {
        // int [][]heightMap = {
        //     {12,13,1,12},
        //     {13,4,13,12},
        //     {13,8,10,12},
        //     {12,13,12,12},
        //     {13,13,13,13}
        // };
        // System.out.println(trapRainWater(heightMap));


        int [][]heightMap = {{9,9,9,9,9,9,8,9,9,9,9},{9,0,0,0,0,0,1,0,0,0,9},{9,0,0,0,0,0,0,0,0,0,9},{9,0,0,0,0,0,0,0,0,0,9},{9,9,9,9,9,9,9,9,9,9,9}};
        // int [][]heightMap = {
        //     {1,4,3,1,3,2},
        //     {3,2,1,3,2,4},
        //     {2,3,3,2,3,1}
        // };
        int [][]result = trapRainWater(heightMap);
    //     // System.out.println(trapRainWater(heightMap));
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j]+",");
            }
            System.out.println(" ");
            
        }
    }
    
}