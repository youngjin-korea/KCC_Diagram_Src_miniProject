package kosa.hrmSystem.employees;

import kosa.hrmSystem.enums.CompanyLevel;
import kosa.hrmSystem.enums.DepartmentType;
import kosa.hrmSystem.enums.StateType;

public class Employee {
    private String name, employeeId, employeePw;
    private DepartmentType departmentType;// 부서
    private StateType vacationState;      // 휴가
    private StateType workOutsideState;   // 외근
    private StateType businessTripState;  // 출장
    private CompanyLevel companyLevel;    // 직급
    
    //constructor
    public Employee() {
        this.vacationState = null;
    }
    
    // 복사 생성자
    public Employee(Employee other) {
        this.name = other.name;
        this.employeeId = other.employeeId;
        this.employeePw = other.employeePw;
        this.departmentType = other.departmentType;
        this.vacationState = other.vacationState;
        this.workOutsideState = other.workOutsideState;
        this.businessTripState = other.businessTripState;
        this.companyLevel = other.companyLevel;
    }

    public Employee(String name, String employeeId, String employeePw) {
		super();
		this.name = name;
		this.employeeId = employeeId;
		this.employeePw = employeePw;
	}
    
    public void copyFrom(Employee other) {
    	  this.name = other.name;
          this.employeeId = other.employeeId;
          this.employeePw = other.employeePw;
          this.departmentType = other.departmentType;
          this.vacationState = other.vacationState;
          this.workOutsideState = other.workOutsideState;
          this.businessTripState = other.businessTripState;
          this.companyLevel = other.companyLevel;
		
	}

	public Employee(String name, String employeeId, String employeePw, DepartmentType departmentType,
			StateType vacationState, StateType workOutsideState, StateType businessTripState,
			CompanyLevel companyLevel) {
		super();
		this.name = name;
		this.employeeId = employeeId;
		this.employeePw = employeePw;
		this.departmentType = departmentType;
		this.vacationState = vacationState;
		this.workOutsideState = workOutsideState;
		this.businessTripState = businessTripState;
		this.companyLevel = companyLevel;
	}

	//    method

    public Employee(String name) {
		this.name=name;
	}

	@Override
	public String toString() {
		return "직원 [이름=" + name 
				+ " 부서=" + departmentType + ", 휴가신청상태=" + vacationState + ", 출장신청상태="
				+ workOutsideState + ", 외근신청상태=" + businessTripState + ", 직급=" + companyLevel
				+ "]";
	}

	//    setter getter
    public StateType getBusinessTripState() {
        return businessTripState;
    }

    public void setBusinessTripState(StateType businessTripState) {
        this.businessTripState = businessTripState;
    }

    public DepartmentType getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(DepartmentType departmentType) {
        this.departmentType = departmentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StateType getVacationState() {
        return vacationState;
    }

    public void setVacationState(StateType vacationState) {
        this.vacationState = vacationState;
    }

    public StateType getWorkOutsideState() {
        return workOutsideState;
    }

    public void setWorkOutsideState(StateType workOutsideState) {
        this.workOutsideState = workOutsideState;
    }

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeePw() {
		return employeePw;
	}

	public void setEmployeePw(String employeePw) {
		this.employeePw = employeePw;
	}

	public CompanyLevel getCompanyLevel() {
		return companyLevel;
	}

	public void setCompanyLevel(CompanyLevel companyLevel) {
		this.companyLevel = companyLevel;
	}

	
	
    
}
