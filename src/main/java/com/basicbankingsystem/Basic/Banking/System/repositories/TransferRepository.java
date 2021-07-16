package com.basicbankingsystem.Basic.Banking.System.repositories;

import com.basicbankingsystem.Basic.Banking.System.models.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Integer> {
}
