import controller.UserController;
import model.AdminUser;
import model.StandardUser;
import model.UserRegister;
import service.UserService;
import view.MainView;
import model.User;

public class App {
    public static void main(String[] args) throws Exception {

        User user = new AdminUser("admin", "Administrador", "1234");
        User user2 =  new StandardUser("standar", "Standard", "1234");

        UserRegister register =  new UserRegister(user);
        UserService service = new UserService(register);
        UserController controller = new UserController(service);
        MainView view = new MainView(controller);

        view.login();

    }
}
