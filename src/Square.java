
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nguleychun
 */
public class Square extends ClosedShape {

    //The height and width of the Square.
    private int side;

    /**
     * Creates a Square.
     *
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param side The side of the square (in pixels).
     * @param colour The line colour or fill colour.
     * @param isFilled True if the square is filled with colour, false if
     * opaque.
     * @param isFlashing True if the square is flashing.
     * @param colour2 The second line colour or fill colour.
     */
    public Square(int insertionTime, int x, int y, int vx, int vy, int side,
            Color colour, boolean isFilled, boolean isFlashing, Color colour2) {
        super(insertionTime, x, y, vx, vy, colour, isFilled, isFlashing, colour2);
        this.side = side;
    }

    /**
     * Method to convert a square to a string.
     */
    public String toString() {
        String result = "This is a square\n";
        result += super.toString();
        result += "Its side is " + this.side + "\n";
        return result;
    }

    /**
     * @param width Resets the width.
     */
    public void setWidth(int side) {
        this.side = side;
    }

    /**
     * @param height Resets the height.
     */
    public void setHeight(int side) {
        this.side = side;
    }

    /**
     * @return The width of the square.
     */
    public int getWidth() {
        return side;
    }

    /**
     * @return The height of the oval.
     */
    public int getHeight() {
        return side;
    }

    /**
     * Draw the square.
     *
     * @param g The graphics object of the drawable component.
     */
    public void draw(GraphicsContext g) {
        g.setFill(colour);
        g.setStroke(colour);
        if (isFilled) {
            g.fillRect(x, y, side, side);
        } else {
            g.strokeRect(x, y, side, side);
        }
    }

}
