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

public class JCarlysCatering extends JFrame implements ActionListener, ItemListener {

    final int PRICE_PER_GUEST = 35;
    int price = 0;
    int count = 0;
    String entreeChoice = "";
    String sideChoice = "";
    String dessertChoice = "";

    JLabel headerCarly = new JLabel("--- Carly's Choices ---");

    JLabel guestsLabel = new JLabel("Enter number of guests attending");
    JTextField numberGuests = new JTextField(5);

    JLabel entreeLabel = new JLabel("Pick one entree");
    ButtonGroup entrees = new ButtonGroup();
    JCheckBox entree1 = new JCheckBox("Ramen Bowl");
    JCheckBox entree2 = new JCheckBox("Sushi");
    JCheckBox entree3 = new JCheckBox("Tacos");
    JCheckBox entree4 = new JCheckBox("Enchiladas");

    JLabel sidesLabel = new JLabel("Pick two sides");
    JCheckBox side1 = new JCheckBox("Sweet Potato Fries");
    JCheckBox side2 = new JCheckBox("Mashed Potatoes");
    JCheckBox side3 = new JCheckBox("Caesar Salad");
    JCheckBox side4 = new JCheckBox("Onion Rings");

    JLabel dessertLabel = new JLabel("Pick one dessert..I know, only 1, sucks");
    ButtonGroup desserts = new ButtonGroup();
    JCheckBox dessert1 = new JCheckBox("Lemon Bars");
    JCheckBox dessert2 = new JCheckBox("Cinnamon Rolls");
    JCheckBox dessert3 = new JCheckBox("Pecan Pie");

    JButton submitButton = new JButton("Submit");

    JLabel totalPriceLabel = new JLabel();
    JLabel menuLabel = new JLabel();

    public static void main(String[] args) {
        JCarlysCatering frame = new JCarlysCatering();
    }

    public JCarlysCatering() {
        setTitle("Carly's Catering");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setVisible(true);
        headerCarly.setFont(new Font("Monospaced", Font.BOLD, 22));

        add(headerCarly);

        add(guestsLabel);
        add(numberGuests);

        add(entreeLabel);
        entrees.add(entree1);
        entrees.add(entree2);
        entrees.add(entree3);
        entrees.add(entree4);
        add(entree1);
        add(entree2);
        add(entree3);
        add(entree4);

        add(sidesLabel);
        add(side1);
        add(side2);
        add(side3);
        add(side4);

        add(dessertLabel);
        desserts.add(dessert1);
        desserts.add(dessert2);
        desserts.add(dessert3);
        add(dessert1);
        add(dessert2);
        add(dessert3);

        add(submitButton);

        add(totalPriceLabel);
        add(menuLabel);

        // Listeners
        submitButton.addActionListener(this);
        entree1.addItemListener(this);
        entree2.addItemListener(this);
        entree3.addItemListener(this);
        entree4.addItemListener(this);
        side1.addItemListener(this);
        side2.addItemListener(this);
        side3.addItemListener(this);
        side4.addItemListener(this);
        dessert1.addItemListener(this);
        dessert2.addItemListener(this);
        dessert3.addItemListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == submitButton) {
            try {
                price = Integer.parseInt(numberGuests.getText()) * PRICE_PER_GUEST;
            } catch (Exception e) {
                price = 0;
            }
            totalPriceLabel.setText("Price: $" + price);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent item) {
        Object source = item.getSource();
        int select = item.getStateChange();

        if (source == entree1) {
            if (select == ItemEvent.SELECTED) {
                entreeChoice = "Ramen Bowl" + ", ";
            }
        }
        if (source == entree2) {
            if (select == ItemEvent.SELECTED) {
                entreeChoice = "Sushi" + ", ";
            }
        }
        if (source == entree3) {
            if (select == ItemEvent.SELECTED) {
                entreeChoice = "Tacos" + ", ";
            }
        }
        if (source == entree4) {
            if (select == ItemEvent.SELECTED) {
                entreeChoice = "Enchiladas" + ", ";
            }
        }
        if (source == side1 || source == side2 || source == side3 || source == side4) {
            if (select == ItemEvent.SELECTED) {
                count++;
            } else {
                count--;
            }
            sideChoice = "";
            if (count <= 2) {
                if (side1.isSelected()) {
                    sideChoice += "Sweet Potato Fries" + ", ";
                }
                if (side2.isSelected()) {
                    sideChoice += "Mashed Potatoes" + ", ";
                }
                if (side3.isSelected()) {
                    sideChoice += "Caesar Salad" + ", ";
                }
                if (side4.isSelected()) {
                    sideChoice += "Onion Rings" + ", ";
                }
            } else {
                side1.setSelected(false);
                side2.setSelected(false);
                side3.setSelected(false);
                side4.setSelected(false);
            }
        }
        if (source == dessert1) {
            if (select == ItemEvent.SELECTED) {
                dessertChoice = "Lemon Bars";
            }
        }
        if (source == dessert2) {
            if (select == ItemEvent.SELECTED) {
                dessertChoice = "Cinnamon Rolls";
            }
        }
        if (source == dessert3) {
            if (select == ItemEvent.SELECTED) {
                dessertChoice = "Pecan Pie";
            }
        }
        menuLabel.setText("Menu: " + entreeChoice + sideChoice + dessertChoice);
    }
}
