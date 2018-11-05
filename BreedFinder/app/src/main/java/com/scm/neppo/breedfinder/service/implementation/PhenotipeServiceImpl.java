package com.scm.neppo.breedfinder.service.implementation;

import com.scm.neppo.breedfinder.data.model.Environment;
import com.scm.neppo.breedfinder.data.model.Genotype;
import com.scm.neppo.breedfinder.service.CrossBreedService;
import com.scm.neppo.breedfinder.service.PhenotipeService;
import com.scm.neppo.breedfinder.service.TrainingService;

import java.util.ArrayList;
import java.util.List;

public class PhenotipeServiceImpl implements PhenotipeService {
    private TrainingService trainingService;

    public List<Genotype> getPhenotipe(Environment environment) throws Exception {
        List<Genotype> genotypes = new ArrayList<>();
        CrossBreedService crossBreedService = new CrosBreedServiceImplementation();
        List<Genotype> aceptableGenotypes = new ArrayList<>();
        double[] wheights = new double[genotypes.get(0).getChromosome1().getGenome().size()];//TODO get this on base

        for(Genotype genotype1 : genotypes){
            for(Genotype genotype2 : genotypes){
                if(genotype1 != genotype2){
                    Genotype sonGenotype = crossBreedService.crossing(genotype1, genotype2);
                    int[] neuros = trainingService.getArray(sonGenotype, sonGenotype.getChromosome1().getGenome().size());
                    int somatory = 0;
                    if(wheights.length > 0){
                        for(int i = 0; i < neuros.length; i ++){
                            somatory += neuros[i] * wheights[i];
                        }
                        if(somatory > 0) aceptableGenotypes.add(sonGenotype);
                    }
                }
            }
        }
        return aceptableGenotypes;
    }
}
