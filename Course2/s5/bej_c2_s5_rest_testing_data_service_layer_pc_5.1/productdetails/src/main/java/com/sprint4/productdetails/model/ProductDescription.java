package com.sprint4.productdetails.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ProductDescription {
    private int itemCost;
    private String itemCat;

//    public ProductDescription() {
//    }
//
//    public ProductDescription(int itemCost, String itemCat) {
//        this.itemCost = itemCost;
//        this.itemCat = itemCat;
//    }
//
//    public int getItemCost() {
//        return itemCost;
//    }
//
//    public void setItemCost(int itemCost) {
//        this.itemCost = itemCost;
//    }
//
//    public String getItemCat() {
//        return itemCat;
//    }
//
//    public void setItemCat(String itemCat) {
//        this.itemCat = itemCat;
//    }
//
//    @Override
//    public String toString() {
//        return "ProductDescription{" +
//                "itemCost=" + itemCost +
//                ", itemCat='" + itemCat + '\'' +
//                '}';
//    }
}
