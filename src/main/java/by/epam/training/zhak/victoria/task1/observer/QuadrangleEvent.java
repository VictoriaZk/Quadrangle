package by.epam.training.zhak.victoria.task1.observer;

import by.epam.training.zhak.victoria.task1.entity.Quadrangle;

import java.util.EventObject;

public class QuadrangleEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    //QuadrangleEvent(Quadrangle)
    public QuadrangleEvent(Object source) {
        super(source);
    }

   public Quadrangle getQuadrangle(){
        return (Quadrangle)getSource();
   }

}
