package br.com.wishlister.model;

import java.util.List;

/**
 * Created by wallace on 14/10/2017.
 */
public class Response {

    private Venue venue;
    private List<Recent> recent;

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public List<Recent> getRecent() {
        return recent;
    }

    public void setRecent(List<Recent> recent) {
        this.recent = recent;
    }
}
