package vn.edu.ecomapp.util.prefs;

import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.List;

import vn.edu.ecomapp.dto.Cart;
import vn.edu.ecomapp.model.LineItem;
import vn.edu.ecomapp.util.Constants;

public class CartManager {
   private final SharedPreferences prefs;
   private final SharedPreferences.Editor editor;
   private static CartManager INSTANCE  = null;
   private  final Gson gson = new Gson();
   public static synchronized CartManager getInstance(SharedPreferences prefs){
        if(INSTANCE == null){
            INSTANCE = new CartManager(prefs);
        }
        return INSTANCE;
    }
   private CartManager(SharedPreferences prefs) {
       this.prefs = prefs;
       this.editor = prefs.edit();
   }

    public Cart getCart() {
       String cartJSON = prefs.getString(Constants.CART_JSON, null);
       if(cartJSON == null) return  new Cart();
       return gson.fromJson(cartJSON, Cart.class);
   }

   public void saveCart(Cart cart) {
       if(cart == null) return;
       String cartJSON = gson.toJson(cart);
       editor.putString(Constants.CART_JSON, cartJSON);
       editor.apply();
   }

   public void removeCart() {
        editor.remove(Constants.CART_JSON);
        editor.apply();
   }
}
