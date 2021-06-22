package com.mstore.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mstore.domain.product.entity.Product;
import com.mstore.domain.product.repository.ProductRepository;
import com.mstore.domain.sales.entity.OrderDetail;
import com.mstore.domain.sales.repository.OrderDetailRepository;

@Component
public class Cart {

	private static final Logger LOG = LoggerFactory.getLogger(Cart.class);

	private double totalAmount;

	@Autowired
	OrderDetailRepository orderDetailRepository;

	@Autowired
	ProductRepository productRepository;

	int counter;

	List<OrderDetail> orderDetails;

	Map<String, OrderDetail> cartList;

	public Cart() {
		this.counter = 0;
		orderDetails = new ArrayList<OrderDetail>();
		cartList = new HashMap<String, OrderDetail>();
	}

	public List<OrderDetail> addToCart(String productId) {
		try {

			Product product = productRepository.getById(productId);
			OrderDetail orderDetail = null;

			if (cartList.containsKey(productId)) {
				//
				orderDetail = cartList.get(productId);
				orderDetail.setQuantity(orderDetail.getQuantity() + 1);
				orderDetail.setAmount(orderDetail.getPrice() * orderDetail.getQuantity());
			} else {
				//
				orderDetail = new OrderDetail();
				orderDetail.setId(UUID.randomUUID().toString());
				orderDetail.setQuantity(1);
				orderDetail.setProduct(product);
				orderDetail.setPrice(product.getSalePrice());
				orderDetail.setAmount(orderDetail.getPrice() * orderDetail.getQuantity());
				cartList.put(productId, orderDetail);
			}
			++counter;
			// System.out.println(cartList);
			cartList.forEach((k, v) -> System.out.println("Key:" + k + " V:" + v.toString()));
		} catch (Exception ex) {
			LOG.info(ex.getMessage());
		}
		return this.orderDetails;
	}

	public void removeProduct(String productId) {
		OrderDetail orderDetail = cartList.get(productId);
		this.counter = this.counter - orderDetail.getQuantity();
		cartList.remove(productId);
		getTotalAmount();

	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public List<OrderDetail> getOrderDetails() {
		List<OrderDetail> list = new ArrayList<OrderDetail>(cartList.values());
		return list;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public double getTotalAmount() {
		this.totalAmount = 0;
		if (cartList.size() > 0) {
			LOG.info(" " + this.totalAmount);
			cartList.forEach((k, v) -> totalAmount += v.getAmount());

		} else {
			return 0;
		}
		return this.totalAmount;
	}
}
