package SalaryManage;

import java.util.*;
import java.io.*;
import java.util.*;


/**
 * <p><strong>Employee</strong>��˾�࣬�����������е���Ա������Ϣ</p>
 * һ����˵������ϵͳ����ԭ������Employee�����м�������Corpration
 * @version 1.0
 * @author 190207131������
 */

public class Corporation {

	public static final int  MAX_EMPLOYEES = 100;  //��˾Ա���������
	public static int nextId; // ����Ա�����λ��,�Լ�Ա��������

	private String corpName;  //��˾��
	private String corpDescript;  //��˾ҵ������
	private String superManager;  //��˾����
	
	private  Employee[]  employees; //������Ź�˾��Ա������
	
    private  Scanner  scan; //���ںܶ෽������Ҫ�����������ݣ����Խ�scan����������Աʹ��

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Corporation corp = new Corporation("�Ϻ���Ժ������޹�˾", "ר�Ŵ�����ҵ��Ӧ�ÿ���","����ʦ");

		corp.showMainUI();
		
		//��ʾ�����棬���ȴ�����˵�ѡ���ִ����ѡ����
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
	 * ��ʾ��˾���ʹ���������
	 */	
	public  void  showMainUI() {

		System.out.println("***************************************");
		System.out.printf("***********%sְԱ���ʹ���ϵͳ\n" , corpName);
		System.out.println("����init:�Զ���ʼ������");
		System.out.println("����show:չʾ����Ա����Ϣ");
		System.out.println("����add:���ְԱ��Ϣ");
		System.out.println("����del:ɾ��ְԱ��Ϣ");
		System.out.println("����search:��ѯְԱ��Ϣ");
		System.out.println("����modify:�޸�ְԱ��Ϣ");
		System.out.println("����sort:��ְԱ��������");
		System.out.println("����save:����ְԱ��Ϣ");
		System.out.println("����save as:���Ϊ...ְԱ��Ϣ");
		System.out.println("����open:���ļ�����ְԱ��Ϣ");
		System.out.println("����open as:����ѡ�ļ�����ְԱ��Ϣ");
		System.out.println("����first:��ʾ��������Ϣ");
		System.out.printf("***********%s****�ܾ���:%s\n" , corpDescript , superManager);
		System.out.println("***********************************************");	
	}
	
	/**
	 * �ȴ��û�ѡ�����ѡ����磺��������"add"����ѡ�����һְԱ����
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
	 * ��ʼ��4λְ����Ϣ���ֶ���ʼ���������
	 */
	private void initEmployee() {
		Employee employee01 = new Employee("����",2020,12,10,10000.0,"ѧ��","111");
		employees[nextId++] = employee01;

		Employee employee02 = new Employee("����",2020,12,1,5000.0,"��ʦ","222");
		employees[nextId++] = employee02;

		Employee employee03 = new Employee("����",2020,1,10,3000.0,"�쵼","333");
		employees[nextId++] = employee03;

		Employee employee04 = new Employee("����",2019,6,28,50000.0,"У��","444");
		employees[nextId++] = employee04;

		Manager employee05 = new Manager("����",2019,6,28,60000.0,"У��","444",8000);
		employees[nextId++] = employee05;
		
		Manager employee06 = new Manager("����",2019,5,28,10000.0,"У��","444",2000);
		employees[nextId++] = employee06;
		
		Employee employee07 = new Employee("������d",2019,6,28,18000.0,"У��","444");
		employees[nextId++] = employee07;
		System.out.println("ְ�����ݳ�ʼ���ɹ�������");
	}

	/**
	 * չʾ����Ա����Ϣ
	 */
	public void showAllEmployee(){

		if(nextId == 0){
			System.out.println("����ְ����Ϣ");
			return;
		}

		for(int i = 0;i < nextId;i++){
			System.out.println(employees[i]);
		}
	}
	
	/**
	 * ���һְԱ���Ӽ������������Ϣ��
	 * @return ����Ŀǰ��˾�ĵ�ǰְԱ��
	 */
	public int  addOneEmployee() {

		if(nextId <= MAX_EMPLOYEES){
			System.out.println("��������һְԱ����,�밴��ʽ��������");

			//������scan���������������
			/*String s = scan.nextLine();
			System.out.println(s);*/
			String name = "";//Ա������
			int y,m,d;//Ա����ְ�꣬�£���
			double salary;//Ա����������
			String position = "";//Ա���������š�ְλ����
			String tel;//�绰����
			System.out.println("������Ա������");
			name = scan.nextLine();
			System.out.println("������Ա������ְ��");
			y = scan.nextInt();
			System.out.println("������Ա������ְ��");
			m = scan.nextInt();
			System.out.println("������Ա������ְ��");
			d = scan.nextInt();
			System.out.println("������Ա���Ļ�������");
			salary = scan.nextDouble();
			position = scan.nextLine();
			System.out.println("������Ա�����������š�ְλ����");
			position = scan.nextLine();
			System.out.println("������Ա���ĵ绰����");
			tel = scan.nextLine();
			System.out.println("�������Ա���Ƿ�Ϊ�������������yes,��������no");
			String  isManager = scan.nextLine();
			if(isManager.equals("yes")) {
				System.out.println("�����뾭��Ľ���");
				double bonus = scan.nextDouble();
				Manager mang = new Manager(name,y,m,d,salary,position,tel,bonus);
				employees[nextId++] = mang;
				System.out.println("��Ӿ���ɹ�");
			}else {
				Employee employee = new Employee(name,y,m,d,salary,position,tel);
				employees[nextId++] = employee;
				System.out.println("���Ա���ɹ�");
			}
			
			
		}
		else {
			System.out.println("Ա�������Ѵ����ߣ����ʧ��");
		}
		return nextId;
	}
	
	/**
	 * ɾ��һְԱ,�Ӽ�������Ҫɾ��ְԱ�Ĺ���
	 *  @return  Ŀǰ��˾�ĵ�ǰְԱ��
	 */
	public  int  delOneEmployee() {
		boolean flag = false;
		System.out.println("����ɾ��һְԱ����,������Ҫɾ��Ա���Ĺ���");
		//������scan���������������
		int id = scan.nextInt();
		for(int i = 0;i < nextId;i++){
			if(employees[i].getId() == id){
				for(int j = i + 1;j < nextId;j++){
					employees[j - 1] = employees[j];
				}
				nextId--;
				System.out.println("ɾ�����ݳɹ�");
				flag = true;
				break;
			}
		}
		if(flag == false){
				System.out.println("ɾ������ʧ�ܣ�δ�ҵ�����Ϊ" + id +"��Ա��");
		}
		return nextId;
	}
	
	/**
	 * ����ְԱ��Ϣ�Ĳ˵����
	 */
	public void searchEmployee() {
		
		System.out.println("�������ְԱ����,������ѡ�����id��id�������ݣ�����name�����ֲ�������");
		//������scan���������������
		String select = scan.nextLine();
		if(select.equals("id")){
			System.out.println("�����빤�ţ����س�������");
			int id = scan.nextInt();
			Employee find = searchEmployeeById(id);
			if(find == null)
				System.out.println("û���ҵ���Ϣ");
			else
				find.showEmployeeMsg();
			
		}else {
			System.out.println("���������֣����س�������");
			String name = scan.nextLine();
			Employee[] finds = searchEmployeesByName(name);
			if(finds == null)
				System.out.println("û���ҵ���Ϣ");
			else
				for(Employee e :finds)
				    e.showEmployeeMsg();
		}
			
	}
	
	/**
	 * ���ݹ��Ų���ְԱ��Ϣ
	 * @return  ���ҵ���ְԱ��Ϣ
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
	 * ����ְԱ��������ְԱ��Ϣ
	 * @param name   ����
	 * @return  ���ҵ��Ķ��ְԱ��Ϣ����Ϊ�п�������
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
	 * �޸�ĳ��ְԱ�Ļ�����Ϣ
	 * �Ӽ������빤�ţ��޸ĸù�Ա�Ļ�����Ϣ
	 * @return   �޸���Ϣ���ְԱ����
	 */
	public Employee modifyEmployeeMsg() {
		boolean flag = false;
		String name = "";//Ա������
		int y,m,d;//Ա����ְ�꣬�£���
		double salary;//Ա����������
		String position = "";//Ա���������š�ְλ����
		String tel;//�绰����
		System.out.println("������Ҫ����Ա����Ա����");
		int num = scan.nextInt();
		name = scan.nextLine();

		for(int i = 0;i < nextId;i++){
			if(num == employees[i].getId()){

				System.out.println("�������޸ĺ�Ա������");
				name = scan.nextLine();
				System.out.println("�������޸ĺ�Ա������ְ��");
				y = scan.nextInt();
				System.out.println("�������޸ĺ�Ա������ְ��");
				m = scan.nextInt();
				System.out.println("�������޸ĺ�Ա������ְ��");
				d = scan.nextInt();
				System.out.println("�������޸ĺ�Ա���Ļ�������");
				salary = scan.nextDouble();
				position = scan.nextLine();
				System.out.println("�������޸ĺ�Ա�����������š�ְλ����");
				position = scan.nextLine();
				System.out.println("�������޸ĺ�Ա���ĵ绰����");
				tel = scan.nextLine();
				Employee employee = new Employee(num,name,y,m,d,salary,position,tel);
				employees[i] = employee;
				System.out.println(1);
				flag = true;
				break;
			}
		}

		if(flag == false){
			System.out.println("�޸�ʧ�ܣ�Ϊ�ҵ�����Ϊ" + num + "��Ա��");
		}
		return null;
	}
	/**
	 * ����������
	 */
	public void  sortEmployee() {
		System.out.println("******************************");
		System.out.println("������������˵�����,������ѡ��");
		System.out.println("����salary��salary����");
		System.out.println("����Hire�򰴹�Ӷ��������");
		System.out.println("����id�򰴹�������");
		System.out.println("����DaySalary������нˮ��������");
		System.out.println("����back�˳�����ģ��");
		System.out.println("***************************");
		String select="";
		do {
			//������scan���������������
			select = scan.nextLine();
			if(select.equals("salary")){
				sortEmployeeBySalary();
				System.out.println("��salary�����");
				showAllEmployee();
			} else if(select.equals("Hire")){
				sortEmployeeByHireTime();
				System.out.println("��HireTime�����");
				showAllEmployee();
			}else if(select.equals("id")){
				sortEmployeeById();
				System.out.println("��id�����");
				showAllEmployee();
			}else if(select.equals("DaySalary")){
				sortEmployeeByDayAndSalary();
				System.out.println("��id�����");
				showAllEmployee();
			}else {
				showAllEmployee();
			}	
		}while(select.equals("back")== false);
		
	}
	
	/**
	 * ����н�ʸߵ�����
	 * ʹ��List.sort()����
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
	 * *����ʹ��lambda���ʽ���򻯱Ƚ����������
	 */
	public void sortEmployeeById() {
		Arrays.sort(employees,0,nextId,(first,second) ->{
		        return first.getId()-second.getId();
		});
	}
	/**
	 * *����ʹ�ú���ʽ���򻯱Ƚ����������
	 * �ú����Ȱ���Ӷ���ڵĸߵ����������ͬ�ٰ�нˮ����
	 */
    public  void  sortEmployeeByDayAndSalary() {
    	Arrays.sort(employees , 
    			    0,
    			    nextId,
    			    Comparator.comparing(Employee::getHireDay).thenComparing(Employee::getSalary));
    }
	/**
	 * ������ְʱ�䳤������
	 * ʹ��List.sort()����
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
	 * �����Ա��Ϣ���ļ�
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
	 * ����Ա��Ϣ����ѡ���ļ�
	 */
	public  void savaAsEmployeesToFile() {
		System.out.println("������Ҫ���Ϊ���ļ�������׺�����磺employees.dat��");
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
	 * ��ĳ�ļ��������Ա��Ϣ
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
	 * ����ѡ�ļ��������Ա��Ϣ
	 * @return
	 */
	public Boolean openFile() {

		System.out.println("������Ҫ�򿪵��ļ�������׺�����磺employees.dat��");
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
	 * ���㰴ĳ����������Ա�����ʺ���ܹ���
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
