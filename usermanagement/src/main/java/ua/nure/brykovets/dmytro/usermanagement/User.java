package ua.nure.brykovets.dmytro.usermanagement;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class User implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    public User() {
    }

    public User(Long id, String firstName, String lastName, Date dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    /**
     * Returns a concatenation of user's first and last names
     * in format "lastName, firstName".
     * For example: "Brykovets, Dmytro"
     *
     * @return the concatenation of user's first and last names.
     */
    public String getFullName() {
        return this.lastName + ", " + this.firstName;
    }


    /**
     * Returns user's age based on his date of birth and current system date.
     *
     * @return the user's age.
     */
    public int getAge() {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

        calendar.setTime(this.dateOfBirth);
        int yearOfBirth = calendar.get(Calendar.YEAR);
        int monthOfBirth = calendar.get(Calendar.MONTH);
        int dayOfBirth = calendar.get(Calendar.DAY_OF_MONTH);

        int age = currentYear - yearOfBirth;
        if (currentMonth >= monthOfBirth && currentDay >= dayOfBirth) {
            return age;
        }
        return age - 1;
    }
}
