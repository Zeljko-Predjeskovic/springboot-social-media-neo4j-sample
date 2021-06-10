package com.predjeskovic.socialmedia.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

import java.time.LocalDate;


public class Persistable{

    @Id @GeneratedValue
    @Getter @Setter
    private Long id;

    @Getter
    private LocalDate createdOn = LocalDate.now();

    public boolean isNew(){
        return id==null;
    }

}
