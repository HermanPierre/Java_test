package com.smallAPI.smallAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class PropertyLoader {

    @Autowired
    private StandardEnvironment environment;

    @Scheduled(fixedRate=1000)
    public void reload() throws IOException {
        MutablePropertySources propertySources = environment.getPropertySources();
        Properties properties = new Properties();
        InputStream inputStream = getClass().getResourceAsStream("/external.properties");
        properties.load(inputStream);
        inputStream.close();
        System.out.println(properties);
        propertySources.replace("class path resource [external.properties]", new PropertiesPropertySource("class path resource [external.properties]", properties));
    }
}