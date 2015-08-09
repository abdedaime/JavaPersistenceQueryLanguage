package com.example.dao;

import java.util.List;

/**
 * @author hicham 1 déc. 2014 18:47:27
 */
public interface Dao<T> {

	public void add(T t);

	public T retrieve(T t);

	public void delete(T t);

	public List<T> getAll();
}
