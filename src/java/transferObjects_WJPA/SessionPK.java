/* 
 * This Project is the property of Kevin Fox.
 * Created for CST 8288 and George Kriger.
 * All Rights Reserved.
 */
package transferObjects_WJPA;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The Session's primary key DTO with JPA assist
 *
 * @author kevin
 */
@Embeddable
public class SessionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "DateKey")
    @Temporal(TemporalType.DATE)
    private Date dateKey;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TimeKey")
    @Temporal(TemporalType.TIME)
    private Date timeKey;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tutor_TutorID")
    private int tutorTutorID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "course_CourseCode")
    private String courseCourseCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "student_StudentID")
    private int studentStudentID;

    /**
     * No Arg constructor
     */
    public SessionPK() {
    }

    /**
     * Constructor with all values of primary key
     *
     * @param dateKey Date of tutor session
     * @param timeKey Time of tutor session
     * @param tutorTutorID the ID of the tutor
     * @param courseCourseCode the courseCode of course to be tutored
     * @param studentStudentID the ID of the student
     */
    public SessionPK(Date dateKey, Date timeKey, int tutorTutorID, String courseCourseCode, int studentStudentID) {
        this.dateKey = dateKey;
        this.timeKey = timeKey;
        this.tutorTutorID = tutorTutorID;
        this.courseCourseCode = courseCourseCode;
        this.studentStudentID = studentStudentID;
    }

    /**
     * Getter for dateKey
     *
     * @return the date of the session
     */
    public Date getDateKey() {
        return dateKey;
    }

    /**
     * Setter for dateKey
     *
     * @param dateKey the date of the session
     */
    public void setDateKey(Date dateKey) {
        this.dateKey = dateKey;
    }

    /**
     * Getter for timeKey
     *
     * @return the time of the tutor session
     */
    public Date getTimeKey() {
        return timeKey;
    }

    /**
     * Setter for timeKey
     *
     * @param timeKey the time of the tutor session
     */
    public void setTimeKey(Date timeKey) {
        this.timeKey = timeKey;
    }

    /**
     * Getter for tutorTutorID
     *
     * @return the tutor's ID
     */
    public int getTutorTutorID() {
        return tutorTutorID;
    }

    /**
     * Setter for tutorTutorID
     *
     * @param tutorTutorID the tutor's ID
     */
    public void setTutorTutorID(int tutorTutorID) {
        this.tutorTutorID = tutorTutorID;
    }

    /**
     * Getter for courseCourseCode
     *
     * @return the course code
     */
    public String getCourseCourseCode() {
        return courseCourseCode;
    }

    /**
     * Setter for courseCourseCode
     *
     * @param courseCourseCode the course code of the course
     */
    public void setCourseCourseCode(String courseCourseCode) {
        this.courseCourseCode = courseCourseCode;
    }

    /**
     * Getter studentStudentID
     *
     * @return the student's ID
     */
    public int getStudentStudentID() {
        return studentStudentID;
    }

    /**
     * Setter for studentStudentID
     *
     * @param studentStudentID the student's ID
     */
    public void setStudentStudentID(int studentStudentID) {
        this.studentStudentID = studentStudentID;
    }

}
