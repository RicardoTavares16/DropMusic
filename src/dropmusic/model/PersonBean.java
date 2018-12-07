package dropmusic.model;

import java.io.Serializable;

public class PersonBean implements Serializable {
    public static final String SESSION_MAP_KEY = "PersonBean";
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private boolean admin;
    private boolean editor;

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
