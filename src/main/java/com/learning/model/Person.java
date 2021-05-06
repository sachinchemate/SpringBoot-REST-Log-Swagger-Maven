/**
 * 
 */
package com.learning.model;

import javax.validation.constraints.NotNull;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author SACHIN
 *
 */

@ApiModel(description="All details about the contact/user. ")
public class Person {

	@NotNull(message = "First Name cannot be null")
	private String firstName;
	@ApiModelProperty(notes = "Last Name should have atleast 2 character",required=true,value="test last name")
	private String lastName;

	/**
	 * @param firstName
	 * @param lastName
	 */
	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
