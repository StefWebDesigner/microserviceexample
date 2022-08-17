package com.MicroservicesSpringExample.repository;

import com.MicroservicesSpringExample.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
