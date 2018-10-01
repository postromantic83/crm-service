package ru.gazpromneft_at;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
@RestController
@RequestMapping("/monitoring")
@PropertySource("classpath:application.properties")
public class Application {
    Logger logger = LogManager.getLogger(Application.class);
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Value("${app.hostname}")
    private String hostName;

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello() throws UnknownHostException {
        ArrayList<InetAddress>ips = null;
        Integer availableIP = 0;
        InetAddress ip = InetAddress.getByName(hostName);
        ips = new ArrayList<InetAddress>(Arrays.asList(InetAddress.getAllByName(hostName)));

        for(InetAddress inetAddress : ips){
            logger.info(hostName + " ip: " + inetAddress);
            availableIP++;
        }
        return new String("Hello world! Host:" + hostName + " IP:" + ips);

    }

}