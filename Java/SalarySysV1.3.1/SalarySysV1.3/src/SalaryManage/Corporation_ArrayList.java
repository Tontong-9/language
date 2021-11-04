
package SalaryManage;

import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;


public class Corporation_ArrayList {//�����࣬���װ����䣬����ȫ�����ǲ������ݵ����ͣ��������ࣨlist��dict��str���ϸ���룬��������ƥ��

	private String corpName;  //��˾��
	private String corpDescript;  //��˾ҵ������
	private String superManager;  //��˾����
	
	private  ArrayList<Employee>  employees; //������Ź�˾��Ա������
	
    private  Scanner  scan; //���ںܶ෽������Ҫ�����������ݣ����Խ�scan����������Աʹ��

	public static void main(String[] args) {
		
		Corporation_ArrayList corp = new Corporation_ArrayList("�Ϻ���Ժ������޹�˾", "ר�Ŵ�����ҵ��Ӧ�ÿ���","����ʦ");

		corp.showMainUI();
		
		//��ʾ�����棬���ȴ�����˵�ѡ���ִ����ѡ����
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
		System.out.println("����open:���ļ�����ְԱ��Ϣ");
		System.out.println("����saveB:����Ϊ�������ļ�d:\\employees.dat");
		System.out.println("����openB:�򿪶������ļ�d:\\employees.dat����ְԱ��Ϣ");
		System.out.println("����saveT:����Ϊ�ı��ļ�d:\\employees.txt");
		System.out.println("����openT:���ı�d:\\employees.txt����ְԱ��Ϣ");
		System.out.println("����saveO:�����л�����ְԱ��Ϣd:\\employees2.dat");
		System.out.println("����openO:�����л���ְԱ��Ϣd:\\employees2.dat");
		System.out.println("����save as:���Ϊ...ְԱ��Ϣ");
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
	 * ��ʼ��4λְ����Ϣ���ֶ���ʼ���������
	 */
	private void initEmployee() {
		Employee employee01 = new Employee("����",2020,12,10,10000.0,"ѧ��","111");
		employees.add(employee01);

		Employee employee02 = new Employee("����",2020,12,1,5000.0,"��ʦ","222");
		employees.add(employee02);
		
		Employee employee03 = new Employee("����",2020,1,10,3000.0,"�쵼","333");
		employees.add(employee03);

		Employee employee04 = new Employee("����",2019,6,28,50000.0,"У��","444");
		employees.add(employee04);

		Manager employee05 = new Manager("����",2019,6,28,60000.0,"У��","444",8000);
		employees.add(employee05);
		
		Manager employee06 = new Manager("����",2019,5,28,10000.0,"У��","444",2000);
		employees.add(employee06);
		
		Employee employee07 = new Employee("������d",2019,6,28,18000.0,"У��","444");
		employees.add(employee07);
		System.out.println("ְ�����ݳ�ʼ���ɹ�������");
	}

	/**
	 * չʾ����Ա����Ϣ
	 */
	public void showAllEmployee(){
        for(Employee e : employees)
        	System.out.println(e.toString());
	}
	
	/**
	 * ���һְԱ���Ӽ������������Ϣ��
	 * @return ����Ŀǰ��˾�ĵ�ǰְԱ��
	 */
	public int  addOneEmployee() {
		
		System.out.println("��������һְԱ����,�밴��ʽ��������");
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
			employees.add(mang);
			System.out.println("��Ӿ���ɹ�");
		}else {
			Employee employee = new Employee(name,y,m,d,salary,position,tel);
            employees.add(employee);
			System.out.println("���Ա���ɹ�");
		}
		return employees.size();
	}
	
	/**
	 * ɾ��һְԱ,�Ӽ�������Ҫɾ��ְԱ�Ĺ���
	 *  @return  Ŀǰ��˾�ĵ�ǰְԱ��
	 */
	public  int  delOneEmployee() {

		System.out.println("����ɾ��һְԱ����,������Ҫɾ��Ա���Ĺ���");
		//������scan���������������
		int id = scan.nextInt();
		
		//�õ������ķ�������������Ч�ʸ���
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
				System.out.println("ɾ������ʧ�ܣ�δ�ҵ�����Ϊ" + id +"��Ա��");
		else
			employees.remove(nfind);
		return employees.size();
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
			ArrayList<Employee> finds = searchEmployeesByName(name);
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
		
		Employee find = null;
		//�õ������ķ�������������Ч�ʸ���
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
	 * ����ְԱ��������ְԱ��Ϣ
	 * @param name   ����
	 * @return  ���ҵ��Ķ��ְԱ��Ϣ����Ϊ�п�������
	 */	
	public ArrayList<Employee> searchEmployeesByName(String name) {

        ArrayList<Employee> find = new ArrayList<Employee>();
		//�õ������ķ�������������Ч�ʸ���
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
		Employee find = searchEmployeeById(num);
		if(find == null) {
			System.out.println("û���ҵ��ù��ŵ�Ա��");return null;
		}
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
		find.setMsg(name,y,m,d,salary,position,tel);
		return find;
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
		employees.sort(
				Comparator.comparing(Employee::getSalary).reversed());
	}
	
	/**
	 * *����ʹ��lambda���ʽ���򻯱Ƚ����������
	 */
	public void sortEmployeeById() {
		employees.sort((first,second) ->{
		        return first.getId()-second.getId();
		});
	}
		 
	/**
	 * ������ְʱ�䳤������
	 * ʹ��List.sort()����
	 */
	public void sortEmployeeByHireTime() {
		employees.sort(
				Comparator.comparing(Employee::getHireDay).reversed());
	}
	
	
	/**
	 * *����ʹ�ú���ʽ���򻯱Ƚ����������
	 * �ú����Ȱ���Ӷ���ڵĸߵ����������ͬ�ٰ�нˮ����
	 */
    public  void  sortEmployeeByDayAndSalary() {
    	employees.sort(Comparator.comparing(Employee::getHireDay).thenComparing(Employee::getSalary));
    }
   
	
	/**
	 * �����Ա��Ϣ���ļ�
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
	 * ����Ա��Ϣ����ѡ���ļ�
	 */
	public  void savaAsEmployeesToFile() {
		System.out.println("������Ҫ���Ϊ���ļ�������׺�����磺employees.dat��");
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
	 * �Զ������ֽڵ���ʽ����������ְ������
	 * @������̣���д��ְ��������
	 *         ��ѭ��д��ÿ��ְԱ����Ϣ��������Ϣ���ֽ���+�����ֽڣ�	 
	 * */
	public void  saveAsBinaryFile(String filename) {
		DataOutputStream  out = null;
		try {
			//ʹ��DataOutputStream����д��������͵�����
			out = new DataOutputStream(
					new BufferedOutputStream(
					   new FileOutputStream(filename)));
			out.writeInt(employees.size());//��д��ְԱ������
			for(Employee e : employees) {
				String emsg = e.toString();
				byte[] msg = emsg.getBytes();
				System.out.println(""+msg.length);
				out.writeInt(msg.length);
				out.write(msg);
				System.out.println(emsg);				
			}
			System.out.println("�������ݳɹ�");
			out.close();
			
		}catch(IOException e) {
			System.out.println(e);
		}
	}

	/**
	 * �򿪶������ļ�������ȡ����ְ������
	 * ��ȡ���̣��ͱ������ݵĹ�����ƥ��
	 * */
	public void openAsBinaryFile(String filename) {
		DataInputStream in = null;
		try {
			in = new DataInputStream(new BufferedInputStream(
					   new FileInputStream(filename)));
			int number = 0; //�ȶ���ְԱ������
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
	 * ���ı���ʽ����ʽ����������ְ������
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
			   System.out.println("�����ı��ɹ�");
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
	
	//��Ҫ���������һ���ַ���������ĳ����Ա�ľ�����Ϣ
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

}
