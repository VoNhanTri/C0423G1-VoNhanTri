package com.codegym.music.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicDto implements Validator {
    private int id;
    @NotEmpty
    @Size(max = 800)
    @Pattern(regexp = "^[a-zA-Z0-9\\s]*$")
    private String nameMusic;
    @NotEmpty
    @Size(max = 300)
    @Pattern(regexp = "^[a-zA-Z0-9\\s]*$")
    private String nameSinger;
    @NotEmpty
    @Size(max = 1000)
    @Pattern(regexp = "^[a-zA-Z0-9\\s,]*$")
    private String genresMusic;

    public MusicDto(String nameMusic, String nameSinger, String genresMusic) {
        this.nameMusic = nameMusic;
        this.nameSinger = nameSinger;
        this.genresMusic = genresMusic;
    }

    public MusicDto() {
    }

    public MusicDto(int id, String nameMusic, String nameSinger, String genresMusic) {
        this.id = id;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
