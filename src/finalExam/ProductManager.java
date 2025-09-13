package finalExam;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> products;

    public ProductManager() {
        this.products =new ArrayList<>();
    }

    public void addToProductList(Product product){
        this.products.add(product);
    }

    public List<Product> getProductsList(){
        return this.products;
    }

    @Override
    public String toString() {
        return "ProductManager{" +
                "products=" + products +
                '}';
    }
}
