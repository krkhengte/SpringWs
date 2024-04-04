package jfs.backend.eligibilityService;

import java.util.List;

import jakarta.servlet.http.HttpServletResponse;
import jfs.backend.request.SearchRequest;
import jfs.backend.response.SearchResponse;

public interface ReportService {

	public List<String> getUniquePlanNames();
	
	public List<String> getUniquePlanStatuses();
	
	public List<SearchResponse> search(SearchRequest request);
	
	public void generateExcel(HttpServletResponse response) throws Exception;
	
	public void generatePdf(HttpServletResponse response) throws Exception;
}
