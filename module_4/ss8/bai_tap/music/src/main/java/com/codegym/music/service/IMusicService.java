package com.codegym.music.service;

import com.codegym.music.dto.MusicDto;
import com.codegym.music.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMusicService {
    Page<Music> findAll(String music, Pageable pageable);

    void add(Music music);
    void edit(int id,Music music);

    Music findByIdMusic(int id);
}
