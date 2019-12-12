package com.example.auction.repository;

import com.example.auction.module.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends JpaRepository<Message, Long> {

   List<Message> findByText(String text);

}
