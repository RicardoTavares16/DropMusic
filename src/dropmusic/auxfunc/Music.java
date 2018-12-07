package dropmusic.auxfunc;

import java.io.Serializable;

/**
 * Class que contém os dados de dada Música.
 */

public class Music implements Serializable {
    private String songName;

    public Music(String name){
        this.songName = name;
    }

    public String getMusicName() {
        return this.songName;
    }


    @Override
    public String toString(){
        return this.songName;
    }
}
