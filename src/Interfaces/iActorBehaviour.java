package Interfaces;

import Classes.Actor;

/**
 * @apiNote Интерфейс исполнения Флагов заказа. Получения заданного класса клиента
 */
public interface iActorBehaviour {
    /**
     * @return boolean
     * @apiNote Флаг о получении заказа клиентом
     */
    public boolean isTakeOrder();
    /**
     * @return Boolean
     * @apiNote Флаг о том что клиент сделал заказ
     */
    public boolean isMakeOrder();
    /**
     * @param val
     * @apiNote Задает значение для isTakeOrder()
     */
    public void setTakeOrder(boolean val); 
    /**
     * @param val
     * @apiNote Задает значение isMakeOrder
     */
    public void setMakeOrder(boolean val); 
    /**
     * @return Actor
     * @apiNote Возвращает тип (class) указанного клиента
     */
    public Actor geActor(); 
}
