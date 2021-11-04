package SalaryManage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Scanner;

public class Corporation_HashMap {
	
	private String corpName;  //公司名
	private String corpDescript;  //公司业务描述
	private String superManager;  //公司法人
	
	//用来存放公司的员工对象 映射是采用工号-职工的形式
	//因为每个员工的工号都是不同的
	private  HashMap<Integer,Employee>  employees; 
	
    private  Scanner  scan; //由于很多方法都需要键盘输入数据，所以将scan对象放在类成员使用

    //测试代码，每个类中都可以加上测试模块
    public static void main(String[] args) {
		
    	Corporation_HashMap corp = new Corporation_HashMap("南航科院软件有限公司", "专门从事企业级应用开发","郭老师");

		corp.showMainUI();
		
		//显示主界面，并等待输入菜单选项，并执行所选功能
		corp.waitforMenuSelect();
		
	}
	
    Corporation_HashMap(String name , String des , String superManager ){
		corpName = name;
		corpDescript = des;
		this.superManager = superManager;
		employees = new HashMap<Integer,Employee>(100);
		scan = new Scanner(System.in);
		initEmployee();
	}
	
	/**
	 * 显示公司工资管理主界面
	 */	
	public  void  showMainUI() {

		System.out.println("***************************************");
		System.out.printf("***********%s职员工资管理系统\n" , corpName);
		System.out.println("输入init:自动初始化数据");
		System.out.println("输入show:展示所以员工信息");
		System.out.println("输入add:添加职员信息");
		System.out.println("输入del:删除职员信息");
		System.out.println("输入search:查询职员信息");
		System.out.println("输入modify:修改职员信息");
		System.out.println("输入sort:对职员进行排序");
		System.out.println("输入save:保存职员信息");
		System.out.println("输入open:打开文件读入职员信息");
		System.out.println("输入saveB:保存为二进制文件d:\\employees.dat");
		System.out.println("输入openB:打开二进制文件d:\\employees.dat读入职员信息");
		System.out.println("输入saveT:保存为文本文件d:\\employees.txt");
		System.out.println("输入openT:打开文本d:\\employees.txt读入职员信息");
		System.out.println("输入saveO:用序列化保存职员信息d:\\employees2.dat");
		System.out.println("输入openO:用序列化打开职员信息d:\\employees2.dat");
		System.out.println("输入save as:另存为...职员信息");
		System.out.println("输入open as:打开所选文件读入职员信息");
		System.out.println("输入first:显示主界面信息");
		System.out.printf("***********%s****总经理:%s\n" , corpDescript , superManager);
		System.out.println("***********************************************");	
	}
	
	/**
	 * 等待用户选择操作选项，比如：键盘输入"add"，则选择添加一职员功能
	 */
	public void   waitforMenuSelect() {
		
		String select="";
		Boolean ret = true;
		while(ret == true) {
	//	    showMainUI();
			select = scan.nextLine();
			switch(select) {
			case "init":initEmployee();break;
			case "show":showAllEmployee();break;
			case "add":addOneEmployee();break;
			case "del":delOneEmployee();break;
			case "search":searchEmployee();break;
			case "modify":modifyEmployeeMsg();break;
			case "sort":sortEmployee();break;
			case "first":showMainUI();break;
			case "saveB":saveAsBinaryFile("d:\\employees.dat");break;
			case "save as":savaAsEmployeesToFile();break;
			case "openB":openAsBinaryFile("d:\\employees.dat");break;
			case "saveT":saveAsTextFile("d:\\employees.txt");break;
			case "saveO":saveAsObjectToFile("d:\\employees2.dat");break;
			case "openT":openAsTextFile("d:\\employees.txt");break;
			case "openO":openAsObjectFile("d:\\employees2.dat");break;
			case "open as":openFile();break;
			case "abort":ret = false;break;
			default:break;
			}
		}
		
	}

	/**
	 * 初始化4位职工信息，手动初始化输入较慢
	 */
	private void initEmployee() {
		
		System.out.println("职工数据初始化成功！！！");
	}

	/**
	 * 展示所有员工信息
	 */
	public void showAllEmployee(){
     
	}
	
	/**
	 * 添加一职员（从键盘输入基本信息）
	 * @return 返回目前公司的当前职员数
	 */
	public int  addOneEmployee() {

         return 0;
	}
	
	/**
	 * 删除一职员,从键盘输入要删除职员的工号
	 *  @return  目前公司的当前职员数
	 */
	public  int  delOneEmployee() {

        return 0;

	}
	
	/**
	 * 查找职员信息的菜单入口
	 */
	public void searchEmployee() {
		
	
			
	}
	
	/**
	 * 根据工号查找职员信息
	 * @return  查找到的职员信息
	 */
	public  Employee searchEmployeeById(int id) {
		
          return null;

	}
	/**
	 * 根据职员姓名查找职员信息
	 * @param name   姓名
	 * @return  查找到的多个职员信息，因为有可能重名
	 */	
	public ArrayList<Employee> searchEmployeesByName(String name) {

          return null;

	}
	
	/**
	 * 修改某个职员的基本信息
	 * 从键盘输入工号，修改该雇员的基本信息
	 * @return   修改信息后的职员数据
	 */
	public Employee modifyEmployeeMsg() {

         return null;
	}
	/**
	 * 排序的总入口
	 */
	public void  sortEmployee() {
		System.out.println("******************************");
		System.out.println("进入排序二级菜单界面,请输入选项");
		System.out.println("输入salary则按salary排序");
		System.out.println("输入Hire则按雇佣日期排序");
		System.out.println("输入id则按工号排序");
		System.out.println("输入DaySalary则按日期薪水二次排序");
		System.out.println("输入back退出排序模块");
		System.out.println("***************************");
		String select="";
		do {
			//具体用scan来解析输入的数据
			select = scan.nextLine();
			if(select.equals("salary")){
				sortEmployeeBySalary();
				System.out.println("按salary排序后");
				showAllEmployee();
			} else if(select.equals("Hire")){
				sortEmployeeByHireTime();
				System.out.println("按HireTime排序后");
				showAllEmployee();
			}else if(select.equals("id")){
				sortEmployeeById();
				System.out.println("按id排序后");
				showAllEmployee();
			}else if(select.equals("DaySalary")){
				sortEmployeeByDayAndSalary();
				System.out.println("按id排序后");
				showAllEmployee();
			}else {
				showAllEmployee();
			}	
		}while(select.equals("back")== false);
		
	}
	
	/**
	 * 根据薪资高低排序
	 * 使用List.sort()排序
	 */
	public void  sortEmployeeBySalary() {
	
	}
	
	/**
	 * *可以使用lambda表达式来简化比较器类的生成
	 */
	public void sortEmployeeById() {
	
	}
		 
	/**
	 * 根据入职时间长短排序
	 * 使用List.sort()排序
	 */
	public void sortEmployeeByHireTime() {
		
	}
	
	
	/**
	 * *可以使用函数式来简化比较器类的生成
	 * 该函数先按雇佣日期的高低排序，如果相同再按薪水排序
	 */
    public  void  sortEmployeeByDayAndSalary() {
    	
    }
   
	
	/**
	 * 保存雇员信息到文件
	 * @param fileName
	 */
	public void saveEmployeesToFile(String fileName) {
		
	}
	/**
	 * 另存雇员信息到所选择文件
	 */
	public  void savaAsEmployeesToFile() {
	
	}
	
	/**
	 * 打开某文件，读入雇员信息
	 * @param fileName
	 * @return
	 */
	public Boolean openFile(String fileName) {
		
		return true;
	}
	
	/**
	 * 打开所选文件，读入雇员信息
	 * @return
	 */
	public Boolean openFile() {

		

		return true;
	}
	
	/**
	 * 以二进制字节的形式来保存所有职工数据
	 * @保存过程：先写入职工总数，
	 *         再循环写入每个职员的信息（包括信息总字节数+所有字节）	 
	 * */
	public void  saveAsBinaryFile(String filename) {
		
	}

	/**
	 * 打开二进制文件，并读取所有职工数据
	 * 读取过程：和保存数据的过程相匹配
	 * */
	public void openAsBinaryFile(String filename) {
		
	}
	
	/**
	 * 以文本格式的形式来保存所有职工数据
	 * */
	public void  saveAsTextFile(String filename) {
		
	}
	
	public void  openAsTextFile(String filename) {
	
	}
	
	//需要根据输入的一行字符串解析出某个雇员的具体信息
	public static Employee  parseEmployee(String  content ) {
		
		return null;
	}

	public void saveAsObjectToFile(String filename) {
		
		
	}
	
	public void openAsObjectFile(String filename) {


	}
	/**
	 * 计算按某个比例增加员工工资后的总工资
	 */
	public double calculateAllSalary(double percent) {
		return 0.0;
	}
	
	public String getCorpName() {
		return corpName;
	}


	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}


	public String getCorpDescript() {
		return corpDescript;
	}


	public void setCorpDescript(String corpDescript) {
		this.corpDescript = corpDescript;
	}


	public String getSuperManager() {
		return superManager;
	}


	public void setSuperManager(String superManager) {
		this.superManager = superManager;
	}

}

