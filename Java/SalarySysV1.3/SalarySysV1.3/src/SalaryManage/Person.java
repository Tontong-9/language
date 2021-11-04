package SalaryManage;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class  Person implements Comparable<Person>, Serializable{
	
  private  String name;   //名字
  private  double    height;  //身高
  private  double weight;  //体重
  private  LocalDate	birthday; //出生年月
  
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
	      String s = "名字："+getName()+ 
	    		      "出生年月" + getBirthday() +
	    		    "\n身高体重比"+ height/weight;
	      return s;
	}
	
	@Override//人比较的时候按照出生年月来比较
	public int compareTo(Person other) {
	   return birthday.compareTo(other.getBirthday());
	}
	
	//需要把共同的操作全部集中在基类中来
	public abstract double  getSalary();
}
