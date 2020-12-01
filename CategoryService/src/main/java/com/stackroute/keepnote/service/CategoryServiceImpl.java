package com.stackroute.keepnote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.keepnote.exception.CategoryDoesNoteExistsException;
import com.stackroute.keepnote.exception.CategoryNotCreatedException;
import com.stackroute.keepnote.exception.CategoryNotFoundException;
import com.stackroute.keepnote.model.Category;
import com.stackroute.keepnote.repository.CategoryRepository;

/*
* Service classes are used here to implement additional business logic/validation 
* This class has to be annotated with @Service annotation.
* @Service - It is a specialization of the component annotation. It doesn't currently 
* provide any additional behavior over the @Component annotation, but it's a good idea 
* to use @Service over @Component in service-layer classes because it specifies intent 
* better. Additionally, tool support and additional behavior might rely on it in the 
* future.
* */
@Service
public class CategoryServiceImpl implements CategoryService {

	/*
	 * Autowiring should be implemented for the CategoryRepository. (Use
	 * Constructor-based autowiring) Please note that we should not create any
	 * object using the new keyword.
	 */

	CategoryRepository categoryRepository;

	@Autowired
	CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	/*
	 * This method should be used to save a new category.Call the corresponding
	 * method of Respository interface.
	 */
	public Category createCategory(Category category) throws CategoryNotCreatedException {

		if (null != category) {
			Category newcategory = categoryRepository.insert(category);
			if (null != newcategory) {
				return newcategory;
			} else {
				throw new CategoryNotCreatedException("category Already Exists");
			}

		} else {
			return null;
		}
	}

	/*
	 * This method should be used to delete an existing category.Call the
	 * corresponding method of Respository interface.
	 */
	public boolean deleteCategory(String categoryId) throws CategoryDoesNoteExistsException {
		try {
			categoryRepository.deleteById(categoryId);
			return true;
		} catch (Exception e) {
			throw new CategoryDoesNoteExistsException("Category Not Found");
		}
	}

	/*
	 * This method should be used to update a existing category.Call the
	 * corresponding method of Respository interface.
	 */
	public Category updateCategory(Category category, String categoryId) {

		if (null != categoryRepository.findById(categoryId)) {
			categoryRepository.save(category);
			return categoryRepository.findById(categoryId).get();
		} else {
			return null;
		}
	}

	/*
	 * This method should be used to get a category by categoryId.Call the
	 * corresponding method of Respository interface.
	 */
	public Category getCategoryById(String categoryId) throws CategoryNotFoundException {

		Category category = null;
		try {
			category = categoryRepository.findById(categoryId).get();
			if (category != null) {
				return category;
			} else {
				throw new CategoryNotFoundException("Category Not Found");
			}
		} catch (Exception e) {
			throw new CategoryNotFoundException("Category Not Found");

		}
	}

	/*
	 * This method should be used to get a category by userId.Call the corresponding
	 * method of Respository interface.
	 */
	public List<Category> getAllCategoryByUserId(String userId) {

		return categoryRepository.findAllCategoryByCategoryCreatedBy(userId);
	}

}
