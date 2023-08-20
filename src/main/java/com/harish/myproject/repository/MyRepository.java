package com.harish.myproject.repository;

import com.harish.myproject.model.Personalinfo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import org.springframework.stereotype.Repository;


@Repository
public interface MyRepository extends ReactiveMongoRepository<Personalinfo,String> {


}

