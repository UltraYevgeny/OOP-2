package Interfaces;

import java.util.List;

import Classes.Actor;

/**
 * @apiNote Вход, Выход из маркета.
 * @apiNote В классе Market метод update - запускает методы интерфейса iQueueBehaviou.
 */
public interface iMarcketBehaviour {
    /**
     * @param actor
     * @apiNote Метод принимающий клиентов.
     * @apiNote В классе Market передает клиентов в класс takeInQueu.
     */
    public void acceptToMarket(iActorBehaviour actor);
    /**
     * @param actors
     * @apiNote Метод удаляющий клиентов из маркета
     */
    public void releseFromMarket(List<Actor> actors);
    /**
     * @apiNote В классе Market метод update - запускает методы интерфейса iQueueBehaviou.
     */
    public void update();
}
