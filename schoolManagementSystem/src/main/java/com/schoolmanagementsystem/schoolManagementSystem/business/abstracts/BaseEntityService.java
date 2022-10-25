package com.schoolmanagementsystem.schoolManagementSystem.business.abstracts;

import java.util.List;

public interface BaseEntityService <T> {
	void add(T entity);
	List<T> getAll();
}
