package vn.iostar.dao;

import java.util.List;
import vn.iostar.model.Category;

public interface CategoryDao {
    void insert(Category category);
    void update(Category category);
    void delete(int id);
    Category findById(int id);
    List<Category> findAll();
    
    List<Category> searchAndPaginate(String search, int offset, int limit);
    int countCategories(String search);
}
