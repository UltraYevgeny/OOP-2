package Classes;

import Interfaces.iActorBehaviour;

public class PromotionClient implements iActorBehaviour {
    private String name;
    private String promotionName;
    private int idClient;
    private static int numberOfHumans;
    private boolean isTakeOrder = false;
    private boolean isMakeOrder = false;

    public PromotionClient(String name, String promotionName, int idClient) {
        PromotionClient.numberOfHumans = 10;
        this.name = name;
        this.promotionName = promotionName;
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }
    
    public String getPromotionName() {
        return promotionName;
    }

    public int getIdClient() {
        return idClient;
    }

    public static int getNumberOfHumans() {
        return numberOfHumans;
    }

    public boolean isTakeOrder() {
        return isTakeOrder;
    }

    public boolean isMakeOrder() {
        return isMakeOrder; 
    }

    public void setTakeOrder(boolean val) {
        isTakeOrder = val;
    }
    public void setMakeOrder(boolean val) {
        isMakeOrder = val;        
    }

    @Override
    public Actor geActor() {
        return new OrdinaryClient(name);
            
        }
    }

