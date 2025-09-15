package vn.iostar.service.impl;

import vn.iostar.dao.CategoryDao;
import vn.iostar.dao.impl.CategoryDaoImpl;
import vn.iostar.model.Category;
import vn.iostar.service.CategoryService;
import vn.iostar.service.impl.CategoryServiceImpl;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao dao = new CategoryDaoImpl();

    @Override
    public void insert(Category category) { dao.insert(category); }

    @Override
    public void update(Category category) { dao.update(category); }

    @Override
    public void delete(int id) { dao.delete(id); }

    @Override
    public Category findById(int id) { return dao.findById(id); }

    @Override
    public List<Category> findAll() { return dao.findAll(); }
    
    @Override
    public List<Category> searchAndPaginate(String search, int offset, int limit) {
        return dao.searchAndPaginate(search, offset, limit);
    }

    @Override
    public int countCategories(String search) {
        return dao.countCategories(search);
    }
}
