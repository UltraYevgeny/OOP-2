package Interfaces;

import Classes.Actor;

/**
 * @apiNote Интерфейс методов работающих с очередью и заказами
 */
public interface iQueueBehaviour {
    /**
     * @param actor
     * @apiNote Создает очередь
     */
    public void takeInQueue(iActorBehaviour actor);
    /**
     * @apiNote Создает список клиентов вышедших из очереди
     */
    public void releaseFromQueue();
    /**
     * @apiNote Клиент делает заказ
     */
    public void takeOrder ();
    /**
     * @apiNote Клиент забирает заказ
     */
    public void giveOrder ();
   // public void geActor ();
}
