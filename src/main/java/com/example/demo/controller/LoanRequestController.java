package com.example.demo.controller;
import com.example.demo.model.LoanRequest;
import com.example.demo.service.LoanRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/loan-requests")
public class LoanRequestController{
    @Autowired
    LoanRequestService service;

    @PostMapping
    public LoanRequest submit()
}