package SalaryManage;

import java.util.*;
import java.io.*;
import java.util.*;


/**
 * <p><strong>Employee</strong>公司类，用来处理所有单个员工的信息</p>
 * 一般来说，管理系统中有原子类如Employee，还有集合类如Corpration
 * @version 1.0
 * @author 190207131吴宇鑫
 */

public class Corporation {

	public static final int  MAX_EMPLOYEES = 100;  //公司员工的最大数
	public static int nextId; // 新增员工存放位置,以及员工总人数

	private String corpName;  //公司名
	private String corpDescript;  //公司业务描述
	private String superManager;  //公司法人
	
	private  Employee[]  employees; //用来存放公司的员工对象
	
    private  Scanner  scan; //由于很多方法都需要键盘输入数据，所以将scan对象放在类成员使用

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Corporation corp = new Corporation("南航科院软件有限公司", "专门从事企业级应用开发","郭老师");

		corp.showMainUI();
		
		//显示主界面，并等待输入菜单选项，并执行所选功能
		corp.waitforMenuSelect();
		
	}
	
	Corporation(String name , String des , String superManager ){
		corpName = name;
		corpDescript = des;
		this.superManager = superManager;
		employees = new Employee[MAX_EMPLOYEES];
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
		System.out.println("输入save as:另存为...职员信息");
		System.out.println("输入open:打开文件读入职员信息");
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
			case "save":saveEmployeesToFile("employees.dat");break;
			case "save as":savaAsEmployeesToFile();break;
			case "open":openFile("employees.dat");break;
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
		Employee employee01 = new Employee("张三",2020,12,10,10000.0,"学生","111");
		employees[nextId++] = employee01;

		Employee employee02 = new Employee("李四",2020,12,1,5000.0,"老师","222");
		employees[nextId++] = employee02;

		Employee employee03 = new Employee("王五",2020,1,10,3000.0,"领导","333");
		employees[nextId++] = employee03;

		Employee employee04 = new Employee("王五",2019,6,28,50000.0,"校长","444");
		employees[nextId++] = employee04;

		Manager employee05 = new Manager("张六",2019,6,28,60000.0,"校长","444",8000);
		employees[nextId++] = employee05;
		
		Manager employee06 = new Manager("张七",2019,5,28,10000.0,"校长","444",2000);
		employees[nextId++] = employee06;
		
		Employee employee07 = new Employee("张王五d",2019,6,28,18000.0,"校长","444");
		employees[nextId++] = employee07;
		System.out.println("职工数据初始化成功！！！");
	}

	/**
	 * 展示所有员工信息
	 */
	public void showAllEmployee(){

		if(nextId == 0){
			System.out.println("暂无职工信息");
			return;
		}

		for(int i = 0;i < nextId;i++){
			System.out.println(employees[i]);
		}
	}
	
	/**
	 * 添加一职员（从键盘输入基本信息）
	 * @return 返回目前公司的当前职员数
	 */
	public int  addOneEmployee() {

		if(nextId <= MAX_EMPLOYEES){
			System.out.println("进入增加一职员界面,请按格式输入数据");

			//具体用scan来解析输入的数据
			/*String s = scan.nextLine();
			System.out.println(s);*/
			String name = "";//员工名字
			int y,m,d;//员工入职年，月，日
			double salary;//员工基本工资
			String position = "";//员工所属部门、职位描述
			String tel;//电话号码
			System.out.println("请输入员工姓名");
			name = scan.nextLine();
			System.out.println("请输入员工的入职年");
			y = scan.nextInt();
			System.out.println("请输入员工的入职月");
			m = scan.nextInt();
			System.out.println("请输入员工的入职日");
			d = scan.nextInt();
			System.out.println("请输入员工的基本工资");
			salary = scan.nextDouble();
			position = scan.nextLine();
			System.out.println("请输入员工的所属部门、职位描述");
			position = scan.nextLine();
			System.out.println("请输入员工的电话号码");
			tel = scan.nextLine();
			System.out.println("请输入该员工是否为经理，如果是输入yes,否则输入no");
			String  isManager = scan.nextLine();
			if(isManager.equals("yes")) {
				System.out.println("请输入经理的津贴");
				double bonus = scan.nextDouble();
				Manager mang = new Manager(name,y,m,d,salary,position,tel,bonus);
				employees[nextId++] = mang;
				System.out.println("添加经理成功");
			}else {
				Employee employee = new Employee(name,y,m,d,salary,position,tel);
				employees[nextId++] = employee;
				System.out.println("添加员工成功");
			}
			
			
		}
		else {
			System.out.println("员工数量已达上线，添加失败");
		}
		return nextId;
	}
	
	/**
	 * 删除一职员,从键盘输入要删除职员的工号
	 *  @return  目前公司的当前职员数
	 */
	public  int  delOneEmployee() {
		boolean flag = false;
		System.out.println("进入删除一职员界面,请输入要删除员工的工号");
		//具体用scan来解析输入的数据
		int id = scan.nextInt();
		for(int i = 0;i < nextId;i++){
			if(employees[i].getId() == id){
				for(int j = i + 1;j < nextId;j++){
					employees[j - 1] = employees[j];
				}
				nextId--;
				System.out.println("删除数据成功");
				flag = true;
				break;
			}
		}
		if(flag == false){
				System.out.println("删除数据失败，未找到工号为" + id +"的员工");
		}
		return nextId;
	}
	
	/**
	 * 查找职员信息的菜单入口
	 */
	public void searchEmployee() {
		
		System.out.println("进入查找职员界面,请输入选项，输入id则按id查找数据，输入name则按名字查找数据");
		//具体用scan来解析输入的数据
		String select = scan.nextLine();
		if(select.equals("id")){
			System.out.println("请输入工号，按回车键结束");
			int id = scan.nextInt();
			Employee find = searchEmployeeById(id);
			if(find == null)
				System.out.println("没有找到信息");
			else
				find.showEmployeeMsg();
			
		}else {
			System.out.println("请输入名字，按回车键结束");
			String name = scan.nextLine();
			Employee[] finds = searchEmployeesByName(name);
			if(finds == null)
				System.out.println("没有找到信息");
			else
				for(Employee e :finds)
				    e.showEmployeeMsg();
		}
			
	}
	
	/**
	 * 根据工号查找职员信息
	 * @return  查找到的职员信息
	 */
	public  Employee searchEmployeeById(int id) {
		for(int i = 0;i < nextId;i++){
			if(id == employees[i].getId()){
				return employees[i];
			}
		}
		return null;
	}
	/**
	 * 根据职员姓名查找职员信息
	 * @param name   姓名
	 * @return  查找到的多个职员信息，因为有可能重名
	 */	
	public Employee[] searchEmployeesByName(String name) {
		int len = 0,index = 0;
		for(int i = 0;i < nextId;i++){
			if(employees[i].getName().equals(name)){
				len++;
			}
		}
		if(len == 0){
			return null;
		}

		Employee[] e = new Employee[len];
		for(int i = 0;i < nextId;i++){
			if(employees[i].getName().equals(name)){
				e[index++] = employees[i];
			}
		}
		return e;
	}
	
	/**
	 * 修改某个职员的基本信息
	 * 从键盘输入工号，修改该雇员的基本信息
	 * @return   修改信息后的职员数据
	 */
	public Employee modifyEmployeeMsg() {
		boolean flag = false;
		String name = "";//员工名字
		int y,m,d;//员工入职年，月，日
		double salary;//员工基本工资
		String position = "";//员工所属部门、职位描述
		String tel;//电话号码
		System.out.println("请输入要更改员工的员工号");
		int num = scan.nextInt();
		name = scan.nextLine();

		for(int i = 0;i < nextId;i++){
			if(num == employees[i].getId()){

				System.out.println("请输入修改后员工姓名");
				name = scan.nextLine();
				System.out.println("请输入修改后员工的入职年");
				y = scan.nextInt();
				System.out.println("请输入修改后员工的入职月");
				m = scan.nextInt();
				System.out.println("请输入修改后员工的入职日");
				d = scan.nextInt();
				System.out.println("请输入修改后员工的基本工资");
				salary = scan.nextDouble();
				position = scan.nextLine();
				System.out.println("请输入修改后员工的所属部门、职位描述");
				position = scan.nextLine();
				System.out.println("请输入修改后员工的电话号码");
				tel = scan.nextLine();
				Employee employee = new Employee(num,name,y,m,d,salary,position,tel);
				employees[i] = employee;
				System.out.println(1);
				flag = true;
				break;
			}
		}

		if(flag == false){
			System.out.println("修改失败，为找到工号为" + num + "的员工");
		}
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
		/*List<Employee> EmployeeList01 = new ArrayList<Employee>();
		for(int i = 0;i < nextId;i++){
			EmployeeList01.add(employees[i]);
		}
		EmployeeList01.sort(Comparator.comparing(Employee::getSalary).reversed());
		for(int i = 0;i < nextId;i++){
			employees[i] = EmployeeList01.get(i);
		}*/
		Arrays.sort(employees , 0 , nextId);
		
	}
	
	/**
	 * *可以使用lambda表达式来简化比较器类的生成
	 */
	public void sortEmployeeById() {
		Arrays.sort(employees,0,nextId,(first,second) ->{
		        return first.getId()-second.getId();
		});
	}
	/**
	 * *可以使用函数式来简化比较器类的生成
	 * 该函数先按雇佣日期的高低排序，如果相同再按薪水排序
	 */
    public  void  sortEmployeeByDayAndSalary() {
    	Arrays.sort(employees , 
    			    0,
    			    nextId,
    			    Comparator.comparing(Employee::getHireDay).thenComparing(Employee::getSalary));
    }
	/**
	 * 根据入职时间长短排序
	 * 使用List.sort()排序
	 */
	public void sortEmployeeByHireTime() {
		/*List<Employee> EmployeeList02 = new ArrayList<Employee>();
		for(int i = 0;i < nextId;i++){
			EmployeeList02.add(employees[i]);
		}
		EmployeeList02.sort(Comparator.comparing(Employee::getHireDay));
		for(int i = 0;i < nextId;i++){
			employees[i] = EmployeeList02.get(i);
		}
		*/
		Arrays.sort(employees ,0, nextId ,  new HireDateComparator());
	}
	
	/**
	 * 保存雇员信息到文件
	 * @param fileName
	 */
	public void saveEmployeesToFile(String fileName) {
		try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
				for(int i = 0;i < nextId;i++) {
					bw.write(employees[i].toString());
					bw.newLine();
			}
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	/**
	 * 另存雇员信息到所选择文件
	 */
	public  void savaAsEmployeesToFile() {
		System.out.println("请输入要另存为的文件名及后缀（例如：employees.dat）");
		String fileName = scan.nextLine();
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
			for(int i = 0;i < nextId;i++) {
				bw.write(employees[i].toString());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 打开某文件，读入雇员信息
	 * @param fileName
	 * @return
	 */
	public Boolean openFile(String fileName) {
		String line = null;
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			while((line = in.readLine()) != null){
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}
	
	/**
	 * 打开所选文件，读入雇员信息
	 * @return
	 */
	public Boolean openFile() {

		System.out.println("请输入要打开的文件名及后缀（例如：employees.dat）");
		String fileName = scan.nextLine();

		String line = null;
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			while((line = in.readLine()) != null){
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
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


	public Employee[] getEmployees() {
		return employees;
	}


	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}


	public static int getMaxEmployees() {
		return MAX_EMPLOYEES;
	}

}
