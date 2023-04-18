package Bill;

import javax.swing.*;

public class Bill{
    public int roomBill(int RoomType){
        int oneSeater=300;
        int twoSeater=200;
        int threeSeater=150;
        int total=-1;
        if(RoomType==1){
            total= oneSeater;
        }
        else if (RoomType==2){
            total= twoSeater;
        }
        else if(RoomType==3){
            total= threeSeater;
        }
       return total;
    }
}