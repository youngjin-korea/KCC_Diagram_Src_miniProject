package kosa.hrmSystem.employees;

import java.time.LocalDate;

import kosa.hrmSystem.RecruitmentMg;
import kosa.hrmSystem.enums.StateType;

public class JobSeeker {

    //    field
    private StateType isPass; //  합/불 상태
	static int id;
	private int jobSeekerId;// 인덱스 번호
    private String name;// 이름
    private LocalDate applyDate; // 지원날짜
    
    
    // constructor
    public JobSeeker(String name) {
		this.name = name;
		this.jobSeekerId = id++;
        this.isPass = StateType.pending;
    }

	//	method
	public void apply(RecruitmentMg rm){
		rm.getJobSeekers().add(this);
		this.applyDate = LocalDate.now();
	}

	public StateType getIsPass() {
		return isPass;
	}

	public void setIsPass(StateType isPass) {
		this.isPass = isPass;
	}

	public int getJobSeekerId() {
		return jobSeekerId;
	}

	public void setJobSeekerId(int jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(LocalDate applyDate) {
		this.applyDate = applyDate;
	}
	
	
    
    
    
}
