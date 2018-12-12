/* 
 * This Project is the property of Kevin Fox.
 * Created for CST 8288 and George Kriger.
 * All Rights Reserved.
 */
package businesslogic;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Business logic to hash the password
 *
 * @author kevin
 */
public class LogInLogic {

    /**
     * Used to hash passwords
     *
     * @param passwordToHash password in plain string
     * @param salt special salt if applied
     * @return the password in hash form
     */
    public String get_SHA_512_SecurePassword(String passwordToHash, String salt) {

        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return (generatedPassword);

    }
}
