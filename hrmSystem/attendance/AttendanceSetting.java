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

		List<Integer> vacation = new ArrayList<>(); // 휴가번째 인덱스
		List<Integer> workQust = new ArrayList<>(); // 외근번째 인덱스
		List<Integer> business = new ArrayList<>(); // 출장번째 인덱스

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
		System.out.println("1.휴가승인 "+vacation.size() +"건\t\t2.외근승인 "+workQust.size()+ "건\t\t3.출장승인"+business.size()+"건");
		String str = sc.nextLine();
		switch (str) {
		case "1":
			if(vacation.size()==0) System.out.println("휴가 신청 건이 없습니다.");
			for (int i = 0; i < allEmployee.size(); i++) {
				Employee employee = allEmployee.get(i);
				if (employee.getVacationState() != null && employee.getVacationState().equals(StateType.pending)) {
					System.out.println( employee.getName() + "님의 휴가신청");
					System.out.println("1.승인\t\t2.거절\t\t3.뒤로가기");
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
			if(workQust.size()==0) System.out.println("외근 신청 건이 없습니다.");
			for (int i = 0; i < allEmployee.size(); i++) {
				Employee employee = allEmployee.get(i);
				if (employee.getWorkOutsideState() != null && employee.getWorkOutsideState().equals(StateType.pending)) {
					System.out.println( employee.getName() + "님의 외근신청");
					System.out.println("1.승인\t\t2.거절\t\t3.뒤로가기");
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
			if(business.size()==0) System.out.println("출장 신청 건이 없습니다.");
			for (int i = 0; i < allEmployee.size(); i++) {
				Employee employee = allEmployee.get(i);
				if (employee.getBusinessTripState() != null && employee.getBusinessTripState().equals(StateType.pending)) {
					System.out.println( employee.getName() + "님의 휴가신청");
					System.out.println("1.승인\t\t2.거절\t\t3.뒤로가기");
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
			System.out.println("잘못 입력 하셨습니다.");
			break;
		}
	}

}
