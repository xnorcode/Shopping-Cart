package com.kikkos.shoppingcart.cart;

import java.util.HashMap;

/**
 * Created by kikkos on 2/13/2017.
 */

public class CartModel {
    private final double apples = 0.32;
    private final double pineapples = 1.0;
    private final double bananas = 0.13;
    private final double carrots = 1.0;

    private static final String APPLES = "apples";
    private static final String PINEAPPLES = "pineapples";
    private static final String BANANAS = "bananas";
    private static final String CARROTS = "carrots";

    ICartPresenter cartPresenter;

    public CartModel(ICartPresenter cartPresenter) {
        this.cartPresenter = cartPresenter;
    }

    public void calculateTotal(HashMap<String, Integer> cart){
        // calculate total cost.
        double total = 0;
        if (cart.containsKey(APPLES)){
            total += cart.get(APPLES) * apples;
        }
        if (cart.containsKey(PINEAPPLES)){
            total += cart.get(PINEAPPLES) * pineapples;
        }
        if (cart.containsKey(BANANAS)){
            total += cart.get(BANANAS) * bananas;
        }
        if (cart.containsKey(CARROTS)){
            total += cart.get(CARROTS) * carrots;
        }
        // pass total price to presenter.
        cartPresenter.totalCalculated(total);
    }
}
