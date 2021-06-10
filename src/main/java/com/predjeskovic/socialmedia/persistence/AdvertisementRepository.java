package com.predjeskovic.socialmedia.persistence;

import com.predjeskovic.socialmedia.domain.AdvertisementNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementRepository extends Neo4jRepository<AdvertisementNode,Long> {
    
}
