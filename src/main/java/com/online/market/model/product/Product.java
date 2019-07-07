package com.online.market.model.product;

import com.online.market.service.common.AbstractIdentifiable;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "product")
public class Product extends AbstractIdentifiable {

    private String name;
}
