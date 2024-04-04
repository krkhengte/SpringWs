package jfs.backend.bms.theater.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import jfs.backend.bms.theater.service.entity.Theater;

public interface TheaterRepository extends JpaRepository<Theater, String>{

}
