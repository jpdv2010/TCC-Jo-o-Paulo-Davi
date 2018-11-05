package com.scm.neppo.breedfinder.service.implementation;

import android.annotation.TargetApi;
import android.os.Build;

import com.scm.neppo.breedfinder.data.model.Chromosome;
import com.scm.neppo.breedfinder.data.model.Gene;
import com.scm.neppo.breedfinder.data.model.Genotype;
import com.scm.neppo.breedfinder.service.CrossBreedService;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CrosBreedServiceImplementation implements CrossBreedService {

    @Override
    public Genotype crossing(Genotype phaterGenotipe, Genotype motherGenothipe) throws Exception {
        Genotype sonGenotype = new Genotype();

        for(Gene phaterGene : phaterGenotipe.getChromosome1().getGenome()){
            for(Gene motherGene :motherGenothipe.getChromosome1().getGenome()){
                Gene phaterAlelo = findAlelo(phaterGene, phaterGenotipe.getChromosome2());
                Gene motherAlelo = findAlelo(motherGene, motherGenothipe.getChromosome2());

                Gene[] genes = new Gene[]{phaterGene,phaterAlelo};
                Gene sonGene = getGene(genes);

                Gene[] alelos = new Gene[]{motherGene, motherAlelo};
                Gene sonAlelo = getGene(alelos);

                sonGenotype.getChromosome1().getGenome().add(sonGene);
                sonGenotype.getChromosome2().getGenome().add(sonAlelo);
            }
        }
        return sonGenotype;
    }

    private Gene getGene(Gene[] genes) {
        Integer index = new Random().nextInt(genes.length);
        return genes[index];
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public Gene findAlelo(final Gene gene, Chromosome chromosome) throws Exception {
        List<Gene> genes = chromosome.getGenome().stream()
                .filter(g -> g.getId().equals(gene.getId())).collect(Collectors.toList());
        if(genes != null && genes.size() > 0){
            return genes.get(0);
        } else {
            throw new Exception("Alelo not founded");
        }
    }
}
