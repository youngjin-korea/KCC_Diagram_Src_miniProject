package kosa.hrmSystem.attendance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import kosa.hrmSystem.dao.StaffDB;
import kosa.hrmSystem.employees.Employee;
import kosa.hrmSystem.enums.StateType;

public class AttendanceSetting {
	private String startTimeStandard, endTimeStandard;
	private StaffDB db;
	private Scanner sc = new Scanner(System.in);

	public AttendanceSetting() {
	}

	public AttendanceSetting(StaffDB db) {
		super();
		this.db = db;
	}

	public void attendanceApproval() {
		List<Employee> allEmployee = db.readDB();

		List<Integer> vacation = new ArrayList<>(); // �ް���° �ε���
		List<Integer> workQust = new ArrayList<>(); // �ܱٹ�° �ε���
		List<Integer> business = new ArrayList<>(); // �����° �ε���

		for (int i = 0; i < allEmployee.size(); i++) {
			Employee employee = allEmployee.get(i);

			if (employee.getVacationState() != null && employee.getVacationState().equals(StateType.pending)) {
				vacation.add(i);
			}
			if (employee.getWorkOutsideState() != null && employee.getWorkOutsideState().equals(StateType.pending)) {
				workQust.add(i);
			}
			if (employee.getBusinessTripState() != null && employee.getBusinessTripState().equals(StateType.pending)) {
				business.add(i);
			}
		}
		System.out.println(vacation.size());
		System.out.println("1.�ް����� "+vacation.size() +"��\t\t2.�ܱٽ��� "+workQust.size()+ "��\t\t3.�������"+business.size()+"��");
		String str = sc.nextLine();
		switch (str) {
		case "1":
			if(vacation.size()==0) System.out.println("�ް� ��û ���� �����ϴ�.");
			for (int i = 0; i < allEmployee.size(); i++) {
				Employee employee = allEmployee.get(i);
				if (employee.getVacationState() != null && employee.getVacationState().equals(StateType.pending)) {
					System.out.println( employee.getName() + "���� �ް���û");
					System.out.println("1.����\t\t2.����\t\t3.�ڷΰ���");
					String userInput = sc.nextLine();
					if (userInput.equals("1")) {
						employee.setVacationState(StateType.commit);
						employee.toString();
						vacation.clear();
					}else if(userInput.equals("2")) {
						employee.setVacationState(StateType.reject);
						vacation.clear();
					}else if(userInput.equals("3")) {
						return;
					}
				}
			}
			System.out.println("--------------------------------------");
			break;
		case "2":
			if(workQust.size()==0) System.out.println("�ܱ� ��û ���� �����ϴ�.");
			for (int i = 0; i < allEmployee.size(); i++) {
				Employee employee = allEmployee.get(i);
				if (employee.getWorkOutsideState() != null && employee.getWorkOutsideState().equals(StateType.pending)) {
					System.out.println( employee.getName() + "���� �ܱٽ�û");
					System.out.println("1.����\t\t2.����\t\t3.�ڷΰ���");
					String userInput = sc.nextLine();
					if (userInput.equals("1")) {
						employee.setWorkOutsideState(StateType.commit);
						employee.toString();
						vacation.clear();
					}else if(userInput.equals("2")) {
						employee.setWorkOutsideState(StateType.reject);
						vacation.clear();
					}else if(userInput.equals("3")) {
						return;
					}
				}
			}
			System.out.println("--------------------------------------");
			break;
		case "3":
			if(business.size()==0) System.out.println("���� ��û ���� �����ϴ�.");
			for (int i = 0; i < allEmployee.size(); i++) {
				Employee employee = allEmployee.get(i);
				if (employee.getBusinessTripState() != null && employee.getBusinessTripState().equals(StateType.pending)) {
					System.out.println( employee.getName() + "���� �ް���û");
					System.out.println("1.����\t\t2.����\t\t3.�ڷΰ���");
					String userInput = sc.nextLine();
					if (userInput.equals("1")) {
						employee.setBusinessTripState(StateType.commit);
						employee.toString();
						vacation.clear();
					}else if(userInput.equals("2")) {
						employee.setBusinessTripState(StateType.reject);
						vacation.clear();
					}else if(userInput.equals("3")) {
						return;
					}
				}
			}
			System.out.println("--------------------------------------");
			break;

		default:
			System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
			break;
		}
	}

}
