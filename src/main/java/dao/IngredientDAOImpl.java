package dao;

import model.Ingredient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Service
@EnableTransactionManagement
@Transactional
public class IngredientDAOImpl implements IngredientDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Ingredient getIngredient(String name) {
        Session session = sessionFactory.openSession();
        Ingredient ingredient = (Ingredient) session.get(Ingredient.class, name);
        session.close();
        return ingredient;
    }
}
