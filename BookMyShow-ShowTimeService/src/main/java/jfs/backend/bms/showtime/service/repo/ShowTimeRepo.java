package jfs.backend.bms.showtime.service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jfs.backend.bms.showtime.service.entity.ShowTime;
import jfs.backend.bms.showtime.service.payload.ShowTimeDto;

public interface ShowTimeRepo extends JpaRepository<ShowTime, String> {
	
	public List<ShowTime> findByStartTimeContaining(String startTime);

}
