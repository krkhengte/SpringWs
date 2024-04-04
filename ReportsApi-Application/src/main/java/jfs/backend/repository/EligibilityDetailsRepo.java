package jfs.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.servlet.http.HttpServletResponse;
import jfs.backend.entity.EligibilityDetails;
import jfs.backend.request.SearchRequest;
import jfs.backend.response.SearchResponse;

@Repository
public interface EligibilityDetailsRepo extends JpaRepository<EligibilityDetails, Integer>{
	
//	public List<String> findByPlanName(String planName);
	
	@Query("select distinct(planName) from EligibilityDetails")
	public List<String> findPlanNames();
	
	
	@Query("select distinct(planStatus) from EligibilityDetails")
	public List<String> findPlanStatuses();
}
