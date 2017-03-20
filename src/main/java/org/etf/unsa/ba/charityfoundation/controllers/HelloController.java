package org.etf.unsa.ba.charityfoundation.controllers;

import org.etf.unsa.ba.charityfoundation.utils.Contact;
import org.etf.unsa.ba.charityfoundation.utils.MailHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    private static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/api")
    @ResponseBody
    String home() {
        return "Connected with backend!";
    }

    @RequestMapping(value = "/api/contact", method = RequestMethod.POST)
    public void sendEmail(@RequestBody Contact contact) {
        try {
            MailHelper.sendMail(contact.getTo(), contact.getMessage());
            LOGGER.info("Email has been sent successfully.");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }
}