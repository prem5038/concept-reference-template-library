package com.prem.camel.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class SolaceProperties {

    String host;

    String vpn;

    String username;

    String password;

    String clientId;

}
