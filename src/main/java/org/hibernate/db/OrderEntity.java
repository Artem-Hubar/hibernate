package org.hibernate.db;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "orders", schema = "simpleshop", catalog = "")
public class OrderEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idOrder")
    private int idOrder;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "amount")
    private int amount;
    @Basic
    @Column(name = "Sellor_idSellor")
    private int sellorIdSellor;
    @Basic
    @Column(name = "Consumer_idConsumer")
    private int consumerIdConsumer;

    public OrderEntity() {
    }

    public OrderEntity(String title, int amount, int sellorIdSellor, int consumerIdConsumer) {
        this.title = title;
        this.amount = amount;
        this.sellorIdSellor = sellorIdSellor;
        this.consumerIdConsumer = consumerIdConsumer;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSellorIdSellor() {
        return sellorIdSellor;
    }

    public void setSellorIdSellor(int sellorIdSellor) {
        this.sellorIdSellor = sellorIdSellor;
    }

    public int getConsumerIdConsumer() {
        return consumerIdConsumer;
    }

    public void setConsumerIdConsumer(int consumerIdConsumer) {
        this.consumerIdConsumer = consumerIdConsumer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return idOrder == that.idOrder && amount == that.amount && sellorIdSellor == that.sellorIdSellor && consumerIdConsumer == that.consumerIdConsumer && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder, title, amount, sellorIdSellor, consumerIdConsumer);
    }
}
