package com.news.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.news.model.ResponseDataDto;

@Repository
public interface ResponseDataRepository extends JpaRepository<ResponseDataDto, Long> {

	
}
