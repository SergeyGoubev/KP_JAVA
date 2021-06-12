package Agency.Controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import Agency.DAO.*;
import Agency.Models.*;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({"userJSP", "backRef"})   //Сессионные атрибуты для извлечения данных о пользователе после входа.
@RequiredArgsConstructor
public class UserController {
    private final UserDAO userDao;
    private final CategoryDAO categoryDao;
    private final GuestsDAO guestsDao;
    private final CommentRatingDAO commentRatingDao;
    private final MessageDao messageDao;
    private final ServicesDAO servicesDao;
    private final OrdersDao ordersDao;

    @ModelAttribute("userJSP")
    public User createUser() {
        return new User();
    }

    @GetMapping(value = "/entry")      //открытие страницы входа
    public String entry(Model m, @RequestParam(required = false) String error) {
        if(error != null) {
            m.addAttribute("test", "wrong  data");
            return "entry";
        }
        m.addAttribute("command", new User());
        return "entry";
    }

    @RequestMapping("/userIndex")   //открытие главной страницы клиента после входа в систему
    public ModelAndView userIndex(Principal principal) {
        User user = userDao.getByLogin(principal.getName());
        ModelAndView modelAndView = new ModelAndView("UserIndex");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping("/organizatorIndex")       //открытие главной страницы организатора после входа в систему
    public String organizatorIndex() {
        return "OrganizatorIndex";
    }

    @RequestMapping("/organizatorRegistration")    //открытие страницы регистрации организатора
    public String organizatorRegistration(Model m) {
        m.addAttribute("command", new User());
        return "OrganizatorRegistration";
    }

    @RequestMapping("/userRegistration")    //открытие страницы регистрации клиента
    public String userRegistration(Model m) {
        m.addAttribute("command", new User());
        return "UserRegistration";
    }

    @RequestMapping(value = "/organizatorInfo/{id}")
    //просмотр страницы организатора и реализация кнопки вернуться на главную страницу в зависимости от типа пользователя
    public String organizatorInfo(@PathVariable int id, @ModelAttribute("userJSP") User userjsp, Model m) {
        User user = userDao.getById(id);  //Вывод организатора
        List<CommentRating> list = commentRatingDao.getCommentsByOrgId(id); //вывод списка комментариев и оценок
        int mark = commentRatingDao.getMark(id, userjsp.getUserId());
        CommentRating commentRating = new CommentRating();
        commentRating.setMark(5);
        int type = userjsp.getTypeOfUser().getTypeOfUser();
        if(mark > 0 || type != 1) m.addAttribute(
            "hidden",
            "hidden"
        );   //если пользователь поставил комментарий, ему уже не доступна эта функция
        else m.addAttribute("hidden", "");                               //комментарии может ставить только клиент
        m.addAttribute("command", commentRating);
        m.addAttribute("list", list);
        if(user.getTypeOfUser().getTypeOfUser() == 2) {
            float rating = commentRatingDao.getRating(id);
            user.setRating(rating);
        }
        if(type == 1) {
            m.addAttribute("backRef", "userIndex");
        } else if(type == 2) {
            m.addAttribute("backRef", "organizatorIndex");
        } else if(type == 3) {
            m.addAttribute("backRef", "adminIndex");
        } else {
            m.addAttribute("backRef", "Error");
        }
        m.addAttribute("user", user);
        return "OrganizatorInfo";
    }

    @RequestMapping(value = "/test")
    public String test() {
        return "test";
    }

    @RequestMapping(value = "/Hosts/{category}")
    //просмотр списка организаторов по категориям и полуение навания категории и реализация кнопки Вернуться назад в заависимости от типа пользователя который вошел
    public String Hosts(@PathVariable int category, @ModelAttribute("userJSP") User user, Model m) {
        int type = user.getTypeOfUser().getTypeOfUser();
        if(type == 1) {
            m.addAttribute("backRef", "userIndex");
        } else if(type == 2) {
            m.addAttribute("backRef", "organizatorIndex");
        } else if(type == 3) {
            m.addAttribute("backRef", "adminIndex");
        } else {
            m.addAttribute("backRef", "Error");
        }
        List<User> list =
            userDao.getByCategory(category);  //Вывод списка пользователей по категориям и вывод названия категории
        Category cat = categoryDao.getById(category);
        m.addAttribute("list", list);
        m.addAttribute("cat", cat.getName());
        return "Hosts";
    }

    @RequestMapping(value = "/getUserImage/{userId}")   //загрузка картинки при регистрации организатора
    public void getUserImage(HttpServletResponse response, @PathVariable("userId") int userId) throws IOException {
        response.setContentType("image/jpeg");
        byte[] buffer = userDao.getUserImage(userId);
        InputStream in1 = new ByteArrayInputStream(buffer);
        IOUtils.copy(in1, response.getOutputStream());
    }

    @RequestMapping(value = "/guests")     //просмотр списка гостей
    public String guests(@ModelAttribute("userJSP") User user, Model m) {
        int userId = user.getUserId();
        List<Guest> list = guestsDao.getGuestsById(userId);
        m.addAttribute("list", list);
        m.addAttribute("command", new Guest());
        return "Guests";
    }

    @RequestMapping("index")
    //при нажати на кнопку Выход, сессия будет завершена и пользователь вернется на главную страницу, где не выполнен вход
    public String back(@ModelAttribute("userJSP") User user, SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "index";
    }

    @RequestMapping(value = "/pageUserInfo")
    //@PathVariable используется для работы с параметрами, передаваемыми через адрес запроса
    public String userInfo(
        @ModelAttribute("userJSP") User user,
        Model m
    ) {    //возможность клиента просматривать информацию о себе
        m.addAttribute("user", user);
        m.addAttribute("backRef", "userIndex");
        return "UserInfo";
    }

    @RequestMapping(value = "/userInfo/{id}")
    //просмотр страницы организатора и реализация кнопки вернуться на главную страницу в зависимости от типа пользователя
    public String userInfo(@PathVariable int id, Model m) {
        User user = userDao.getById(id);  //Вывод организатора
        m.addAttribute("user", user);
        return "UserInfo";
    }

    @RequestMapping(value = "/pageOrganizatorInfo")
    //@PathVariable используется для работы с параметрами, передаваемыми через адрес запроса
    public String pageOrganizatorInfo(
        @ModelAttribute("userJSP") User user,
        Model m
    ) {       //возможность организатора просматривать информацию о себе
        m.addAttribute("user", user);
        m.addAttribute("backRef", "organizatorIndex");
        return "PageOrganizator";
    }

    @RequestMapping(value = "/newuser")//добавление нового пользователя
    public String newUser(@ModelAttribute("command") User user) {
        user.setCategory(categoryDao.getById(1));
        int id = userDao.add(user);    //вызов метода insert
        if(id != -1) return "entry";  //возвращаем страницу входа
        else return "redirect:/Error";
    }

    @RequestMapping(value = "/newguest")  //добавление нового гостя
    public String newGuest(@ModelAttribute("command") Guest guest, @ModelAttribute("userJSP") User user) {
        int id = guestsDao.add(guest);    //вызов метода insertGuest
        if(id != -1) return "redirect:/guests";  //возвращаем страницу входа
        else return "redirect:/Error";
    }

    @RequestMapping(value = "/deleteGuest/{id}")
    public String deleteGuest(@PathVariable int id) {
        int i = guestsDao.delete(id);
        if(i != -1) return "redirect:/guests";
        else return "redirect:/Error";
    }

    @RequestMapping(value = "/neworganizator")  //добавление нового организатора
    public String newOrganizator(@ModelAttribute("command") User user, @RequestParam("image2") MultipartFile image) {
        try {
            user.setImage(image.getBytes());
        } catch(Exception e) {
            return "redirect:/Error";
            //return new ModelAndView("index", "msg", "Error: " + e.getMessage());
        }
        user.setCategory(categoryDao.getById(2));
        int id = userDao.add(user);
        if(id != -1) return "entry";
        else return "redirect:/Error";
    }

    @RequestMapping(value = "/comment/{orgId}")  //добавление комментария и оценки
    public String comment(
        @PathVariable int orgId,
        @ModelAttribute("userJSP") User user,
        @ModelAttribute("command") CommentRating commentRating
    ) {
        int userId = user.getUserId();
        int id = commentRatingDao.add(commentRating);
        if(id != -1) return "redirect:/pageOrganizatorInfo";
        else return "redirect:/Error";
    }


    /* @RequestMapping(value="/services")     //просмотр списка гостей
    public String services (@ModelAttribute("userJSP")  Model m){
        List<Services> list = ServicesDAO.getAllServices();
        m.addAttribute("list",list);
        return "Services";
    }
     */

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public ModelAndView orderForm() {
        ModelAndView modelAndView = new ModelAndView("order");
        modelAndView.addObject("organizators", userDao.getByCategory(2));
        modelAndView.addObject("order", new Orders().setOrganizator(new User()));
        return modelAndView;
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ModelAndView createOrder(@RequestBody @ModelAttribute("order") Orders orders, Principal principal) {
        orders.setDate(LocalDateTime.now());
        orders.setUser(userDao.getByLogin(principal.getName()));
        orders.setStatus("accepted");
        orders.setOrganizator(userDao.getById(orders.getOrganizator().getUserId()));
        ordersDao.add(orders);
        return new ModelAndView("redirect:/userIndex");
    }

    @RequestMapping("/error")   //возврат страницы с ошибкой
    public String viewUsers() {
        return "Error";
    }


    @RequestMapping("/messages/{id}")
    public ModelAndView messages(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("messages");
        List<Message> messages = messageDao.getAllMessagesOfOrganizator(id);
        modelAndView.addObject("list", messages);
        return modelAndView;
    }

    @RequestMapping(value = "/services")     //просмотр списка услуг
    public String services(@ModelAttribute("userJSP") User user, Model m) {
        int userId = user.getUserId();
        List<Service> list = servicesDao.getServicesById(userId);
        m.addAttribute("list", list);
        m.addAttribute("command", new Service());
        return "Services";
    }


    @RequestMapping(value = "/message/write/{id}")
    public ModelAndView writeForm(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("messageForm");
        User user = userDao.getById(id);
        Message message = new Message();
        message.setUser(user);
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @RequestMapping(value = "/send/{userId}")
    public ModelAndView send(@RequestBody @ModelAttribute("message") Message message, Principal principal,
                             @PathVariable(name = "userId") int userId) {
        User organizator = userDao.getByLogin(principal.getName());
        User user = userDao.getById(userId);
        message.setDate(LocalDateTime.now());
        message.setOrganizator(organizator);
        message.setUser(user);
        messageDao.add(message);
        return new ModelAndView("redirect:/messages/"+organizator.getUserId());
    }
}