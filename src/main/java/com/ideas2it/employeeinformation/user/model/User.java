package com.ideas2it.employeeinformation.user.model;

/**
 * User class is the Entity class is having the getters and setter methods
 * which is used to get the values from the user. This class acts as an Model
 * for the Admin Details.
 *
 * @author  Arul Murugan
 * @version 1.0
 */
public class User {

    private Integer id ;
    private String emailId;
    private String password;
    private String role;
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

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
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
     * @return  true     when the user object is the same.
     *          false    when the user object is not equal.
     */
    @Override
    public boolean equals(Object usr) {
	if (null == usr) {
	    return Boolean.FALSE;
	}

	if (getClass() != usr.getClass()) {
            return Boolean.FALSE;
	}

	User user = (User) usr;
	return (this.getId() == user.getId());
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
