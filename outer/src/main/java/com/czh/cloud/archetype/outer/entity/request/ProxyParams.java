package com.czh.cloud.archetype.outer.entity.request;

import java.util.HashMap;

public class ProxyParams {

    private String endpoint;

    private HashMap<String, Object> parameters;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public HashMap<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(HashMap<String, Object> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "ProxyRequest{" +
                "endpoint='" + endpoint + '\'' +
                ", parameters=" + parameters +
                '}';
    }
}
