package kosa.hrmSystem;

import java.util.List;

import kosa.hrmSystem.dao.StaffDB;
import kosa.hrmSystem.employees.Employee;

public class Login {
	public static Employee login(StaffDB db) {
//        �α��� ������ ����� �ν��Ͻ��� �ޱ����� ����
		Employee em = null;
//        StaffDB�ν��Ͻ����� ��� �迭�� ������
		List<Employee> allEmployee = db.readDB();

		while (true) {
			System.out.print("���� ID�� �Է��ϼ���: ");
			String employeeId = ScannerTool.sc.nextLine();
			System.out.print("pw�� �Է��ϼ���: ");
			String employeePw = ScannerTool.sc.nextLine();
			for (Employee employee : allEmployee) {
				
				if (employee.getEmployeeId().equals(employeeId)&&employee.getEmployeePw().equals(employeePw)) {
					System.out.println("�α��� ����!");
					em = employee;
					return em;
				}
				
			}
			System.out.println("����! �ٽýõ����ּ���");
		}


	}
}
