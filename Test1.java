1.爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是
他们拥有的糖果棒大小的总和。）返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
如果有多个答案，你可以返回其中任何一个。保证答案存在。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/fair-candy-swap
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
示例 
输入：A = [1,2,5], B = [2,4]
输出：[5,4]
class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA=0;
        int sumB=0;
        int[] arr={0,0};
        for(int i=0;i<A.length;i++){
            sumA+=A[i];
        }
        for(int i=0;i<B.length;i++){
            sumB+=B[i];
        }
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                if(sumA-A[i]+B[j]==sumB-B[j]+A[i]){
                    arr[0]=A[i];
                    arr[1]=B[j];
                    return arr;
                }
            }
        }
        return arr;
    }
}

2.
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:

s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int firstUniqChar(String s) {
        for(int i=0;i<s.length();i++){
            char c1=s.charAt(i);
            int count=0;
            int j=0;
            for( j=0;j<s.length();j++){
                char c2=s.charAt(j);
                if(c1==c2){
                    count++;
                }
                if(count==2){
                    break;
                }
            }
            if(j==s.length()){
                    return i;
                }
        }
        return -1;
    }
}

3.
给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。

数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
       char min=letters[0];
        int i=0;
        for( i=0;i<letters.length;i++){
            if(target<letters[i]){
                min=letters[i];
                break;
            }
        }
        if(i==letters.length){
            return letters[0];
        }else{
            return min;
        }
    }
}

4.环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。

环线上的公交车都可以按顺时针和逆时针的方向行驶。

返回乘客从出发点 start 到目的地 destination 之间的最短距离。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/distance-between-bus-stops
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum=0;
        int sum1=0;
        for(int i=0;i<distance.length;i++){
            sum+=distance[i];
        }
        if(start>destination){
            int tmp=start;
            start=destination;
            destination=tmp;
        }
        for(int i=start;i<destination;i++){
            sum1+=distance[i];
        }
        return Math.min(sum-sum1,sum1);
    }
}