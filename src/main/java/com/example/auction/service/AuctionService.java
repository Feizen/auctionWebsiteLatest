package com.example.auction.service;

import com.example.auction.model.Auction;

public interface AuctionService {


    /**
     * Find auction by Id
     *
     * @param auctionId
     * @return Auction
     */
    Auction FindAuctionById(Integer auctionId);


    /**
     * Find auction by category
     *
     * @param categoryName
     * @return Auction
     */

    Auction findAuctionByCategory(String categoryName);
}
