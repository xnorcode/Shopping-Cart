package com.kikkos.shoppingcart.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kikkos.shoppingcart.BuildConfig;
import com.kikkos.shoppingcart.R;
import com.kikkos.shoppingcart.cart.CartPresenter;
import com.kikkos.shoppingcart.cart.ICartView;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ICartView {

    @BindView(R.id.apples)
    EditText apples;
    @BindView(R.id.pineapples)
    EditText pineapples;
    @BindView(R.id.bananas)
    EditText bananas;
    @BindView(R.id.carrots)
    EditText carrots;
    @BindView(R.id.addToCart)
    Button btnAddToCart;
    @BindView(R.id.cart)
    TextView mCart;

    private CartPresenter mCartPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (BuildConfig.DEBUG){
            apples.setText("6");
            pineapples.setText("3");
            bananas.setText("6");
            carrots.setText("1");
        }
        // create cart presenter instance
        mCartPresenter = new CartPresenter(this);
    }

    @OnClick(R.id.addToCart)
    public void submit(){
        // on submit button click, create hashmap of the item and the quantity.
        HashMap<String, Integer> cart = new HashMap<>();
        if (Integer.parseInt(apples.getText().toString()) > 0){
            cart.put("apples", Integer.parseInt(apples.getText().toString()));
        }
        if (Integer.parseInt(pineapples.getText().toString()) > 0){
            cart.put("pineapples", Integer.parseInt(pineapples.getText().toString()));
        }
        if (Integer.parseInt(bananas.getText().toString()) > 0){
            cart.put("bananas", Integer.parseInt(bananas.getText().toString()));
        }
        if (Integer.parseInt(carrots.getText().toString()) > 0){
            cart.put("carrots", Integer.parseInt(carrots.getText().toString()));
        }
        // pass the cart of to presenter.
        mCartPresenter.addToCart(cart);
    }

    @Override
    public void showCart(String cart) {
        // get cart text with total from presenter.
        mCart.setText(cart);
    }
}
