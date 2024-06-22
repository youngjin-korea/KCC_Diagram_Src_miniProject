package kosa.hrmSystem.hr.salaryMg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kosa.hrmSystem.dao.StaffDB;
import kosa.hrmSystem.employees.Employee;

public class SalaryPrint implements BasicSalary {
	Scanner sc = new Scanner(System.in);
	private StaffDB db;
	private List<Employee> employeeList;

	ArrayList<SalaryMath> arr = new ArrayList<SalaryMath>();

	public SalaryPrint(StaffDB db) {
		this.db = db;
		this.employeeList = db.readDB();

	}

	@Override
	public void work() {

		for (Employee employee : employeeList) {
			SalaryMath cb = new SalaryMath();
			cb.setName(employee.getName());
			cb.setJobRank(employee.getCompanyLevel());
			arr.add(cb);
		}

	}

	@Override
	public void search() { // 사원이름 검색 >> 사원 월급출력
		System.out.println("사원 이름 입력: ");
		String searchName = sc.nextLine();
		boolean right = true;

		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).getName().equals(searchName)) {
				right = false;
				arr.get(i).getLevelSalary();
				arr.get(i).getRating();
				System.out.println("이름: " + arr.get(i).getName());
				System.out.println("직급: " + arr.get(i).getJobRank());
				System.out.println("기본급: " + arr.get(i).getStandardSalary());
				System.out.println("수당: " + arr.get(i).getBonus());
				System.out.println("세율: " + arr.get(i).getRating());
				System.out.println("월급: " + arr.get(i).getMonthSalary());
				break;
			}
		}

		if (right) {
			System.out.println("사원이 존재하지않습니다.");
		}
	}

	@Override
	public void salaryAllview() { // 전체 사원 >> 월급 전체 출력
		System.out.println("==========모든 사원 정보 출력==========");
		System.out.println("--------------------------------------------------");
		System.out.println("| 이름  | 직급 |  기본급   |  수당   | 세율  |  월급    |");
		System.out.println("--------------------------------------------------");
		for (int i = 0; i < arr.size(); i++) {
//	         System.out.println("|" + arr.get(i).getName() + "| " + arr.get(i).getJobRank() + " | "
//	               + arr.get(i).getStandardSalary() + "  | " + arr.get(i).getBonus() + " | " 
//	               + arr.get(i).getRating() + " | " + arr.get(i).getMonthSalary() + " |");
			System.out.printf("| %-4s | %-6s | %8d | %7s | %6.4f | %8d |\n", arr.get(i).getName(),
					arr.get(i).getJobRank(), arr.get(i).getStandardSalary(), arr.get(i).getBonus(),
					arr.get(i).getRating(), arr.get(i).getMonthSalary());
		}

	}

}
