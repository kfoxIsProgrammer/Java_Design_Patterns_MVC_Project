/* 
 * This Project is the property of Kevin Fox.
 * Created for CST 8288 and George Kriger.
 * All Rights Reserved.
 */
package transferObjects_WJPA;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Users DTO with JPA assist Used for login
 *
 * @author kevin
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "username")
    private String username;
    @Size(max = 65)
    @Column(name = "password")
    private String password;

    /**
     * No Arg constructor
     */
    public Users() {
    }

    /**
     * Constructor with primary key
     *
     * @param username the username of login user
     */
    public Users(String username) {
        this.username = username;
    }

    /**
     * Getter for username
     *
     * @return the username of the user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter for username
     *
     * @param username the username the user has entered
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter for password for the user
     *
     * @return the user's password in hash
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for password
     *
     * @param password the password the user has entered
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
