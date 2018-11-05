package com.scm.neppo.breedfinder.service;

import android.annotation.TargetApi;
import android.os.Build;

import com.scm.neppo.breedfinder.data.model.Chromosome;
import com.scm.neppo.breedfinder.data.model.Gene;
import com.scm.neppo.breedfinder.data.model.Genotype;

public interface CrossBreedService {
    Genotype crossing(Genotype phaterGenotipe, Genotype motherGenothipe) throws Exception;

    @TargetApi(Build.VERSION_CODES.N)
    Gene findAlelo(Gene gene, Chromosome chromosome) throws Exception;
}
