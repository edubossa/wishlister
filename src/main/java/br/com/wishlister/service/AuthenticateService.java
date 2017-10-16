package br.com.wishlister.service;

import br.com.wishlister.model.AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wallace on 15/10/2017.
 * <p>
 *  Responsible for authentication, Foursquare - OAuth 2.0
 * </p>
 * @see <a href="https://developer.foursquare.com/docs/api/configuration/authentication">click</a>
 */
@Service
public class AuthenticateService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${client_id}")
    private String clientId;

    @Value("${client_secret}")
    private String clientSecret;

    @Value("${redirect_uri}")
    private String redirectUri;

    @Value("${url_oauth2}")
    private String urlOauth2;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Direct users to Foursquare with your registered redirect uri.
     *
     * @return url for authentication Foursquare
     */
    public String authenticate() {
        return "redirect:"  + urlOauth2 + "authenticate?client_id=" + clientId
                + "&response_type=code&redirect_uri=" + redirectUri;
    }

    /**
     * Get access token
     *
     * @param code parameter returned by Foursquare
     * @return AccessToken
     */
    public AccessToken getAccessToken(String code) {
        String url = urlOauth2 + "access_token?client_id=" + clientId + "&client_secret=" + clientSecret
                + "&grant_type=authorization_code&redirect_uri=" + redirectUri + "&code=" + code;
        logger.info(url);
        AccessToken accessToken = restTemplate.getForObject(url, AccessToken.class);
        logger.info(accessToken.toString());
        return accessToken;
    }

}