package SalaryManage;

import java.time.LocalDate;
import java.util.Comparator;

public class Pair<T> {
	private static final Object[] aa = null;
	private T min;  //�����һ�㶼�趨Ϊprivate
	private T max;
	
	public void setMin(T min) {this.min = max;}
	public void setMax(T max) {this.max = max;}
	
	//���캯����new�����ʱ�����Ȼ��Զ����øú�����
	//һ���������������ĸ���ֵ�Ĺ���
	public Pair(T min , T max){  
		this.min = min; this.max = max;
	}
	//ȱʡ���캯����һ���Լ�д���඼Ҫд��ȱʡ���캯��
	public Pair() { 
		min = null;max=null;  //���͵���������ֻ�������ã�ĳ����Ķ���
    }
	
	public void showPairMsg() {
	   System.out.println("**\n--��Сֵ��"+min);
	   System.out.println("--���ֵ��"+max+"\n**");
	}

	//ʵ�����ɸ��ַ����������С�ַ���
	public static Pair<String> minmax(String[] a){
		if(a.length == 0) return null;
		String min , max;
		min = a[0]; max = a[0];
		
		//�ַ����ıȽϴ�СĬ�ϵ��ǰ����ַ���Unicode��Ƚ�
		//��ΪString����ʵ���˽ӿ�Comparable�е�compareTo����
		//ʵ�ֵ��㷨���ǰ���Unicode��Ƚ�
		for(String s : a) {
			if(s.compareTo(min) < 0)  min = s;
			if(s.compareTo(max) > 0)  max = s;
		}
		return  new Pair<String>(min , max);
	}
	
	//���ͺ�����ʵ�ֲ�ͬ����������������Сֵ
	//���ϸ��������븴����������Stringȫ������T
	//Ҫ��ʹ��ʱĳ�������T����Ҳ����ʵ��Comparable�ӿ�
	public static <T extends Comparable> Pair<T> minmaxT(T[] a){
		
		if(a.length == 0) return null;
		T min , max;
		min = a[0]; max = a[0];
		for(T s : a) {
			if(s.compareTo(min) < 0)  min = s;
			if(s.compareTo(max) > 0)  max = s;
		}
		return  new Pair<T>(min , max);
	}
	
	//���ͺ�����ʵ�ֲ�ͬ����������������Сֵ��ʵ�ֲ�ͬ�ıȽϲ���
	//һ����˵��Comparable�ӿ�ֻ��ʵ��һ�ֱȽϷ��������Ҫ���ֵĻ���
	//��Ҫ�õ�Comparator�ӿ���ʵ��
	public static <T> Pair<T> minmaxT(T[] a, Comparator<? super T> comp){
		if(a.length == 0) return null;
		T  min , max;
		min = a[0]; max=a[0];
		for(T s : a) {
			if(comp.compare(s, min) < 0) min = s;
			if(comp.compare(s, max) > 0) max = s;
		}
		return  new Pair<T>(min , max);
	}

	
	public static void main(String[] args) {
	
		//���԰���1 ����8���ַ�������������С�ַ���
		String[]  strs = {"test1","max","����","����","����"};
		Pair<String> ret1 = minmax(strs);
		//���߿���Pair<String> ret1 = minmaxT(strs);
		ret1.showPairMsg();
		
		//���԰���2 ����8����������������С����
		
		
		//���԰���3 ����5��ְ�����ݣ���нˮ��ߵĺ�нˮ��͵�ְ��
		Employee[] persons = new Employee[] {
				new Employee("����",2020,12,10,10000.0,"ѧ��","111"),
				new Employee("����",2020,12,1,5000.0,"��ʦ","222"),
				new Employee("����",2020,1,10,3000.0,"�쵼","333"),
				new Manager("����",2019,6,28,60000.0,"У��","444",8000),
				new Employee("������d",2019,6,28,18000.0,"У��","444") };
	
		Pair<Employee> ret3 = minmaxT(persons);
		ret3.showPairMsg();
		
		//�ñȽ���������ְʱ�������̵�Ա��
		//Pair<Employee> ret6 = minmaxT(persons , new HireDateComparator());
		//ret6.showPairMsg();
		
		//���԰���4 ����5��ְ�����ݣ����������ĺ�������С��ְ��
		//Ϊ����ʾ���󣬶�������������Person���������ԣ����֡���ߡ�����
	Employee_new[] men = new Employee_new[] {
				new Employee_new("����",1.85,56.0 , LocalDate.of(1971, 10, 10),
						2020,12,10,10000.0,"ѧ��","111"),
				
				new Employee_new("����",1.83 , 67.5 ,  LocalDate.of(1981, 10, 10),
						2020,12,1,5000.0,"��ʦ","222"),
				new Employee_new("����",1.67 , 57.5 ,  LocalDate.of(1990, 10, 10),
						2020,1,10,3000.0,"�쵼","333")};
		
		Pair<Employee_new> ret4 = minmaxT(men);
		ret4.showPairMsg();
		
	
		//���԰���5 ����10��ѧ������3�ſΣ��ɼ���Ϣ�����ܷ���ߺ��ܷ���͵�ѧ��
		Student[] stu = new Student[] {
				new Student("����",1.85,56.0 , LocalDate.of(1971, 10, 10),456),
				new Student("����",1.83 , 67.5 ,  LocalDate.of(1981, 10, 10),980),
				new Student("����",1.83 , 67.5 ,  LocalDate.of(1981, 10, 10),678),
				new Student("����",1.83 , 67.5 ,  LocalDate.of(1981, 10, 10),998),
				new Student("��ǿ",1.83 , 67.5 ,  LocalDate.of(1981, 10, 10),789)};

	    Pair<Student> ret5 = minmaxT(stu  , new StuScoreCompare());
	    ret5.showPairMsg();
		
		//���԰���6 ְ����ѧ�����й�ͬ����������ߺ����أ�����
		//�ֱ�����3��ְ����2������3��ѧ�����������������/���ر�������С��
		Person[]  people = new Person[] {
				
				//����ְ��
				new Employee_new("����",1.85,56.0 , LocalDate.of(1971, 10, 10),
						2020,12,10,10000.0,"ѧ��","111"),
				new Employee_new("����",1.83 , 67.5 ,  LocalDate.of(1981, 10, 10),
						2020,12,1,5000.0,"��ʦ","222"),
				new Employee_new("����",1.67 , 57.5 ,  LocalDate.of(1990, 10, 10),
						2020,1,10,3000.0,"�쵼","333"),
				//��������
				new Manager_new("����1",1.73 , 78.5 ,  LocalDate.of(1971, 10, 10),
						2020,12,1,5000.0,"��ʦ","222",90000),
				new Employee_new("����2",1.69 , 57.5 ,  LocalDate.of(1990, 10, 10),
						2020,1,10,3000.0,"�쵼","333"),
				//����ѧ��
				new Student("ѧ��1",1.85,56.0 , LocalDate.of(1971, 10, 10),456),
				new Student("ѧ��2",1.83 , 67.5 ,  LocalDate.of(1981, 10, 10),980),
				new Student("ѧ��3",1.83 , 67.5 ,  LocalDate.of(1981, 10, 10),678)};
		
		        //����������ķ�ʽ���ñȽ����Ƚ�
		        Pair<Person> ret7 = minmaxT(people , new Comparator<Person>(){
		        	public int compare(Person arg0, Person arg1) {
		        		double b1 = arg0.getHeight()/arg0.getWeight();
		        		double b2 = arg1.getHeight()/arg1.getWeight();
		        		return Double.compare(b1, b2);
		        	}      	
		        });
		        ret7.showPairMsg();
	}
	
}
