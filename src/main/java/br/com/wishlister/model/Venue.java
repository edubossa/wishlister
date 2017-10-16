package br.com.wishlister.model;

/**
 * Created by wallace on 14/10/2017.
 */
public class Venue {

    private String id;
    private String name;
    private Photos photos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }
}
