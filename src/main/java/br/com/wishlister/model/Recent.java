package br.com.wishlister.model;

/**
 * Created by wallace on 14/10/2017.
 */
public class Recent {

    private String id;
    private User user;
    private Venue venue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
