package kosa.hrmSystem.employees;

import kosa.hrmSystem.enums.CompanyLevel;
import kosa.hrmSystem.enums.DepartmentType;
import kosa.hrmSystem.enums.StateType;

public class Employee {
    private String name, employeeId, employeePw;
    private DepartmentType departmentType;// �μ�
    private StateType vacationState;      // �ް�
    private StateType workOutsideState;   // �ܱ�
    private StateType businessTripState;  // ����
    private CompanyLevel companyLevel;    // ����
    
    //constructor
    public Employee() {
        this.vacationState = null;
    }
    
    // ���� ������
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
		return "���� [�̸�=" + name 
				+ " �μ�=" + departmentType + ", �ް���û����=" + vacationState + ", �����û����="
				+ workOutsideState + ", �ܱٽ�û����=" + businessTripState + ", ����=" + companyLevel
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
