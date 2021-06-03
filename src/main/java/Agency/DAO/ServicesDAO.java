package Agency.DAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import Agency.Models.Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;


@Repository
public class ServicesDAO {
    static JdbcTemplate template;
    private static final Logger logger= LoggerFactory.getLogger(ServicesDAO.class);

    public static List<Services> getServiceById(int userId) {
        logger.info("Выполнение метода getServiceById для вывода списка услуг");
        String Sql="select * from services where userId=" + userId;
        try{
            return template.query(Sql,new RowMapper<Services>(){
                public Services mapRow(ResultSet rs, int row) throws SQLException {
                    Services g =  new Services();
                    g.setId(rs.getInt("id"));
                    g.setName(rs.getString("name"));
                    g.setDescription(rs.getString("description"));
                    g.setCost(rs.getInt("costs"));
                    return g;
                }
            });
        }catch (Exception e) {
            logger.error("Ошибка при выполнении метода getServiceById: ", e);
            return null;
        }
    }


    public List<Services> getAllServices(){
        logger.info("Выполнение метода getAllServices для вывода всех сервисов");
        try{
            return template.query("select * from services",new RowMapper<Services>(){

                public Services mapRow(ResultSet rs, int row) throws SQLException {
                    Services s =  new Services();
                    s.setUserId(rs.getInt("userId"));
                    s.setName(rs.getString("name"));
                    s.setDescription(rs.getString("description"));
                    s.setCost(rs.getInt("costs"));
                    return s;
                }
            });

        }catch (Exception e){
            logger.error("Ошибка при выполнении метода getAllServices: ", e);
            return null;
        }
    }




    /*   public List<Services> getServicesById(int Id){
          logger.info("Выполнение метода getGuestsById для вывода списка сервисов");
          String Sql="select * from services where Id=" + Id;
          try{
              return template.query(Sql,new RowMapper<Services>(){
                  public Services mapRow(ResultSet rs, int row) throws SQLException {
                      Services s =  new Services();
                      s.setId(rs.getInt("id"));
                      s.setName(rs.getString("name"));
                      s.setDescription(rs.getString("description"));
                      s.setCost(rs.getInt("costs"));
                      return s;
                  }
              });
          }catch (Exception e) {
              logger.error("Ошибка при выполнении метода getServicesById: ", e);
              return null;
          }
      }
  */
    public int insertServices(int Id, Services services){
        logger.info("Выполнение метода insertGuest - добавление нового сервиса");
        String query="insert into services(Id, userId, name, description, costs) values (?, ?, ?, ?,?)";
        logger.info(query + services.getName());
        Object[] params = {Id, services.getUserId(), services.getName(), services.getDescription(), services.getCost()};
        int[] types = {Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        try {
            return template.update(query,params,types);
        }catch (Exception e) {
            logger.error("Ошибка при выполнении метода insertServices: ", e);
            return -1;
        }
    }

    public int deleteGuest(int id){
        logger.info("Выполнение метода delete - удаление сервиса");
        String query="delete from services where id=?";
        Object[] params = {id};
        int[] types = {Types.INTEGER};
        try {
            return template.update(query,params,types);
        }catch (Exception e) {
            logger.error("Ошибка при выполнении метода delete: ", e);
            return -1;
        }
    }



    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
}