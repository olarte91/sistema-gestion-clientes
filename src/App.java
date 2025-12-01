import controller.UserController;
import model.AdminUser;
import model.StandardUser;
import model.UserRegister;
import service.UserService;
import view.AdminView;
import view.MainView;
import view.StandardView;
import model.User;

public class App {
    public static void main(String[] args) throws Exception {

        User user = new AdminUser("admin", "Administrador", "1234");
        User user2 =  new StandardUser("standar", "Standard", "1234");

        UserRegister register =  new UserRegister(user2);
        UserService service = new UserService(register);
        MainView mainView = new MainView();
        StandardView standardView = new StandardView();
        AdminView adminView = new AdminView();
        UserController controller = new UserController(service, adminView, standardView, mainView);

        controller.loginUser();
       
    }
}
