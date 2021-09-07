package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@EnableTransactionManagement
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public User getUser(long userId) {
        Session session = sessionFactory.openSession();
        User user = (User) session.get(User.class, userId);
        session.close();
        return user;
    }
}
