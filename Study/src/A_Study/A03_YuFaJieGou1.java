package A_Study;

import java.util.Random;
import java.util.Scanner;

public class A03_YuFaJieGou1 {

	public static void main(String[] args) {
		//1.利用if语句，判断给定月份对应的季节
        Scanner input = new Scanner(System.in);
		/*
		 * System.out.println("请输入要查的月份：");
		 * 
		 * int month = input.nextInt();
		 * 
		 * if (month == 3 || month == 4 || month == 5){ System.out.println("春天."); }else
		 * if (month == 6 || month == 7 || month == 8){ System.out.println("夏天."); }else
		 * if (month == 9 || month == 10 || month == 11){ System.out.println("秋天.");
		 * }else if (month == 12 || month == 1 || month == 2){
		 * System.out.println("冬天."); }else { System.out.println("输入的月份错误！！！请重新输入。"); }
		 */
        
      //2.用if实现摇色子的游戏，随机一个点数，玩家用Scanner输入，猜大小，if比较后输出猜对了或猜错了
        System.out.println("请输入‘大’或‘小’。");
        String mon = input.nextLine();
        int Min = 1;
        int Max = 6;
        int result = Min + (int)(Math.random() * ((Max - Min) + 1));
        
        if (mon.equals("大")){
            if (result < 4){
                System.out.println("猜错了");
            }else if(result >= 4){
                System.out.println("猜对了");
            }
        }else if (mon.equals("小")){
            if (result < 4){
                System.out.println("猜对了");
            }else if(result >= 4){
                System.out.println("猜错了");
            }
        }
	}

}
