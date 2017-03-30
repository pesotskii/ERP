package erp.UI;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.annotation.EnableVaadin;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.context.annotation.Configuration;

import javax.servlet.annotation.WebServlet;

/**
 * Created by vkc on 30.03.2017.
 */

@Theme("mytheme")
@SpringUI
public class LoginUI extends UI {

    @Configuration
    @EnableVaadin
    public static class UIConfiguration{

    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        final TextField name = new TextField("Enter your name..");

        Button button = new Button("Click me");
        button.addClickListener( e -> {
            layout.addComponent(new Label("Thanks" + name.getValue()
                    + ", it works!"));
        });

        layout.addComponents(name,button);

        setContent(layout);
    }

    @WebServlet(urlPatterns = "/uitest", name = "StartUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = LoginUI.class, productionMode = false)
    public static class LoginUIServlet extends VaadinServlet{

    }
}
