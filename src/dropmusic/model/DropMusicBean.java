package dropmusic.model;

import rmi.RmiInterface;

import javax.servlet.ServletException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class DropMusicBean {
    public static final String SESSION_MAP_KEY = "dropMusicBean";

    private RmiInterface rmiServer;
    private int id;
    private String name;

    private ArrayList<DropMusicBean> albums;


    public DropMusicBean() throws Exception {
        try {
            System.out.println("Creating RMI Connection...");
            id = (int) (Math.random() * 100);
            id = id * 2 + 1;
            rmiServer = (RmiInterface) Naming.lookup("XPTO");
        } catch (NotBoundException|MalformedURLException|RemoteException e) {
            throw new ServletException(e);
        }
    }

    public ArrayList<DropMusicBean> getAlbums() throws RemoteException {
        this.getAllAlbums();
        return this.albums;
    }

    public void getAllAlbums() throws RemoteException{
        System.out.println("Getting all albums from server...");
        System.out.println("ID = " +id);
        ArrayList<Album> albumList = new ArrayList<Album>();
        List<Album> tmp = rmiServer.getAlbuns(this.id);
        albumList.addAll(tmp);

        for (Album a: albumList) {
            this.setName(a.getAlbumName());
            albums.add(this);
        }

        System.out.println("Finished getting all albums...");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
