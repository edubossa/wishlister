package br.com.wishlister.controllers;

import br.com.wishlister.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by wallace on 13/10/2017.
 *
 * <p>
 *  Controller for page venue.html
 * </p>
 */
@Controller
public class VenueController {

    @Autowired
    private VenueRepository venueRepository;

    @RequestMapping("/venue/add")
    public String venue(@RequestParam(value="id") String id, Model model) {
        venueRepository.addWishlist(id);
        model.addAttribute("wishlist", venueRepository.getWishlist());
        model.addAttribute("recentVenues", venueRepository.getRecentVenues());
        return "venue";
    }

    @RequestMapping("/venue/remove")
    public String removeVenue(@RequestParam(value="id") String id, Model model) {
        venueRepository.removeWishlist(id);
        model.addAttribute("wishlist", venueRepository.getWishlist());
        model.addAttribute("recentVenues", venueRepository.getRecentVenues());
        return "venue";
    }

}