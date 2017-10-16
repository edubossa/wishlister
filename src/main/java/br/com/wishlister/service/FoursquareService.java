package br.com.wishlister.service;

import br.com.wishlister.model.AccessToken;
import br.com.wishlister.model.FoursquareResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wallace on 15/10/2017.
 *
 * <p>
 *   Responsible for integration with Foursquare API
 * </p>
 */
@Service
public class FoursquareService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${url_api}")
    private String urlApi;

    @Value("${v}")
    private String v;

    @Value("${limit}")
    private String limit;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Get Recent Check-ins by Friends
     *
     * @see <a href="https://developer.foursquare.com/docs/api/checkins/recent">click</a>
     * @param accessToken
     * @return A list of recent checkins from friends.
     */
    public FoursquareResponse getCheckinsRecent(AccessToken accessToken) {
        String url = urlApi + "checkins/recent?oauth_token=" + accessToken.getAccess_token() + "&v=" + v + "&limit=" + limit;
        logger.info(url);
        return restTemplate.getForObject(url, FoursquareResponse.class);
    }

    /**
     * Get a Venue's Photos
     *
     * @see <a href="https://developer.foursquare.com/docs/api/venues/photos">click</a>
     * @param accessToken
     * @param idVenue
     * @return Photos for a specific venue.
     */
    public FoursquareResponse getVenues(AccessToken accessToken, String idVenue) {
        String url = urlApi + "venues/" + idVenue + "?oauth_token=" + accessToken.getAccess_token() + "&v=" + v;
        logger.info(url);
        return restTemplate.getForObject(url, FoursquareResponse.class);
    }

}
