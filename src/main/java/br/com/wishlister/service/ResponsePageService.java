package br.com.wishlister.service;

import br.com.wishlister.model.FoursquareResponse;
import br.com.wishlister.model.Recent;
import br.com.wishlister.repository.VenueRepository;
import br.com.wishlister.model.AccessToken;
import br.com.wishlister.model.ResponsePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wallace on 15/10/2017.
 */
@Service
public class ResponsePageService {

    @Autowired
    private FoursquareService foursquareService;

    @Autowired
    private VenueRepository venueRepository;

    /**
     * Makes combination of APIs checkins/recent and venues/photos
     *
     * @param accessToken
     * @return list ResponsePage
     */
    public List<ResponsePage> mergeCheckinsRecentAndVenues(AccessToken accessToken) {
        this.venueRepository.init();
        List<ResponsePage> recentVenues = new ArrayList<>();
        FoursquareResponse checkinsRecent = this.foursquareService.getCheckinsRecent(accessToken);
        List<Recent> recents = checkinsRecent.getResponse().getRecent();
        //add checkinsRecent to ResponsePage
        recents.forEach(recent -> {
            ResponsePage page = new ResponsePage(recent.getUser().getId(), recent.getVenue().getName());
            page.setVanuePhoto("http://lorempixel.com/850/280/nature/4/");
            page.setUserName(recent.getUser().getFirstName() + " " + recent.getUser().getLastName());
            page.setUserPhoto(recent.getUser().getPhoto().getPrefix() + "original" + recent.getUser().getPhoto().getSuffix());
            recentVenues.add(page);
        });
        //get Venues ID
        List<String> idVenues = recents.stream().map(recent -> recent.getVenue().getId()).collect(Collectors.toList());
        //add venues to ResponsePage
        idVenues.forEach(id -> {
            FoursquareResponse venues = this.foursquareService.getVenues(accessToken, id);
            venues.getResponse().getVenue().getPhotos().getGroups().forEach(group -> {
                group.getItems().forEach(item -> {
                    ResponsePage page = new ResponsePage(item.getId(), venues.getResponse().getVenue().getName());
                    page.setVanuePhoto(item.getPrefix() + "original" + item.getSuffix());
                    page.setUserName(item.getUser().getFirstName() + " " + item.getUser().getLastName());
                    page.setUserPhoto(item.getUser().getPhoto().getPrefix() + "original" + item.getUser().getPhoto().getSuffix());
                    recentVenues.add(page);
                });
            });

        });

        venueRepository.setRecentVenues(recentVenues);

        return recentVenues;
    }

}
