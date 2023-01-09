package com.dbanalyzer.dbpkproject.database.dynamo.service;

import com.dbanalyzer.dbpkproject.controllers.enums.QueryType;
import com.dbanalyzer.dbpkproject.csv.dto.MovieDto;
import com.dbanalyzer.dbpkproject.csv.mapper.DynamoMapper;
import com.dbanalyzer.dbpkproject.database.dynamo.entity.Movie;
import com.dbanalyzer.dbpkproject.database.dynamo.repository.IDynamoMovieRepository;
import com.dbanalyzer.dbpkproject.manager.DataBaseService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class DynamoService implements DataBaseService {

    private final IDynamoMovieRepository movieRepository;
    private final DynamoMapper dynamoMapper;

    public DynamoService(IDynamoMovieRepository movieRepository, DynamoMapper dynamoMapper) {
        this.movieRepository = movieRepository;
        this.dynamoMapper = dynamoMapper;
    }

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    public void saveMovies(List<? extends Object> movieList) {
        movieRepository.deleteAll();
        movieRepository.saveAll((List<Movie>) movieList);
    }

    @Override
    public Collection<MovieDto> getMovies() {
        return dynamoMapper.mapToDtoList(movieRepository.findAll());
    }

    @Override
    public Collection<MovieDto> executeQuery(QueryType queryType) {
        System.out.println("hehe dynamo");
        return null;
    }

}