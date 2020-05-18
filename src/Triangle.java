/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author mynamenn
 */
public class Triangle extends ClosedShape {

    //The height and width of the triangle.
    private int length;

    /**
     * Creates a triangle.
     *
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param length The length of the triangle (in pixels).
     * @param colour The line colour or fill colour.
     * @param isFilled True if the triangle is filled with colour, false if
     * opaque.
     * @param isFlashing True if the triangle is flashing.
     * @param colour2 The second line colour or fill colour.
     */
    public Triangle(int insertionTime, int x, int y, int vx, int vy, int length,
            Color colour, boolean isFilled, boolean isFlashing, Color colour2) {
        super(insertionTime, x, y, vx, vy, colour, isFilled, isFlashing, colour2);
        this.length = length;
    }

    /**
     * Method to convert a triangle to a string.
     */
    public String toString() {
        String result = "This is a triangle\n";
        result += super.toString();
        result += "Its length is " + this.length + "\n";
        return result;
    }

    /**
     * @param width Resets the length.
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * @return The width of the triangle.
     */
    public int getWidth() {
        return length;
    }

    /**
     * @return The height of the triangle.
     */
    public int getHeight() {
        double a = Math.pow(length / 2.0, 2);
        double b = Math.pow(length, 2);
        double height = Math.sqrt(b - a);
        return (int) height;
    }

    /**
     * Draw the triangle.
     *
     * @param g The graphics object of the drawable component.
     */
    public void draw(GraphicsContext g) {
        g.setFill(colour);
        g.setStroke(colour);
        double[] xp = new double[]{x, x + length / 2, x - length / 2};
        double[] yp = new double[]{y + getHeight() / 2, y - getHeight(), y - getHeight()};
        if (isFilled) {
            g.fillPolygon(xp, yp, 3);
        } else {
            g.strokePolygon(xp, yp, 3);
        }
    }

    /**
     * Puts the shape back in bounds
     *
     * @param winY Y boundary.
     */
    @Override
    public void putInBoundsY(double winY) {
        if (y < 0) {
            y = 0;
        }
        if (y > winY) {
            y = (int) (winY);
        }
        if (y - this.getHeight() < 0) {
            y = (int) (this.getHeight());
        }
    }//end inBoundsY;

    /**
     * Puts the shape back in bounds in X
     *
     * @param winX X boundary.
     */
    @Override
    public void putInBoundsX(double winX) {
        if (x < 0) {
            x = 0;
        }
        if (x + this.getWidth() > winX) {
            x = (int) (winX - Math.ceil(this.getWidth() / 2.0));
        }
        if (x - this.getWidth() < 0) {
            x = (int) (this.getWidth() / 2.0);
        }
    }//end inBoundsX;

    /**
     * Returns true if the shapes have gone out of bounds in Y
     *
     * @param winY Y boundary.
     */
    @Override
    public boolean outOfBoundsY(double winY) {
        return (y + this.getHeight() / 2.0 > winY) || (y < 0) || (y - this.getHeight() < 0);
    }

    /**
     * Returns true if the shapes have gone out of bounds in X
     *
     * @param winX X boundary.
     */
    @Override
    public boolean outOfBoundsX(double winX) {
        return (x + this.getWidth() / 2.0 > winX) || (x < 0) || (x - this.getWidth() / 2.0 < 0);
    }

}
