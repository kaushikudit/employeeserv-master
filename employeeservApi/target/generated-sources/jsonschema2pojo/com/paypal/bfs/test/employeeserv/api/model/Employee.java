
package com.paypal.bfs.test.employeeserv.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Employee resource
 * <p>
 * Employee resource object
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "emp_id",
    "first_name",
    "last_name",
    "date_of_birth",
    "address"
})
public class Employee {

    /**
     * employee id
     * 
     */
    @JsonProperty("emp_id")
    @JsonPropertyDescription("employee id")
    private Integer empId;
    /**
     * first name
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    @JsonPropertyDescription("first name")
    private String firstName;
    /**
     * last name
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    @JsonPropertyDescription("last name")
    private String lastName;
    /**
     * date of birth
     * 
     */
    @JsonProperty("date_of_birth")
    @JsonPropertyDescription("date of birth")
    private String dateOfBirth;
    /**
     * address of employee
     * 
     */
    @JsonProperty("address")
    @JsonPropertyDescription("address of employee")
    private Address address;

    /**
     * employee id
     * 
     */
    @JsonProperty("emp_id")
    public Integer getEmpId() {
        return empId;
    }

    /**
     * employee id
     * 
     */
    @JsonProperty("emp_id")
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    /**
     * first name
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    /**
     * first name
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * last name
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    /**
     * last name
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * date of birth
     * 
     */
    @JsonProperty("date_of_birth")
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * date of birth
     * 
     */
    @JsonProperty("date_of_birth")
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * address of employee
     * 
     */
    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    /**
     * address of employee
     * 
     */
    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Employee.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("empId");
        sb.append('=');
        sb.append(((this.empId == null)?"<null>":this.empId));
        sb.append(',');
        sb.append("firstName");
        sb.append('=');
        sb.append(((this.firstName == null)?"<null>":this.firstName));
        sb.append(',');
        sb.append("lastName");
        sb.append('=');
        sb.append(((this.lastName == null)?"<null>":this.lastName));
        sb.append(',');
        sb.append("dateOfBirth");
        sb.append('=');
        sb.append(((this.dateOfBirth == null)?"<null>":this.dateOfBirth));
        sb.append(',');
        sb.append("address");
        sb.append('=');
        sb.append(((this.address == null)?"<null>":this.address));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
