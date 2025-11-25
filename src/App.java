import controller.UserController;
import model.AdminUser;
import model.UserRegister;
import service.UserService;
import view.MainView;
import model.User;

public class App {
    public static void main(String[] args) throws Exception {

        User user = new AdminUser("username", "nombre", "1234");

        UserRegister register =  new UserRegister();
        UserService service = new UserService(user, register);
        UserController controller = new UserController(service);
        MainView view = new MainView(controller);

        view.createUser();

    }
}
