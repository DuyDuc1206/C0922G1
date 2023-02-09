package com.example.music_information.dto;

import com.sun.istack.NotNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.Size;

public class MusicDto implements Validator {
    private int id;
    @NotNull
    @Size(max=800,message = "khong duoc qua 800 ki tu")
    private String song;
    @NotNull
    @Size(max=300,message = "khong duoc qua 300 ki tu")
    private String singer;
    @NotNull
    @Size(max=1000,message = "khong duoc qua 1000 ki tu")
    private String genre;

    public MusicDto() {
    }

    public MusicDto(int id, String song, String singer, String genre) {
        this.id = id;
        this.song = song;
        this.singer = singer;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MusicDto musicDto = (MusicDto) target;
        String song = musicDto.getSong();
        if (!song.matches("^([A-Z0-9][a-z0-9]+[ ])+([A-Z0-9][a-z0-9]+)$")){
            errors.rejectValue("song","error1","Song name can not contains special digits like @ ; , . = - + , ….");
        }
        String singer = musicDto.getSinger();
        if (!singer.matches("^([A-Z0-9][a-z0-9]+[ ])+([A-Z0-9][a-z0-9]+)$")){
            errors.rejectValue("singer","error1","Singer name can not contains special digits like @ ; , . = - + , ….");
        }
        String genre = musicDto.getGenre();
        if (!genre.matches("^[A-Za-z, ]$")){
            errors.rejectValue("genre","error1","Genre can not contains special digits, except ','");
        }
    }
}
