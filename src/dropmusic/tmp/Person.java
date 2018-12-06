package dropmusic.tmp;

import java.io.Serializable;

/**
 * Nesta class são guardadas as informações de cada utilizador.
 */

public class Person implements Serializable {
    private boolean editor;
    private String username;
    private String password;

    public Person(String username, String password, boolean editor){
        this.username = username;
        this.password = password;
        this.editor = editor;
    }

    public String getUsername() { return this.username; }
    public String getPassword() { return this.password; }
    public boolean getEditor() { return this.editor; }
    public void setEditor(Boolean editor) { this.editor = editor; }

    @Override
    public String toString(){
        return this.username + "," + this.password + "," + this.editor;
    }
}
