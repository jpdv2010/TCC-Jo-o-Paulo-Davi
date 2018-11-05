package com.scm.neppo.breedfinder.service;

import com.scm.neppo.breedfinder.data.model.Genotype;

public interface TrainingService {
    int[] getArray(Genotype genotype, int size) throws Exception;
}
