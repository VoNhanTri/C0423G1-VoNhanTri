package com.codegym.music.repository;

import com.codegym.music.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IMusicRepository extends JpaRepository<Music, Integer> {
    Page<Music> findMusicByNameMusicContaining(String nameMusic, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "insert into music(name_music,name_singer,genres_music)values(:nameMusic,:nameSinger,:genresMusic)", nativeQuery = true)
    void saveMusic(@Param(value = "nameMusic") String nameMusic, @Param(value = "nameSinger") String nameSinger, @Param(value = "genresMusic") String genresMusic);

    @Modifying
    @Transactional
    @Query(value = "update music set name_music=:nameMusic,name_singer=:nameSinger,genres_music=:genresMusic where id=:id", nativeQuery = true)
    void edit(@Param(value = "nameMusic") String nameMusic, @Param(value = "nameSinger") String nameSinger, @Param(value = "genresMusic") String genresMusic,@Param(value = "id") int id);


    @Query(value = "select * from music where id = :id", nativeQuery = true)
    Music findByIdMusic(@Param(value = "id") int id);
}
