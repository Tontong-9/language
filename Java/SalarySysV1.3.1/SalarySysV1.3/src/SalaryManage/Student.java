package SalaryManage;

import java.io.Serializable;
import java.time.LocalDate;

public class Student extends Person  {

	private  double score;   //总分
	private  int   working_hours; //工作小时
	private  double  pay_perhour; //工作时薪
	
	Student(String name , double h , double w , LocalDate bir,
			double s , int work , double p){
		super(name , h , w , bir);
		score = s;
		working_hours = work;
		pay_perhour = p;
	}
	Student(String name , double h , double w , LocalDate bir,double s){
		super(name,h,w,bir);//调用父类，必须放在首句
		working_hours = 0;
		pay_perhour = 0.0;
		score = s;
		
	}
	Student(){}
	
	@Override 
	//假设学生的薪水是按照小时计
	public double getSalary() {
		
		return pay_perhour*working_hours;
	}
	
	public String toString() {
	      String s = "\n学生名字："+super.getName()+
	    		     "总分"+score;
	      return s;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public int getWorking_hours() {
		return working_hours;
	}
	public void setWorking_hours(int working_hours) {
		this.working_hours = working_hours;
	}
	public double getPay_perhour() {
		return pay_perhour;
	}
	public void setPay_perhour(double pay_perhour) {
		this.pay_perhour = pay_perhour;
	}

}
