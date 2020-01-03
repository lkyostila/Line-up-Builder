/*
 * A class to create the field and the players
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class Field extends JPanel implements Printable {

    private static final long serialVersionUID = 1L;
    Image image;

    public Field() {
        setBackground(new Color(0, 128, 0));
        setPreferredSize(new Dimension(100, 180));
    }

    Shape[] players = new Shape[]{
        new Ellipse2D.Double(130, 450, 50, 50),
        new Ellipse2D.Double(40, 450, 50, 50),
        new Ellipse2D.Double(220, 450, 50, 50),
        new Ellipse2D.Double(310, 450, 50, 50),
        new Ellipse2D.Double(130, 300, 50, 50),
        new Ellipse2D.Double(40, 300, 50, 50),
        new Ellipse2D.Double(220, 300, 50, 50),
        new Ellipse2D.Double(310, 300, 50, 50),
        new Ellipse2D.Double(220, 150, 50, 50),
        new Ellipse2D.Double(130, 150, 50, 50),
        new Ellipse2D.Double(180, 560, 50, 50),};

    Color[] colors = new Color[]{
        Color.BLUE,
        Color.BLUE,
        Color.BLUE,
        Color.BLUE,
        Color.BLUE,
        Color.BLUE,
        Color.BLUE,
        Color.BLUE,
        Color.BLUE,
        Color.BLUE,
        Color.BLUE,
        Color.BLUE
    };

    String[] numbers = new String[]{
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10",
        "11",};
    String[] names = new String[]{
        "Player 1",
        "Player 2",
        "Player 3",
        "Player 4",
        "Player 5",
        "Player 6",
        "Player 7",
        "Player 8",
        "Player 9",
        "Player 10",
        "Player 11",};
    int targetSet = 0;
    AffineTransform toLogical;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        double width = getWidth();
        double fieldLength = getHeight();
        double fieldWidth = getWidth();
        double scaleWidth = fieldWidth;
        double scale = width / scaleWidth;

        g2.scale(scale, scale);
        g2.translate(1, 1);
        g2.setColor(Color.WHITE);
        Stroke stroke = new BasicStroke(30 / 36);
        g2.setStroke(stroke);
        touchLines(g2, fieldLength, fieldWidth);
        // Draw the field by calling the operations
        centerLine(g2, fieldLength, fieldWidth);
        centerCircle(g2, fieldLength, fieldWidth);
        goalAreas(g2, fieldLength, fieldWidth);
        penaltyAreas(g2, fieldLength, fieldWidth);
        penaltyArches(g2, fieldLength, fieldWidth);
        // Draw the players by calling the operation
        drawPlayers(g2, fieldLength, fieldWidth);

        if (image != null) {
            setImage(image);
        }
    }

    public void drawNumbers(Color c, Graphics2D g2) {
        for (int i = 0; i < players.length; i++) {
            String number = "";
            Point2D pos = new Point2D.Double();
            Rectangle2D bounds = players[i].getBounds2D();
            pos.setLocation(pos.getX() + bounds.getCenterX(), pos.getY() + bounds.getCenterY());
            number = numbers[i];
            float halfWidth = (float) (g2.getFontMetrics().getStringBounds(number, g2).getWidth() / 2f);
            float halfWidth2 = (float) (g2.getFontMetrics().getStringBounds(number, g2).getWidth() / 2f);
            g2.setColor(c);
            g2.setFont(new Font("Arial", Font.BOLD, 20));
            g2.drawString(number, (float) pos.getX() - halfWidth, (float) pos.getY());
        }
    }

    public void drawPlayers(Graphics2D g2, double fieldLength, double fieldWidth) {
        double scaleWidth = fieldWidth;
        double scaleHeight = fieldLength;
        double scale = fieldWidth / scaleWidth;
        Composite oldComposite = g2.getComposite();

        float scale2 = Math.min(getWidth(), getHeight()) / 6;
        AffineTransform t = AffineTransform.getScaleInstance(scale, scale);

        try {
            toLogical = t.createInverse();
        } catch (NoninvertibleTransformException ex) {
            Logger.getLogger(Field.class.getName()).log(Level.SEVERE, null, ex); // This should never occur
        }
        g2.transform(t);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (int i = 0; i < players.length; i++) {
            g2.setColor(colors[i]);
            g2.fill(players[i]);
        }
        g2.setComposite(oldComposite);

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(1.0f / scale2));
        for (int i = 0; i < players.length; i++) {
            g2.draw(players[i]);
        }

        for (int i = 0; i < players.length; i++) {
            String name = "";
            String number = "";
            Point2D pos = new Point2D.Double(); // find the center position of the included players
            Rectangle2D bounds = players[i].getBounds2D(); // find set bounds
            pos.setLocation(pos.getX() + bounds.getCenterX(), pos.getY() + bounds.getCenterY()); // and adjust average location per set area center
            name = names[i];
            number = numbers[i];
            float halfWidth = (float) (g2.getFontMetrics().getStringBounds(number, g2).getWidth() / 2f);
            float halfWidth2 = (float) (g2.getFontMetrics().getStringBounds(name, g2).getWidth() / 2f);
            g2.setFont(new Font("Arial", Font.BOLD, 20));
            g2.drawString(number, (float) pos.getX() - halfWidth * 2, (float) pos.getY() + 10);
            g2.setFont(new Font("Arial", Font.BOLD, 12));
            g2.drawString(name, (float) pos.getX() - halfWidth2, (float) pos.getY() + 50);
        }

    }

    public void setImage(Image image) {
        this.image = image;
    }
    // The next operations are supposed to draw the different player formations.
    public void draw433() {
        players = new Shape[]{
            new Ellipse2D.Double(130, 450, 50, 50),
            new Ellipse2D.Double(40, 450, 50, 50),
            new Ellipse2D.Double(220, 450, 50, 50),
            new Ellipse2D.Double(310, 450, 50, 50),
            new Ellipse2D.Double(75, 300, 50, 50),
            new Ellipse2D.Double(175, 300, 50, 50),
            new Ellipse2D.Double(285, 300, 50, 50),
            new Ellipse2D.Double(75, 150, 50, 50),
            new Ellipse2D.Double(175, 150, 50, 50),
            new Ellipse2D.Double(285, 150, 50, 50),
            new Ellipse2D.Double(180, 560, 50, 50),};
    }

    public void draw352() {
        players = new Shape[]{
            new Ellipse2D.Double(65, 450, 50, 50),
            new Ellipse2D.Double(175, 450, 50, 50),
            new Ellipse2D.Double(285, 450, 50, 50),
            new Ellipse2D.Double(175, 330, 50, 50),
            new Ellipse2D.Double(30, 330, 50, 50),
            new Ellipse2D.Double(120, 280, 50, 50),
            new Ellipse2D.Double(230, 280, 50, 50),
            new Ellipse2D.Double(320, 330, 50, 50),
            new Ellipse2D.Double(220, 150, 50, 50),
            new Ellipse2D.Double(130, 150, 50, 50),
            new Ellipse2D.Double(180, 560, 50, 50),};
    }

    public void draw442() {
        players = new Shape[]{
            new Ellipse2D.Double(130, 450, 50, 50),
            new Ellipse2D.Double(40, 450, 50, 50),
            new Ellipse2D.Double(220, 450, 50, 50),
            new Ellipse2D.Double(310, 450, 50, 50),
            new Ellipse2D.Double(130, 300, 50, 50),
            new Ellipse2D.Double(40, 300, 50, 50),
            new Ellipse2D.Double(220, 300, 50, 50),
            new Ellipse2D.Double(310, 300, 50, 50),
            new Ellipse2D.Double(220, 150, 50, 50),
            new Ellipse2D.Double(130, 150, 50, 50),
            new Ellipse2D.Double(180, 560, 50, 50),};
    }

    public void draw343() {
        players = new Shape[]{
            new Ellipse2D.Double(65, 450, 50, 50),
            new Ellipse2D.Double(175, 450, 50, 50),
            new Ellipse2D.Double(285, 450, 50, 50),
            new Ellipse2D.Double(310, 300, 50, 50),
            new Ellipse2D.Double(130, 300, 50, 50),
            new Ellipse2D.Double(40, 300, 50, 50),
            new Ellipse2D.Double(220, 300, 50, 50),
            new Ellipse2D.Double(75, 150, 50, 50),
            new Ellipse2D.Double(175, 150, 50, 50),
            new Ellipse2D.Double(285, 150, 50, 50),
            new Ellipse2D.Double(180, 560, 50, 50),};
    }

    public void draw331() {
        players = new Shape[]{
            new Ellipse2D.Double(65, 450, 50, 50),
            new Ellipse2D.Double(175, 450, 50, 50),
            new Ellipse2D.Double(285, 450, 50, 50),
            new Ellipse2D.Double(75, 300, 50, 50),
            new Ellipse2D.Double(175, 300, 50, 50),
            new Ellipse2D.Double(285, 300, 50, 50),
            new Ellipse2D.Double(175, 150, 50, 50),
            new Ellipse2D.Double(180, 560, 50, 50)
        };
    }
    // The operations to draw the field.
    private void penaltyArches(Graphics2D g2, double fieldLength, double fieldWidth) {
        double extent = 106.26020470831196d;
        g2.draw(new Arc2D.Double((fieldWidth / 2) - 40, 0, 80, 80, 270 - (extent / 2), extent, Arc2D.OPEN));
        g2.draw(new Arc2D.Double((fieldWidth / 2) - 40, fieldLength - 80, 80, 80, 90 - (extent / 2), extent, Arc2D.OPEN));
    }

    private void penaltyAreas(Graphics2D g2, double fieldLength, double fieldWidth) {
        g2.draw(new Rectangle2D.Double((fieldWidth / 2) - 90, 4, 180, 60));
        g2.draw(new Rectangle2D.Double((fieldWidth / 2) - 90, fieldLength - 64, 180, 60));
    }

    private void goalAreas(Graphics2D g2, double fieldLength, double fieldWidth) {
        g2.draw(new Rectangle2D.Double((fieldWidth / 2) - 40, 4, 80, 25));
        g2.draw(new Rectangle2D.Double((fieldWidth / 2) - 40, fieldLength - 29, 80, 25));
    }
    private void centerCircle(Graphics2D g2, double fieldLength,
            double fieldWidth) {
        g2.draw(new Ellipse2D.Double((fieldWidth / 2) - 40, (fieldLength / 2) - 40, 80, 80));
    }

    private void centerLine(Graphics2D g2, double fieldLength,
            double fieldWidth) {
        g2.draw(new Line2D.Double(4, fieldLength / 2, fieldWidth - 4, fieldLength / 2));
    }

    private void touchLines(Graphics2D g2, double fieldLength,
            double fieldWidth) {
        g2.draw(new Line2D.Double(4, 4, fieldWidth - 4, 4));
        g2.draw(new Line2D.Double(4, fieldLength - 4, fieldWidth - 4, fieldLength - 4));
        g2.draw(new Line2D.Double(4, 4, 4, fieldLength - 4));
        g2.draw(new Line2D.Double(fieldWidth - 4, 4, fieldWidth - 4, fieldLength - 4));
    }
    
    public boolean selectPlayerSet(MouseEvent e) {
        Point2D ptDst = new Point2D.Double();
        toLogical.transform(e.getPoint(), ptDst);
        for (int i = 0; i < players.length; i++) {
            if (players[i].contains(ptDst)) {
                targetSet = i;
                return true;
            }
        }
        return false;
    }
    /*
     * Accessors
     */
    void setNames(String name) {
        names[targetSet] = name;
        repaint();
    }

    void setNumbers(String num) {
        numbers[targetSet] = num;
        repaint();
    }

    void setSetColor(Color c) {
        for (int i = 0; i < players.length; i++) {
            colors[i] = c;
            repaint();
        }
    }

    void setNumColor(Color c) {
        for (int i = 0; i < players.length; i++) {
            //setColor(c);
            colors[i] = c;
            repaint();
        }
    }

    String getSetName() {
        return names[targetSet];
    }

    String getSetNumber() {
        return numbers[targetSet];
    }

    Color getSetColor() {
        return colors[targetSet];
    }

    public void mouseDragged(MouseEvent e) {
        int newX = e.getX();
        int newY = e.getY();
        e.getComponent().setLocation(newX, newY);
    }

    @Override
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        Graphics2D g2 = (Graphics2D) g;
        paintComponent(g2);
        return PAGE_EXISTS;
    }
}
