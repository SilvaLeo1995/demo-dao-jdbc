package model.dao;

import model.entities.Seller;

import java.util.List;

public interface SellerDao {

    static void insert(Seller obj);

    static void update(Seller obj);

    static void deleteById(int id);

    Department findById(int id);

    List<Seller> findAll();


}
