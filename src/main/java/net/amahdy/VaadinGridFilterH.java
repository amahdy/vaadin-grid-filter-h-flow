package net.amahdy;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;

@Tag("vaadin-grid-filter-h")
@HtmlImport("bower_components/vaadin-grid-filter-h/vaadin-grid-filter-h.html")
public class VaadinGridFilterH extends Component {

    public VaadinGridFilterH() {

    }

    public VaadinGridFilterH(String item, String filter) {
        setItem(item);
        setFilter(filter);
    }

    public void setItem(String item) {
        getElement().setAttribute("item", item);
    }

    public void setFilter(String filter) {
        getElement().setAttribute("filter", filter);
    }
}
