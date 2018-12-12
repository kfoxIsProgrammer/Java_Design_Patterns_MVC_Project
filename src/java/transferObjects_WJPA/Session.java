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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Session DTO with JPA assist
 *
 * @author kevin
 */
@Entity
@Table(name = "session")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Session.findAll", query = "SELECT s FROM Session s")
    , @NamedQuery(name = "Session.findByDateKey", query = "SELECT s FROM Session s WHERE s.sessionPK.dateKey = :dateKey")
    , @NamedQuery(name = "Session.findByTimeKey", query = "SELECT s FROM Session s WHERE s.sessionPK.timeKey = :timeKey")
    , @NamedQuery(name = "Session.findByStudentLastName", query = "SELECT s FROM Session s WHERE s.studentLastName = :studentLastName")
    , @NamedQuery(name = "Session.findBySessionStatus", query = "SELECT s FROM Session s WHERE s.sessionStatus = :sessionStatus")
    , @NamedQuery(name = "Session.findByTutorTutorID", query = "SELECT s FROM Session s WHERE s.sessionPK.tutorTutorID = :tutorTutorID")
    , @NamedQuery(name = "Session.findByCourseCourseCode", query = "SELECT s FROM Session s WHERE s.sessionPK.courseCourseCode = :courseCourseCode")
    , @NamedQuery(name = "Session.findByStudentStudentID", query = "SELECT s FROM Session s WHERE s.sessionPK.studentStudentID = :studentStudentID")})
public class Session implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Session Primary key (Composite of DateKey, TimeKey, CourseCode, StudentIDS
     * and TutorID
     */
    @EmbeddedId
    protected SessionPK sessionPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "StudentLastName")
    private String studentLastName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SessionStatus")
    private int sessionStatus;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "SessionTopic")
    private String sessionTopic;
    @JoinColumn(name = "tutor_TutorID", referencedColumnName = "TutorID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tutor tutor;
    @JoinColumn(name = "course_CourseCode", referencedColumnName = "CourseCode", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Course course;
    @JoinColumn(name = "student_StudentID", referencedColumnName = "StudentID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;

    /**
     * No Arg Constructor
     */
    public Session() {
    }

    /**
     * Session Constructor with the primary key composite of dateKey,timeKey,
     * courseCode,tutorID,StudentID
     *
     * @param sessionPK the primary composite key of Session table
     */
    public Session(SessionPK sessionPK) {
        this.sessionPK = sessionPK;
    }

    /**
     * Constructor with all parameters
     *
     * @param sessionPK the primary composite key of Session table
     * @param studentLastName student's last name
     * @param sessionStatus status of tutoring session
     * @param sessionTopic topic of tutoring session
     */
    public Session(SessionPK sessionPK, String studentLastName, int sessionStatus, String sessionTopic) {
        this.sessionPK = sessionPK;
        this.studentLastName = studentLastName;
        this.sessionStatus = sessionStatus;
        this.sessionTopic = sessionTopic;
    }

    /**
     * Constructor with parameters of primary key
     *
     * @param dateKey Date of tutor session
     * @param timeKey Time of tutor session
     * @param tutorTutorID the ID of the tutor
     * @param courseCourseCode the code for the course
     * @param studentStudentID the ID of the student
     */
    public Session(Date dateKey, Date timeKey, int tutorTutorID, String courseCourseCode, int studentStudentID) {
        this.sessionPK = new SessionPK(dateKey, timeKey, tutorTutorID, courseCourseCode, studentStudentID);
    }

    /**
     * Getter for Session Primary Key
     *
     * @return
     */
    public SessionPK getSessionPK() {
        return sessionPK;
    }

    /**
     * Setter for Session Primary Key
     *
     * @param sessionPK the primary compostie key
     */
    public void setSessionPK(SessionPK sessionPK) {
        this.sessionPK = sessionPK;
    }

    /**
     * Getter for studentLastName
     *
     * @return the student's last name
     */
    public String getStudentLastName() {
        return studentLastName;
    }

    /**
     * Setter for studentLastName
     *
     * @param studentLastName the student's last name
     */
    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    /**
     * Getter for sessionStatus
     *
     * @return the session's status
     */
    public int getSessionStatus() {
        return sessionStatus;
    }

    /**
     * Setter for sessionStatus
     *
     * @param sessionStatus status of current tutoring session
     */
    public void setSessionStatus(int sessionStatus) {
        this.sessionStatus = sessionStatus;
    }

    /**
     * Getter for sessionTopic
     *
     * @return the session's topic
     */
    public String getSessionTopic() {
        return sessionTopic;
    }

    /**
     * Setter for sessionTopic
     *
     * @param sessionTopic the topic of tutor session
     */
    public void setSessionTopic(String sessionTopic) {
        this.sessionTopic = sessionTopic;
    }

    /**
     * Getter for tutor
     *
     * @return the info of the tutor
     */
    public Tutor getTutor() {
        return tutor;
    }

    /**
     * Setter for tutor
     *
     * @param tutor the info about the tutor
     */
    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    /**
     * Getter for course
     *
     * @return the course of the tutor session
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Setter for course
     *
     * @param course the course info
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * Getter for student
     *
     * @return the student's info
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Setter for student
     *
     * @param student the info about the student
     */
    public void setStudent(Student student) {
        this.student = student;
    }

}
