import java.util.Scanner;
import java.util.Random;
class Test{
	//14. 完成猜数字游戏
public static void main14(String[] args){
	Scanner sc=new Scanner(System.in);
	Random random=new Random();
	int key=random.nextInt(100);
	System.out.println("请输入一个1-100之间的数字：");
	while(true){
		int num=sc.nextInt();
		if(num==key){
			System.out.println("猜对了");
			break;
	}if(num>key){
		System.out.println("猜大了");
	}else{
		System.out.println("猜小了");
	}
 }
sc.close();
}
	//13. 输出一个整数的每一位.
static void print(int num){
	if(num>9){
		print(num/10);
	}
	System.out.println(num%10);
}
public static void main13(String[] args){
	print(1234);
}
	//12. 获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列
public static void main12(String[] args){
	int num=7;
	System.out.println("偶数位：");
	for(int i=31;i>=0;i-=2){
		System.out.printf("%d ",(num>>i)&1);
	}
	System.out.println();
	System.out.println("奇数位：");
	for(int i=30;i>=0;i-=2){
		System.out.printf("%d ",(num>>i)&1);
	}
	System.out.println();
}
	//11. 写一个函数返回参数二进制中 1 的个数 比如： 15 0000 1111 4 个 1
public static void main11(String[] args){
	int count=0;
	Scanner sc=new Scanner(System.in);
	System.out.println("请输入一个数：");
	int num=sc.nextInt();
	while(num!=0){
		count++;
		num&=(num-1);
	}
	System.out.println(count);
	sc.close();
}
	//10. 编写代码模拟三次密码输入的场景。 最多能输入三次密码，密码正确，
	//提示“登录成功”,密码错误， 可以重新输入，最多输入三次。三次均错，则提示退出程序
public static void main10(String[] args){
	int i=0;
	Scanner sc=new Scanner(System.in);
	while(i<3){
		System.out.println("请输入密码：");
		String s=sc.nextLine(); 
		if(s.equals("123")){
			System.out.println("密码正确,登陆成功");
			break;
		}else{
			System.out.printf("密码错误，您还有%d次机会%n",2-i);
			if(i==2){
				System.out.println("程序退出");
			}
		}
		i++;
	}
	sc.close();
}
}