import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CustomerApp {

    private JFrame frame;
    private JLabel idLabel, lastNameLabel, firstNameLabel, phoneLabel;
    private JTextField idField, lastNameField, firstNameField, phoneField;
    private JButton previousButton, nextButton;
    private List<Customer> customers;
    private int currentCustomerIndex = 0;

    public CustomerApp() {
        initializeGUI();
        initializeCustomers();
        displayCustomer();
    }

    private void initializeGUI() {
        frame = new JFrame("Customer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(5, 2));

        idLabel = new JLabel("ID:");
        lastNameLabel = new JLabel("Last Name:");
        firstNameLabel = new JLabel("First Name:");
        phoneLabel = new JLabel("Phone:");

        idField = new JTextField();
        idField.setEditable(false);
        lastNameField = new JTextField();
        lastNameField.setEditable(false);
        firstNameField = new JTextField();
        firstNameField.setEditable(false);
        phoneField = new JTextField();
        phoneField.setEditable(false);

        previousButton = new JButton("Previous");
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                previousCustomer();
            }
        });

        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextCustomer();
            }
        });

        frame.add(idLabel);
        frame.add(idField);
        frame.add(lastNameLabel);
        frame.add(lastNameField);
        frame.add(firstNameLabel);
        frame.add(firstNameField);
        frame.add(phoneLabel);
        frame.add(phoneField);
        frame.add(previousButton);
        frame.add(nextButton);

        frame.setVisible(true);
    }

    private void initializeCustomers() {
        customers = new ArrayList<>();
        customers.add(new Customer(001, "Meun", "Somaly", "010802030"));
        // Add more customers here...
    }

    private void displayCustomer() {
        Customer customer = customers.get(currentCustomerIndex);
        idField.setText(String.valueOf(customer.getId()));
        lastNameField.setText(customer.getLastName());
        firstNameField.setText(customer.getFirstName());
        phoneField.setText(customer.getPhone());
    }

    private void previousCustomer() {
        if (currentCustomerIndex > 0) {
            currentCustomerIndex--;
            displayCustomer();
        }
    }

    private void nextCustomer() {
        if (currentCustomerIndex < customers.size() - 1) {
            currentCustomerIndex++;
            displayCustomer();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CustomerApp();
            }
        });
    }
}

class Customer {
    private int id;
    private String lastName;
    private String firstName;
    private String phone;

    public Customer(int id, String lastName, String firstName, String phone) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhone() {
        return phone;
    }
}