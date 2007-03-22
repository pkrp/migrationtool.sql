
package uk.icat3.sessionbeans.user;

import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jws.WebMethod;
import uk.icat3.exceptions.SessionException;


/**
 * This is the business interface for UserSession enterprise bean.
 */
@Local
public interface UserSessionLocal {
   java.lang.String login(String username, String password) throws SessionException;

    boolean logout(String sid) throws SessionException;

    java.lang.String getUserId(String sid) throws SessionException;
     
}