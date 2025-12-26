package com.example.demo.service.impl;

import com.example.demo.dto.LoanDtos;
import com.example.demo.entity.LoanRequest;
import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LoanRequestService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Service
public class LoanRequestServiceImpl implements LoanRequestService {

    private final LoanRequestRepository loanRequestRepository;
    private final UserRepository userRepository;

    public LoanRequestServiceImpl(LoanRequestRepository loanRequestRepository, UserRepository userRepository) {
        this.loanRequestRepository = loanRequestRepository;
        this.userRepository = userRepository;
    }

    @Override
    public LoanRequest submitLoanRequest(LoanRequest request) {
        return loanRequestRepository.save(request);
    }

    public LoanRequest create(LoanDtos.LoanRequestDto dto) {
        if (dto.getRequestedAmount() <= 0) {
            throw new BadRequestException("Requested amount");
        }

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        LoanRequest loanRequest = new LoanRequest();
        loanRequest.setUser(user);
        loanRequest.setRequestedAmount(dto.getRequestedAmount());
        loanRequest.setTenureMonths(dto.getTenureMonths());
        loanRequest.setPurpose(dto.getPurpose());
        loanRequest.setStatus("PENDING");
        loanRequest.setAppliedAt(new Timestamp(System.currentTimeMillis()));

        return loanRequestRepository.save(loanRequest);
    }

    @Override
    public LoanRequest getRequestById(Long id) {
        return loanRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan request not found"));
    }

    public List<LoanRequest> getByUserId(Long userId) {
        return loanRequestRepository.findByUserId(userId);
    }

    @Override
    public LoanRequest getById(Long id) {
        return loanRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan request not found"));
    }

    @Override
    public List<LoanRequest> getAllRequests() {
        return loanRequestRepository.findAll();
    }
}
