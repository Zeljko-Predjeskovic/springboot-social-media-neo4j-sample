package com.predjeskovic.neo4jrestapi.domain;

import lombok.Getter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

import java.util.Objects;

@Getter
public class Persistable {

    @Id @GeneratedValue
    private Long id;

    public boolean isNew(){
        return id==null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persistable that = (Persistable) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
