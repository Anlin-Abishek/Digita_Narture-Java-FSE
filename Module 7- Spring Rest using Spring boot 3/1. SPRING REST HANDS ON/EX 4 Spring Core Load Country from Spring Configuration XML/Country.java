package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {

    private static final Logger LOG = LoggerFactory.getLogger(Country.class);

    private String code;
    private String name;

    public Country() {
        LOG.debug("Inside Country Constructor.");
    }

    public String getCode() {
        LOG.debug("Inside getCode. code={}", code);
        return code;
    }

    public void setCode(String code) {
        LOG.debug("Inside setCode. code={}", code);
        this.code = code;
    }

    public String getName() {
        LOG.debug("Inside getName. name={}", name);
        return name;
    }

    public void setName(String name) {
        LOG.debug("Inside setName. name={}", name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
