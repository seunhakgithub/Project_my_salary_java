package salary;

import java.util.Date;

/**
 *
 * @author Seun Hak
 */
public class Data {

    Data(String ID, Date Dat, String Save) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the salary
     */
    public String getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(String salary) {
        this.salary = salary;
    }

    private String id;
    private String date;
    private String salary;
    

    public Data() {
    }

    public Data(String id, String date, String salary) {
        this.id = id;
        this.date = date;
        this.salary = salary;
    }

 

}
