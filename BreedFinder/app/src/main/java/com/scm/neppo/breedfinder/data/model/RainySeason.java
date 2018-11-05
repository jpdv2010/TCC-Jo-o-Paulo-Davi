package com.scm.neppo.breedfinder.data.model;

import java.util.Date;

public class RainySeason {
    private Date begins;
    private Date end;
    private Double milimeters;

    public Double getMilimeters() {
        return milimeters;
    }

    public void setMilimeters(Double milimeters) {
        this.milimeters = milimeters;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getBegins() {
        return begins;
    }

    public void setBegins(Date begins) {
        this.begins = begins;
    }
}
