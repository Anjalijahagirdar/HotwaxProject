package com.springrest.springrest.model;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Order_Header {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_id;

    @Column(nullable = false)
    private Date order_date;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "shipping_contact_mech_id", nullable = false)
    private Contact_Mech shipping_contact_mech;

    @ManyToOne
    @JoinColumn(name = "billing_contact_mech_id", nullable = false)
    private Contact_Mech billing_contact_mech;

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Contact_Mech getShipping_contact_mech() {
		return shipping_contact_mech;
	}

	public void setShipping_contact_mech(Contact_Mech shipping_contact_mech) {
		this.shipping_contact_mech = shipping_contact_mech;
	}

	public Contact_Mech getBilling_contact_mech() {
		return billing_contact_mech;
	}

	public void setBilling_contact_mech(Contact_Mech billing_contact_mech) {
		this.billing_contact_mech = billing_contact_mech;
	}

}
