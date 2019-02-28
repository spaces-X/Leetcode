# 17. Letter Combinations of a Phone Number

Given a string containing digits from `2-9` inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

![img](http://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png)

**Example:**

```
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
```

**Note:**

Although the above answer is in lexicographical order, your answer could be in any order you want.



## 思路：

1. 递归：

   在getchar( char ) 返回键盘上数字对应字母的``List<String>``

   public static List<String> letterCombinations(String digits) 函数返回digits对应的所有结果的集合

   1. 当 digits 长度为 0 时 返回空 list
   2. 当 digits 长度为 1 时 返回get(digits.charAt(0))
   3. 当 digits 长度大于1时 返回 get(digits.charAt(0)) 和 letterCombinations(digits[1:]) 对应list的组合

   

   