package kosa.hrmSystem.approve;

import java.util.ArrayList;
import java.util.List;

import kosa.hrmSystem.dao.StaffDB;
import kosa.hrmSystem.employees.Employee;
import kosa.hrmSystem.employees.HrStaff;

public class Approve {
	StaffDB db;

	public Approve() {
	};

	public Approve(StaffDB db) {
		super();
		this.db = db;
	}

	List<Employee> hrApprovalCase = new ArrayList<Employee>();
	List<Employee> allEmployee = db.getEmployeeList();

	// �λ� ����
	public void hrApproval() {
		hrApprovalCase.add(new HrStaff("��¿�","aaa","1234"));
		
		List<Employee> tmpEmployees = new ArrayList<Employee>();
		for (Employee employee : hrApprovalCase) {

		}
	}

}
