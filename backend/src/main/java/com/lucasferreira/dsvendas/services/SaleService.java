package com.lucasferreira.dsvendas.services;

import com.lucasferreira.dsvendas.dto.SaleDTO;
import com.lucasferreira.dsvendas.dto.SaleSuccessDTO;
import com.lucasferreira.dsvendas.dto.SaleSumDTO;
import com.lucasferreira.dsvendas.entities.Sale;
import com.lucasferreira.dsvendas.repositories.SaleRepository;
import com.lucasferreira.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable) {
        sellerRepository.findAll();
        Page<Sale> result = repository.findAll(pageable);
        return result.map(x -> new SaleDTO(x));
    }

    @Transactional(readOnly = true)
    public List<SaleSumDTO> amountGroupedBySeller() {
        return repository.amountGroupedBySeller();
    }

    @Transactional(readOnly = true)
    public List<SaleSuccessDTO> successGroupedBySeller() {
        return repository.successGroupedBySeller();
    }
}
