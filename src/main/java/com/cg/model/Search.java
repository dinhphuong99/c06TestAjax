package com.cg.model;

import java.math.BigDecimal;

public class Search {

    private BigDecimal minMoney = BigDecimal.valueOf(0);
    private BigDecimal maxMoney = BigDecimal.valueOf(0);

    public Search() {
    }

    public Search(BigDecimal minMoney, BigDecimal maxMoney) {
        this.minMoney = minMoney;
        this.maxMoney = maxMoney;
    }

    public BigDecimal getMinMoney() {
        return minMoney;
    }

    public void setMinMoney(BigDecimal minMoney) {
        this.minMoney = minMoney;
    }

    public BigDecimal getMaxMoney() {
        return maxMoney;
    }

    public void setMaxMoney(BigDecimal maxMoney) {
        this.maxMoney = maxMoney;
    }
}

