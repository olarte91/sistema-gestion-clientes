import controller.UserController;
import model.UserRegister;
import model.UserReigsterImpl;
import service.UserService;
import view.MainView;

public class App {
    public static void main(String[] args) throws Exception {

        UserRegister register = new UserReigsterImpl();

        UserService service = new UserService(register);

        UserController controller = new UserController(service);

        MainView mainView = new MainView(controller);

        mainView.login();
    }
}
