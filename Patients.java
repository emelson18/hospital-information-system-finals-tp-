/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tryhis;

/**
 *
 * @author Grapevine Homecare
 */
public class Patients {
    private String firstName, middleName, lastName, admissionDate, status;
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }
    
    public void setMiddleName(String middleName){
        this.middleName = middleName;
    }
    public String getMiddleName(){
        return middleName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setAdmissionDate(String admissionDate){
        this.admissionDate = admissionDate;
    }
    public String getAdmissionDate(){
        return admissionDate;
    }
    public void setStatus (String status){
        this.status = status;
    }
    public String getStatus(){
        return status;
    }
}
