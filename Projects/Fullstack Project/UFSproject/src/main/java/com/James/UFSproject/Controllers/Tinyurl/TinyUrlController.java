package com.James.UFSproject.Controllers.Tinyurl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.James.UFSproject.Models.Website;
import com.James.UFSproject.Service.WebsiteService;

@RestController
@RequestMapping("/tinyurl")
public class TinyUrlController {

	Logger log = LoggerFactory.getLogger(TinyUrlController.class);
	
	private final WebsiteService websiteService;
	
	public TinyUrlController(WebsiteService websiteService) {
		this.websiteService = websiteService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Website>> getAllWebsites(){
		log.info("Requesting to get list of all websites");
		List<Website> websites = websiteService.findAllWebsites();
		return new ResponseEntity<>(websites, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Website> addWebsite(@RequestBody Website website){
		log.info("Requesting to create new tinyUrl");
		Website newWebsite = websiteService.addWebsite(website);
		return new ResponseEntity<>(newWebsite, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteWebsite(@PathVariable("id") Long id){
		log.info("Requesting to delete website with id " + id);
		websiteService.deleteWebsite(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
