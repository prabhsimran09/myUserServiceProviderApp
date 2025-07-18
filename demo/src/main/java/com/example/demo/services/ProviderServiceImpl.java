package com.example.demo.services;

import com.example.demo.dao.ProviderDao;
import com.example.demo.models.ServiceProvider;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProviderServiceImpl implements ProviderService{

    ProviderDao providerDao;

    public ProviderServiceImpl(ProviderDao providerDao) {
        this.providerDao = providerDao;
    }

    @Override
    public Long addProvider(String providerName) {
        ServiceProvider provider = new ServiceProvider();
        provider.setServiceProviderName(providerName);
        return providerDao.save(provider).getServiceProviderID();
    }

    @Override
    public ServiceProvider getServiceProvider(Long providerId) {
        Optional<ServiceProvider> provider = providerDao.findById(providerId);
        return provider.orElse(null);
    }

    @Override
    public boolean checkIfProviderExists(String providerId){
        int count = providerDao.getProviderCount(providerId);
        return count > 0;
    }
}
