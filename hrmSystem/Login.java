package kosa.hrmSystem;

import java.util.List;

import kosa.hrmSystem.dao.StaffDB;
import kosa.hrmSystem.employees.Employee;

public class Login {
	public static Employee login(StaffDB db) {
//        로그인 성공한 사원의 인스턴스를 받기위한 변수
		Employee em = null;
//        StaffDB인스턴스에서 모든 배열을 가져옴
		List<Employee> allEmployee = db.readDB();

		while (true) {
			System.out.print("직원 ID를 입력하세요: ");
			String employeeId = ScannerTool.sc.nextLine();
			System.out.print("pw를 입력하세요: ");
			String employeePw = ScannerTool.sc.nextLine();
			for (Employee employee : allEmployee) {
				
				if (employee.getEmployeeId().equals(employeeId)&&employee.getEmployeePw().equals(employeePw)) {
					System.out.println("로그인 성공!");
					em = employee;
					return em;
				}
				
			}
			System.out.println("실패! 다시시도해주세요");
		}


	}
}
