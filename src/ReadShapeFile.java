
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author you
 *
 */
import javafx.scene.paint.Color;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadShapeFile {

    public ReadShapeFile(int i) {
        int j = 0;
    }

    /**
     * Reads the data file used by the program and returns the constructed queue
     *
     * @param in the scanner of the file
     * @return the queue represented by the data file
     */
    private static Queue<ClosedShape> readDataFile(Scanner in) {
        Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();
        while (in.hasNextLine()) {
            String data = in.nextLine();
            String[] datas = data.split(" ");
            switch (datas[0]) {
                case "square":
                    shapeQueue.enqueue(readSquareData(datas));
                    continue;
                case "circle":
                    shapeQueue.enqueue(readCircleData(datas));
                    continue;
                case "rect":
                    shapeQueue.enqueue(readRectData(datas));
                    continue;
                case "oval":
                    shapeQueue.enqueue(readOvalData(datas));
                    continue;
                case "triangle":
                    shapeQueue.enqueue(readTriangleData(datas));
                    continue;
            }
        }
        return shapeQueue;
    }

    /**
     * Method to read the file and return a queue of shapes from this file. The
     * program should handle the file not found exception here and shut down the
     * program gracefully.
     *
     * @param filename the name of the file
     * @return the queue of shapes from the file
     */
    public static Queue<ClosedShape> readDataFile(String filename) throws FileNotFoundException{
        File file = new File(filename);
        Scanner in = null;
        try {
            in = new Scanner(file);
        } catch (FileNotFoundException ex) {
            throw ex;
        }
        return ReadShapeFile.readDataFile(in);
    }

    /**
     * Reads the datas array and return a circle object.
     *
     * @param datas A string array.
     * @return A circle object.
     */
    public static Circle readCircleData(String[] datas) {
        System.out.println(Arrays.toString(datas));

        int x = Integer.parseInt(datas[1]);
        int y = Integer.parseInt(datas[2]);
        int vx = Integer.parseInt(datas[3]);
        int vy = Integer.parseInt(datas[4]);
        boolean isFilled = Boolean.valueOf(datas[5]);
        int side = Integer.parseInt(datas[6]);
        int r = Integer.parseInt(datas[7]);
        int g = Integer.parseInt(datas[8]);
        int b = Integer.parseInt(datas[9]);
        int insertionTime = Integer.parseInt(datas[10]);
        boolean isFlashing = Boolean.valueOf(datas[11]);
        int r2 = Integer.parseInt(datas[12]);
        int g2 = Integer.parseInt(datas[13]);
        int b2 = Integer.parseInt(datas[14]);
        Color color = Color.rgb(r, g, b);
        Color color2 = Color.rgb(r2, g2, b2);
        Circle circle = new Circle(insertionTime, x, y, vx, vy, side, color, isFilled, isFlashing, color2);
        System.out.println(circle);
        return circle;
    }

    /**
     * Reads the datas array and return a square object.
     *
     * @param datas A string array.
     * @return A square object.
     */
    public static Square readSquareData(String[] datas) {
        System.out.println(Arrays.toString(datas));

        int x = Integer.parseInt(datas[1]);
        int y = Integer.parseInt(datas[2]);
        int vx = Integer.parseInt(datas[3]);
        int vy = Integer.parseInt(datas[4]);
        boolean isFilled = Boolean.valueOf(datas[5]);
        int diameter = Integer.parseInt(datas[6]);
        int r = Integer.parseInt(datas[7]);
        int g = Integer.parseInt(datas[8]);
        int b = Integer.parseInt(datas[9]);
        int insertionTime = Integer.parseInt(datas[10]);
        boolean isFlashing = Boolean.valueOf(datas[11]);
        int r2 = Integer.parseInt(datas[12]);
        int g2 = Integer.parseInt(datas[13]);
        int b2 = Integer.parseInt(datas[14]);
        Color color2 = Color.rgb(r2, g2, b2);
        Color color = Color.rgb(r, g, b);
        Square sq = new Square(insertionTime, x, y, vx, vy, diameter, color, isFilled, isFlashing, color2);
        System.out.println(sq);
        return sq;

    }

    /**
     * Reads the datas array and return a rectangle object.
     *
     * @param datas A string array.
     * @return A rectangle object.
     */
    public static Rect readRectData(String[] datas) {
        System.out.println(Arrays.toString(datas));

        int x = Integer.parseInt(datas[1]);
        int y = Integer.parseInt(datas[2]);
        int vx = Integer.parseInt(datas[3]);
        int vy = Integer.parseInt(datas[4]);
        boolean isFilled = Boolean.valueOf(datas[5]);
        int width = Integer.parseInt(datas[6]);
        int height = Integer.parseInt(datas[7]);
        int r = Integer.parseInt(datas[8]);
        int g = Integer.parseInt(datas[9]);
        int b = Integer.parseInt(datas[10]);
        int insertionTime = Integer.parseInt(datas[11]);
        boolean isFlashing = Boolean.valueOf(datas[12]);
        int r2 = Integer.parseInt(datas[13]);
        int g2 = Integer.parseInt(datas[14]);
        int b2 = Integer.parseInt(datas[15]);
        Color color2 = Color.rgb(r2, g2, b2);
        Color color = Color.rgb(r, g, b);
        Rect rectangle = new Rect(insertionTime, x, y, vx, vy, width, height, color, isFilled, isFlashing, color2);
        System.out.println(rectangle);
        return rectangle;
    }

    /**
     * Reads the datas array and return an oval object.
     *
     * @param datas A string array.
     * @return A oval object.
     */
    public static Oval readOvalData(String[] datas) {
        System.out.println(Arrays.toString(datas));

        int x = Integer.parseInt(datas[1]);
        int y = Integer.parseInt(datas[2]);
        int vx = Integer.parseInt(datas[3]);
        int vy = Integer.parseInt(datas[4]);
        boolean isFilled = Boolean.valueOf(datas[5]);
        int width = Integer.parseInt(datas[6]);
        int height = Integer.parseInt(datas[7]);
        int r = Integer.parseInt(datas[8]);
        int g = Integer.parseInt(datas[9]);
        int b = Integer.parseInt(datas[10]);
        int insertionTime = Integer.parseInt(datas[11]);
        boolean isFlashing = Boolean.valueOf(datas[12]);
        int r2 = Integer.parseInt(datas[13]);
        int g2 = Integer.parseInt(datas[14]);
        int b2 = Integer.parseInt(datas[15]);
        Color color2 = Color.rgb(r2, g2, b2);
        Color color = Color.rgb(r, g, b);
        Oval oval = new Oval(insertionTime, x, y, vx, vy, width, height, color, isFilled, isFlashing, color2);
        System.out.println(oval);
        return oval;
    }

    /**
     * Reads the datas array and return a triangle object.
     *
     * @param datas A string array.
     * @return A triangle object.
     */
    public static Triangle readTriangleData(String[] datas) {
        System.out.println(Arrays.toString(datas));

        int x = Integer.parseInt(datas[1]);
        int y = Integer.parseInt(datas[2]);
        int vx = Integer.parseInt(datas[3]);
        int vy = Integer.parseInt(datas[4]);
        boolean isFilled = Boolean.valueOf(datas[5]);
        int length = Integer.parseInt(datas[6]);
        int r = Integer.parseInt(datas[7]);
        int g = Integer.parseInt(datas[8]);
        int b = Integer.parseInt(datas[9]);
        int insertionTime = Integer.parseInt(datas[10]);
        boolean isFlashing = Boolean.valueOf(datas[11]);
        int r2 = Integer.parseInt(datas[12]);
        int g2 = Integer.parseInt(datas[13]);
        int b2 = Integer.parseInt(datas[14]);
        Color color2 = Color.rgb(r2, g2, b2);
        Color color = Color.rgb(r, g, b);
        Triangle triangle = new Triangle(insertionTime, x, y, vx, vy, length, color, isFilled, isFlashing, color2);
        System.out.println(triangle);
        return triangle;
    }

}
