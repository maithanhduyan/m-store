/**
 * @author Mai Thành Duy An
 */
package com.mstore.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mstore.entities.Shop;

public class ShopServiceImpl implements ShopService{

	@Override
	public Shop findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Shop> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shop> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Shop> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Shop entity) {
		// TODO Auto-generated method stub
		
	}

}
