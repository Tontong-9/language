package SalaryManage;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class  Person implements Comparable<Person>, Serializable{
	
  private  String name;   //����
  private  double    height;  //���
  private  double weight;  //����
  private  LocalDate	birthday; //��������
  
  public Person(String name, double height, double weight, LocalDate birthday) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.birthday = birthday;
	}
  public Person() {
	  name = null; height = 0; weight = 0.0;birthday = null;
  }
 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	public String toString() {
	      String s = "���֣�"+getName()+ 
	    		      "��������" + getBirthday() +
	    		    "\n������ر�"+ height/weight;
	      return s;
	}
	
	@Override//�˱Ƚϵ�ʱ���ճ����������Ƚ�
	public int compareTo(Person other) {
	   return birthday.compareTo(other.getBirthday());
	}
	
	//��Ҫ�ѹ�ͬ�Ĳ���ȫ�������ڻ�������
	public abstract double  getSalary();
}
