package homework2;

public class Render {

    public void render(Object object) {

        if (object instanceof HasHealthPoint hasHealthPoint) {
            Utils.PrintValue(object.getClass().getName() + ": Здоровье", hasHealthPoint.getCurrentHealthPoint());
        }

        if (object instanceof Tiredness tiredness) {
            Utils.PrintValue(object.getClass().getName() + ": Бодрость", tiredness.getCurrentEnergy());
        }
     }
    
}
