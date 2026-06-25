package com.revature.daodemo.DAO;

import com.revature.daodemo.model.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JdbcProductDAO implements ProductDAO{
    @Override
    public long insert(Product product) throws SQLException {
        return 0;
    }

    @Override
    public Optional<Product> findBySku(String sku) throws Exception {
        return Optional.empty();
    }

    @Override
    public void updatePrice(String sku, double newPrice) throws SQLException {

    }

    @Override
    public void deleteBySku(String sku) throws SQLException {

    }

    @Override
    public List<Product> findAll() throws SQLException {
        return List.of();
    }
}
