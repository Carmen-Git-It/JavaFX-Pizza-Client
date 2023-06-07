package com.carmengitit.ws02.controller;

import com.carmengitit.ws02.model.Customer;
import com.carmengitit.ws02.model.Order;
import com.carmengitit.ws02.model.Product;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PizzaController {
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private RadioButton cheeseRadioButton;
    @FXML
    private RadioButton vegetarianRadioButton;
    @FXML
    private RadioButton meatRadioButton;
    @FXML
    private ChoiceBox<String> sizeChoiceBox;
    @FXML
    private TextField quantityTextField;
    @FXML
    private Button placeOrderButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextArea summaryTextArea;

    private ArrayList<Order> orders = new ArrayList<Order>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private ToggleGroup pizzaType = new ToggleGroup();

    @FXML
    protected void onPlaceOrderButtonClick() {
        try {
            Customer customer = new Customer(nameTextField.getText(), phoneTextField.getText());

            if (customers.contains(customer)) {
                customer = customers.get(customers.indexOf(customer));
            }

            RadioButton type = (RadioButton) pizzaType.getSelectedToggle();

            double productPrice = 0;

            if (type.getText().equalsIgnoreCase("cheese")) {
               switch(sizeChoiceBox.getValue()) {
                   case "Small":
                       productPrice = 5;
                       break;
                   case "Medium":
                       productPrice = 8;
                       break;
                   case "Large":
                       productPrice = 10;
                       break;
               }
            } else if (type.getText().equalsIgnoreCase("meat lovers")) {
                switch(sizeChoiceBox.getValue()) {
                    case "Small":
                        productPrice = 6.50;
                        break;
                    case "Medium":
                        productPrice = 9.5;
                        break;
                    case "Large":
                        productPrice = 11.5;
                        break;
                }
            } else if (type.getText().equalsIgnoreCase("vegetarian")) {
                switch(sizeChoiceBox.getValue()) {
                    case "Small":
                        productPrice = 5.75;
                        break;
                    case "Medium":
                        productPrice = 8.75;
                        break;
                    case "Large":
                        productPrice = 10.75;
                        break;
                }
            }
            Product product = new Product(sizeChoiceBox.getValue(), type.getText(), productPrice);
            Order order = new Order();
            order.setCustomer(customer);
            order.addProduct(product, Integer.parseInt(quantityTextField.getText()));
            orders.add(order);
            customer.addOrder(order);

            if (!customers.contains(customer)) {
                customers.add(customer);
            }

            onCancelButtonClick();  // Clear inputs for next order

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            String summary = "Order Placed: " + dtf.format(LocalDateTime.now()) + "\n\n"
                    + "Customer Name: " + customer.getName() + "\n"
                    + "Customer Phone: " + customer.getPhone() + "\n\n"
                    + "Products Ordered:\n"
                    + "Size | Type | Price | Quantity\n"
                    + product + " | " + order.getProducts().get(product) + "\n\n"
                    + "Subtotal: " + order.getTotal();
            summaryTextArea.setText(summary);
        } catch(Exception e) {
            System.out.println(e.toString());
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Invalid Inputs");
            alert.setContentText("Please enter your information correctly and try again.");
            alert.showAndWait();
        }
    }

    @FXML
    protected void onCancelButtonClick() {
        summaryTextArea.setText("");
        quantityTextField.setText("");
        nameTextField.setText("");
        phoneTextField.setText("");
        cheeseRadioButton.setSelected(false);
        vegetarianRadioButton.setSelected(false);
        meatRadioButton.setSelected(false);
    }

    public void initialize() {
        cheeseRadioButton.setToggleGroup(pizzaType);
        meatRadioButton.setToggleGroup(pizzaType);
        vegetarianRadioButton.setToggleGroup(pizzaType);
        String[] sizes = {"Small", "Medium", "Large"};
        sizeChoiceBox.setItems(FXCollections.observableArrayList(sizes));
    }
}