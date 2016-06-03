package de.holisticon.dw;

import com.google.gwt.thirdparty.guava.common.base.Objects;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Title("Main UI")
@Theme("valo")
public class MainUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        final VerticalLayout layout = new VerticalLayout();
        layout.setHeight(100f,Unit.PERCENTAGE);
        setContent(layout);

        Button button = new Button("click!", new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent clickEvent) {
                int count = (Integer) Objects.firstNonNull(getSession().getAttribute("count"), 0);
                getSession().setAttribute("count", ++count);
                layout.addComponent(new Label("clicked: " + count ));
            }
        });

        layout.addComponent(button);

    }

}
