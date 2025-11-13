package com.capstoneproject.musicplatform.controller;

import com.capstoneproject.musicplatform.model.Song;
import com.capstoneproject.musicplatform.service.SongService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    // Tüm şarkıları listele
    @GetMapping
    public ResponseEntity<List<Song>> getAllSongs() {
        List<Song> songs = songService.getAllSongs();
        return ResponseEntity.ok(songs);
    }

    // ID ile şarkı getir
    @GetMapping("/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable Long id) {
        return songService.getSongById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Sanatçı ID'sine göre şarkılar
    @GetMapping("/artist/{artistId}")
    public ResponseEntity<List<Song>> getSongsByArtistId(@PathVariable Long artistId) {
        List<Song> songs = songService.getSongsByArtistId(artistId);
        if (songs.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(songs);
    }

    // Türüne göre şarkılar
    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Song>> getSongsByGenre(@PathVariable String genre) {
        List<Song> songs = songService.getSongsByGenre(genre);
        if (songs.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(songs);
    }

    // Başlığa göre arama
    @GetMapping("/search")
    public ResponseEntity<List<Song>> getSongsByTitle(@RequestParam String title) {
        List<Song> songs = songService.getSongsByTitle(title);
        if (songs.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(songs);
    }

    // En çok dinlenen ilk 10 şarkı
    @GetMapping("/top10")
    public ResponseEntity<List<Song>> getTop10Songs() {
        List<Song> songs = songService.getTop10SongsByPlayCount();
        return ResponseEntity.ok(songs);
    }

    // Yeni şarkı ekle
    @PostMapping
    public ResponseEntity<Song> createSong(@RequestBody Song song) {
        Song savedSong = songService.saveSong(song);
        return ResponseEntity.ok(savedSong);
    }

    // Şarkı güncelle
    @PutMapping("/{id}")
    public ResponseEntity<Song> updateSong(@PathVariable Long id, @RequestBody Song song) {
        Song updatedSong = songService.updateSong(id, song);
        if (updatedSong == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedSong);
    }

    // Şarkı sil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable Long id) {
        songService.deleteSong(id);
        return ResponseEntity.noContent().build();
    }
}