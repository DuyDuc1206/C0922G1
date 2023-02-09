package com.example.music_information.service;

import com.example.music_information.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();
    void save(Music music);
    Music findById(int id);
}
