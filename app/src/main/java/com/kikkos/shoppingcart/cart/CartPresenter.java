package com.kikkos.shoppingcart.cart;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by kikkos on 2/13/2017.
 */

public class CartPresenter implements ICartPresenter {

    private ICartView mCartView;
    private CartModel mCartModel;

    private StringBuilder sb;

    public CartPresenter(ICartView mCartView) {
        this.mCartView = mCartView;
        this.mCartModel = new CartModel(this);
    }

    public void addToCart(HashMap<String, Integer> cart){
        // create text of cart list
        sb = new StringBuilder();
        Iterator it = cart.entrySet().iterator();
        while (it.hasNext()){
            HashMap.Entry pair = (HashMap.Entry)it.next();
            sb.append(pair.getValue());
            sb.append(" x ");
            sb.append(pair.getKey());
            sb.append("\n");
        }
        // pass cart to model to get total cost.
        mCartModel.calculateTotal(cart);
    }

    @Override
    public void totalCalculated(double total) {
        // add total cost to cart text
        sb.append("Total cost: ");
        sb.append(String.valueOf(total));
        mCartView.showCart(sb.toString());
    }
}
