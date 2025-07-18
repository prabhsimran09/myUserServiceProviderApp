package com.example.demo.services;

import com.example.demo.models.ServiceProvider;

public interface ProviderService {

    Long addProvider(String providerName);

    ServiceProvider getServiceProvider(Long providerId);

    boolean checkIfProviderExists(String providerId);
}
