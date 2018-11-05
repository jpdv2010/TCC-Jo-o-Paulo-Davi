package com.scm.neppo.breedfinder.service.implementation;

import com.scm.neppo.breedfinder.data.enumeration.GeneType;
import com.scm.neppo.breedfinder.data.model.Environment;
import com.scm.neppo.breedfinder.data.model.Gene;
import com.scm.neppo.breedfinder.data.model.Genotype;
import com.scm.neppo.breedfinder.service.CrossBreedService;
import com.scm.neppo.breedfinder.service.TrainingService;

import java.util.List;

public class TrainingServiceImpl implements TrainingService {
    private CrossBreedService crossBreedService;

    private List<Environment> enviroments;
    private double[] weights;

    public void trainNetwordk(Environment env , Genotype genotype) throws Exception {
        int size = genotype.getChromosome1().getGenome().size();
        double[] deltaW=new double[size];
        //TODO get enviroment list
        int[] neuros=getArray(genotype, size);

        double majorError = 1;
        int desiredOutput;
        double quadraticError;
        int cicles = 0;
        double minimError = 0.001;
        while (majorError > minimError)
        {
            majorError = 0;
            for (Environment enviroment : enviroments) {
                if (enviroment.equals(env))//DEFINE A SAIDA DESEJADA
                {
                    desiredOutput = 1;
                } else {
                    desiredOutput = -1;
                }
                double somatory = 0;
                for (int k = 0; k < size; k++)//-----------calculo de somatorio
                {
                    somatory += (neuros[k] * this.weights[k]);
                }
                if (somatory >= 0) {
                    somatory = 1;
                } else {
                    somatory = -1;
                }

                double erro = desiredOutput - somatory;//CALCULA O ERRO
                quadraticError = Math.pow(erro, 2) / 2;//CALCULA O ERRO QUADRATICO
                if (quadraticError > majorError) {
                    majorError = quadraticError;
                }//ATUALOZA O MAIOR ERRO Q.

                for (int j = 0; j < size; j++)//ATUALIZA OS PESOS DA LETRA
                {
                    double learningRate = 0.02;
                    deltaW[j] = erro * neuros[j] * learningRate;
                    this.weights[j] += deltaW[j];
                }

                //TODO: SAVE WAIGHTS ON BASE
            }
        }
    }

    @Override
    public int[] getArray(Genotype genotype, int size) throws Exception {
        crossBreedService = new CrosBreedServiceImplementation();
        int[] array = new int[size];
        int i = 0;
        for(Gene gene : genotype.getChromosome1().getGenome()){
            Gene alelo = crossBreedService.findAlelo(gene, genotype.getChromosome2());

            if(gene.getGeneType().equals(GeneType.DOMINANT) ||	 alelo.getGeneType().equals(GeneType.DOMINANT)){
                array[i++] = 1;
            } else {
                array[i++] = -1;
            }
        }
        return array;
    }
}
