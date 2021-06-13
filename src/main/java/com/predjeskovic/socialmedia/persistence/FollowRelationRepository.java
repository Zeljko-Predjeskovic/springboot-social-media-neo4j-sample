package com.predjeskovic.socialmedia.persistence;

import com.predjeskovic.socialmedia.domain.FollowRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface FollowRelationRepository extends Neo4jRepository<FollowRelation, Long> {
}
