package dropmusic.auxfunc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class que contém os dados de um dado Album.
 */

public class Album {
    private String albumName;
    private List<Music> musicList = Collections.synchronizedList(new ArrayList<Music>());
    private List<Review> reviewList = Collections.synchronizedList(new ArrayList<Review>());
    private String details;

    public Album(String name) {
        this.albumName = name;
    }

    public Album(String name, String details) {
        this.albumName = name;
        this.details = details;
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public void changeAlbumName(String name) {
        this.albumName = name;
    }

    public String getAlbumDetails() {
        return this.details;
    }

    public void addToMusicList(Music music) {
        this.musicList.add(music);
    }

    public List<Music> getMusicList() {
        return musicList;
    }

    public void setAlbumDetails(String details) {
        this.details = details;
    }

    public void setReview(Review review) {
        this.reviewList.add(review);
    }

    public List<Review> getAlbumReviews() {
        return this.reviewList;
    }

    @Override
    public String toString() {
        return this.albumName + "," + this.details;
    }
}
