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
	// 보류
	// public void hrRegistration(){}

	public void hrUpdate() {
		List<Employee> employees = db.readDB();
		Employee employee;
		
		DepartmentType[] arr = { DepartmentType.executives, DepartmentType.generalEmployee, DepartmentType.hrStaff };

		CompanyLevel[] arr2 = { CompanyLevel.gm, CompanyLevel.dgm, CompanyLevel.manager, CompanyLevel.am,
				CompanyLevel.clerk };

		while (true) {
			System.out.print("1.편집하기  2. 뒤로가기: ");
			String str = sc.nextLine();
			if (str.equals("2")) {
				System.out.println("원본");
				for (Employee origin : employees) {
					System.out.println(origin.toString());
				}
				System.out.println("임시");
				for (Employee test : pendingUpdate) {
					System.out.println(test.toString());
				}
				
				return;
			}
			if (str.equals("1")) {
				System.out.println("수정하실 직원의 ID를 입력: ");
				str = sc.nextLine();

				for (Employee e : employees) {
					if (e.getEmployeeId().equals(str)) {
						
						employee = new Employee(
								e.getName(), e.getEmployeeId(), e.getEmployeePw(),
								e.getDepartmentType(), e.getVacationState(), e.getWorkOutsideState(),
								e.getBusinessTripState(), e.getCompanyLevel()
								);
						System.out.println(employee.toString());

						System.out.println("바꿀 부서를 선택해주세요");
						System.out.println("1. 임직원  2. 인사과  3. 일반직원  4. 변경 안함");
						String str2 = sc.nextLine();
						if (!str2.equals("4"))
							employee.setDepartmentType(arr[Integer.parseInt(str2) - 1]);

						System.out.println("바꿀 직급을 선택해주세요");
						System.out.println("1. 부장  2. 차장  3. 과장  4. 대리  5. 사원  6. 변경 안함");
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
