package com.upversionlab.dolcegusto;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rborcat on 6/8/2016.
 */
public class Ingredient implements Parcelable{
    private String flavor;
    private int quantity;

    public Ingredient(String flavor, int quantity) {
        this.flavor = flavor;
        this.quantity = quantity;
    }

    public String getFlavor() {
        return flavor;
    }

    public int getQuantity() {
        return quantity;
    }

    protected Ingredient(Parcel in) {
        flavor = in.readString();
        quantity = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(flavor);
        dest.writeInt(quantity);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Ingredient> CREATOR = new Creator<Ingredient>() {
        @Override
        public Ingredient createFromParcel(Parcel in) {
            return new Ingredient(in);
        }

        @Override
        public Ingredient[] newArray(int size) {
            return new Ingredient[size];
        }
    };
}
