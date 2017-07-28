package com.traz.exampleapp.presenter.viewObject;

import java.io.Serializable;

/**
 * Created by TRaz on 27.07.17.
 * Have to work
 */

public class Rate implements Serializable {
    private String name;
    private double rateValue;

    public Rate(String name, double rateValue) {
        this.name = name;
        this.rateValue = rateValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRateValue() {
        return rateValue;
    }

    public void setRateValue(double rateValue) {
        this.rateValue = rateValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rate rate = (Rate) o;

        if (Double.compare(rate.rateValue, rateValue) != 0) return false;
        return name != null ? name.equals(rate.name) : rate.name == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(rateValue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}