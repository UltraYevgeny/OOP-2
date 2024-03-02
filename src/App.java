import Classes.Actor;
import Classes.Market;
import Classes.OrdinaryClient;
import Classes.PromotionClient;
import Classes.SpecialClient;
import Classes.TaxInspector;
import Interfaces.iActorBehaviour;

public class App {
    public static void main(String[] args) throws Exception {
        Market magnit = new Market();

        iActorBehaviour client1 = new OrdinaryClient("boris");
        iActorBehaviour client2 = new OrdinaryClient("masha");
        iActorBehaviour client3 = new SpecialClient("prezident", 1);
        iActorBehaviour client4 = new TaxInspector();
        iActorBehaviour client5 = new PromotionClient("Lary", "2 for price 1", 78);
        

        magnit.acceptToMarket(client1);
        magnit.acceptToMarket(client2);
        magnit.acceptToMarket(client3);
        magnit.acceptToMarket(client4);
        magnit.acceptToMarket(client5);


        System.out.println("\n =================================");
        magnit.update();

        System.out.println("\n!!!!!! Возврат товара !!!!!!");
        magnit.returnInMarket(client2);
        magnit.returnInMarket(client5);

        magnit.returnProduct();

    }
}
