package jfs.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import jfs.backend.entity.Address;
import jfs.backend.entity.Customer;

@Repository
@EnableJpaRepositories
public interface AddressRepository extends JpaRepository<Address, Integer> {

	List<Address> findByCustomers(Customer customer);


	
}
