package org.hibernate.db;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "orders", schema = "simpleshop", catalog = "")
public class OrdersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idOrder", nullable = false)
    private int idOrder;
    @Basic
    @Column(name = "title", nullable = false, length = 45)
    private String title;
    @Basic
    @Column(name = "amount", nullable = false)
    private int amount;

    @ManyToOne
    @JoinColumn(name = "Sellor_idSellor", referencedColumnName = "idSellor", nullable = false)
    private SellorEntity sellorBySellorIdSellor;
    @ManyToOne
    @JoinColumn(name = "Consumer_idConsumer", referencedColumnName = "idConsumer", nullable = false)
    private ConsumerEntity consumerByConsumerIdConsumer;

    public OrdersEntity(String title, int amount,  SellorEntity sellorBySellorIdSellor, ConsumerEntity consumerByConsumerIdConsumer) {
        this.title = title;
        this.amount = amount;
            this.sellorBySellorIdSellor = sellorBySellorIdSellor;
        this.consumerByConsumerIdConsumer = consumerByConsumerIdConsumer;
    }

    public OrdersEntity() {

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




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersEntity that = (OrdersEntity) o;
        return idOrder == that.idOrder && amount == that.amount  && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder, title, amount);
    }

    public SellorEntity getSellorBySellorIdSellor() {
        return sellorBySellorIdSellor;
    }

    public void setSellorBySellorIdSellor(SellorEntity sellorBySellorIdSellor) {
        this.sellorBySellorIdSellor = sellorBySellorIdSellor;
    }

    public ConsumerEntity getConsumerByConsumerIdConsumer() {
        return consumerByConsumerIdConsumer;
    }

    public void setConsumerByConsumerIdConsumer(ConsumerEntity consumerByConsumerIdConsumer) {
        this.consumerByConsumerIdConsumer = consumerByConsumerIdConsumer;
    }
}
