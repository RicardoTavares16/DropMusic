package dropmusic.model;

import java.io.Serializable;

public class userBean implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SESSION_MAP_KEY = "UserBean";


    private boolean editor;
    private String username;
    private String password;
    private boolean isAdmin;

    public String getUsername() { return this.username; }
    public void setUsername(String username) { this.username = username;}
    public String getPassword() { return this.password; }
    public void setPassword(String password) { this.password = password;}
    public boolean getEditor() { return this.editor; }
    public void setEditor(Boolean editor) { this.editor = editor; }
    public boolean getIsAdmin() { return this.isAdmin; }
    public void setIsAdmin(Boolean admin) { this.isAdmin = admin; }

    @Override
    public String toString(){
        return this.username + "," + this.password + "," + this.editor;
    }
}
