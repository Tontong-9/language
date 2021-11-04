package SalaryManage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;

public class Customer implements Comparable,Comparator<Customer>{

    private String cardId;
    private String  name;
    private  int    level;
    private  int     score;
    private  int     age;
    private   char   sex;

    public  Customer(String id , String n , int l , int s , int age , char sex) {
        cardId = id;
        name = n;
        level = l;
        score = s;
        this.age = age;
        this.sex = sex;
    }

    public Customer() {

    }
    @Override
    public String toString() {
       String s = "卡号:"+cardId+"姓名"+name+"等级:"+level+"积分"+score+"年龄"+age+"性别"+sex;
       return s;
    }

    public int compareTo(Object o) {
	     if(getScore() > ((Customer)o).getScore()) return 1;
	     else if(getScore() < ((Customer)o).getScore()) return -1;
	     else
	    	 return 0;
  
	}
	public int compare(Customer o1 , Customer o2) {
		return o1.getName().compareTo(o2.getName());
	}
    public boolean equals(Object o) {//判断对象是否完全相同，二者其一也是不同
        if(this==o) return true;
        if(o==null) return false;
        if(o instanceof Customer==false) return false;//如果它是个Customer类就返回ture
        Customer obj =(Customer)o;
        if(getCardId().compareTo(obj.getCardId())==0 && getName().compareTo(obj.getName())== 0) return true;
        else return false;
    }

    public int hashCode() {
        int code1 =getName().hashCode();
        int code2 =getCardId().hashCode();
        return code1+code2;
    }

    public String getCardId() {
        return cardId;
    }
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public char getSex() {
        return sex;
    }
    public void setSex(char sex) {
        this.sex = sex;
    }

    public static void main(String[] arg) {
        Customer[] men = new Customer[] {
                new Customer("card01","man1",1 , 600,50,'W'),
                new Customer("card02","man2",2 , 800,80,'W'),
                new Customer("card01","man1",1 , 900,30,'W'),
                new Customer("card03","man1",1 , 700,20,'W'),
                new Customer("card03","man2",1 , 1600,50,'W')};//集合自动过滤掉完全一样的对象
        for(Customer c:men) {
        	System.out.println(c);
        }
        System.out.println("tt");
/*
 * 存对象的方式
 * 
 */
        var cut3=new TreeSet<Customer>();
        var cust2=new ArrayList<Customer>(100);
        var cust1=new HashSet<Customer>(100);
        
        for(Customer c:men) {
        	cust1.add(c);
        }
        
//        for(Customer c:men) {
//        	System.out.println(c);
//        }
        Iterator<Customer> it=cust1.iterator();
        //可迭代对象（可以for循环访问的）拥有迭代器，不可迭代对象（list，dict，str）可通过iter()函数获得一个可迭代对象
        /*
         * # 首先获得Iterator对象:
				it = iter([1, 2, 3, 4, 5])
				# 循环:
				while True:
				    try:
				        # 获得下一个值:
				        x = next(it)
				    except StopIteration:
				        # 遇到StopIteration就退出循环
				        break
	
         */
        while(it.hasNext()) {//一直next，直到最后并报错
        		
        	Customer s=it.next();
        	System.out.println(s);
        	}
        
    }
  }