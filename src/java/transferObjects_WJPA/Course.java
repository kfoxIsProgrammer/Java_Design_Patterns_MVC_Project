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
import javax.persistence.Lob;
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
 * Course DTO and JPA assist
 * @author kevin
 */
@Entity
@Table(name = "course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")
    , @NamedQuery(name = "Course.findByCourseCode", query = "SELECT c FROM Course c WHERE c.courseCode = :courseCode")
    , @NamedQuery(name = "Course.findByCourseName", query = "SELECT c FROM Course c WHERE c.courseName = :courseName")})

public class Course implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "CourseCode")
    private String courseCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CourseName")
    private String courseName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "CourseDescription")
    private String courseDescription;
    @ManyToMany(mappedBy = "courseList")
    private List<Student> studentList;
    @ManyToMany(mappedBy = "courseList")
    private List<Tutor> tutorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<Session> sessionList;
    /**
     * No arg constructor
     */
    public Course() {
    }
    /**
     * One Arg constructor using primary key
     * @param courseCode code of the course Primary Key
     */
    public Course(String courseCode) {
        this.courseCode = courseCode;
    }
    /**
     * 3 arg constructor
     * @param courseCode Primary key
     * @param courseName name of course
     * @param courseDescription description of course
     */
    public Course(String courseCode, String courseName, String courseDescription) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
    }
    /**
     * Getter of CourseCode
     * @return courseCode
     */
    public String getCourseCode() {
        return courseCode;
    }
    /**
     * Setter of courseCode
     * @param courseCode the courseCode
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    /**
     * Getter of courseName
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }
    /**
     * Setter of courseName
     * @param courseName course name
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    /**
     * Getter of courseDescription
     * @return courseDescription
     */
    public String getCourseDescription() {
        return courseDescription;
    }
    /**
     * Setter for courseDescription
     * @param courseDescription course description
     */
    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
    /**
     * Used to get list of students from join table
     * @return list of students
     */
    @XmlTransient
    public List<Student> getStudentList() {
        return studentList;
    }
    /**
     * Used to set studentList for join table
     * @param studentList list of student DTO's
     */
    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
    /**
     * Used to get list of tutors from join table
     * @return list of tutors
     */
    @XmlTransient
    public List<Tutor> getTutorList() {
        return tutorList;
    }
    /**
     * Used to set a list of tutors for the join table
     * @param tutorList list of tutor DTO's
     */
    public void setTutorList(List<Tutor> tutorList) {
        this.tutorList = tutorList;
    }
    /**
     * Used to get list of Sessions from join table
     * @return list of session DTO's
     */
    @XmlTransient
    public List<Session> getSessionList() {
        return sessionList;
    }
    /**
     * Used to set a list of sessions for the join table
     * @param sessionList 
     */
    public void setSessionList(List<Session> sessionList) {
        this.sessionList = sessionList;
    }

  
    
}
