package com.cg.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@Accessors(chain = true)
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String phone;


    @Digits(integer = 8, fraction = 0)
    private BigDecimal balance = BigDecimal.valueOf(0);


    @ManyToOne
    @JoinColumn(name = "location_region_id", referencedColumnName = "id", unique = true, nullable = false)
    private LocationRegion locationRegion;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", balance=" + balance +
                '}';
    }
}
