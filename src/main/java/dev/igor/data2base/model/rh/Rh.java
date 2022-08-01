package dev.igor.data2base.model.rh;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_rh")
public class Rh {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
}
