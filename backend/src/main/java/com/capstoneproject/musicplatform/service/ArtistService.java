package com.capstoneproject.musicplatform.service;

import com.capstoneproject.musicplatform.model.Artist;
import com.capstoneproject.musicplatform.repository.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;
    public ArtistService(ArtistRepository artistRepository){     //Constructor based dependency injection
        this.artistRepository = artistRepository;
    }

    public Artist getArtistById(Long id) {
        Optional<Artist> artist = artistRepository.findById(id);
        return artist.orElse(null);
    }


    public Artist updateArtist(Long id, Artist artistDetails) {
        return artistRepository.findById(id).map(artist -> {
            artist.setStageName(artistDetails.getStageName());
            artist.setRealName(artistDetails.getRealName());
            artist.setGenre(artistDetails.getGenre());
            artist.setCountry(artistDetails.getCountry());
            artist.setDebutDate(artistDetails.getDebutDate());
            artist.setBio(artistDetails.getBio());
            artist.setProfileImageUrl(artistDetails.getProfileImageUrl());
            return artistRepository.save(artist);
        }).orElse(null);
    }
    public Artist registerArtist(Artist artist){           //Used for saving artists to the database
        if(artistRepository.existsByStageName(artist.getStageName())){
            throw new RuntimeException("Artist already exists");
        }
        return artistRepository.save(artist);
    }

    public List<Artist> getAllArtists(){          //Listing all artists service
        return artistRepository.findAll();
    }

    public Optional<Artist> getArtistByStageName(String stageName){      //Retrieving artist by stage name service
        return artistRepository.findByStageName(stageName);
    }

    public List<Artist> getArtistByGenre(String genre){         //Retrieving artists by genre service
        return artistRepository.findByGenreIgnoreCase(genre);
    }

    public List<Artist> getArtistByCountry(String country){         //Retrieving artists by country service
        return artistRepository.findByCountryIgnoreCase(country);
    }

    public void deleteArtist(Long id){
        artistRepository.deleteById(id);
    }
}
