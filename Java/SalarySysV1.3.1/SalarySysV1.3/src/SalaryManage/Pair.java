package SalaryManage;

import java.time.LocalDate;
import java.util.Comparator;

public class Pair<T> {
	private static final Object[] aa = null;
	private T min;  //类变量一般都设定为private
	private T max;
	
	public void setMin(T min) {this.min = max;}
	public void setMax(T max) {this.max = max;}
	
	//构造函数，new对象的时候首先会自动调用该函数，
	//一般用来完成类变量的赋初值的工作
	public Pair(T min , T max){  
		this.min = min; this.max = max;
	}
	//缺省构造函数，一般自己写的类都要写上缺省构造函数
	public Pair() { 
		min = null;max=null;  //泛型的数据类型只能是引用（某个类的对象）
    }
	
	public void showPairMsg() {
	   System.out.println("**\n--最小值："+min);
	   System.out.println("--最大值："+max+"\n**");
	}

	//实现若干个字符串的最大最小字符串
	public static Pair<String> minmax(String[] a){
		if(a.length == 0) return null;
		String min , max;
		min = a[0]; max = a[0];
		
		//字符串的比较大小默认的是按照字符的Unicode码比较
		//因为String类中实现了接口Comparable中的compareTo方法
		//实现的算法就是按照Unicode码比较
		for(String s : a) {
			if(s.compareTo(min) < 0)  min = s;
			if(s.compareTo(max) > 0)  max = s;
		}
		return  new Pair<String>(min , max);
	}
	
	//泛型函数，实现不同的数据数组的最大最小值
	//将上个函数代码复制下来，将String全部换成T
	//要求使用时某个具体的T类型也必须实现Comparable接口
	public static <T extends Comparable> Pair<T> minmaxT(T[] a){
		
		if(a.length == 0) return null;
		T min , max;
		min = a[0]; max = a[0];
		for(T s : a) {
			if(s.compareTo(min) < 0)  min = s;
			if(s.compareTo(max) > 0)  max = s;
		}
		return  new Pair<T>(min , max);
	}
	
	//泛型函数，实现不同的数据数组的最大最小值，实现不同的比较策略
	//一般来说用Comparable接口只能实现一种比较方法，如果要多种的话，
	//就要用到Comparator接口来实现
	public static <T> Pair<T> minmaxT(T[] a, Comparator<? super T> comp){
		if(a.length == 0) return null;
		T  min , max;
		min = a[0]; max=a[0];
		for(T s : a) {
			if(comp.compare(s, min) < 0) min = s;
			if(comp.compare(s, max) > 0) max = s;
		}
		return  new Pair<T>(min , max);
	}

	
	public static void main(String[] args) {
	
		//测试案例1 输入8个字符串，求最大和最小字符串
		String[]  strs = {"test1","max","我们","你们","他们"};
		Pair<String> ret1 = minmax(strs);
		//或者可以Pair<String> ret1 = minmaxT(strs);
		ret1.showPairMsg();
		
		//测试案例2 输入8个整数，求最大和最小整数
		
		
		//测试案例3 输入5个职工数据，求薪水最高的和薪水最低的职工
		Employee[] persons = new Employee[] {
				new Employee("张三",2020,12,10,10000.0,"学生","111"),
				new Employee("李四",2020,12,1,5000.0,"老师","222"),
				new Employee("王五",2020,1,10,3000.0,"领导","333"),
				new Manager("张六",2019,6,28,60000.0,"校长","444",8000),
				new Employee("张王五d",2019,6,28,18000.0,"校长","444") };
	
		Pair<Employee> ret3 = minmaxT(persons);
		ret3.showPairMsg();
		
		//用比较器来求入职时间最长和最短的员工
		//Pair<Employee> ret6 = minmaxT(persons , new HireDateComparator());
		//ret6.showPairMsg();
		
		//测试案例4 输入5个职工数据，求年龄最大的和年龄最小的职工
		//为了演示抽象，独立出来抽象类Person，共有属性：名字、身高、体重
	Employee_new[] men = new Employee_new[] {
				new Employee_new("张三",1.85,56.0 , LocalDate.of(1971, 10, 10),
						2020,12,10,10000.0,"学生","111"),
				
				new Employee_new("李四",1.83 , 67.5 ,  LocalDate.of(1981, 10, 10),
						2020,12,1,5000.0,"老师","222"),
				new Employee_new("王五",1.67 , 57.5 ,  LocalDate.of(1990, 10, 10),
						2020,1,10,3000.0,"领导","333")};
		
		Pair<Employee_new> ret4 = minmaxT(men);
		ret4.showPairMsg();
		
	
		//测试案例5 输入10个学生（含3门课）成绩信息，求总分最高和总分最低的学生
		Student[] stu = new Student[] {
				new Student("张三",1.85,56.0 , LocalDate.of(1971, 10, 10),456),
				new Student("李四",1.83 , 67.5 ,  LocalDate.of(1981, 10, 10),980),
				new Student("李鑫",1.83 , 67.5 ,  LocalDate.of(1981, 10, 10),678),
				new Student("王四",1.83 , 67.5 ,  LocalDate.of(1981, 10, 10),998),
				new Student("王强",1.83 , 67.5 ,  LocalDate.of(1981, 10, 10),789)};

	    Pair<Student> ret5 = minmaxT(stu  , new StuScoreCompare());
	    ret5.showPairMsg();
		
		//测试案例6 职工和学生都有共同的属性是身高和体重，现在
		//分别输如3个职工、2个经理、3个学生，求所有人中身高/体重比最大和最小的
		Person[]  people = new Person[] {
				
				//三个职工
				new Employee_new("张三",1.85,56.0 , LocalDate.of(1971, 10, 10),
						2020,12,10,10000.0,"学生","111"),
				new Employee_new("李四",1.83 , 67.5 ,  LocalDate.of(1981, 10, 10),
						2020,12,1,5000.0,"老师","222"),
				new Employee_new("王五",1.67 , 57.5 ,  LocalDate.of(1990, 10, 10),
						2020,1,10,3000.0,"领导","333"),
				//两个经理
				new Manager_new("经理1",1.73 , 78.5 ,  LocalDate.of(1971, 10, 10),
						2020,12,1,5000.0,"老师","222",90000),
				new Employee_new("经理2",1.69 , 57.5 ,  LocalDate.of(1990, 10, 10),
						2020,1,10,3000.0,"领导","333"),
				//三个学生
				new Student("学生1",1.85,56.0 , LocalDate.of(1971, 10, 10),456),
				new Student("学生2",1.83 , 67.5 ,  LocalDate.of(1981, 10, 10),980),
				new Student("学生3",1.83 , 67.5 ,  LocalDate.of(1981, 10, 10),678)};
		
		        //用匿名子类的方式来用比较器比较
		        Pair<Person> ret7 = minmaxT(people , new Comparator<Person>(){
		        	public int compare(Person arg0, Person arg1) {
		        		double b1 = arg0.getHeight()/arg0.getWeight();
		        		double b2 = arg1.getHeight()/arg1.getWeight();
		        		return Double.compare(b1, b2);
		        	}      	
		        });
		        ret7.showPairMsg();
	}
	
}
