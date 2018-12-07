package dropmusic.action;

import com.opensymphony.xwork2.ActionSupport;
import dropmusic.model.PersonBean;
import org.apache.struts2.interceptor.SessionAware;
import rmi.RmiInterface;

import javax.servlet.ServletException;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.Map;


public class LoginAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 4L;
    private transient Map<String, Object> session;

    private String username = null, password = null;

    private RmiInterface rmiServer;


    private static final String SUCCESS_USER = "success user";
    private static final String SUCCESS_ADMIN = "success admin";

    @Override
    public String execute() throws Exception {
        System.out.println("Trying to Login");

        try {
            System.out.println("TRY");
            Registry registry = LocateRegistry.getRegistry(1099);
            rmiServer = (RmiInterface) Naming.lookup("XPTO");
            System.out.println("XPTO");
        } catch (AccessException e) {
            throw new ServletException(e);
        } catch (RemoteException e) {
            throw new ServletException(e);
        } catch (NotBoundException e) {
            throw new ServletException(e);
        }

        System.out.println("After RMI");

        PersonBean person = this.getPersonBean();
        username = person.getUsername();
        password = person.getPassword();

        System.out.println(username + ", " + password);

        rmiServer.login("tintin", "unicorn", 1);

        return SUCCESS_ADMIN;
    }

    public PersonBean getPersonBean() {
        if(!session.containsKey(PersonBean.SESSION_MAP_KEY)) {
            this.setPersonBean(new PersonBean());
        }

        return (PersonBean) session.get(PersonBean.SESSION_MAP_KEY);
    }

    public void setPersonBean(PersonBean personBean) {
        this.session.put(PersonBean.SESSION_MAP_KEY, personBean);
    }


    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

}
