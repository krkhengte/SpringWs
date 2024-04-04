package jfs.backend.bms.theater.service.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jfs.backend.bms.theater.service.payload.TheaterDto;
import jfs.backend.bms.theater.service.service.TheaterService;


@RestController
@RequestMapping("/theaters")
public class TheaterController {

	@Autowired
	private TheaterService theaterService;
	
	@PostMapping("/addNewTheater")
	public ResponseEntity<TheaterDto> addNewTheater(@Valid @RequestBody TheaterDto theaterDto){
		
		TheaterDto addNewTheater = this.theaterService.addNewTheater(theaterDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(addNewTheater);
		
	}
	
	@GetMapping("/getAllTheaters")
	public ResponseEntity<List<TheaterDto>> getAllTheaters(){
		
		List<TheaterDto> allTheaters = this.theaterService.getAllTheaters();
		
		return ResponseEntity.status(HttpStatus.OK).body(allTheaters);
		
	}
	
	@PutMapping("/updateTheater/{theaterId}")
	public ResponseEntity<TheaterDto> updateTheterDetails(@Valid @PathVariable String theaterId){
		
		TheaterDto updateTheater = this.theaterService.updateTheater(theaterId);
		
		return ResponseEntity.status(HttpStatus.OK).body(updateTheater);
	}
	
	@DeleteMapping("/deleteTheater/{theaterId}")
	public ResponseEntity<String> deleteTheater(@Valid @PathVariable String theaterId){
	
		String deleteTheater = this.theaterService.deleteTheater(theaterId);
		
		return ResponseEntity.status(HttpStatus.OK).body(deleteTheater);
	}
	@GetMapping("/getTheaterDetailsById/{theaterId}")
	public ResponseEntity<TheaterDto> getTheaterDetailsById(@Valid @PathVariable String theaterId){
		
		TheaterDto theaterDetails = this.theaterService.getTheaterDetails(theaterId);
		
		return ResponseEntity.status(HttpStatus.OK).body(theaterDetails);
	}
	
	
	@PatchMapping(value = "/updateSpecificValue/{theaterId}",consumes = {"multipart/form-data","application/json","application/xml"})
    public ResponseEntity<TheaterDto> updateSpecificField(@PathVariable ("theaterId") String theaterId,@RequestBody Map<String,Object> objectMap){
        System.out.println (objectMap.isEmpty ());
        TheaterDto updatedTheaterDto = this.theaterService.updateSpecificField(theaterId,objectMap );
        return ResponseEntity.ok(updatedTheaterDto);
    }
	
}
