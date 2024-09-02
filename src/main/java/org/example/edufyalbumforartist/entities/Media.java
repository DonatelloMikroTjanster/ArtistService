package org.example.edufyalbumforartist.entities;

import jakarta.persistence.*;

import java.net.URL;
import java.sql.Date;

@Entity
@Table(name = "media")
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

    @Column(name = "media_type", length = 20, nullable = false)
    private String mediaType;

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    @Column(name = "release_date", length = 15)
    private Date releaseDate;


    @ManyToOne
    @JoinColumn(name = "album_id", nullable = true)
    private Album album;

    @Column(name = "URL", nullable = false)
    private URL mediaURL;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public URL getMediaURL() {
        return mediaURL;
    }

    public void setMediaURL(URL mediaURL) {
        this.mediaURL = mediaURL;
    }
}
