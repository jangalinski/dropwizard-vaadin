package de.holisticon.dw;

import com.google.gwt.thirdparty.guava.common.base.Objects;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Title("Main UI")
@Theme("valo")
public class MainUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        final TextField counterField = new TextField("Counter", "N/A");
        counterField.setEnabled(false);

        Button incrementButton = new Button("Increment", new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent clickEvent) {
                int count = (Integer) Objects.firstNonNull(getSession().getAttribute("count"), 0);
                getSession().setAttribute("count", ++count);
                counterField.setValue(String.format("%d", count));
            }
        });

        VerticalLayout layout = new VerticalLayout();
        layout.setSpacing(true);
        layout.setMargin(true);
        layout.addComponent(counterField);
        layout.addComponent(incrementButton);
        setContent(layout);

    }

}
