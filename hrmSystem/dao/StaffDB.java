package kosa.hrmSystem.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import kosa.hrmSystem.employees.Employee;
import kosa.hrmSystem.employees.Executives;
import kosa.hrmSystem.employees.GeneralEmployee;
import kosa.hrmSystem.employees.HrStaff;
import kosa.hrmSystem.enums.CompanyLevel;
import kosa.hrmSystem.enums.DepartmentType;
import kosa.hrmSystem.enums.StateType;

public class StaffDB {

	Scanner sc = new Scanner(System.in);

	private List<Employee> employeeList;
	public StaffDB() {
		employeeList=new ArrayList<Employee>();
		employeeList.add(new HrStaff("��¿�","aaa","1234"));
		employeeList.add(new GeneralEmployee("�迵��","bbb","1234"));
		employeeList.add(new Executives("������","ccc","1234"));
		employeeList.get(0).setVacationState(StateType.pending);
		employeeList.get(0).setCompanyLevel(CompanyLevel.am);
		employeeList.get(1).setCompanyLevel(CompanyLevel.clerk);
		employeeList.get(2).setCompanyLevel(CompanyLevel.gm);
		
		employeeList.get(2).setWorkOutsideState(StateType.pending);
		
		employeeList.add(new Executives("����","zzz","1234"));
		employeeList.get(3).setCompanyLevel(CompanyLevel.gm);
		
		
		employeeList.add(new Executives("����","yyy","1234"));
		employeeList.get(4).setCompanyLevel(CompanyLevel.gm);
		employeeList.get(4).setBusinessTripState(StateType.pending);
	}

	public void createDB(String name,String employeeId,String employeePw) {
		
		employeeList.add(new Employee(name, employeeId, employeePw)); ////�⺻Ʋ
		
	}

	public void updateDB(String employeeId) {
		for (Employee employee : employeeList) {
			if (employee.getEmployeeId().equals(employeeId)) {
				System.out.println("���泻�� �Է����ּ��� :");
				System.out.print("���̵� :");
				employee.setEmployeeId(sc.nextLine());
				System.out.print("��� :");
				employee.setEmployeePw(sc.nextLine());
				System.out.print("�̸� :");
				employee.setName(sc.nextLine());
			} else {
				System.out.println("");
			}
		}
	}

	public void deleteDB(String employeeId) {
		Employee employee = readDetail(employeeId);
		if (employee != null) {			
			employeeList.remove(employee);
		}else {
			throw new RuntimeException("�ش� ������ �����ϴ�");
		}
	}
	
	public Employee readDetail(String employeeId) {
		List<Employee> list = employeeList.stream()
				.filter(Id->Id.getEmployeeId().equals(employeeId))
				.collect(Collectors.toList());
		Employee employee=null;
		if (!list.isEmpty()) {
			employee = list.get(0);
		}
		return employee;
	}

	public List<Employee> readDB() {
		return employeeList;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
	
}
