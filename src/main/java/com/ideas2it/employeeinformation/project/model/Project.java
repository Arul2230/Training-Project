package com.ideas2it.employeeinformation.project.model;

import java.util.List;

import com.ideas2it.employeeinformation.client.model.Client;
import com.ideas2it.employeeinformation.employee.model.Employee;

/**
 * Project class is the Entity class will be having the getters
 * and setters, which will be used to get the values from the user
 * and set the values to the Project Object.
 *
 * @author  Arul Murugan
 * @version 1.0
 */
public class Project {

    private int numberOfResources;
    private Integer id ;
    private String name;
    private String projectCode;
    private List<Employee> employees;
    private Integer clientId;
    private boolean isActive;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumberOfResources() {
        return this.numberOfResources;
    }

    public void setNumberOfResources(int numberOfResources) {
        this.numberOfResources = numberOfResources;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectCode() {
        return this.projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Integer getClientId() {
        return this.clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * This Method is to Override the equals method and it compares to the
     * object having same value.
     *
     * @return  true  when the employee object is the same.
     *          false when the employee object is not equal.
     */
    @Override
    public boolean equals(Object prj) {
	if (null == prj) {
	    return Boolean.FALSE;
	}

	if (getClass() != prj.getClass()) {
            return Boolean.FALSE;
	}

	Project project = (Project) prj;
	return (this.getId() == project.getId());
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
