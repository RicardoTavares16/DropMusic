package dropmusic.model;

import dropmusic.auxfunc.Album;
import rmi.RmiInterface;

import javax.servlet.ServletException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class DropMusicBean {
    public static final String SESSION_MAP_KEY = "DropMusicBean";

    private RmiInterface rmiServer;
    private int id;

    public DropMusicBean() throws Exception {
        try {
            id = (int) (Math.random() * 100);
            id = id * 2 + 1;
            rmiServer = (RmiInterface) Naming.lookup("XPTO");
        } catch (NotBoundException|MalformedURLException|RemoteException e) {
            throw new ServletException(e);
        }
    }

    public List<Album> getAllAlbums() throws RemoteException{
        id = (int) (Math.random() * 100);
        id = id * 2 + 1;
        return rmiServer.getAlbuns(id);
    }

}
