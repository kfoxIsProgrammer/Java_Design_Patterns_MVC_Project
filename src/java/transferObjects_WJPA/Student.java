/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Student DTO with JPA assist
 *
 * @author kevin
 */
@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findByStudentID", query = "SELECT s FROM Student s WHERE s.studentID = :studentID")
    , @NamedQuery(name = "Student.findByLastName", query = "SELECT s FROM Student s WHERE s.lastName = :lastName")
    , @NamedQuery(name = "Student.findByFirstName", query = "SELECT s FROM Student s WHERE s.firstName = :firstName")
    , @NamedQuery(name = "Student.findByEmail", query = "SELECT s FROM Student s WHERE s.email = :email")
    , @NamedQuery(name = "Student.findByPhoneNumber", query = "SELECT s FROM Student s WHERE s.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "Student.findByIsATutor", query = "SELECT s FROM Student s WHERE s.isATutor = :isATutor")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "StudentID")
    private Integer studentID;
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
    @Size(max = 45)
    @Column(name = "PhoneNumber")
    private String phoneNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsATutor")
    private boolean isATutor;
    @JoinTable(name = "studentcourse", joinColumns = {
        @JoinColumn(name = "student_StudentID", referencedColumnName = "StudentID")}, inverseJoinColumns = {
        @JoinColumn(name = "course_CourseCode", referencedColumnName = "CourseCode")})
    @ManyToMany
    private List<Course> courseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Session> sessionList;

    /**
     * No Arg constructor
     */
    public Student() {
    }

    /**
     * Constructor with primary key
     *
     * @param studentID the student's ID
     */
    public Student(Integer studentID) {
        this.studentID = studentID;
    }

    /**
     * Constructor with all parameters
     *
     * @param studentID the ID of the student
     * @param lastName the last name of the student
     * @param firstName the first name of the student
     * @param isATutor is the student a tutor
     * @param email the email of the student
     * @param phoneNumber the phone number of the student
     */
    public Student(Integer studentID, String lastName, String firstName, boolean isATutor, String email, String phoneNumber) {
        this.studentID = studentID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.isATutor = isATutor;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter for studentID
     *
     * @return the student's ID number
     */
    public Integer getStudentID() {
        return studentID;
    }

    /**
     * Setter for studentID
     *
     * @param studentID the ID number of the student
     */
    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    /**
     * Getter for lastName
     *
     * @return the student's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for lastName
     *
     * @param lastName last name of the student
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for firstName
     *
     * @return the first name of the student
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for firstName
     *
     * @param firstName the first name of the student
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for email
     *
     * @return the student's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for email
     *
     * @param email the email of the student
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for phoneNumber
     *
     * @return the sutdent's phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter for phoneNumber
     *
     * @param phoneNumber the student's phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter for isATutor
     *
     * @return boolean is the student a tutor?
     */
    public boolean getIsATutor() {
        return isATutor;
    }

    /**
     * Setter for isATutor
     *
     * @param isATutor boolean is the student a tutor?
     */
    public void setIsATutor(boolean isATutor) {
        this.isATutor = isATutor;
    }

    /**
     * Used for getting list of courses from join table
     *
     * @return list of courses that the student has taken
     */
    @XmlTransient
    public List<Course> getCourseList() {
        return courseList;
    }

    /**
     * Used to set a list of courses in join table
     *
     * @param courseList a list of courses that student has taken
     */
    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    /**
     * Used to getting a list of sessions in join table
     *
     * @return list of sessions
     */
    @XmlTransient
    public List<Session> getSessionList() {
        return sessionList;
    }

    /**
     * Used for setting a list of sessions in join table
     *
     * @param sessionList list of sessions
     */
    public void setSessionList(List<Session> sessionList) {
        this.sessionList = sessionList;
    }

}
