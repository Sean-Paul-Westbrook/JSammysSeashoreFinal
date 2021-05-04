import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JSammysSeashore extends JFrame implements ActionListener, ItemListener {

    final int HIGH_FEE = 40;
    final int MED_FEE = 20;
    final int LOW_FEE = 7;
    final int EQUIP_LESSON = 5;
    int totalPrice = 0;
    int timeEntered = 0;
    int rentalPrice = 0;
    int lessonPrice = 0;
    String equipString = "";

    JLabel headerSammy = new JLabel("--- Sammy's Rentals ---");

    JLabel rentalLabel = new JLabel("Enter Rental Time (hrs)");
    JTextField rentalTime = new JTextField(5);

    JLabel rentalItem = new JLabel("Item");
    ButtonGroup rentals = new ButtonGroup();
    JCheckBox rental1 = new JCheckBox("Personal Watercraft");
    JCheckBox rental2 = new JCheckBox("Pontoon Boat");
    JCheckBox rental3 = new JCheckBox("Rowboat");
    JCheckBox rental4 = new JCheckBox("Canoe");
    JCheckBox rental5 = new JCheckBox("Kayak");
    JCheckBox rental6 = new JCheckBox("Beach Chair");
    JCheckBox rental7 = new JCheckBox("Umbrella");

    JLabel equipmentLesson = new JLabel("Add Lesson?");
    JCheckBox lesson = new JCheckBox("Equipment Lesson ($5)");

    JButton submitButton = new JButton("Submit");

    JLabel totalPriceLabel = new JLabel();
    JLabel rentalPrint = new JLabel();

    public static void main(String[] args) {
        JSammysSeashore frame = new JSammysSeashore();
    }

    public JSammysSeashore() {
        setTitle("Sammy's Seashore");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setVisible(true);
        headerSammy.setFont(new Font("Monospaced", Font.BOLD, 26));

        add(headerSammy);

        add(rentalLabel);
        add(rentalTime);
        add(rentalItem);
        add(rental1);
        add(rental2);
        add(rental3);
        add(rental4);
        add(rental5);
        add(rental6);
        add(rental7);
        rentals.add(rental1);
        rentals.add(rental2);
        rentals.add(rental3);
        rentals.add(rental4);
        rentals.add(rental5);
        rentals.add(rental6);
        rentals.add(rental7);

        add(equipmentLesson);
        add(lesson);

        add(submitButton);

        add(totalPriceLabel);
        add(rentalPrint);

        // Listeners
        submitButton.addActionListener(this);
        rental1.addItemListener(this);
        rental2.addItemListener(this);
        rental3.addItemListener(this);
        rental4.addItemListener(this);
        rental5.addItemListener(this);
        rental6.addItemListener(this);
        rental7.addItemListener(this);
        lesson.addItemListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == submitButton) {
            try {
                timeEntered = Integer.parseInt(rentalTime.getText());
            } catch (Exception e) {
                timeEntered = 0;
                rentalTime.setText("Error");
            }
        }
        totalPrice = rentalPrice + lessonPrice;
        totalPriceLabel.setText("Price: $" + totalPrice);
        rentalPrint.setText("Equipment: " + equipString + ", Time Rented: " + timeEntered + " hrs");
    }

    @Override
    public void itemStateChanged(ItemEvent item) {
        Object source = item.getSource();
        int select = item.getStateChange();
        if (select == ItemEvent.SELECTED) {
            if (source == rental1) {
                rentalPrice = HIGH_FEE * timeEntered;
                equipString = "Personal Watercraft";
            } else if (source == rental2) {
                rentalPrice = HIGH_FEE * timeEntered;
                equipString = "Pontoon Boat";
            } else if (source == rental3) {
                rentalPrice = MED_FEE * timeEntered;
                equipString = "Rowboat";
            } else if (source == rental4) {
                rentalPrice = MED_FEE * timeEntered;
                equipString = "Canoe";
            } else if (source == rental5) {
                rentalPrice = MED_FEE * timeEntered;
                equipString = "Kayak";
            } else if (source == rental6) {
                rentalPrice = LOW_FEE * timeEntered;
                equipString = "Beach Chair";
            } else if (source == rental7) {
                rentalPrice = LOW_FEE * timeEntered;
                equipString = "Umbrella";
            } else if (source == lesson) {
                lessonPrice = EQUIP_LESSON;
            } else {
                lessonPrice = 0;
            }
        }
    }
}