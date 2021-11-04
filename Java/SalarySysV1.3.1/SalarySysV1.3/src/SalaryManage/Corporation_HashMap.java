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
	
	private String corpName;  //��˾��
	private String corpDescript;  //��˾ҵ������
	private String superManager;  //��˾����
	
	//������Ź�˾��Ա������ ӳ���ǲ��ù���-ְ������ʽ
	//��Ϊÿ��Ա���Ĺ��Ŷ��ǲ�ͬ��
	private  HashMap<Integer,Employee>  employees; 
	
    private  Scanner  scan; //���ںܶ෽������Ҫ�����������ݣ����Խ�scan����������Աʹ��

    //���Դ��룬ÿ�����ж����Լ��ϲ���ģ��
    public static void main(String[] args) {
		
    	Corporation_HashMap corp = new Corporation_HashMap("�Ϻ���Ժ������޹�˾", "ר�Ŵ�����ҵ��Ӧ�ÿ���","����ʦ");

		corp.showMainUI();
		
		//��ʾ�����棬���ȴ�����˵�ѡ���ִ����ѡ����
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
		
		System.out.println("ְ�����ݳ�ʼ���ɹ�������");
	}

	/**
	 * չʾ����Ա����Ϣ
	 */
	public void showAllEmployee(){
     
	}
	
	/**
	 * ���һְԱ���Ӽ������������Ϣ��
	 * @return ����Ŀǰ��˾�ĵ�ǰְԱ��
	 */
	public int  addOneEmployee() {

         return 0;
	}
	
	/**
	 * ɾ��һְԱ,�Ӽ�������Ҫɾ��ְԱ�Ĺ���
	 *  @return  Ŀǰ��˾�ĵ�ǰְԱ��
	 */
	public  int  delOneEmployee() {

        return 0;

	}
	
	/**
	 * ����ְԱ��Ϣ�Ĳ˵����
	 */
	public void searchEmployee() {
		
	
			
	}
	
	/**
	 * ���ݹ��Ų���ְԱ��Ϣ
	 * @return  ���ҵ���ְԱ��Ϣ
	 */
	public  Employee searchEmployeeById(int id) {
		
          return null;

	}
	/**
	 * ����ְԱ��������ְԱ��Ϣ
	 * @param name   ����
	 * @return  ���ҵ��Ķ��ְԱ��Ϣ����Ϊ�п�������
	 */	
	public ArrayList<Employee> searchEmployeesByName(String name) {

          return null;

	}
	
	/**
	 * �޸�ĳ��ְԱ�Ļ�����Ϣ
	 * �Ӽ������빤�ţ��޸ĸù�Ա�Ļ�����Ϣ
	 * @return   �޸���Ϣ���ְԱ����
	 */
	public Employee modifyEmployeeMsg() {

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
	
	}
	
	/**
	 * *����ʹ��lambda���ʽ���򻯱Ƚ����������
	 */
	public void sortEmployeeById() {
	
	}
		 
	/**
	 * ������ְʱ�䳤������
	 * ʹ��List.sort()����
	 */
	public void sortEmployeeByHireTime() {
		
	}
	
	
	/**
	 * *����ʹ�ú���ʽ���򻯱Ƚ����������
	 * �ú����Ȱ���Ӷ���ڵĸߵ����������ͬ�ٰ�нˮ����
	 */
    public  void  sortEmployeeByDayAndSalary() {
    	
    }
   
	
	/**
	 * �����Ա��Ϣ���ļ�
	 * @param fileName
	 */
	public void saveEmployeesToFile(String fileName) {
		
	}
	/**
	 * ����Ա��Ϣ����ѡ���ļ�
	 */
	public  void savaAsEmployeesToFile() {
	
	}
	
	/**
	 * ��ĳ�ļ��������Ա��Ϣ
	 * @param fileName
	 * @return
	 */
	public Boolean openFile(String fileName) {
		
		return true;
	}
	
	/**
	 * ����ѡ�ļ��������Ա��Ϣ
	 * @return
	 */
	public Boolean openFile() {

		

		return true;
	}
	
	/**
	 * �Զ������ֽڵ���ʽ����������ְ������
	 * @������̣���д��ְ��������
	 *         ��ѭ��д��ÿ��ְԱ����Ϣ��������Ϣ���ֽ���+�����ֽڣ�	 
	 * */
	public void  saveAsBinaryFile(String filename) {
		
	}

	/**
	 * �򿪶������ļ�������ȡ����ְ������
	 * ��ȡ���̣��ͱ������ݵĹ�����ƥ��
	 * */
	public void openAsBinaryFile(String filename) {
		
	}
	
	/**
	 * ���ı���ʽ����ʽ����������ְ������
	 * */
	public void  saveAsTextFile(String filename) {
		
	}
	
	public void  openAsTextFile(String filename) {
	
	}
	
	//��Ҫ���������һ���ַ���������ĳ����Ա�ľ�����Ϣ
	public static Employee  parseEmployee(String  content ) {
		
		return null;
	}

	public void saveAsObjectToFile(String filename) {
		
		
	}
	
	public void openAsObjectFile(String filename) {


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

