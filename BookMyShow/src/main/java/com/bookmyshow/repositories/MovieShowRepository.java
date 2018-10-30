package com.bookmyshow.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bookmyshow.models.MovieShow;

public interface MovieShowRepository extends CrudRepository<MovieShow, Integer>{
	@Query("SELECT ms FROM MovieShow ms WHERE ms.theatreName=:theatreName AND ms.movieName=:movieName")
	Iterable<MovieShow> findMovieShowsByTheatreAndMovie(@Param("theatreName") String theatreName, @Param("movieName") String movieName);
	@Query("SELECT ms FROM MovieShow ms WHERE ms.theatreName=:theatreName")
	Iterable<MovieShow> findMovieShowsByTheatre(@Param("theatreName") String theatreName);
	@Query("SELECT ms FROM MovieShow ms WHERE ms.movieName=:movieName AND ms.date=:date")
	Iterable<MovieShow> findMovieShowsByMovieAndDate(@Param("movieName") String movieName, @Param("date") String date);
	@Query("SELECT ms FROM MovieShow ms WHERE ms.movieName=:movieName AND ms.theatreName=:theatreName AND ms.date=:date AND ms.time =:time")
	Iterable<MovieShow> findOne(@Param("movieName") String movieName, @Param("theatreName") String theatreName, @Param("date") String date, @Param("time") String time);
}