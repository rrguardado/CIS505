/*
References:
Guardado, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University.
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/

package BowlingShopApp;

public class ProductsDB {

    public static GenericQueue getProducts (String code) {
        if (code.equalsIgnoreCase("b")){
            Ball ball1 = new Ball();
            ball1.setCode("B100");
            ball1.setDescription("Black Widow 2.0");
            ball1.setPrice(144.95);
            ball1.setColor("Black and Red");

            Ball ball2 = new Ball();
            ball2.setCode("B200");
            ball2.setDescription("Green Machine");
            ball2.setPrice(244.95);
            ball2.setColor("Green");

            Ball ball3 = new Ball();
            ball3.setCode("B300");
            ball3.setDescription("Orange You Glad");
            ball3.setPrice(344.95);
            ball3.setColor("Orange");
                   
            Ball ball4 = new Ball();
            ball4.setCode("B400");
            ball4.setDescription("Mello Yello");
            ball4.setPrice(444.95);
            ball4.setColor("Yellow");
                        
            Ball ball5 = new Ball();
            ball5.setCode("B500");
            ball5.setDescription("Grape Poupon");
            ball5.setPrice(544.95);
            ball5.setColor("Purple");
            
            GenericQueue ballQueue = new GenericQueue();
            ballQueue.enqueue(ball1);
            ballQueue.enqueue(ball2);
            ballQueue.enqueue(ball3);
            ballQueue.enqueue(ball4);
            ballQueue.enqueue(ball5);

            return ballQueue;
        }//end if (code = b)

        else if (code.equalsIgnoreCase("s")) {
            Shoe shoe1 = new Shoe();
            shoe1.setCode("S100");
            shoe1.setDescription("Ages 4 through 6");
            shoe1.setPrice(1);
            shoe1.setSize(1);

            Shoe shoe2 = new Shoe();
            shoe2.setCode("S200");
            shoe2.setDescription("Ages 7 through 8");
            shoe2.setPrice(2);
            shoe2.setSize(2);

            Shoe shoe3 = new Shoe();
            shoe3.setCode("S300");
            shoe3.setDescription("Ages 9 through 10");
            shoe3.setPrice(3);
            shoe3.setSize(3);

            Shoe shoe4 = new Shoe();
            shoe4.setCode("S400");
            shoe4.setDescription("Ages 11 through 12");
            shoe4.setPrice(4);
            shoe4.setSize(4);

            Shoe shoe5 = new Shoe();
            shoe5.setCode("S500");
            shoe5.setDescription("Ages 13 and up");
            shoe5.setPrice(5);
            shoe5.setSize(5);

            GenericQueue shoeQueue = new GenericQueue();
            shoeQueue.enqueue(shoe1);
            shoeQueue.enqueue(shoe2);
            shoeQueue.enqueue(shoe3);
            shoeQueue.enqueue(shoe4);
            shoeQueue.enqueue(shoe5);

            return shoeQueue;
        }//end else if (code = s)

        else if (code.equalsIgnoreCase("a")) {
            Bag bag1 = new Bag();
            bag1.setCode("A100");
            bag1.setDescription("One-Hand Bag");
            bag1.setType("Single");
            bag1.setPrice(111.11);

            Bag bag2 = new Bag();
            bag2.setCode("A200");
            bag2.setDescription("Two-Handed Bag");
            bag2.setType("Double");
            bag2.setPrice(222.22);

            Bag bag3 = new Bag();
            bag3.setCode("A300");
            bag3.setDescription("Shoulder-Worn Bag");
            bag3.setType("Triple");
            bag3.setPrice(333.33);

            GenericQueue bagQueue = new GenericQueue();
            bagQueue.enqueue(bag1);
            bagQueue.enqueue(bag2);
            bagQueue.enqueue(bag3);

            return bagQueue;
        }// end else if code = a
        else { // not b, not s, not a
            return new GenericQueue();
        }//end else
    }//end getProducts method    
}//end ProductsDB class