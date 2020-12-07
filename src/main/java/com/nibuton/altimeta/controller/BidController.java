package com.nibuton.altimeta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nibuton.altimeta.entities.Bid;
import com.nibuton.altimeta.entities.BidItem;
import com.nibuton.altimeta.exception.BidValidationException;
import com.nibuton.altimeta.exception.BidValidationExceptionResponse;
import com.nibuton.altimeta.service.BidService;

@RestController
@RequestMapping("/")
public class BidController {
	
	BidService bidService;

	@Autowired
	public BidController(BidService bidService) {
		this.bidService = bidService;
	}
	
	@PostMapping
	//@ResponseBody
	public int saveBid(@RequestBody Bid bid) {
		Bid returnedBid = bidService.save(bid);
		return returnedBid.getId();
	}
	
	/*@GetMapping("/best")
	public BidItem returnBestBid(@RequestParam int trade_item_id) {
		return bidService.returnBestBid();
	} */
	
	@ExceptionHandler(BidValidationException.class)
	public ResponseEntity<BidValidationExceptionResponse> 
	handleBidValidationException(BidValidationException ex) {
	
			BidValidationExceptionResponse response = new BidValidationExceptionResponse();
			response.setStatus_code(ex.getCode());
			response.setTrade_item_id(ex.getTrade_item_id());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

		}
	
	

}
