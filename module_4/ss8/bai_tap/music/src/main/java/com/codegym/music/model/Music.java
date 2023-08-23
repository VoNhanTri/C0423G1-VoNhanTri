package com.codegym.music.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    private String nameMusic;
    private String nameSinger;
    private String genresMusic;

    public Music() {
    }

    public Music(int id, String nameMusic, String nameSinger, String genresMusic) {
        this.id = id;
        this.nameMusic = nameMusic;
        this.nameSinger = nameSinger;
        this.genresMusic = genresMusic;
    }

    public Music(String nameMusic, String nameSinger, String genresMusic) {
        this.nameMusic = nameMusic;
        this.nameSinger = nameSinger;
        this.genresMusic = genresMusic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getGenresMusic() {
        return genresMusic;
    }

    public void setGenresMusic(String genresMusic) {
        this.genresMusic = genresMusic;
    }
}
