package com.scm.neppo.breedfinder.data.model;

import java.util.List;

public class Chromosome {
    private String id;
    private List<Gene> genome;
    private Chromosome homologousChromosome;

    public List<Gene> getGenome() {
        return genome;
    }

    public void setGenome(List<Gene> genome) {
        this.genome = genome;
    }

    public Chromosome getHomologousChromosome() {
        return homologousChromosome;
    }

    public void setHomologousChromosome(Chromosome homologousChromosome) {
        this.homologousChromosome = homologousChromosome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
