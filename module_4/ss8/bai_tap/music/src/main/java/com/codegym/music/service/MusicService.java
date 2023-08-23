package com.codegym.music.service;

import com.codegym.music.dto.MusicDto;
import com.codegym.music.model.Music;
import com.codegym.music.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository iMusicRepository;

    @Override
    public Page<Music> findAll(String music, Pageable pageable) {
        return iMusicRepository.findMusicByNameMusicContaining(music, pageable);
    }

    @Override
    public void add(Music music) {
        iMusicRepository.saveMusic(music.getNameMusic(), music.getNameSinger(), music.getGenresMusic());
    }

    @Override
    public void edit(int id, Music music) {
        iMusicRepository.edit(music.getNameMusic(), music.getNameSinger(), music.getGenresMusic(),music.getId());
    }

    @Override
    public Music findByIdMusic(int id) {
        return iMusicRepository.findByIdMusic(id);
    }

}
