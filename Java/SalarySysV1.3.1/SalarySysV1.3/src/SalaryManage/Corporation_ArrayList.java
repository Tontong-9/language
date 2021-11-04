
package SalaryManage;

import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;


public class Corporation_ArrayList {//范型类，多次装箱拆箱，不安全，它是不管数据的类型，而集合类（list，dict，str）严格编译，数据类型匹配

	private String corpName;  //公司名
	private String corpDescript;  //公司业务描述
	private String superManager;  //公司法人
	
	private  ArrayList<Employee>  employees; //用来存放公司的员工对象
	
    private  Scanner  scan; //由于很多方法都需要键盘输入数据，所以将scan对象放在类成员使用

	public static void main(String[] args) {
		
		Corporation_ArrayList corp = new Corporation_ArrayList("南航科院软件有限公司", "专门从事企业级应用开发","郭老师");

		corp.showMainUI();
		
		//显示主界面，并等待输入菜单选项，并执行所选功能
		corp.waitforMenuSelect();
		
	}
	
	Corporation_ArrayList(String name , String des , String superManager ){
		corpName = name;
		corpDescript = des;
		this.superManager = superManager;
		employees = new ArrayList<Employee>(100);
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
		Employee employee01 = new Employee("张三",2020,12,10,10000.0,"学生","111");
		employees.add(employee01);

		Employee employee02 = new Employee("李四",2020,12,1,5000.0,"老师","222");
		employees.add(employee02);
		
		Employee employee03 = new Employee("王五",2020,1,10,3000.0,"领导","333");
		employees.add(employee03);

		Employee employee04 = new Employee("王五",2019,6,28,50000.0,"校长","444");
		employees.add(employee04);

		Manager employee05 = new Manager("张六",2019,6,28,60000.0,"校长","444",8000);
		employees.add(employee05);
		
		Manager employee06 = new Manager("张七",2019,5,28,10000.0,"校长","444",2000);
		employees.add(employee06);
		
		Employee employee07 = new Employee("张王五d",2019,6,28,18000.0,"校长","444");
		employees.add(employee07);
		System.out.println("职工数据初始化成功！！！");
	}

	/**
	 * 展示所有员工信息
	 */
	public void showAllEmployee(){
        for(Employee e : employees)
        	System.out.println(e.toString());
	}
	
	/**
	 * 添加一职员（从键盘输入基本信息）
	 * @return 返回目前公司的当前职员数
	 */
	public int  addOneEmployee() {
		
		System.out.println("进入增加一职员界面,请按格式输入数据");
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
			employees.add(mang);
			System.out.println("添加经理成功");
		}else {
			Employee employee = new Employee(name,y,m,d,salary,position,tel);
            employees.add(employee);
			System.out.println("添加员工成功");
		}
		return employees.size();
	}
	
	/**
	 * 删除一职员,从键盘输入要删除职员的工号
	 *  @return  目前公司的当前职员数
	 */
	public  int  delOneEmployee() {

		System.out.println("进入删除一职员界面,请输入要删除员工的工号");
		//具体用scan来解析输入的数据
		int id = scan.nextInt();
		
		//用迭代器的方法来遍历查找效率更高
		ListIterator<Employee> it = employees.listIterator();
		int nfind = -1;
		while(it.hasNext()) {
			Employee e = it.next();
			nfind++;
			if(e.getId() == id) {
				nfind = id; break;
			}
		}
		if(nfind == -1)
				System.out.println("删除数据失败，未找到工号为" + id +"的员工");
		else
			employees.remove(nfind);
		return employees.size();
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
			ArrayList<Employee> finds = searchEmployeesByName(name);
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
		
		Employee find = null;
		//用迭代器的方法来遍历查找效率更高
		ListIterator<Employee> it = employees.listIterator();
		while(it.hasNext()) {
			Employee e = it.next();
			if(e.getId() == id) {
				find = e; break;
			}
		}
		return find;
	}
	/**
	 * 根据职员姓名查找职员信息
	 * @param name   姓名
	 * @return  查找到的多个职员信息，因为有可能重名
	 */	
	public ArrayList<Employee> searchEmployeesByName(String name) {

        ArrayList<Employee> find = new ArrayList<Employee>();
		//用迭代器的方法来遍历查找效率更高
		ListIterator<Employee> it = employees.listIterator();
		while(it.hasNext()) {
			Employee e = it.next();
			String s = e.getName();
			if(s.equals(name))
                 find.add(e);
		}
		return find;
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
		Employee find = searchEmployeeById(num);
		if(find == null) {
			System.out.println("没有找到该工号的员工");return null;
		}
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
		find.setMsg(name,y,m,d,salary,position,tel);
		return find;
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
		employees.sort(
				Comparator.comparing(Employee::getSalary).reversed());
	}
	
	/**
	 * *可以使用lambda表达式来简化比较器类的生成
	 */
	public void sortEmployeeById() {
		employees.sort((first,second) ->{
		        return first.getId()-second.getId();
		});
	}
		 
	/**
	 * 根据入职时间长短排序
	 * 使用List.sort()排序
	 */
	public void sortEmployeeByHireTime() {
		employees.sort(
				Comparator.comparing(Employee::getHireDay).reversed());
	}
	
	
	/**
	 * *可以使用函数式来简化比较器类的生成
	 * 该函数先按雇佣日期的高低排序，如果相同再按薪水排序
	 */
    public  void  sortEmployeeByDayAndSalary() {
    	employees.sort(Comparator.comparing(Employee::getHireDay).thenComparing(Employee::getSalary));
    }
   
	
	/**
	 * 保存雇员信息到文件
	 * @param fileName
	 */
	public void saveEmployeesToFile(String fileName) {
		try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
				for(Employee e : employees) {
					bw.write(e.toString());
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
			for(Employee e : employees) {
				bw.write(e.toString());
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
	 * 以二进制字节的形式来保存所有职工数据
	 * @保存过程：先写入职工总数，
	 *         再循环写入每个职员的信息（包括信息总字节数+所有字节）	 
	 * */
	public void  saveAsBinaryFile(String filename) {
		DataOutputStream  out = null;
		try {
			//使用DataOutputStream可以写入具体类型的数据
			out = new DataOutputStream(
					new BufferedOutputStream(
					   new FileOutputStream(filename)));
			out.writeInt(employees.size());//先写入职员的总数
			for(Employee e : employees) {
				String emsg = e.toString();
				byte[] msg = emsg.getBytes();
				System.out.println(""+msg.length);
				out.writeInt(msg.length);
				out.write(msg);
				System.out.println(emsg);				
			}
			System.out.println("保存数据成功");
			out.close();
			
		}catch(IOException e) {
			System.out.println(e);
		}
	}

	/**
	 * 打开二进制文件，并读取所有职工数据
	 * 读取过程：和保存数据的过程相匹配
	 * */
	public void openAsBinaryFile(String filename) {
		DataInputStream in = null;
		try {
			in = new DataInputStream(new BufferedInputStream(
					   new FileInputStream(filename)));
			int number = 0; //先读入职员的总数
			number = in.readInt();
			if(number > 0) {
				for(int i = 0 ; i < number ; i++) {
					int len = in.readInt();
					System.out.println(len);
					byte[] data = new byte[len];
					int n = in.read(data);
					String s = new String(data , 0 , n);
					System.out.println(s);
				}	
			}

		}catch(IOException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * 以文本格式的形式来保存所有职工数据
	 * */
	public void  saveAsTextFile(String filename) {
		PrintWriter out = null;
		try {
			   out = new PrintWriter(
					    new FileWriter(
					   filename, StandardCharsets.UTF_8));
			   for(Employee  e : employees) {
				   out.println(e.toString());
				   System.out.println(e.toString());
			   }
			   out.close();
			   System.out.println("保存文本成功");
		}catch(IOException e) {
			System.out.println(e);
		}
	}
	
	public void  openAsTextFile(String filename) {
		Scanner in = null;
		try {
			in = new Scanner(
					new FileReader(
							filename,StandardCharsets.UTF_8));
			while(in.hasNextLine()) {
				String content = in.nextLine();
				System.out.println(content);
			}
			in.close();
			
		}catch(IOException e) {
			System.out.println(e);
		}
		
	}
	
	//需要根据输入的一行字符串解析出某个雇员的具体信息
	public static Employee  parseEmployee(String  content ) {
		
		return null;
	}

	public void saveAsObjectToFile(String filename) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(
					new FileOutputStream(filename));
			out.writeObject(employees);
			out.close();
		}catch(IOException e) {
			System.out.println(e);
		}
	}
	
	public void openAsObjectFile(String filename) {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(
					new FileInputStream(filename));
			employees = (ArrayList<Employee>)in.readObject();
			for(Employee e : employees) {
				System.out.println(e.toString());
			}
			in.close();
		}catch(Exception e) {
			System.out.println(e);
		}
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
