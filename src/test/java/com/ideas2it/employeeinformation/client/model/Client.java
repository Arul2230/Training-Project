package com.ideas2it.employeeinformation.client.model;

import java.util.List;

import com.ideas2it.employeeinformation.project.model.Project;
import com.ideas2it.employeeinformation.address.model.Address;

/**
 * Client class is the Entity class is having the getters and setter methods
 * which is used to get the values from the user. This class acts as an Model
 * for the Client Details.
 *
 * @author  Arul Murugan
 * @version 1.0
 */
public class Client {

    private Integer id ;
    private String emailId;
    private String name;
    private String companyName;
    private List<Project> projects;
    private List<Address> addresses;
    private boolean isActive;

    // Getters and Setters for Employee Model.
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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


    /**
     * This Method is to Override the equals method and it compares to the
     * object having same value.
     *
     * @return  true     when the client object is the same.
     *          false    when the client object is not equal.
     */
    @Override
    public boolean equals(Object cli) {
	if (null == cli) {
	    return Boolean.FALSE;
	}

	if (getClass() != cli.getClass()) {
            return Boolean.FALSE;
	}

	Client client = (Client) cli;
	return (this.getId() == client.getId());
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
	result = prime * result ;
	return result;
    }
}
