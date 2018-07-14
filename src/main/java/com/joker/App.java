package com.joker;

import com.joker.api.JokerGreetAPI;
import com.joker.api.UserAPI;
import com.joker.config.AppConfig;
import com.joker.repository.UserRepository;
import com.joker.service.UserService;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;


public class App extends Application<AppConfig> {
    UserRepository userRepository;
    public static void main(String[] args) {
        try {
            new App().run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(AppConfig config, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, config.getDataSourceFactory(), "h2");
        userRepository = jdbi.onDemand(UserRepository.class);
        environment.jersey().register(JokerGreetAPI.class);
        environment.jersey().register(new UserAPI(new UserService(userRepository)));
    }

    @Override
    public void initialize(Bootstrap<AppConfig> bootstrap) {
        super.initialize(bootstrap);
    }
}
