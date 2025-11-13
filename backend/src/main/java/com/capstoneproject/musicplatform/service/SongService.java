package com.capstoneproject.musicplatform.service;

import com.capstoneproject.musicplatform.model.Song;
import com.capstoneproject.musicplatform.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public Song saveSong(Song song) {
        song.setUploadDate(LocalDateTime.now());
        return songRepository.save(song);
    }

    public Optional<Song> getSongById(Long id) {
        return songRepository.findById(id);
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public List<Song> getSongsByArtistId(Long artistId) {
        return songRepository.findByArtistId(artistId);
    }

    public List<Song> getSongsByGenre(String genre) {
        return songRepository.findByGenreIgnoreCase(genre);
    }

    public List<Song> getTop10SongsByPlayCount() {
        return songRepository.findTop10ByOrderByPlayCountDesc();
    }

    public List<Song> getSongsByTitle(String title) {
        return songRepository.findByTitleContainingIgnoreCase(title);
    }

    public Song updateSong(Long id, Song updatedSong) {
        return songRepository.findById(id).map(song -> {
            song.setTitle(updatedSong.getTitle());
            song.setDuration(updatedSong.getDuration());
            song.setGenre(updatedSong.getGenre());
            song.setReleaseDate(updatedSong.getReleaseDate());
            song.setArtist(updatedSong.getArtist());
            song.setFileUrl(updatedSong.getFileUrl());
            song.setAverageRating(updatedSong.getAverageRating());
            song.setPlayCount(updatedSong.getPlayCount());
            return songRepository.save(song);
        }).orElse(null);
    }

    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }
}