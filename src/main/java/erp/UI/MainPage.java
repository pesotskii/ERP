package erp.UI;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import erp.DAO.DAOImpl.UserDAOImpl;
import erp.DAO.UserDAO;
import erp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.annotation.WebServlet;

/**
 * Created by Dima on 25.04.2017.
 */
public class MainPage extends UI {
    @Autowired
    UserDAO userDAO = new UserDAOImpl();
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        ComboBox userComboBox = new ComboBox("Users");
        ComboBox roleComboBox = new ComboBox("Roles");
        ComboBox ResourcesComboBox = new ComboBox("Resources");
        ComboBox Project_participantsComboBox = new ComboBox("Project participants");
        ComboBox ProjectComboBox = new ComboBox("Projects");
        ComboBox DepartmentComboBox = new ComboBox("Departments");
        userComboBox.setData("123345");
        setSizeFull();
        layout.addComponents(userComboBox,roleComboBox,ResourcesComboBox,
                ProjectComboBox,Project_participantsComboBox,DepartmentComboBox);
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/mainPage", name = "MainPageUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MainPage.class, productionMode = false)
    public static class MainPageServlet extends VaadinServlet {
    }
}
