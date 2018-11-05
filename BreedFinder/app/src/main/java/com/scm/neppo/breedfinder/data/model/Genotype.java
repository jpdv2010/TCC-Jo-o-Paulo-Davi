package com.scm.neppo.breedfinder.data.model;

import java.util.ArrayList;
import java.util.List;

public class Genotype {
    private Chromosome chromosome1;
    private Chromosome chromosome2;

    public Chromosome getChromosome1() {
        return chromosome1;
    }

    public void setChromosome1(Chromosome chromosome1) {
        this.chromosome1 = chromosome1;
    }

    public Chromosome getChromosome2() {
        return chromosome2;
    }

    public void setChromosome2(Chromosome chromosome2) {
        this.chromosome2 = chromosome2;
    }
}
