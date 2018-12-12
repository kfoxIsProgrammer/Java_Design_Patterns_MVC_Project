/* 
 * This Project is the property of Kevin Fox.
 * Created for CST 8288 and George Kriger.
 * All Rights Reserved.
 */
package transferObjects_WJPA;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Tutor DTO with JPA assist
 *
 * @author kevin
 */
@Entity
@Table(name = "tutor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tutor.findAll", query = "SELECT t FROM Tutor t")
    , @NamedQuery(name = "Tutor.findByTutorID", query = "SELECT t FROM Tutor t WHERE t.tutorID = :tutorID")
    , @NamedQuery(name = "Tutor.findByLastName", query = "SELECT t FROM Tutor t WHERE t.lastName = :lastName")
    , @NamedQuery(name = "Tutor.findByFirstName", query = "SELECT t FROM Tutor t WHERE t.firstName = :firstName")
    , @NamedQuery(name = "Tutor.findByEmail", query = "SELECT t FROM Tutor t WHERE t.email = :email")
    , @NamedQuery(name = "Tutor.findByPhoneNumber", query = "SELECT t FROM Tutor t WHERE t.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "Tutor.findByStatus", query = "SELECT t FROM Tutor t WHERE t.status = :status")})
public class Tutor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TutorID")
    private Integer tutorID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "LastName")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "FirstName")
    private String firstName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "Email")
    private String email;
    @Size(max = 15)
    @Column(name = "PhoneNumber")
    private String phoneNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Status")
    private String status;
    @JoinTable(name = "tutorcourse", joinColumns = {
        @JoinColumn(name = "tutor_TutorID", referencedColumnName = "TutorID")}, inverseJoinColumns = {
        @JoinColumn(name = "course_CourseCode", referencedColumnName = "CourseCode")})
    @ManyToMany
    private List<Course> courseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tutor")
    private List<Session> sessionList;
    @JoinColumn(name = "experience_ExperienceID", referencedColumnName = "ExperienceID")
    @ManyToOne(optional = false)
    private Experience experienceExperienceID;

    /**
     * No Arg constructor
     */
    public Tutor() {
    }

    /**
     * Constructor with primary key
     *
     * @param tutorID tutor's ID number
     */
    public Tutor(Integer tutorID) {
        this.tutorID = tutorID;
    }

    /**
     * Constructor with all parameters
     *
     * @param tutorID the ID of the tutor
     * @param lastName the last name of the tutor
     * @param firstName the first name of the tutor
     * @param status status if the tutor is active
     * @param email email of the tutor
     * @param phoneNumber phone number of the tutor
     */
    public Tutor(Integer tutorID, String lastName, String firstName, String status, String email, String phoneNumber) {
        this.tutorID = tutorID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.status = status;
        this.email = email;
        this.phoneNumber = phoneNumber;

    }

    /**
     * Getter for tutorID
     *
     * @return the tutor's ID number
     */
    public Integer getTutorID() {
        return tutorID;
    }

    /**
     * Setter for tutorID
     *
     * @param tutorID the tutor's ID number
     */
    public void setTutorID(Integer tutorID) {
        this.tutorID = tutorID;
    }

    /**
     * Getter for lastName
     *
     * @return the tutor's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for lastName
     *
     * @param lastName the tutor's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for firstName
     *
     * @return the tutor's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for firstName
     *
     * @param firstName the tutor's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for email
     *
     * @return the tutor's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for email
     *
     * @param email the tutor's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for phoneNumber
     *
     * @return the tutor's phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter for phoneNumber
     *
     * @param phoneNumber the tutor's phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter for status
     *
     * @return is the tutor active?
     */
    public String getStatus() {
        return status;
    }

    /**
     * Setter for status
     *
     * @param status is the tutor active?
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Used to get list of courses from join table
     *
     * @return list of courses that tutor has taken
     */
    @XmlTransient
    public List<Course> getCourseList() {
        return courseList;
    }

    /**
     * Used to set a list of courses from join table
     *
     * @param courseList list of courses that the tutor has taken
     */
    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    /**
     * Used to get a list of sessions from join table
     *
     * @return list of sessions the tutor is in
     */
    @XmlTransient
    public List<Session> getSessionList() {
        return sessionList;
    }

    /**
     * Used to set a list of sessions from join table
     *
     * @param sessionList List of sessions the tutor is in
     */
    public void setSessionList(List<Session> sessionList) {
        this.sessionList = sessionList;
    }

    /**
     * Used to get experience ID from join table
     *
     * @return the experience ID of the tutor
     */
    public Experience getExperienceExperienceID() {
        return experienceExperienceID;
    }

    /**
     * Used to set expereince ID from join table
     *
     * @param experienceExperienceID the expereince ID of the
     */
    public void setExperienceExperienceID(Experience experienceExperienceID) {
        this.experienceExperienceID = experienceExperienceID;
    }

}
