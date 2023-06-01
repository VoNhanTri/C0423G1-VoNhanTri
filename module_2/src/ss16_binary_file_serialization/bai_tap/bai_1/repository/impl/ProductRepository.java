package ss16_binary_file_serialization.bai_tap.bai_1.repository.impl;

import ss16_binary_file_serialization.bai_tap.bai_1.comon.ReadAndWriteToFile;
import ss16_binary_file_serialization.bai_tap.bai_1.model.Product;
import ss16_binary_file_serialization.bai_tap.bai_1.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();
    private static final String PATH_PRODUCT_LIST = "src/ss16_binary_file_serialization/bai_tap/bai_1/data/product.csv";
    static {
        productList.add(new Product("1","bánh",30000,100,"good"));
        productList.add(new Product("2","kẹo",20000,100,"good"));
        productList.add(new Product("3","nước",40000,200,"good"));
//        ReadAndWriteToFile.writeToFile(PATH_PRODUCT_LIST,productList);
    }

    @Override
    public List<Product> getAll() {
        productList = ReadAndWriteToFile.readToFile(PATH_PRODUCT_LIST);
        return productList;
    }

    @Override
    public void addProduct(Product product) {
        productList = ReadAndWriteToFile.readToFile(PATH_PRODUCT_LIST);
        productList.add(product);
        ReadAndWriteToFile.writeToFile(PATH_PRODUCT_LIST, productList);
    }

    @Override
    public Product getByCode(String code) {
        productList = ReadAndWriteToFile.readToFile(PATH_PRODUCT_LIST);
        for (Product product: productList) {
            if (product.getCode().equals(code)){
                return product;
            }
        }
        return null;
    }

    @Override
    public void searchProduct(String name) {
        productList = ReadAndWriteToFile.readToFile(PATH_PRODUCT_LIST);
        for (Product find: productList){
            if (find.getName().contains(name)){
                System.out.println(find);
            }
        }
    }
}
