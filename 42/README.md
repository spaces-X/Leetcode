# 42：接雨水

Given *n* non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

![img](https://assets.leetcode.com/uploads/2018/10/22/rainwatertrap.png)
The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. **Thanks Marcos** for contributing this image!

**Example:**

```
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
```





思路：

1. 短板原则：

   盛水量取决于左右侧较短的bar的值

2. 左右两侧夹逼中间：

   记录当前bar左侧和右侧的最高高度，并取最高高度小的那个(例如左侧的最高高度小于右侧的最高高度，选左侧)

   如果当前值不高于两侧最高高度中相对小的(例如左侧最高高度小)，即当前高度不高于左侧最高高度，则储水量增加**左侧最高高度-当前高度**

   如果当前值高于两侧最高高度中相对小的(例如左侧最高高度小)，即当前高度高于左侧最高高度，更新最高高度较小的那一侧的最高高度为当前高度，即更新左侧最高高度为当前高度

   

