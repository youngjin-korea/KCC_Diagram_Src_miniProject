package kosa.hrmSystem.attendance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import kosa.hrmSystem.dao.StaffDB;
import kosa.hrmSystem.employees.Employee;
import kosa.hrmSystem.enums.StateType;

public class AttendanceMg {
	private StaffDB db;
	private List<Employee> allEmployee;
	private Map<String, String> workWrite;

	public AttendanceMg(StaffDB db) {
		this.db = db;
		this.allEmployee = db.readDB(); // �� �������� DB���� ���� �����͸� �о�ɴϴ�.
		this.workWrite = new HashMap<>(); // ����� ����� ������ ���� �ʱ�ȭ�մϴ�.
	}

	// ���
	public void startWork(String id) {
		workWrite.put(id, "���");
	}

	// ���
	public void endWork(String id) {
		workWrite.put(id, "���");
	}

	// ����� ��Ȳ ��ȸ
	public void commute() {
		Iterator<String> iter = workWrite.keySet().iterator();
		List<String> keys = new ArrayList<String>();
		while (iter.hasNext()) {
			String key = iter.next();
			keys.add(key);
			String value = workWrite.get(key);
			System.out.println(key);

		}

		
	}

	// ����� ��Ȳ ��ȸ
	public void printAttendanceRecords() {
		for (String id : workWrite.keySet()) {
			String records = workWrite.get(id);
			System.out.println("Employee ID: " + id);
			System.out.println("����� ���:");

			System.out.println(records);

			System.out.println("------------------");
		}
	}
	
	// �ް���û
	public void vacationReq(String userId) {
		for (Employee employee : allEmployee) {
			if(employee.getEmployeeId().equals(userId)) {
				employee.setVacationState(StateType.pending);
				return;
			}
		}
	}
	
	// �ܱٽ�û
	public void workQutsideReq(String userId) {
		for (Employee employee : allEmployee) {
			if(employee.getEmployeeId().equals(userId)) {
				employee.setWorkOutsideState(StateType.pending);
				return;
			}
		}
	}
	
	// �����û
	public void businessTripReq(String userId) {
		for (Employee employee : allEmployee) {
			if(employee.getEmployeeId().equals(userId)) {
				employee.setWorkOutsideState(StateType.pending);
				return;
			}
		}
	}
	
	// ������ ��ȸ(usecase���� ���� �߰��� - �¿�)
	public void showCase(String userId) {
		for (Employee employee : allEmployee) {
			if (employee.getEmployeeId().equals(userId)) {
				if (employee.getVacationState() != null) {
					System.out.println("�ް� ���� : " + employee.getVacationState());
				}
				if (employee.getWorkOutsideState() != null) {
					System.out.println("�ܱ� ����: " + employee.getWorkOutsideState());
				}
				if (employee.getBusinessTripState() != null) {
					System.out.println("���� ����: " + employee.getBusinessTripState());
				}
				
			}

		}
		return;
	}
	
	

}
