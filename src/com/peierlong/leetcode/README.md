# LeetCode算法题解

## 8. String to Integer (atoi)

[官方链接点此查看](https://leetcode.com/problems/string-to-integer-atoi/)

### 简要说明：

简单理解，就是把一个字符串转换成一个整数。

- 区分正负数，从左到右，如果直接遇到非整数字符，直接返回 0。
- 如果遇到 Integer 越界，输出最大值和最小值。
- 遇到空格，忽略。

### 代码：

```java
class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }
        StringBuilder result = new StringBuilder();
        boolean isNegative = false;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (i == 0 && !(isDigit(aChar) || aChar == '-' || aChar == '+')) {
                break;
            }
            if (i == 0 && aChar == '-') {
                isNegative = true;
                continue;
            }
            if (i == 0 && aChar == '+') {
                continue;
            }
            if (isDigit(aChar)) {
                result.append(aChar);
            } else {
                break;
            }
        }
        if (result.length() > 0) {
            try {
                return isNegative ? -Integer.parseInt(result.toString()) : Integer.parseInt(result.toString());
            } catch (NumberFormatException e) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return 0;
    }


    private boolean isDigit(char c) {
        return (byte) c >= 48 && (byte) c <= 57;
    }
    
    
}
```

### LeetCode 提交评分

![](https://raw.githubusercontent.com/peiel/oss/master/uPic/q8ISPL.png)