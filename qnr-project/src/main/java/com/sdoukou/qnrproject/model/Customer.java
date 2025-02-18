package com.sdoukou.qnrproject.model;

import jakarta.persistence.*;
import lombok.*;



@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "customers")
public class Customer extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    private String firstname;
    private String lastname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
}
