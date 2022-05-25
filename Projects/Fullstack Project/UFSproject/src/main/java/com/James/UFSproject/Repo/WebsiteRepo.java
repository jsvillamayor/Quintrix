package com.James.UFSproject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.James.UFSproject.Models.Website;

public interface WebsiteRepo extends JpaRepository<Website, Long>{
	void deleteWebsiteById(Long id);
}
