package com.linux.infiniscroll.jpa.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.linux.infiniscroll.jpa.ShortListedCustomerDao;
import com.linux.infiniscroll.jpa.entities.ShortListedCustomer;

public class ShortListedCustomerDaoImpl implements ShortListedCustomerDao {

	@Override
	public List<ShortListedCustomer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShortListedCustomer> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShortListedCustomer> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ShortListedCustomer> List<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends ShortListedCustomer> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<ShortListedCustomer> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public ShortListedCustomer getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ShortListedCustomer> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ShortListedCustomer> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShortListedCustomer findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(ShortListedCustomer entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends ShortListedCustomer> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
