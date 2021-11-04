package SalaryManage;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

/**
 * <p><strong>Employee</strong>雇员类，用来处理单个员工的信息</p>
 * @version 1.0
 * @author 190207131吴宇鑫
 */
public class Employee implements Comparable<Employee> , Serializable{
		
	private static int nextId;  //用来统一自动计算每一个新增员工的工号
	private int id;//员工的工号
	private String name="";//员工名字
	private LocalDate hireDay;//员工入职时间
	private double salary;//员工基本工资
	private String position="";//员工所属部门、职位描述
	private String tel;//电话号码	

	public Employee() {
	}
	
	/** 添加使用的构造函数，其id自增
	 * @param name  名字
	 * @param y  入职年
	 * @param m  入职月
	 * @param d  入职日
	 * @param salary 每月基本工资
	 * @param position 所属部门职位描述
	 * @param tel  手机号
	 */
	public Employee(String name, int y, int m, int d, double salary, String position, String tel) {
		this.id = nextId++;
		this.name = name;
		this.hireDay = LocalDate.of(y,m,d);
		this.salary = salary;
		this.position = position;
		this.tel = tel;
	}

	/** 修改使用的构造函数，其id不变
	 * @param id 员工号
	 * @param name  名字
	 * @param y  入职年
	 * @param m  入职月
	 * @param d  入职日
	 * @param salary 每月基本工资
	 * @param position 所属部门职位描述
	 * @param tel  手机号
	 */
	public Employee(int id,String name, int y, int m, int d, double salary, String position, String tel) {
		this.id = id;
		this.name = name;
		this.hireDay = LocalDate.of(y,m,d);
		this.salary = salary;
		this.position = position;
		this.tel = tel;
	}
	
	public void setMsg(String name,int y,int m,int d,double salary,String position,String tel) {
		this.name = name;
		this.hireDay = LocalDate.of(y,m,d);
		this.salary = salary;
		this.position = position;
		this.tel = tel;
	}
	
	/**
	 * 该函数为增加员工的年底工资
	 * @param percent  年底工资增长比例
	 * @return  返回增加后的工资
	 */
	public double  raiseSalary(double percent) {
		int workYear = getHireTime();
		double s = salary;
		for(int i = 1;i <= workYear;i++){  // 循环迭代算增长后的工资
			s = s + s * percent;
		}
		return s;
	}
	
	/**
	 * 该函数根据当前时间计算员工的入职年限
	 * @return 返回入职年限，按整数计算
	 */
	public int getHireTime() {
		LocalDate date = LocalDate.now();  // 获取当前时间
		return date.getYear() - hireDay.getYear(); // 计算当前时间与入职时间的年差值
	}
	
	/**
	 * 显示自己的信息
	 */
	public void  showEmployeeMsg() {
		System.out.println(this.toString());;
	}
	
	//以下是每种属性的get和set函数，可以在eclipse中自动生成
	public static int getNextId() {
		return nextId;
	}
	public static void setNextId(int nextId) {
		Employee.nextId = nextId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getHireDay() {
		return hireDay;
	}
	public void setHireDay(LocalDate hireDay) {
		this.hireDay = hireDay;
	}
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", name='" + name + '\'' +
				", hireDay=" + hireDay +
				", salary=" + getSalary() +
				", position='" + position + '\'' +
				", tel='" + tel + '\'' +
				'}';
	}

	@Override//比较的时候按照每月薪水的高低来比较
	public int compareTo(Employee other) {
		
		double thisSal = getSalary();
		double otherSal = other.getSalary();
		return Double.compare(thisSal, otherSal);
	
	}
	
	@Override
	/**
	 * 当两个雇员的工号和名字相同时，则认为这两个对象是相等的
	 */
	public boolean equals(Object otherObject) {
		if(this == otherObject) return true;
		if(otherObject == null) return false;
		if(getClass() != otherObject.getClass()) return false;
		Employee o = (Employee)otherObject;
		if(this.getId() == o.getId()
			&& getName().equals(o.getName()))
			return true;
		else
			return false;
	}
	

}
