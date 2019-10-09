1.给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。

J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jewels-and-stones
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int numJewelsInStones(String J, String S) {
        if(S.equals("")){
            return 0;
        }
        int count=0;
        for(int i=0;i<S.length();i++){
            for(int j=0;j<J.length();j++){
                if(S.charAt(i)==J.charAt(j)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}

2.
给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。

如果不存在最后一个单词，请返回 0 。

说明：一个单词是指由字母组成，但不包含任何空格的字符串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/length-of-last-word
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int lengthOfLastWord(String s) {
         int count=0;
         int flag=1;
         int wordnum=0;
         int i=0;
        while(i<s.length()){
             char c=s.charAt(i);
             if(c==' '){
                 flag=1;
             }if(flag==1&&c!=' '){
                 wordnum++;
                 flag=0;
             }
            i++;
        }
        if(wordnum==1){
           for(i=0;i<s.length();i++){
             char c=s.charAt(i);
             if(c==' '){
                count++;
             }
            }
         return s.length()-count;
         } else{
          count=0;
          for(i=s.length()-1;i>=0;i--){
              char c=s.charAt(i);
              if(c!=' '){
                 for( ;i>=0;i--) {
                  c=s.charAt(i);
                  if(c==' '){
                     break;
                  }
                   count++;
                 }    
                  return count;
              }
           
          }
              
    }  
        return 0;
  }
}

3.
在柠檬水摊上，每一杯柠檬水的售价为 5 美元。

顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。

每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。

注意，一开始你手头没有任何零钱。

如果你能给每位顾客正确找零，返回 true ，否则返回 false 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lemonade-change
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0;
        int ten=0;
        for(int i=0;i<bills.length;i++){
            int bill=bills[i];
            switch(bill){
                case 5:
                    five++;
                    break;
                case 10:
                    if(five>=1){
                        ten++;
                        five--;
                    }else{
                        return false;
                    }
                    break;
                case 20:
                    if(five>=1&&ten>=1){
                        five--;
                        ten--;
                    }else if(five>=3){
                        five-=3;
                    }else{
                        return false;
                    }
                    break;
            }
        }
          return true;
    }
}

4.有一堆石头，每块石头的重量都是正整数。

每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：

如果 x == y，那么两块石头都会被完全粉碎；
如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/last-stone-weight
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        if(stones.length==1){
            return stones[0];
        }else if(stones.length==2){
            return stones[1]-stones[0];
        }else{
           while(stones[stones.length-2]!=0){
            stones[stones.length-1]=stones[stones.length-1]-stones[stones.length-2];
               stones[stones.length-2]=0;
             Arrays.sort(stones);
        }
              return stones[stones.length-1];
        }
    }
}