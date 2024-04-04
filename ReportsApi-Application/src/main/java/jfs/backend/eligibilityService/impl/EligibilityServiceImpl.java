package jfs.backend.eligibilityService.impl;

import java.awt.Color;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import jfs.backend.eligibilityService.ReportService;
import jfs.backend.entity.EligibilityDetails;
import jfs.backend.repository.EligibilityDetailsRepo;
import jfs.backend.request.SearchRequest;
import jfs.backend.response.SearchResponse;

@Service
public class EligibilityServiceImpl implements ReportService {

	@Autowired
	private EligibilityDetailsRepo eligibilityRepo;

	@Override
	public List<String> getUniquePlanNames() {

		List<String> listOfPlanName = eligibilityRepo.findPlanNames();

		return listOfPlanName;
	}

	@Override
	public List<String> getUniquePlanStatuses() {

		List<String> findPlanStatus = this.eligibilityRepo.findPlanStatuses();

		return findPlanStatus;
	}

	@Override
	public List<SearchResponse> search(SearchRequest request) {

		List<SearchResponse> response = new ArrayList();

		EligibilityDetails queryBuilder = new EligibilityDetails();

		String planName = request.getPlanName();
		if (planName != null && !planName.equals("")) {
			queryBuilder.setPlanName(planName);
		}

		String planStatus = request.getPlanStatus();
		if (planStatus != null && !planStatus.equals("")) {
			queryBuilder.setPlanStatus(planStatus);
		}

		LocalDate planStartDate = request.getPlanStartDate();
		if (planStartDate != null) {

			queryBuilder.setPlanStartDate(planStartDate);
		}

		LocalDate planEndDate = request.getPlanEndDate();
		if (planEndDate != null) {
			queryBuilder.setPlanEndDate(planEndDate);
		}

		Example<EligibilityDetails> example = Example.of(queryBuilder);

		List<EligibilityDetails> entities = eligibilityRepo.findAll(example);

		for (EligibilityDetails entity : entities) {

			SearchResponse sr = new SearchResponse();

			BeanUtils.copyProperties(entity, sr);
			response.add(sr);
		}

		return response;

	}

	@Override
	public void generateExcel(HttpServletResponse response) throws Exception {

		List<EligibilityDetails> entities = eligibilityRepo.findAll();

		HSSFWorkbook workbook = new HSSFWorkbook();

		HSSFSheet sheet = workbook.createSheet();

		HSSFRow headerRow = sheet.createRow(0);

		headerRow.createCell(0).setCellValue("Name");
		headerRow.createCell(1).setCellValue("Email");
		headerRow.createCell(2).setCellValue("CreateDate");
		headerRow.createCell(3).setCellValue("CreatedBy");
		headerRow.createCell(4).setCellValue("PlanEndDate");
		headerRow.createCell(5).setCellValue("PlanName");
		headerRow.createCell(6).setCellValue("PlanStatus");
		headerRow.createCell(7).setCellValue("UpdatedDate");
		headerRow.createCell(8).setCellValue("UpdatedBy");
		headerRow.createCell(9).setCellValue("Gender");
		headerRow.createCell(10).setCellValue("Mobile");

		int i = 1;

		for (EligibilityDetails entity : entities) {

			HSSFRow dataRow = sheet.createRow(i);

			dataRow.createCell(0).setCellValue(entity.getName());
			dataRow.createCell(1).setCellValue(entity.getEmail());
			dataRow.createCell(2).setCellValue(entity.getCreateDate());
			dataRow.createCell(3).setCellValue(entity.getCreatedBy());
			dataRow.createCell(4).setCellValue(entity.getPlanEndDate());
			dataRow.createCell(5).setCellValue(entity.getPlanName());
			dataRow.createCell(6).setCellValue(entity.getPlanStatus());
			dataRow.createCell(7).setCellValue(entity.getUpdateDate());
			dataRow.createCell(8).setCellValue(entity.getUpdatedBy());
			dataRow.createCell(9).setCellValue(String.valueOf(entity.getGender()));
			dataRow.createCell(10).setCellValue(entity.getMobile());

			i++;

		} 

		ServletOutputStream outputStream = response.getOutputStream();

		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}

	@Override
	public void generatePdf(HttpServletResponse response) throws Exception {

		List<EligibilityDetails> entities = eligibilityRepo.findAll();

		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("Search Report", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 1.5f, 3.5f, 3.0f, 3.0f, 1.5f });
		table.setSpacingBefore(10);

		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		Font font1 = FontFactory.getFont(FontFactory.HELVETICA);
		font1.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("Name", font1));

		table.addCell(cell);

		cell.setPhrase(new Phrase("E-mail", font1));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Created Date", font1));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Created By", font1));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Plan End Date", font1));
		table.addCell(cell);

		for (EligibilityDetails entity : entities) {

			table.addCell(entity.getName());
			table.addCell(entity.getEmail());
			table.addCell(String.valueOf(entity.getCreateDate()));
			table.addCell(String.valueOf(entity.getCreatedBy()));
			table.addCell(String.valueOf(entity.getPlanEndDate()));

		}

		document.add(table);

		document.close();

	}

}
