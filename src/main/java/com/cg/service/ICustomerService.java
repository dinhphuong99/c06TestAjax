package com.cg.service;

import com.cg.model.Customer;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ICustomerService extends IGeneralService<Customer> {

    Optional<Customer> findByFirstName(String firstName);

    Optional<Customer> findByLastNameNativeQuery(String lastName);

    Iterable<Customer> findAllByBalance(BigDecimal minMoney, BigDecimal maxMoney);

}
