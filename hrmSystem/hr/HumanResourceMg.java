package kosa.hrmSystem.hr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kosa.hrmSystem.dao.StaffDB;
import kosa.hrmSystem.employees.Employee;
import kosa.hrmSystem.enums.CompanyLevel;
import kosa.hrmSystem.enums.DepartmentType;

public class HumanResourceMg {
	StaffDB db;
	List<Employee> pendingUpdate = new ArrayList<Employee>();
	Scanner sc = new Scanner(System.in);

	public HumanResourceMg() {
	}

	public HumanResourceMg(StaffDB db) {
		super();
		this.db = db;
	}
	// ����
	// public void hrRegistration(){}

	public void hrUpdate() {
		List<Employee> employees = db.readDB();
		Employee employee;
		
		DepartmentType[] arr = { DepartmentType.executives, DepartmentType.generalEmployee, DepartmentType.hrStaff };

		CompanyLevel[] arr2 = { CompanyLevel.gm, CompanyLevel.dgm, CompanyLevel.manager, CompanyLevel.am,
				CompanyLevel.clerk };

		while (true) {
			System.out.print("1.�����ϱ�  2. �ڷΰ���: ");
			String str = sc.nextLine();
			if (str.equals("2")) {
				System.out.println("����");
				for (Employee origin : employees) {
					System.out.println(origin.toString());
				}
				System.out.println("�ӽ�");
				for (Employee test : pendingUpdate) {
					System.out.println(test.toString());
				}
				
				return;
			}
			if (str.equals("1")) {
				System.out.println("�����Ͻ� ������ ID�� �Է�: ");
				str = sc.nextLine();

				for (Employee e : employees) {
					if (e.getEmployeeId().equals(str)) {
						
						employee = new Employee(
								e.getName(), e.getEmployeeId(), e.getEmployeePw(),
								e.getDepartmentType(), e.getVacationState(), e.getWorkOutsideState(),
								e.getBusinessTripState(), e.getCompanyLevel()
								);
						System.out.println(employee.toString());

						System.out.println("�ٲ� �μ��� �������ּ���");
						System.out.println("1. ������  2. �λ��  3. �Ϲ�����  4. ���� ����");
						String str2 = sc.nextLine();
						if (!str2.equals("4"))
							employee.setDepartmentType(arr[Integer.parseInt(str2) - 1]);

						System.out.println("�ٲ� ������ �������ּ���");
						System.out.println("1. ����  2. ����  3. ����  4. �븮  5. ���  6. ���� ����");
						String str3 = sc.nextLine();
						if (!str3.equals("6"))
							employee.setCompanyLevel(arr2[Integer.parseInt(str3) - 1]);
						if(str2.equals("4") && str3.equals("6")) continue;
						else pendingUpdate.add(employee);
					}

				}

			}
		}
		
	}
	

	public List<Employee> hrApproveReq() {
		
		return pendingUpdate;
	}

	public List<Employee> getPendingUpdate() {
		return pendingUpdate;
	}

	public void setPendingUpdate(List<Employee> pendingUpdate) {
		this.pendingUpdate = pendingUpdate;
	}
	
	
}
