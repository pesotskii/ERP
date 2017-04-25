package erp.UI;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import erp.DAO.DAOImpl.UserDAOImpl;
import erp.DAO.UserDAO;
import erp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.annotation.WebServlet;

/**
 * Created by Dima on 25.04.2017.
 */
@Theme("valo")
public class RegistrationUI extends UI {
    @Autowired
    UserDAO userDAO = new UserDAOImpl();
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        final TextField firstName = new TextField();
        final TextField lastName = new TextField();
        final PasswordField passwordField = new PasswordField();
        firstName.setCaption("login");
        lastName.setCaption("lastName");
        passwordField.setCaption("password");
        Button buttonReg = new Button("Registration");
        buttonReg.addClickListener( e -> {
            User user = new User();
            user.setFirst_name(firstName.getValue());
            user.setLast_name(lastName.getValue());
            userDAO.addUser(user);
        });
        layout.addComponents(firstName,lastName,passwordField,buttonReg);
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/registration/*", name = "RegistrationUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = RegistrationUI.class, productionMode = false)
    public static class RegistrationUIServlet extends VaadinServlet {
    }
}
