package br.com.wishlister.repository;

import br.com.wishlister.model.ResponsePage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wallace on 15/10/2017.
 *
 * <p>
 * Keeps cached objects ResponsePage
 * </p>
 */
@Repository
public class VenueRepository {

    private List<ResponsePage> recentVenues;
    private List<ResponsePage> wishlist;

    public void init() {
        this.recentVenues = new ArrayList<>();
        this.wishlist = new ArrayList<>();
    }

    public List<ResponsePage> getRecentVenues() {
        return recentVenues;
    }

    public void setRecentVenues(List<ResponsePage> recentVenues) {
        this.recentVenues = recentVenues;
    }

    public List<ResponsePage> getWishlist() {
        return wishlist;
    }

    /**
     * Add wishlist in cache
     */
    public void addWishlist(String id) {
        ResponsePage page = this.recentVenues.stream()
                .filter(venue -> venue.getId().equals(id))
                .collect(Collectors.toList()).get(0);
        this.wishlist.add(page);
        this.recentVenues.remove(page);
    }

    /**
     * Remove cache wishlist
     */
    public void removeWishlist(String id) {
        this.wishlist = this.wishlist.stream()
                .filter(venue -> !venue.getId().equals(id))
                .collect(Collectors.toList());
    }

}
