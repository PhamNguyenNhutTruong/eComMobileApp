package vn.edu.ecomapp.util;

import java.text.DecimalFormat;

public class CurrencyFormat {
    public static String VietnameseCurrency(Integer price) {
        if(price == null)  return "";
       DecimalFormat formatter = new DecimalFormat("###,###");
       String cost = formatter.format(price)+"đ";
       return  cost.replace(".", ",");
    }
    public static int convertVNCurrencyToInt(String priceStr) {
        String priceReplaced = priceStr.replace("đ", "").replace(",", "");
        return Integer.parseInt(priceReplaced);
    }
}
