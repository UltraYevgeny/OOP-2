package Interfaces;

import java.util.List;

import Classes.Actor;

/**
 * @author Пинжин Евгений Иванович
 * @apiNote Интерфейс реализующий исполнение возврата товара
 * @version 1.1
 */
public interface iReturnOrder {

    /**
     * @param actor
     * @apiNote Клиенты возвращаются в магазин
     * @apiNote (Должны приниматся из клиентского класса)
     */
    public void returnInMarket(iActorBehaviour actor);
    /**
     * @param actor
     * @apiNote Создает очередь для возврата товара
     */
    public void takeNewQueue(iActorBehaviour actor);
    /**
     * @apiNote Создает очередь клиентов на выход
     */
    public void returnProduct();
    /**
     * @param actors
     * @apiNote Клиенты покидают очередь выхода
     */
    public void releseFromMarketAgain(List<Actor> actors);
    
}
