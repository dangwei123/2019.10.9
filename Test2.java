1.我们正在玩一个猜数字游戏。 游戏规则如下：
我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
每次你猜错了，我会告诉你这个数字是大了还是小了。
你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：

-1 : 我的数字比较小
 1 : 我的数字比较大
 0 : 恭喜！你猜对了！

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int mid=0;
        int left=0;
        int right=n;
        while(left<=right){
            mid=left+(right-left)/2;
            if(guess(mid)==0){
                return mid;
            }if(guess(mid)<0){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }
}
2.
实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-strstr
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int strStr(String haystack, String needle) {
        int a=haystack.length();
        int b=needle.length();
        int flag=0;
         if(needle.equals("")){
            return 0;
        }
        for(int i=0;i<a;i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                flag=i;
                if(i+b>a){
                    return -1;
                }
                int tmp=0;
                for( tmp=i+1;tmp<flag+b;tmp++){
                    if(haystack.charAt(tmp)!=needle.charAt(tmp-flag)){
                        break;
                    }
                }
                if(tmp==flag+b){
                        return flag;
                    }
            }
        }
        return -1;
    }
}

3.
编写一个算法来判断一个数是不是“快乐数”。

一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/happy-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public boolean isHappy(int n) {
      int slow=n;
        int fast=n;
        do{
            slow=fun(slow);
            fast=fun(fast);
            fast=fun(fast);
            
        }while(fast!=slow);
        if(slow==1){
            return true;
        }else{
            return false;
        }
    }
    public int fun(int n){
        int sum=0;
        while(n!=0){
            sum+=Math.pow((n%10),2);
            n/=10;
        }
        return sum;
    }
}

4.
给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相
等的结果，就返回 true ；否则返回 false 。
class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A.equals("")||B.equals("")){
            return false;
        }
        int flag=0;
        int count=0;
        int[] arr={0,0};
        int j=0;
        for(int i=0;i<A.length();i++){
           for(j=i+1;j<A.length();j++){
               if(A.charAt(i)==A.charAt(j)){
                   flag=1;
                   break;
               }
               if(flag==1){
                   break;
               }
           }
        }
        j=0;
        for(int i=0;i<A.length();i++){
            char c1=A.charAt(i);
            char c2=B.charAt(i);
            if(c1!=c2){
                count++;
                    arr[j]=i;
                    j=1;
            }
        }
        if(count==0&&flag==1){
            return true;
        }
        if(count==2){
            int a=arr[0];
            int b=arr[1];
            if(A.charAt(a)==B.charAt(b)&&A.charAt(b)==B.charAt(a)){
                return true;
            }
        }
        return false;
    }
}
 