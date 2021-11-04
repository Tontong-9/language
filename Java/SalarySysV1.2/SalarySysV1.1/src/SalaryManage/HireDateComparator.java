package SalaryManage;

import java.time.LocalDate;
import java.util.Comparator;

public class HireDateComparator implements Comparator<Employee> {
	 
	public  int  compare(Employee first , Employee second) {
		if(first == null || second==null) return 0;
		LocalDate date1 = first.getHireDay();
		LocalDate date2 = first.getHireDay();
		return date1.compareTo(date2);
		
	}
}
