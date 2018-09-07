package com.ideas2it.employeeinformation.employee.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ideas2it.employeeinformation.address.model.Address;
import com.ideas2it.employeeinformation.commons.constants.Constants;
import com.ideas2it.employeeinformation.project.model.Project;
import com.ideas2it.employeeinformation.utils.DateUtil;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Employee class is the Entity class is having the getters and setter methods
 * which is used to get the values from the user. This class acts as an Model
 * for the Employee Details.
 *
 * @author  Arul Murugan
 * @version 1.0
 */
public class Employee {

    private Integer id ;
    private Long salary;
    private String emailId;
    private String name;
    private String role;
    private Date birthDate;
    private Date dateOfJoin;
    private List<Project> projects = new ArrayList<Project>();
    private List<Address> addresses = new ArrayList<Address>();
    private boolean isActive;

    // Getters and Setters for Employee Model.
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getSalary() {
        return this.salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getEmailId() {
        return this.emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @DateTimeFormat(pattern = Constants.DATE_FORMAT)
    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @DateTimeFormat(pattern = Constants.DATE_FORMAT)
    public Date getDateOfJoin() {
        return this.dateOfJoin;
    }

    public void setDateOfJoin(Date dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public List<Project> getProjects() {
        return this.projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Address> getAddresses() {
        return this.addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getAge() {
        return DateUtil.calculateDateDifference(birthDate);
    }

    /**
     * This Method is to Override the equals method and it compares to the
     * object having same value.
     *
     * @return  true     when the employee object is the same.
     *          false    when the employee object is not equal.
     */
    @Override
    public boolean equals(Object emp) {
	if (null == emp) {
	    return Boolean.FALSE;
	}

	if (getClass() != emp.getClass()) {
            return Boolean.FALSE;
	}

	Employee employee = (Employee) emp;
	return (this.getId() == employee.getId());
    }

    /**
     * This Method is to Override the Hashcode value and it is compared to the
     * object having same value and hashCode method returns the same
     * hashcode value for object having same values.
     *
     * @return  result   an int datatype containing the HashCode value of
     *                   the object.
     */
    @Override
    public int hashCode() {

        final int prime = 17;
	int result = 1;
	result = prime * result + getId();
	return result;
    }
}
