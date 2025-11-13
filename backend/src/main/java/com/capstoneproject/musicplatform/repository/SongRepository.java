package com.capstoneproject.musicplatform.repository;

import com.capstoneproject.musicplatform.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findByArtistId(Long artistId);
    List<Song> findByGenreIgnoreCase(String genre);
    List<Song> findTop10ByOrderByPlayCountDesc();
    List<Song> findByTitleContainingIgnoreCase(String title);
}
