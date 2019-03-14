import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BillTest {
    private String output;
    private Writer writerMock = new Writer() {
        @Override
        public void start() {
            output = "";
        }

        @Override
        public void writeLine(String line) {
            output += line + "%n";
        }

        @Override
        public void stop() {
        }
    };
    Customer client = new Customer("EMMANUEL MELCHIOR", "11 RUE YVES MANCEAU - 49330 QUERRE");
    Product cafe = new Product("Cafetière","Cafetière de marque BEKO",59.30);
    Fridge frigo = new Fridge("Frigidère","Fridigère de marque SAMSUNG",599.90,50,true);
    Television tv = new Television("Télévision","TV de marque PANASONIC",260,55,"test");
    RelayDelivery delivery = new RelayDelivery(27);


    @Test
    public void Given_2productsAndDelivery_When_generatingBill_Then_getGoodLineNumber() {
        Bill bill = new Bill(client, delivery);
        bill.addProduct(cafe, 1);
        bill.addProduct(tv, 1);
        bill.generate(writerMock);
        int lineNumber = output.split("\n").length;
        assertEquals(20, lineNumber);
    }



}