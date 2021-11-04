package SalaryManage;

import java.util.Comparator;

public class StuScoreCompare implements Comparator<Student> {

	@Override
	public int compare(Student arg0, Student arg1) {
		// TODO Auto-generated method stub
		return Double.compare(arg0.getScore(), arg1.getScore());
	}
 
}
