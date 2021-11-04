package SalaryManage;
import java.io.Serializable;

public class Manager extends Employee implements Serializable{
	
	private double  bonus;
	
	Manager(String name, int y, int m, int d, double salary, String position, String tel,double bonus){
		  super(name,y,m,d,salary,position,tel);
		  this.bonus = bonus;
	
	}
	
	public double getSalary() {
		
		//为了适合继承的里式替换原则，如果当前对象是基类的对象，则调用基类的函数，否则是继承类的实现方法
		if(getClass().getName().equals("SalaryManage.Manager"))
			return super.getSalary()+bonus;
		else
			return super.getSalary();
		
	}
	
	@Override
	public String toString() {
		return "Manage{" +
				"id=" + getId() +
				", name='" + getName() + '\'' +
				", hireDay=" + getHireDay() +
				", salary=" + getSalary() +
				", position='" + getPosition() + '\'' +
				", tel='" + getTel() + '\'' +
				'}';
	}
	
	

}
