package com.predjeskovic.neo4jrestapi.domain;


import lombok.*;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node("Advertisement")
@EqualsAndHashCode @ToString
public class AdvertisementNode extends Persistable{

    @Property("company")
    @Getter @Setter
    private String company;

    @Property("tags")
    @Getter @Setter
    private String tags;

    @Property("image")
    @Getter @Setter
    private String image;

    @Property("linkToProduct")
    @Getter @Setter
    private String linkToProduct;

    private AdvertisementNode(){  }

    @Builder
    public AdvertisementNode(String company, String tags, String image, String linkToProduct) {
        this.company = company;
        this.tags = tags;
        this.image = image;
        this.linkToProduct = linkToProduct;
    }
}
