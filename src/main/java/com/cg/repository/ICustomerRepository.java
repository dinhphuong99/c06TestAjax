package com.cg.repository;

import com.cg.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAllByFirstNameAndLastName(String firstName, String lastName);


    Optional<Customer> findByFirstName(String firstName);



//    @Query("SELECT c FROM Customer c WHERE c.lastName = :lastName")
//    Optional<Customer> findByLN(@Param("lastName") String lastName);

    @Query(value = "SELECT * FROM customers c WHERE c.lastName = :lastName", nativeQuery = true)
    Optional<Customer> findByLastNameNativeQuery(@Param("lastName") String lastName);



    @Query(value = "SELECT c FROM Customer c WHERE c.balance >= :minMoney AND c.balance <= :maxMoney")
    Iterable<Customer> findAllByBalance(@Param("minMoney") BigDecimal minMoney, @Param("maxMoney") BigDecimal maxMoney);

}
