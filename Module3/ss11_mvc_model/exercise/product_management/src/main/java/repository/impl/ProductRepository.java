package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1,"Máy tính",2000000,"sản phẩm mới","ABC"));
        productList.add(new Product(2,"Điện thoại",3000000,"sản phẩm nhỏ","DEF"));
        productList.add(new Product(3,"Tủ Lạnh",1000000,"sản phẩm to","NML"));
    }
    @Override
    public List<Product> findAll() {
        return productList;
    }
    @Override
    public Product findById(int id){
        Product product = null;
        for (int i = 0; i <productList.size() ; i++) {
            if(id==productList.get(i).getId()){
                product = productList.get(i);
                break;
            }
        }
        return product;
    }

    @Override
    public Product findByName(String name) {
        return null;
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public void update(int id,Product product) {
        for (int i = 0; i <productList.size() ; i++) {
            if(productList.get(i).getId()==id){
                productList.set(id,product);
            }
        }
    }

    @Override
    public void delete(int id) {
        productList.remove(id);
    }

    @Override
    public Product findByName() {
        return null;
    }
}
