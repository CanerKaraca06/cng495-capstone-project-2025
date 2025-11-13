package com.capstoneproject.musicplatform.repository;

import com.capstoneproject.musicplatform.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    Optional<Artist> findByStageName(String stageName);      //Search according to the stage name
    boolean existsByStageName(String stageName);        //Check if there is duplicate names
    List<Artist> findByGenreIgnoreCase(String genre);        //List the artists by genre
    List<Artist> findByCountryIgnoreCase(String country);        //List the artists by country
}
