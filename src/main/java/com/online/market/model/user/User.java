package com.online.market.model.user;

import com.online.market.service.common.AbstractIdentifiable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractIdentifiable {

    private String username;
    private String password;

}
