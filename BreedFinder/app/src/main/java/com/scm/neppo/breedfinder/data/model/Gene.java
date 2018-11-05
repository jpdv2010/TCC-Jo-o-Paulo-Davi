package com.scm.neppo.breedfinder.data.model;

import com.scm.neppo.breedfinder.data.enumeration.GeneType;

public class Gene {
    private String id;
    private Feature feature;
    private GeneType geneType;

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public GeneType getGeneType() {
        return geneType;
    }

    public void setGeneType(GeneType geneType) {
        this.geneType = geneType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
