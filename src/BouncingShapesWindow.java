
import java.io.FileNotFoundException;
import static java.lang.System.currentTimeMillis;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BouncingShapesWindow {

    private static final int ANIMATION_DELAY = 10;
    private static final String FRAME_TITLE = "Shape Booooiiinggg Frame";

    private GraphicsContext gc;
    private Queue<ClosedShape> shapesToAdd;
    private ArrayList<ClosedShape> activeShapes;
    private int currentTime = 0;
    private boolean flag = true;
    private boolean colourState = true;

    private String filename;

    /**
     * Creates a bouncing shape window.
     *
     * @param gc GraphicsContext object.
     * @param filename The location of file.
     */
    public BouncingShapesWindow(GraphicsContext gc, String filename){
        this.gc = gc;

        activeShapes = new ArrayList<ClosedShape>();
        this.initShapes(filename);
        this.insertShapes();
        drawFlashingShapes();
        actionPerformed();
    }

    /**
     * Draws closed shapes.
     */
    private void drawClosedShapes() {
        for (ClosedShape s : activeShapes) {
            s.draw(gc);

        }
    }

    /**
     * Draws flashing shapes if isFlashing equals true, otherwise draw closed shapes.
     */
    private void drawFlashingShapes() {
        Timer t = new Timer();
        t.schedule(new TimerTask() {

            @Override
            public void run() {
                for (ClosedShape s : activeShapes) {
                    s.draw(gc);
                    if (s.isFlashing) {
                        if (colourState) {
                            s.setColour(s.colour2);
                        } else {
                            s.setColour(s.getTemp());
                        }
                    }
                }
                if (colourState) {
                    colourState = false;
                } else {
                    colourState = true;
                }

            }
        }, 0, 2000);
    }

    /**
     * Initialize the shapes.
     * @param filename The filename
     */
    private void initShapes(String filename) {
        try {
            shapesToAdd = ReadShapeFile.readDataFile(filename); //
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }

    /**
     * Insert shapes to queue.
     */
    private void insertShapes() {
        //no more shapes to add, we are done
        if (shapesToAdd.isEmpty()) {
            return;
        }

        //add shapes if needed
        ClosedShape current = shapesToAdd.peek();
        while (!shapesToAdd.isEmpty() && (current.getInsertionTime() <= currentTime * ANIMATION_DELAY)) {
            activeShapes.add(current);
            shapesToAdd.dequeue();
            if (!shapesToAdd.isEmpty()) {
                current = shapesToAdd.peek();
            }
        }
    }

    public void actionPerformed() {

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(5), ae -> onTime()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }

    private void onTime() {
        currentTime++;
        double h = gc.getCanvas().getHeight();
        double w = gc.getCanvas().getWidth();
        gc.clearRect(0, 0, w, h);
        moveShapes();
        insertShapes();
        drawClosedShapes();

    }

    /**
     * Moves shapes in the window.
     */
    public void moveShapes() {
        double dimsY = gc.getCanvas().getHeight();
        double dimsX = gc.getCanvas().getWidth();
        for (ClosedShape s : activeShapes) {
            s.move();

            // Move us back in and bounce if we went outside the drawing area.
            if (s.outOfBoundsX(dimsX)) {
                s.putInBoundsX(dimsX);
                s.bounceX();
            }

            if (s.outOfBoundsY(dimsY)) {
                s.putInBoundsY(dimsY);
                s.bounceY();
            }

        }
    }

}
