package SalaryManage;
import java.io.Serializable;

public class Manager extends Employee implements Serializable{
	
	private double  bonus;
	
	Manager(String name, int y, int m, int d, double salary, String position, String tel,double bonus){
		  super(name,y,m,d,salary,position,tel);
		  this.bonus = bonus;
	
	}
	
	public double getSalary() {
		
		//Ϊ���ʺϼ̳е���ʽ�滻ԭ�������ǰ�����ǻ���Ķ�������û���ĺ����������Ǽ̳����ʵ�ַ���
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
