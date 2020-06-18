package com.example.nieruchomosci;

public class ViewPropertyData {
    public int propertyId;
    public String propertyAddress;
    public int propertyPrice;
    public String propertyType;

    ViewPropertyData(int id, String address, int price, String type) {
        propertyId = id;
        propertyAddress = address;
        propertyPrice = price;
        propertyType = type;
    }
}
