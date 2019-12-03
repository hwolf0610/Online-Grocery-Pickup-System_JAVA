/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online.grade.order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static online.grade.order.order.customerID;

/**
 *
 * @author Admin
 */
public class onlineGroceryQueue {
    order ordervalue=new order();
    
    public void saveorder(String customername, String orderitem, String quanlity) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd/HH/mm/ss");
        LocalDateTime now = LocalDateTime.now();
        String[] ordertime = dtf.format(now).toString().split("/");
        String customerlist = "", oldfilename = "src/orderlist.txt",savetargetfilename = "src/store.txt", plus = "";
        customerlist = Integer.toString(ordervalue.customerID) + "~" + customername + "~" + ordertime[3] + ":" + ordertime[4] + "~" + Integer.toString(Integer.parseInt(ordertime[3]) + 2) + ":" + ordertime[4]+ "~" + orderitem + "~" + quanlity;
        String oldlist = ordervalue.filereadin(oldfilename);
        if (oldlist.isEmpty()) {
            plus = "";
        } else {
            customerlist = "/" + customerlist;
        }
        String saveorderlist=oldlist+customerlist;
        ordervalue.fileoutput(saveorderlist, oldfilename);
        ordervalue.customerID++;
    }
    
}
