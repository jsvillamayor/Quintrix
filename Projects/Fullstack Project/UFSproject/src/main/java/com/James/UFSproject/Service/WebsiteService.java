package com.James.UFSproject.Service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.James.UFSproject.Controllers.Tinyurl.TinyUrlController;
import com.James.UFSproject.Models.Website;
import com.James.UFSproject.Repo.WebsiteRepo;

@Service
@Transactional
public class WebsiteService {
	
	private final WebsiteRepo websiteRepo;
	
	Logger log = LoggerFactory.getLogger(TinyUrlController.class);
	
	@Autowired
	public WebsiteService(WebsiteRepo websiteRepo) {
		this.websiteRepo = websiteRepo;
	}
	
	public Website addWebsite(Website website) {
		String tinyurl = String.valueOf(UUID.randomUUID().toString().replace("-", "").substring(0,8));
		website.setTinyUrl(tinyurl.toUpperCase());
		log.info("TinyUrl created");
		return websiteRepo.save(website);
	}
	
	public List<Website> findAllWebsites(){
		log.info("List of all websites generated");
		return websiteRepo.findAll();
	}
	
	public void deleteWebsite(Long id) {
		log.info("Website of ID " + id + " deleted");
		websiteRepo.deleteWebsiteById(id);
	}
	
}
