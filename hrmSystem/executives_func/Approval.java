package kosa.hrmSystem.executives_func;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import kosa.hrmSystem.dao.StaffDB;
import kosa.hrmSystem.employees.Employee;
import kosa.hrmSystem.employees.GeneralEmployee;
import kosa.hrmSystem.employees.JobSeeker;
import kosa.hrmSystem.enums.StateType;
import kosa.hrmSystem.hr.HumanResourceMg;

public class Approval {
	Scanner sc = new Scanner(System.in);
	private List<Employee> hrApprovalCase;
	private List<Employee> salaryApprovalCase;
	private List<JobSeeker> recruitmentApprovalCase;
	private StaffDB db;

	public void setHrApprovalCase(List<Employee> hrApprovalCase) {
		this.hrApprovalCase = hrApprovalCase;
	}

	// constructor
	public Approval(StaffDB db) {
		this.hrApprovalCase = new LinkedList<Employee>();
		this.salaryApprovalCase = new LinkedList<Employee>();
		this.recruitmentApprovalCase = new LinkedList<JobSeeker>();
		this.db=db;
		
	}

	// method
	public void hrApproval( HumanResourceMg hrm) {
		hrApprovalCase = hrm.getPendingUpdate();
		List<Employee> allEmployee=db.readDB();
		if (hrApprovalCase.isEmpty() == true) {
			System.out.println("���� �� �λ���� ���� �����ϴ�.");
			return;
		}
		System.out.println("������ ������ �����ϼ���: ");
		int cnt = 0;
		for (Employee employee : hrApprovalCase) {
			System.out.print(cnt+"��°)"+"�����̸�: "+employee.getName() + "����: "+employee.getDepartmentType()+"�μ�: "+employee.getCompanyLevel());
			cnt++;
		}
		cnt = 0;
		System.out.println();
		System.out.print("���� �� ����� ��ȣ�� �������� �����Ͽ� �Է��ϼ���:");
		String num = sc.nextLine();
		String[] arr=num.strip().split(" ");
		List<Employee> tmpList = new  ArrayList<Employee>();
		for (int i = 0; i < arr.length; i++) {
			tmpList.add(hrApprovalCase.get(Integer.parseInt(arr[i])));
		}
		for (Employee tmpEmployee : tmpList) {
	        for (Employee allEmp : allEmployee) {
	            if (allEmp.getEmployeeId().equals(tmpEmployee.getEmployeeId())) {
	                // ���� ������ ���� �����մϴ�
	                allEmp.copyFrom(tmpEmployee);
	            }
	        }
	    }
		tmpList.clear();
		for (Employee employee : allEmployee) {
			System.out.println(employee);
		}
		
	}

	public void salaryApproval() {
		if (salaryApprovalCase.isEmpty() == true) {
			System.out.println("���� �� �޿����� ���� �����ϴ�.");
			return;
		}
	}

	public void recruitmentApproval() {
		if (recruitmentApprovalCase.isEmpty() == true) {
			System.out.println("���� �� ä����� ���� �����ϴ�.");
			return;
		}
		System.out.println("++++++++ 1�� �հ��� ��� ++++++++");
		for (int i = 0; i<recruitmentApprovalCase.size();i++){
			JobSeeker jobSeeker = recruitmentApprovalCase.get(i);
			System.out.println((i+1)+") "+"ID: "+jobSeeker.getJobSeekerId()+" �̸�: "+jobSeeker.getName()+" ������¥: "+jobSeeker.getApplyDate()+" (��/��): "+jobSeeker.getIsPass());
		}
		System.out.println("++++++++ +++++++++++++ ++++++++");
		System.out.println("\n");
		System.out.print("�հݽ�ų �ĺ��� ������ ������ �������� �Է�: ");
		String id = sc.nextLine();
		System.out.println();
		System.out.println("++++++++ ä���� ��� ++++++++");
		String[] arr = id.strip().split(" ");
		for (String i : arr){
			JobSeeker e = recruitmentApprovalCase.get(Integer.parseInt(i)-1);
			e.setIsPass(StateType.commit);
			db.readDB().add(new GeneralEmployee(e.getName()));
			System.out.println("������ID: "+e.getJobSeekerId()+" ������ �̸�: "+e.getName()+" (��/��): "+e.getIsPass());
		}
	}

	public List<JobSeeker> getRecruitmentApprovalCase() {

		return recruitmentApprovalCase;
	}

	public List<Employee> getSalaryApprovalCase() {
		return salaryApprovalCase;
	}

	public void setSalaryApprovalCase(List<Employee> salaryApprovalCase) {
		this.salaryApprovalCase = salaryApprovalCase;
	}

	public List<Employee> getHrApprovalCase() {
		return hrApprovalCase;
	}

	public void setRecruitmentApprovalCase(List<JobSeeker> recruitmentApprovalCase) {
		this.recruitmentApprovalCase = recruitmentApprovalCase;
	}
	
	
}
