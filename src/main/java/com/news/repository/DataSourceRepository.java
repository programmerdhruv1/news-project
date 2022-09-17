package com.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.news.model.DataSourceDto;

public interface DataSourceRepository extends JpaRepository<DataSourceDto, Long> {

}
