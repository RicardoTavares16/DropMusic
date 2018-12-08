package dropmusic.model;

import rmi.RmiInterface;

import javax.servlet.ServletException;
import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.*;

public class DropMusicBean {

    private RmiInterface rmiServer;

    public DropMusicBean() throws Exception {
        try {
            rmiServer = (RmiInterface) Naming.lookup("XPTO");
        } catch (NotBoundException|MalformedURLException|RemoteException e) {
            throw new ServletException(e);
        }
    }

}
