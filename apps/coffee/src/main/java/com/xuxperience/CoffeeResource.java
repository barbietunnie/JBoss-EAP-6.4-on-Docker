/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xuxperience;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author babatunde.adeyemi
 */
@Path("coffee")
public class CoffeeResource {
    @GET
    public String coffee() {
        return "dark roast";
    }
}
