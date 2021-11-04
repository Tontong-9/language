
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
		
		//Ϊ���ʺϼ̳е���ʽ�滻ԭ�������ǰ�����ǻ���Ķ�������û���ĺ����������Ǽ̳����ʵ�ַ���
		if(getClass().getName().equals("SalaryManage.Manager"))
			return super.getSalary()+bonus;
		else
			return super.getSalary();
		
	}
	
	@Override
	public String toString() {
		String s = super.toString();
		s += "\n����нˮ��" + getSalary() +
				"\nְλ��" + getPosition() ;
		return s;
	}
	
	

}
