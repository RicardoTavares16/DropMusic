package dropmusic.model;

import rmi.RmiInterface;

import javax.servlet.ServletException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class PersonBean implements Serializable {
    public static final String SESSION_MAP_KEY = "PersonBean";
    private static final long serialVersionUID = 1L;

    RmiInterface rmiServer;

    private String username;
    private String password;
    private int id;
    private boolean admin;
    private boolean editor;

    public PersonBean() throws Exception{
        try {
            id = (int) (Math.random() * 100);
            id = id * 2 + 1;
            rmiServer = (RmiInterface) Naming.lookup("XPTO");
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            throw new ServletException(e);
        }
    }

    public boolean getLogin() throws RemoteException {
        return rmiServer.login(username, password, id);
    }

    public boolean getReg() throws RemoteException {
        return rmiServer.registo(username, password, id);
    }

    public boolean getIsEditor() throws RemoteException {
        return rmiServer.isEditor(this.username, id);
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() { return this.username; }
    public String getPassword() { return this.password; }

    public boolean getAdmin() { return this.admin; }
    public void setAdmin(boolean admin) { this.admin = admin; }
    public boolean getEditor() { return this.editor; }
    public void setEditor(boolean editor) { this.editor = editor; }

    @Override
    public String toString() {
        return "PersonBean [username=" + username + ", password=" + password + ", admin=" + admin + ", editor=" + editor + "]";
    }

}
