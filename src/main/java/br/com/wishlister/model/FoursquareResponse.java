package br.com.wishlister.model;

/**
 * Created by wallace on 14/10/2017.
 */
public class FoursquareResponse {

    private Meta meta;
    private Response response;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
