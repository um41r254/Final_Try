package com.mid_banchers.final_try.adapters;

public class DataModel {

    String  disp;
    String image;
    String  heading;

    public DataModel(String disp, String image, String heading) {
        this.disp = disp;
        this.image = image;
        this.heading = heading;
    }

    public DataModel() {
    }

    public String getDisp() {
        return disp;
    }

    public String getImage() {
        return image;
    }

    public String getHeading() {
        return heading;
    }
}
