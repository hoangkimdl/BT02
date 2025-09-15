package vn.iostar.service;

import java.util.List;
import vn.iostar.model.Category;

public interface CategoryService {
    void insert(Category category);
    void update(Category category);
    void delete(int id);
    Category findById(int id);
    List<Category> findAll();
 // Thêm các phương thức mới
    List<Category> searchAndPaginate(String search, int offset, int limit);
    int countCategories(String search);
}
