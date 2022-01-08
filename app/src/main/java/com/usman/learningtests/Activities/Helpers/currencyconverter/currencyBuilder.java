package com.usman.learningtests.Activities.Helpers.currencyconverter;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class currencyBuilder {
    private static Retrofit retrofit;
    public static Retrofit getRetrofitInstance(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.exchangerate-api.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}
