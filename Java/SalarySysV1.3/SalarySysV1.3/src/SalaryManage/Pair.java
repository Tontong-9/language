package SalaryManage;

import java.util.Comparator;

public class Pair<T> {
	private T min;
	private T max;
	
	public void setFirst(T min) {
		
	}
	public void setSecond(T max) {
	
	}
	public Pair(T min , T max){
	
	}
	public Pair() { 
		
    }
	
	public void showPairMsg() {
	
	}

	//实现若干个字符串的最大最小字符串
	public static Pair<String> minmax(String[] a){
		return null;
	}
	
	//泛型函数，实现不同的数据数组的最大最小值
	public static <T extends Comparable> Pair<T> minmaxT(T[] a){
		return null;
	}
	
	//泛型函数，实现不同的数据数组的最大最小值，实现不同的比较策略
	public static <T extends Comparable> Pair<T> minmaxT(T[] a, Comparator<? super T> comp){
		return null;
	}

	
	public static void main(String[] args) {
		
		//测试泛型方法的使用
		
		//测试案例1 输入8个字符串，求最大和最小字符串
		
		//测试案例2 输入8个整数，求最大和最小整数
		
		//测试案例3 输入5个职工数据，求薪水最高的和薪水最低的职工
		
		//测试案例4 输入5个职工数据，求年龄最大的和年龄最小的职工
		
		//测试案例5 输入10个学生（含3门课）成绩信息，求总分最高和总分最低的学生
		
		//测试案例6 职工和学生都有共同的属性是身高和体重，现在
		//分别输如3个职工、2个经理、3个学生，求所有人中身高/体重比最大和最小的
	
		
	}


	
}
