package kosa.hrmSystem.hr.salaryMg;

import kosa.hrmSystem.enums.CompanyLevel;

public class SalaryMath {
	private String name;
	private CompanyLevel jobRank; // 직급
	private int standardSalary = 2000000; // 기본급
	private int bonus; // 수당
	private double rating; // 세율이 얼마인지
	private int monthSalary; // 월급
	private int levelSalary;

	public SalaryMath() {
	}

	public int getMonthSalary() {
		monthSalary = (int) ((bonus + levelSalary) * (1.0 - rating));
		return monthSalary;
	}

	public int getLevelSalary() {
		levelSalary += standardSalary;
		if (jobRank == CompanyLevel.clerk) {
			levelSalary += 0;
			return levelSalary;
		} else if (jobRank == CompanyLevel.am) {
			levelSalary += 2000000;
			return levelSalary;
		} else if (jobRank == CompanyLevel.manager) {
			levelSalary += 3000000;
			return levelSalary;
		} else if (jobRank == CompanyLevel.dgm) {
			levelSalary += 4000000;
			return levelSalary;
		} else if (jobRank == CompanyLevel.gm) {
			levelSalary += 6000000;
			return levelSalary;
		} else {
			return levelSalary;
		}
	}

	public double getRating() {
		if (levelSalary <= 4000000) {
			rating = 0.15;
			return rating;
		} else if (levelSalary > 4000000 && levelSalary < 7000000) {
			rating = 0.24;
			return rating;
		} else {
			rating = 0.35;
			return rating;
		}

	}

	public SalaryMath(String name, CompanyLevel jobRank, int standardSalary, int bonus, double rating,
			int monthSalary) {
		super();
		this.name = name;
		this.jobRank = jobRank;
		this.standardSalary = standardSalary;
		this.bonus = bonus;
		this.rating = rating;
		this.monthSalary = monthSalary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CompanyLevel getJobRank() {
		return jobRank;
	}

	public void setJobRank(CompanyLevel companyLevel) {
		this.jobRank = companyLevel;
	}

	public int getStandardSalary() {
		return standardSalary;
	}

	public void setStandardSalary(int standardSalary) {
		this.standardSalary = standardSalary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

}