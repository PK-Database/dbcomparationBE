package com.dbanalyzer.dbpkproject.manager;

import com.dbanalyzer.dbpkproject.csv.CsvFileToObjectConverter;
import com.dbanalyzer.dbpkproject.csv.dto.AccidentDto;
import com.dbanalyzer.dbpkproject.csv.mapper.PostgresMapper;
import com.dbanalyzer.dbpkproject.database.postgres.services.PostgresService;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
public class DatabaseUploadManager {

    private final CsvFileToObjectConverter csvFileToObjectConverter;
    private final PostgresMapper postgresMapper;
    private final PostgresService postgresService;

    public DatabaseUploadManager(CsvFileToObjectConverter csvFileToObjectConverter, PostgresMapper postgresMapper, PostgresService postgresService) {
        this.csvFileToObjectConverter = csvFileToObjectConverter;
        this.postgresMapper = postgresMapper;
        this.postgresService = postgresService;
    }

    public void performDatabasesUploads(MultipartFile csvFile) throws IOException {

        List<AccidentDto> dtos = csvFileToObjectConverter.convertAccidents(csvFile);
        postgresService.save(postgresMapper.mapToEntitiesList(dtos));

        //TODO::
        // mongoService.save(postgresMapper.mapToEntities(dtos));

    }
}