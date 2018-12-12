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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Experience DTO with JPA assist
 *
 * @author kevin
 */
@Entity
@Table(name = "experience")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Experience.findAll", query = "SELECT e FROM Experience e")
    , @NamedQuery(name = "Experience.findByExperienceID", query = "SELECT e FROM Experience e WHERE e.experienceID = :experienceID")})
public class Experience implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ExperienceID")
    private Integer experienceID;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "experienceExperienceID")
    private List<Tutor> tutorList;

    /**
     * No Arg constructor
     */
    public Experience() {
    }

    /**
     * Constructor with primary key
     *
     * @param experienceID primary key of experience
     */
    public Experience(Integer experienceID) {
        this.experienceID = experienceID;
    }

    /**
     * Constructor w all parameters
     *
     * @param experienceID primary key
     * @param description description of tutoring experience
     */
    public Experience(Integer experienceID, String description) {
        this.experienceID = experienceID;
        this.description = description;
    }

    /**
     * Getter for experienceID
     *
     * @return current expereienceID
     */
    public Integer getExperienceID() {
        return experienceID;
    }

    /**
     * Setter for expereiceneID
     *
     * @param experienceID the primary key of experience table
     */
    public void setExperienceID(Integer experienceID) {
        this.experienceID = experienceID;
    }

    /**
     * Getter for description
     *
     * @return the description of the tutor's experience
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for description
     *
     * @param description the description of tutor's experience
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Used to get all tutors from join table
     *
     * @return a list of all tutors
     */
    @XmlTransient
    public List<Tutor> getTutorList() {
        return tutorList;
    }

    /**
     * Used to set a list of tutors in join table
     *
     * @param tutorList a list of tutors
     */
    public void setTutorList(List<Tutor> tutorList) {
        this.tutorList = tutorList;
    }

}
