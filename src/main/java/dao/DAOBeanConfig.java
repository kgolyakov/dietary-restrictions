package dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
public class DAOBeanConfig {
    @Bean(name = "userDAO")
    UserDAO userDAO() {
        return new UserDAOImpl();
    }

    @Bean(name = "ingredientDAO")
    IngredientDAO ingredientDAO() {
        return new IngredientDAOImpl();
    }
}
