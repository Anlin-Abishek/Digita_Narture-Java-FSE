package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOG = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOG.info("START");
        SpringApplication.run(SpringLearnApplication.class, args);
        SpringLearnApplication app = new SpringLearnApplication();
        app.displayDate();
        LOG.info("END");
    }

    public void displayDate() {
        LOG.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        try {
            Date date = format.parse("31/12/2018");
            LOG.debug("Parsed Date: {}", date);
        } catch (ParseException e) {
            LOG.error("Error parsing date: {}", e.getMessage());
        }
        LOG.info("END");
    }
}
