package com.cinexpress.videofriend.services;

import java.util.List;

import com.cinexpress.videofriend.models.Movie;

public interface DigitalPlatformService {
    List<Movie> searchMovies();
    Movie streamingMovie();
    //managementDownload()
    //liveChat()
}
