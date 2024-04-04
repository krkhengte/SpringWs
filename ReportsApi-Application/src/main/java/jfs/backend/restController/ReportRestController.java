package jfs.backend.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import jfs.backend.eligibilityService.ReportService;
import jfs.backend.request.SearchRequest;
import jfs.backend.response.SearchResponse;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class ReportRestController {

	@Autowired
	private ReportService reportService;

	@GetMapping("/getUniqyePlanName")
	public ResponseEntity<List<String>> getUniquePlanName() {

		List<String> uniquePlanNames = this.reportService.getUniquePlanNames();

		return ResponseEntity.status(HttpStatus.OK).body(uniquePlanNames);

	}

	@GetMapping("/getUniquePlanStatuses")
	public ResponseEntity<List<String>> getUniquePLanStatus() {

		List<String> uniquePlanStatuses = this.reportService.getUniquePlanStatuses();

		return ResponseEntity.status(HttpStatus.OK).body(uniquePlanStatuses);
	}

	@PostMapping("/searchRequest")
	public ResponseEntity<List<SearchResponse>> search(@RequestBody SearchRequest request) {

		List<SearchResponse> search = this.reportService.search(request);

		return ResponseEntity.status(HttpStatus.OK).body(search);

	}

	@GetMapping("/downloadExcel")
	public void generateExcel(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");

		String headerKey = "Content-Disposition";

		String headerValue = "attachment;filename= data.xls";

		response.setHeader(headerKey, headerValue);

		this.reportService.generateExcel(response);

	}

	@GetMapping("/downloadPdf")
	public void generatePdf(HttpServletResponse response) throws Exception {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		reportService.generatePdf(response);

		// UserPDFExporter exporter = new UserPDFExporter(listUsers);

		// exporter.export(response);

	}

}
