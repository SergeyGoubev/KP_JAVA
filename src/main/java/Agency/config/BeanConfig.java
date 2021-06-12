package Agency.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import Agency.Controllers.UserController;
import Agency.DAO.*;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("Agency")
@EnableWebMvc
@EnableTransactionManagement
//Класс конфигурации в котором создаются бины для приложения
public class BeanConfig {

    //Три бина ниже нужны для создания подключения к БД и управления транзакциями
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory());
        transactionManager.setDataSource(dataSource());
        transactionManager.setJpaDialect(new HibernateJpaDialect());
        return transactionManager;
    }

    @Bean
    public DataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("yfgjktjy1813");
        dataSource.setDatabaseName("agency");
        return dataSource;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        return Persistence.createEntityManagerFactory("agency");
    }

    @Bean
    public CategoryDAO categoryDAO() {
        return new CategoryDAO();
    }

    @Bean
    public CommentRatingDAO commentRatingDAO() {
        return new CommentRatingDAO();
    }

    @Bean
    public GuestsDAO guestsDAO() {
        return new GuestsDAO();
    }

    @Bean
    public MessageDao messageDao() {
        return new MessageDao();
    }

    @Bean
    public ServicesDAO servicesDao() {
        return new ServicesDAO();
    }

    @Bean
    public UserDAO userDAO() {
        return new UserDAO(
            commentRatingDAO()
        );
    }

    @Bean
    public OrdersDao ordersDao() {
        return new OrdersDao();
    }

    @Bean
    public UserController userController() {
        return new UserController(
            userDAO(),
            categoryDAO(),
            guestsDAO(),
            commentRatingDAO(),
            messageDao(),
            servicesDao(),
            ordersDao()
        );
    }
}