package com.bookmyshow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyshow.models.Review;
import com.bookmyshow.models.Theatre;
import com.bookmyshow.models.TheatreOwner;
import com.bookmyshow.repositories.TheatreOwnerRepository;
import com.bookmyshow.repositories.TheatreRepository;

@RestController
public class TheatreService {
    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    TheatreOwnerRepository theatreOwnerRepository;

    @GetMapping("/api/theatre")
    public Iterable<Theatre> findAllTheatres() {
        return theatreRepository.findAll();
    }

//    @GetMapping("/api/theatre")
//    public Iterable<Theatre> findAllTheatresForTheatreOwner(@RequestParam(name = "id", required = false) int id) {
//        return theatreRepository.findAll();
//    }


    @PostMapping("/api/{theatreOwnerId}/theatre")
    public Theatre createTheatre(@RequestBody Theatre theatre, @PathVariable("theatreOwnerId") int id) {
        Optional<TheatreOwner> theatreOwner =theatreOwnerRepository.findById(id);
        theatre.setTheatreOwner(theatreOwner.get());
        theatreOwner.get().setNoOfTheatres(theatreOwner.get().getNoOfTheatres()+ 1);
        return theatreRepository.save(theatre);
    }

    @GetMapping("/api/theatre/{theatreId}")
    public Optional<Theatre> findTheatreById(@PathVariable("theatreId") int id) {
        return theatreRepository.findById(id);
    }

    @DeleteMapping("/api/theatre/{theatreId}")
    public void deleteTheatre(@PathVariable("theatreId") int theatreId) {
        theatreRepository.deleteById(theatreId);
    }

    @PutMapping("/api/theatre/{theatreId}")
    public Theatre updateTheatre(@PathVariable("theatreId") int id, @RequestBody Theatre newTheatre) {
    	Optional<Theatre> theatre = theatreRepository.findById(id);
        theatre.get().set(newTheatre);
        return theatreRepository.save(theatre.get());
    }


    @GetMapping("/api/theatre/{theatreId}/getReviews")
    public List<Review> getAllReviews(@PathVariable("theatreId") int id) {
        Optional<Theatre> theatre = theatreRepository.findById(id);
        return theatre.get().getReviews();
    }




}
