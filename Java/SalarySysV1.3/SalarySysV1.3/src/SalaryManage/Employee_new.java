package SalaryManage;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;


public class Employee_new extends Person implements Comparable<Person> , Serializable{
		
	private static int nextId;  //����ͳһ�Զ�����ÿһ������Ա���Ĺ���
	private int id;//Ա���Ĺ���
	private String name="";//Ա������
	private LocalDate hireDay;//Ա����ְʱ��
	private double salary;//Ա����������
	private String position="";//Ա���������š�ְλ����
	private String tel;//�绰����	

	public Employee_new() {
	}
	
	public Employee_new(String name , double height , double weight , LocalDate birth,
			 int y, int m, int d, double salary, String position, String tel) {
		
		super(name,height,weight,birth);
		this.id = nextId++;
		this.name = name;
		this.hireDay = LocalDate.of(y,m,d);
		this.salary = salary;
		this.position = position;
		this.tel = tel;
	}

	public Employee_new(String name , double height , double weight , LocalDate birth,
			int id,int y, int m, int d, double salary, String position, String tel) {
		
		super(name,height,weight,birth);
		this.id = id;
		this.name = name;
		this.hireDay = LocalDate.of(y,m,d);
		this.salary = salary;
		this.position = position;
		this.tel = tel;
	}
	
	public void setMsg(String name,int y,int m,int d,double salary,String position,String tel) {
		this.name = name;
		super.setName(name);
		this.hireDay = LocalDate.of(y,m,d);
		this.salary = salary;
		this.position = position;
		this.tel = tel;
	}

	public double  raiseSalary(double percent) {
		int workYear = getHireTime();
		double s = salary;
		for(int i = 1;i <= workYear;i++){  // ѭ��������������Ĺ���
			s = s + s * percent;
		}
		return s;
	}
	
	public int getHireTime() {
		LocalDate date = LocalDate.now();  // ��ȡ��ǰʱ��
		return date.getYear() - hireDay.getYear(); // ���㵱ǰʱ������ְʱ������ֵ
	}
	
	/**
	 * ��ʾ�Լ�����Ϣ
	 */
	public void  showEmployeeMsg() {
		System.out.println(this.toString());;
	}
	
	//������ÿ�����Ե�get��set������������eclipse���Զ�����
	public static int getNextId() {
		return nextId;
	}
	public static void setNextId(int nextId) {
		Employee_new.nextId = nextId;
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
		String s = super.toString();
		s += "\nְ��нˮ��" + getSalary() +
				"��\nְλ��" + position ;
		return s;
			
	}

	@Override//�Ƚϵ�ʱ����ÿ��нˮ�ĸߵ����Ƚ�
	/*public int compareTo(Person other) {
		
		double thisSal = getSalary();
		double otherSal = other.getSalary();
		return Double.compare(thisSal, otherSal);
	
	}
	
	@Override*/
	/**
	 * ��������Ա�Ĺ��ź�������ͬʱ������Ϊ��������������ȵ�
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
