package net.travel.booking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.travel.booking.requestVO.BookingRequestVO;
import net.travel.booking.service.BookingService;
import net.travel.common.model.APIResponse;


@RequestMapping("api/v1")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class BookingController {

	private Logger logger = LoggerFactory.getLogger(BookingController.class);

    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking")
    public ResponseEntity<?> create(@RequestBody BookingRequestVO requestVO) {
    	final APIResponse<?> responseVO = bookingService.create(requestVO); 
    	
    	if(responseVO.getError()==null || responseVO.getError().length()==0){
    		return ResponseEntity.ok(responseVO);

         }
    	
		logger.info("POST /api/v1/booking/create ==> bad request: req: {}, resp: {}", requestVO, responseVO);
        return new ResponseEntity<>(responseVO, HttpStatus.BAD_REQUEST);
    }
    

    @PutMapping ("/booking")
    public ResponseEntity<?> edit(@RequestBody BookingRequestVO requestVO) {
    	final APIResponse<?> responseVO = bookingService.edit(requestVO); 
    	
    	if(responseVO.getError()==null || responseVO.getError().length()==0){
    		return ResponseEntity.ok(responseVO);

         }
    	
		logger.info("PUT /api/v1/booking/edit ==> bad request: req: {}, resp: {}", requestVO, responseVO);
        return new ResponseEntity<>(responseVO, HttpStatus.BAD_REQUEST);
    }
    
    @GetMapping ("/booking")
    public ResponseEntity<?> get() {
    	final APIResponse<?> responseVO = bookingService.getAll(); 
    	
    	if(responseVO.getError()==null || responseVO.getError().length()==0){
    		return ResponseEntity.ok(responseVO);

         }
    	
		logger.info("GET /api/v1/booking ==> bad request: req: {}, resp: {}", null, responseVO);
        return new ResponseEntity<>(responseVO, HttpStatus.BAD_REQUEST);
    }
    
    @GetMapping ("/booking/{id}/detail")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
    	final APIResponse<?> responseVO = bookingService.getById(id); 
    	
    	if(responseVO.getError()==null || responseVO.getError().length()==0){
    		return ResponseEntity.ok(responseVO);

         }
    	
		logger.info("GET /api/v1/booking/id/detail ==> bad request: req: {}, resp: {}", null, responseVO);
        return new ResponseEntity<>(responseVO, HttpStatus.BAD_REQUEST);
    }
    
    @DeleteMapping ("/booking/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
    	final APIResponse<?> responseVO = bookingService.getById(id); 
    	
    	if(responseVO.getError()==null || responseVO.getError().length()==0){
    		return ResponseEntity.ok(responseVO);

         }
    	
		logger.info("DELETE /api/v1/booking/id/detail ==> bad request: req: {}, resp: {}", null, responseVO);
        return new ResponseEntity<>(responseVO, HttpStatus.BAD_REQUEST);
    }
}
