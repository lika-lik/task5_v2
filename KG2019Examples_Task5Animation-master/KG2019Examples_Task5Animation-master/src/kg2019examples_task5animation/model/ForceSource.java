/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kg2019examples_task5animation.model;
import kg2019examples_task5animation.math.Vector2;
import kg2019examples_task5animation.model.usersModels.Model;

/**
 *
 * Класс, описывающий источник внешнего воздействия.
 * @author Alexey
 */
public class ForceSource {
    private double value;
    private boolean flagUp, flagDown, flagLeft, flagRight;
    private Model m;

    public ForceSource(Model m) {
        this.m = m;
        value = 0;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Вычисляет вектор силы в заданной точке
     * @param p Точка, для которой производят вычисления
     * @return Вектор силы
     */
    public Vector2 getForceAt(Vector2 p) {
        if (Math.abs(value) < 1e-12)
            return new Vector2(0, 0);
        Vector2 location = new Vector2(m.getPosition().getX(), m.getPosition().getY());
        if (flagUp){
           location = new Vector2(m.getPosition().getX(), m.getPosition().getY()+1);
        }if (flagDown){
            location = new Vector2(m.getPosition().getX(), m.getPosition().getY()-1);
        }if (flagLeft){
            location = new Vector2(m.getPosition().getX()-1, m.getPosition().getY());
        }if (flagRight){
            location = new Vector2(m.getPosition().getX()+1, m.getPosition().getY());
        }
        return location.add(p.mul(-1)).normolized().mul(value);
    }

    public void setFlagUp(boolean flagUp) {
        this.flagUp = flagUp;
        value = flagUp ? 10 : 0;
    }

    public void setFlagDown(boolean flagDown) {
        this.flagDown = flagDown;
        value = flagDown ? 10 : 0;
    }

    public void setFlagLeft(boolean flagLeft) {
        this.flagLeft = flagLeft;
        value = flagLeft ? 10 : 0;
    }

    public void setFlagRight(boolean flagRight) {
        this.flagRight = flagRight;
        value = flagRight ? 10 : 0;
    }

    public void setM(Model m) {
        this.m = m;
    }

    public boolean isFlagUp() {
        return flagUp;
    }

    public boolean isFlagDown() {
        return flagDown;
    }

    public boolean isFlagLeft() {
        return flagLeft;
    }

    public boolean isFlagRight() {
        return flagRight;
    }

    public Model getM() {
        return m;
    }
}
