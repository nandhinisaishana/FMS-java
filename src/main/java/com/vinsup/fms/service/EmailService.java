/*package com.vinsup.fms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
        System.out.println("📧 Mail sent to " + to);
    }
}
*/

package com.vinsup.fms.service;

import com.vinsup.fms.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    // Default recipients (can be moved to DB later)
    private static final String INVENTORY_MANAGER_EMAIL = "inventory.manager@company.com";
    private static final String PURCHASE_DEPARTMENT_EMAIL = "purchase.department@company.com";

    public void sendLowStockAlert(Inventory inventory) {
        String subject = "⚠️ Low Stock Alert - " + inventory.getItemName();
        String body = "Dear Team,\n\n" +
                "This is an automated alert from the Facility Management System.\n\n" +
                "The following inventory item is running low on stock:\n\n" +
                "Item Name: " + inventory.getItemName() + "\n" +
                "Category: " + inventory.getCategory() + "\n" +
                "Current Quantity: " + inventory.getQuantity() + "\n" +
                "Room: " + (inventory.getRoom() != null ? inventory.getRoom().getRoomNumber() : "N/A") + "\n\n" +   //.getName() to .getRoomNumber
                "Please take necessary action such as creating a new purchase order.\n\n" +
                "Regards,\n" +
                "Facility Management System\n" +
                "Automated Notification Service";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(INVENTORY_MANAGER_EMAIL, PURCHASE_DEPARTMENT_EMAIL);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);

        System.out.println("📧 Low stock alert sent to Inventory Manager and Purchase Department for: "
                + inventory.getItemName());
    }
}
