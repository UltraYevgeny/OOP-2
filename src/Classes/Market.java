package Classes;

import java.util.ArrayList;
import java.util.List;

import Interfaces.iActorBehaviour;
import Interfaces.iMarcketBehaviour;
import Interfaces.iQueueBehaviour;
import Interfaces.iReturnOrder;

public class Market implements iMarcketBehaviour,iQueueBehaviour,iReturnOrder {

    private List<iActorBehaviour> queue;
    private List<iActorBehaviour> queueReturn;

    public Market() {
        this.queue = new ArrayList<iActorBehaviour>();
        this.queueReturn = new ArrayList<iActorBehaviour>();
    }

    @Override
    public void acceptToMarket(iActorBehaviour actor) {
        System.out.println(actor.geActor().getName() + " клиент пришел в магазин ");
        takeInQueue(actor);
    }

    @Override
    public void takeInQueue(iActorBehaviour actor) {
        // Проверка акционный клиент или нет
        if (actor.getClass() == PromotionClient.class) {
            PromotionClient clientX;
            clientX = (PromotionClient) actor;
            System.out.println("Face conrol! Promotion Client Name: " + clientX.getName());
            System.out.println("Promotion Name: " + clientX.getPromotionName());
            System.out.println("ID Client: " + clientX.getIdClient());
            System.out.println("Number Of Humans in Promotion: " + PromotionClient.getNumberOfHumans());
            // Проверка количества акционных клиентов
            if (PromotionClient.getNumberOfHumans() > 3){
                System.out.println(actor.geActor().getName() 
                    + " НЕ добавлен в очередь т.к. число акционных клиентов меньше");
            }
            else {
                this.queue.add(actor);
                System.out.println(actor.geActor().getName() + " АКЦИОННЫЙ клиент добавлен в очередь ");
            }
        }
        else {
            this.queue.add(actor);
            System.out.println(actor.geActor().getName() + " клиент добавлен в очередь ");
        }
    }


    @Override
    public void releseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            System.out.println(actor.getName() + " клиент ушел из магазина ");
            queue.remove(actor);
        }

    }

    @Override
    public void update() {
        takeOrder();
        giveOrder();
        releaseFromQueue();
    }

    @Override
    public void giveOrder() {
        for (iActorBehaviour actor : queue) {
            if (actor.isMakeOrder()) {
                actor.setTakeOrder(true);
                System.out.println(actor.geActor().getName() + " клиент получил свой заказ ");
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> releaseActors = new ArrayList<>();
        for (iActorBehaviour actor : queue) {
            if (actor.isTakeOrder()) {
                releaseActors.add(actor.geActor());
                System.out.println(actor.geActor().getName() + " клиент ушел из очереди ");
            }
        }
        releseFromMarket(releaseActors);
    }

    @Override
    public void takeOrder() {
        for (iActorBehaviour actor : queue) {
            if (!actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                System.out.println(actor.geActor().getName() + " клиент сделал заказ ");

            }
        }

    }


    //Возврат товара
    @Override
    public void returnInMarket(iActorBehaviour actor) {
        System.out.println(actor.geActor().getName() + " клиент ВЕРНУЛСЯ в магазин ");
        takeNewQueue(actor);
    }

    @Override
    public void takeNewQueue(iActorBehaviour actor) {
        this.queueReturn.add(actor);
        System.out.println(actor.geActor().getName() + " клиент добавлен в очередь ДЛЯ ВОЗВРАТА");
    }

    @Override
    public void returnProduct() {
        List<Actor> releaseActorsAgain = new ArrayList<>();
        for (iActorBehaviour actor : queueReturn) {
                releaseActorsAgain.add(actor.geActor());
                System.out.println(actor.geActor().getName() + " клиент ВЕРНУЛ ТОВАР И ушел из очереди ДЛЯ ВОЗВРАТА");
        }
        releseFromMarketAgain(releaseActorsAgain);
    }

    @Override
    public void releseFromMarketAgain(List<Actor> actors) {
        for (Actor actor : actors) {
            System.out.println(actor.getName() + " клиент ушел из магазина СНОВА ");
            queueReturn.remove(actor);
        }
    }
 

}
    

