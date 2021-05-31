package com.predjeskovic.neo4jrestapi.domain;


import lombok.*;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.util.Objects;

@Node("Advertisement")
@ToString
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
        setCompany(company);
        setTags(tags);
        setImage(image);
        setLinkToProduct(linkToProduct);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AdvertisementNode that = (AdvertisementNode) o;
        return company.equals(that.company) && linkToProduct.equals(that.linkToProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, linkToProduct);
    }
}
