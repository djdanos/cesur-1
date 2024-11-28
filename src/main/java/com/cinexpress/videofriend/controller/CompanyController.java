package com.cinexpress.videofriend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinexpress.videofriend.models.Company;
import com.cinexpress.videofriend.services.CompanyService;

@RestController
@RequestMapping("'/company'")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    public ResponseEntity<Void> createCompany(@RequestBody Company company) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PatchMapping()
    public ResponseEntity<Void> updateCompany(@RequestBody Company company) {
        try {
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}
