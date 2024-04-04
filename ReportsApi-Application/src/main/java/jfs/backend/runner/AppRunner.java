package jfs.backend.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import jfs.backend.entity.EligibilityDetails;
import jfs.backend.repository.EligibilityDetailsRepo;

@Component
public class AppRunner implements ApplicationRunner{

	@Autowired
	private EligibilityDetailsRepo repo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
	
		EligibilityDetails eDetails=new EligibilityDetails();
		eDetails.setEligId(1);
		eDetails.setEmail("krkhengate123@gmail.com");
		eDetails.setName("kartik");
		eDetails.setCreateDate(LocalDate.now());
		eDetails.setCreatedBy("Kartik");
		eDetails.setPlanEndDate(LocalDate.now());
		
	//	repo.save(eDetails);
		
		
		EligibilityDetails eDetails2=new EligibilityDetails();
		eDetails2.setEligId(2);
		eDetails2.setEmail("krkhengate123@gmail.com");
		eDetails2.setName("kartik");
		eDetails2.setCreateDate(LocalDate.now());
		eDetails2.setCreatedBy("Kartik");
		eDetails2.setPlanEndDate(LocalDate.now());
		
	//	repo.save(eDetails2);
		
		
		EligibilityDetails eDetails3=new EligibilityDetails();
		eDetails3.setEligId(3);
		eDetails3.setEmail("krkhengate123@gmail.com");
		eDetails3.setName("kartik");
		eDetails3.setCreateDate(LocalDate.now());
		eDetails3.setCreatedBy("Kartik");
		eDetails3.setPlanEndDate(LocalDate.now());
		
	//	repo.save(eDetails3);
		
	}

}
