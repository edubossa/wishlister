package br.com.wishlister.controllers;

import br.com.wishlister.service.AuthenticateService;
import br.com.wishlister.model.AccessToken;
import br.com.wishlister.model.ResponsePage;
import br.com.wishlister.service.ResponsePageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by wallace on 13/10/2017.
 *
 * <p>
 *   Controller for page index.html
 * </p>
 */
@Controller
public class FoursquareController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AuthenticateService authenticateService;

    @Autowired
    private ResponsePageService responsePageService;

    @RequestMapping("/foursquare/login")
    public String login() {
        return authenticateService.authenticate();
    }

    @RequestMapping("/foursquare/callback")
    public String callback(@RequestParam(value="code") String code, Model model) {
        logger.info("CODE --> " + code);
        AccessToken accessToken = this.authenticateService.getAccessToken(code);
        List<ResponsePage> recentVenues = responsePageService.mergeCheckinsRecentAndVenues(accessToken);
        logger.info("recentVenues size --> " + recentVenues.size());
        model.addAttribute("recentVenues", recentVenues);
        return "venue";
    }

}
