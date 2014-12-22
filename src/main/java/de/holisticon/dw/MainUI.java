package de.holisticon.dw;

import com.google.gwt.thirdparty.guava.common.base.Objects;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.*;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by jangalinski on 21.12.14.
 */
@Title("Main UI")
@Theme("valo")
public class MainUI extends UI {

    private final Logger logger = getLogger(this.getClass());

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setHeight(100f,Unit.PERCENTAGE);
        setContent(layout);

        Button button = new Button("click!", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                int count = (int) Objects.firstNonNull(getSession().getAttribute("count"), 0);
                getSession().setAttribute("count", ++count);

                layout.addComponent(new Label("clicked: " + count ));
            }
        });

        layout.addComponent(button);
    }
}
