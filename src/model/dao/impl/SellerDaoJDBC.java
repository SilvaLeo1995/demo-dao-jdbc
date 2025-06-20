package model.dao.impl;

import model.dao.SellerDao;
import model.entities.Seller;
import model.entities.Department;
import java.sql.Connection;

import java.util.List;

public class SellerDaoJDBC implements SellerDao{

    private Connection conn;

    public SellerDaoJDBC(Connection conn){
        this.conn = conn;
    }


    @Override
    public void insert(Seller obj){
    }

    @Override
    public void update(Seller obj){
    }

    @Override
    public void deleteById(int id){
    }

    @Override
    public Seller findById(int id) {
        return null;
    }

    @Override
    public List<Seller> findAll() {
        return List.of();
    }
}
