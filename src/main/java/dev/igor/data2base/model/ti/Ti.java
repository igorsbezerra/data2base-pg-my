package dev.igor.data2base.model.ti;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_ti")
public class Ti {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
}
