package com.scm.neppo.breedfinder.data.model;

import com.scm.neppo.breedfinder.data.enumeration.Climate;

import java.util.List;

public class Environment {
    private Double temperature;
    private Climate climate;
    private List<Disease> incidentalDiseases;
    private RainySeason rainySeason;
    private Double hectares;
    private Boolean susceptibilityToTicks;

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Climate getClimate() {
        return climate;
    }

    public void setClimate(Climate climate) {
        this.climate = climate;
    }

    public List<Disease> getIncidentalDiseases() {
        return incidentalDiseases;
    }

    public void setIncidentalDiseases(List<Disease> incidentalDiseases) {
        this.incidentalDiseases = incidentalDiseases;
    }

    public RainySeason getRainySeason() {
        return rainySeason;
    }

    public void setRainySeason(RainySeason rainySeason) {
        this.rainySeason = rainySeason;
    }

    public Double getHectares() {
        return hectares;
    }

    public void setHectares(Double hectares) {
        this.hectares = hectares;
    }

    public Boolean getSusceptibilityToTicks() {
        return susceptibilityToTicks;
    }

    public void setSusceptibilityToTicks(Boolean susceptibilityToTicks) {
        this.susceptibilityToTicks = susceptibilityToTicks;
    }
}
