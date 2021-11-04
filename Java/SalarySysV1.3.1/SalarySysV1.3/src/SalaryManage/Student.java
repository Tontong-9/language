package SalaryManage;

import java.io.Serializable;
import java.time.LocalDate;

public class Student extends Person  {

	private  double score;   //�ܷ�
	private  int   working_hours; //����Сʱ
	private  double  pay_perhour; //����ʱн
	
	Student(String name , double h , double w , LocalDate bir,
			double s , int work , double p){
		super(name , h , w , bir);
		score = s;
		working_hours = work;
		pay_perhour = p;
	}
	Student(String name , double h , double w , LocalDate bir,double s){
		super(name,h,w,bir);//���ø��࣬��������׾�
		working_hours = 0;
		pay_perhour = 0.0;
		score = s;
		
	}
	Student(){}
	
	@Override 
	//����ѧ����нˮ�ǰ���Сʱ��
	public double getSalary() {
		
		return pay_perhour*working_hours;
	}
	
	public String toString() {
	      String s = "\nѧ�����֣�"+super.getName()+
	    		     "�ܷ�"+score;
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
