package com.cinexpress.videofriend.services;

import com.cinexpress.videofriend.models.Company;

public interface CompanyService {
    Company createCompany(Company company);
    void deleteCompany(Long id);
}
