/**
 * @author Mai Thành Duy An
 */
package com.mstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mstore.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand, String> {

}
