package com.example.auction.repository;

import com.example.auction.model.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends JpaRepository<Auction, Long> {

   List<Auction> findByName(String name);
   Auction findAuctionById(Integer auctionId);
   List<Auction> findAuctionByCategory(String category);

}
