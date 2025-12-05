import controller.UserController;
import model.UserRegister;
import service.UserService;
import util.UserType;
import view.AdminView;
import view.MainView;
import view.StandardView;
import model.User;

public class App {
    public static void main(String[] args) throws Exception {

        User user = new User("admin", "Administrador", "1234", UserType.ADMIN);
        User user2 =  new User("standar", "Standard", "1234", UserType.STANDARD);

        UserRegister register =  new UserRegister(user);
        UserService service = new UserService(register);
        MainView mainView = new MainView();
        StandardView standardView = new StandardView();
        AdminView adminView = new AdminView();
        UserController controller = new UserController(service, adminView, standardView, mainView);

        controller.loginUser();
       
    }
}
