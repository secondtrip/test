package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.MyDataMongo;
@Repository
public interface MyDataMongoRepository extends MongoRepository<MyDataMongo, String>{
	public MyDataMongo findByid(String id);
}