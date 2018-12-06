package auxfunc;

import java.io.Serializable;

/**
 * Class que contém os dados de uma critica.
 */

public class Review implements Serializable {
    private String username, review;
    private int score;

    public Review(String username, String review, int score) {
        this.review = review;
        this.username = username;
        this.score = score;
    }

    public String getReview() {
        return this.username + "*" + this.review + "*" + this.score;
    }

    @Override
    public String toString() {
        return this.username + "*" + this.review + "*" + this.score;
    }

}
