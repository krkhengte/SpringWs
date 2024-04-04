package jfs.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jfs.backend.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
