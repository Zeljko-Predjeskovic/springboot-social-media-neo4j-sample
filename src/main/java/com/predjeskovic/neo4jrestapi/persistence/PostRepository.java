package com.predjeskovic.neo4jrestapi.persistence;

import com.predjeskovic.neo4jrestapi.domain.PostNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.nio.channels.Pipe;

@Repository
public interface PostRepository extends Neo4jRepository<PostNode,Long> {

}
