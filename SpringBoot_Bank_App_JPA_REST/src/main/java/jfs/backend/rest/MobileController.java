
package jfs.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jfs.backend.dto.MobileDto;
import jfs.backend.entity.Mobile;
import jfs.backend.service.MobileService;

@RestController
public class MobileController {

	@Autowired
	private MobileService mobileService;

	@PostMapping("/addMobileNumber")
	public ResponseEntity<String> addMobile(@RequestBody MobileDto mobileDto, Integer customerId) {

		String addMobileNum = mobileService.addMobileNum(mobileDto, customerId);

		return new ResponseEntity<String>(addMobileNum, HttpStatus.CREATED);
	}
}
