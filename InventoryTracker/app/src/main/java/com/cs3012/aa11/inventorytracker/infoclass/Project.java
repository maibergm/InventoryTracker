package com.cs3012.aa11.inventorytracker.infoclass;

/**
 * Created by jcalc on 21/11/2016.
 */

import java.util.List;
import java.util.Date;

public class Project {

    int id;
    String name;
    Date endDate;

    public Project(int id, String name, Date endDate) {
        this.id = id;
        this.name = name;
        this.endDate = endDate;
    }
}