package com.basicbankingsystem.Basic.Banking.System.services;

import com.basicbankingsystem.Basic.Banking.System.models.Transfer;
import com.basicbankingsystem.Basic.Banking.System.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferService {
    @Autowired
    TransferRepository transferRepository;

    public List<Transfer> getAll()
    {
        return transferRepository.findAll();
    }
}
