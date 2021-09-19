/*
References:
Guardado, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University.
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/

package BowlingShopApp;

import java.util.LinkedList;

public class GenericQueue {
    private LinkedList<Product> list = new LinkedList<Product>();

    public void enqueue (Product item) {
        list.addFirst(item);
    }

    public void dequeue () {
        list.removeFirst();
    }

    public Integer size () {
        return list.size();
    }
    
    public void printFirstProduct () {
        Product firstProduct = list.getFirst();
        System.out.println(firstProduct.toString());       
    }
}
