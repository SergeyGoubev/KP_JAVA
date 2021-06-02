package Agency.DAO;

import java.util.List;

import Agency.Models.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class MessageDao {
    private JdbcTemplate template;
    private static final Logger logger= LoggerFactory.getLogger(MessageDao.class);

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void add(Message message) {
        logger.info("Внесение сообщения в базу данных");
        String createQuery = "INSERT INTO agency.messages(id, userId, organizatorId, message, date) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            Object[] params = {message.getId(), message.getUserId(), message.getOrganizatorId(), message.getMessage(), message.getData()};
            template.update(createQuery, params);
        } catch(Exception e) {
            logger.info(e.getMessage());
        }
    }

    public List<Message> getAllMessagesOfOrganizator(int id) {
        logger.info("Получить список всех сообщений");
        String selectQuery = "SELECT * FROM agency.messages WHERE messages.id = ?";
        try {
            return template.query(selectQuery,
                new Object[]{id},
                new BeanPropertyRowMapper<>(Message.class)
            );
        } catch(Exception e) {
            logger.info(e.getMessage());
            return null;
        }
    }
}
