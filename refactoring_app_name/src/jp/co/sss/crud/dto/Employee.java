package jp.co.sss.crud.dto;

import jp.co.sss.crud.util.ConstantMsg;

public class Employee {
	
	private int emp_id;
	private String emp_name;
	private int gender;
	private String birthday;
	private int dept_id;
	private String dept_name;
	private Department department;

	public int getEmpId() {
		return emp_id;
	}
	public void setEmpId(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmpName() {
		return emp_name;
	}
	public void setEmpName(String emp_name) {
		this.emp_name = emp_name;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getDeptId() {
		return dept_id;
	}
	public void setDeptId(int dept_id) {
		this.dept_id = dept_id;
	}
	
	public String getDeptName() {
		return dept_name;
	}
	
	public void setDeptName(String dept_name) {
		this.dept_name = dept_name;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		Department d = new Department();
		String gender_ja = ""; 
		if (this.gender == 1) { 
			gender_ja = ConstantMsg.male; 
		} else if (this.gender == 2) { 
			gender_ja = ConstantMsg.female; 
		}else {
			gender_ja = ConstantMsg.kaitouNasi +"または" + ConstantMsg.etc;
		}
		
		return emp_id +"\t" + 
				emp_name + "\t" + 
				gender_ja + "\t" +
				birthday + "\t" +
				d.getDeptName();
		
	}
}
