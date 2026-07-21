package com.pos_application.pos.entity;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name="customer")

public class Customer {
    @Id
    @Column(name = "customer_id",length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name="customer_name",length = 100,nullable = false)
    private String customerName;

    @Column(name = "customer_address",length = 255)
    private String customerAddress;

    @Column(name="customer_salary")
    private double customerSalary;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "contact_numbers", columnDefinition = "json")
    private ArrayList<Integer> contactNo;

    @Column(name="customer_nic",length = 255)
    private String nic;

    @Column(name="active_state",columnDefinition = "TINYINT default 0")
    private boolean active;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;


    public Customer() {}

    public Customer(int customerId, String customerName, String customerAddress, double customerSalary, ArrayList<Integer> contactNo, String nic, boolean active) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
        this.contactNo = contactNo;
        this.nic = nic;
        this.active = active;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public ArrayList<Integer> getContactNo() {
        return contactNo;
    }

    public void setContactNo(ArrayList<Integer> contactNo) {
        this.contactNo = contactNo;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerSalary=" + customerSalary +
                ", contactNo=" + contactNo +
                ", nic=" + nic +
                ", active=" + active +
                '}';
    }
}
