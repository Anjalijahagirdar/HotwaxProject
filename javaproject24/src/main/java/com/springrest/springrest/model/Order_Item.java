package com.springrest.springrest.model;
import javax.persistence.*;

@Entity
public class Order_Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_item_seq_id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order_Header order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false, length = 20)
    private String status;

	public Integer getOrder_item_seq_id() {
		return order_item_seq_id;
	}

	public void setOrder_item_seq_id(Integer order_item_seq_id) {
		this.order_item_seq_id = order_item_seq_id;
	}

	public Order_Header getOrder() {
		return order;
	}

	public void setOrder(Order_Header order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    
}