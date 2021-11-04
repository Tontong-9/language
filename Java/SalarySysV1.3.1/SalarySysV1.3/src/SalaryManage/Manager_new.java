
package SalaryManage;
import java.io.Serializable;
import java.time.LocalDate;

public class Manager_new extends Employee_new{
	
	private double  bonus;
	
	public Manager_new() {
		
	}
	public Manager_new(String name , double height , double weight , LocalDate birth,
			 int y, int m, int d, double salary, String position, String tel,double bonus) {
		
		super(name,height,weight,birth,y,m,d,salary,position,tel);
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
		String s = super.toString();
		s += "\n经理薪水：" + getSalary() +
				"\n职位：" + getPosition() ;
		return s;
	}
	
	

}
