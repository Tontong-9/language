package SalaryManage;

import java.util.Comparator;

public class NameComparator implements Comparator<Employee> {
   public  int  compare(Employee first , Employee second) {
	   if(first == null || second==null) return 0;
	   return first.getName().compareTo(second.getName());
   }
}
