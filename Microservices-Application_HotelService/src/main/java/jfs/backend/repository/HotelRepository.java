package jfs.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import jfs.backend.entity.Hotel;

@EnableJpaRepositories
@Repository
public interface HotelRepository extends JpaRepository<Hotel, String>{

}
