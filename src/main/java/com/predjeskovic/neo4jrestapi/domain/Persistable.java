package com.predjeskovic.neo4jrestapi.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;


public class Persistable {

    @Id @GeneratedValue
    @Getter @Setter
    private Long id;

    public boolean isNew(){
        return id==null;
    }

}
