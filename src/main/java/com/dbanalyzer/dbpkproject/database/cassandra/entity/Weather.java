package com.dbanalyzer.dbpkproject.database.cassandra.entity;

import com.googlecode.jmapper.annotations.JMap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.relational.core.mapping.Table;
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Weather {

    @PrimaryKey
    private String accidentId;
    @JMap("weatherTimestamp")
    private String weatherTimestamp;
    @JMap("windDirection")
    private String windDirection;
    @JMap("weatherCondition")
    private String weatherCondition;

}