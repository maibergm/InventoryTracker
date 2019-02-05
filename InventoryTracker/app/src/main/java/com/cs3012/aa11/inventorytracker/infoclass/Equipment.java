package com.cs3012.aa11.inventorytracker.infoclass;

/**
 * Created by jcalc on 21/11/2016.
 */

import java.util.Date;

public class Equipment {

    int id;
    String name;
    int barcode;
    Date returnDate;

    public Equipment(int id, String name, int barcode) {
        this.id = id;
        this.name = name;
        this.barcode = barcode;
    }
}
