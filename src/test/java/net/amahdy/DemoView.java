package net.amahdy;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.HeaderRow;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.function.ValueProvider;
import com.vaadin.flow.router.Route;

import org.apache.commons.lang3.StringUtils;

@Route("")
public class DemoView extends Div {

    List<Person> createItems() {
        ArrayList<Person> items = new ArrayList<>();
        items.add(new Person("Isabella", "Martin"));
        items.add(new Person("Alex", "John"));
        items.add(new Person("Alice", "Martinez"));
        items.add(new Person("Sandy", "Joe"));
        items.add(new Person("Fredu", "Ronn"));
        items.add(new Person("Marcus", "Helberg"));
        items.add(new Person("Miki", "Jobs"));
        items.add(new Person("Alice", "Wonderland"));
        items.add(new Person("Sara", "Alan"));
        items.add(new Person("Adam", "Adam"));
        return items;
    }

    public DemoView() {
        Grid<Person> grid = new Grid<>();
        ListDataProvider<Person> dataProvider = new ListDataProvider<>(createItems());
        grid.setDataProvider(dataProvider);

        List<ValueProvider<Person, String>> valueProviders = new ArrayList<>();
        valueProviders.add(0, Person::getFirstName);
        valueProviders.add(1, Person::getLastName);

        TextField fnFilter = new TextField();
        fnFilter.setSizeFull();
        fnFilter.setPlaceholder("First Name Filter");
        fnFilter.setValueChangeMode(ValueChangeMode.EAGER);
        fnFilter.addValueChangeListener(event -> {
            dataProvider.addFilter(person -> StringUtils.containsIgnoreCase(
                valueProviders.get(0).apply(person), fnFilter.getValue()));
        });
        TextField lnFilter = new TextField();
        lnFilter.setSizeFull();
        lnFilter.setPlaceholder("Last Name Filter");
        lnFilter.setValueChangeMode(ValueChangeMode.EAGER);
        lnFilter.addValueChangeListener(event -> {
            dataProvider.addFilter(person -> StringUtils.containsIgnoreCase(
                valueProviders.get(1).apply(person), lnFilter.getValue()));
        });

        grid.addColumn(new ComponentRenderer<>(VaadinGridFilterH::new,
            (highlighter, person) -> {
                highlighter.setItem(person.getFirstName());
                highlighter.setFilter(fnFilter.getValue());
            })).setKey("fn");
        grid.addColumn(new ComponentRenderer<>(VaadinGridFilterH::new,
            (highlighter, person) -> {
                highlighter.setItem(person.getLastName());
                highlighter.setFilter(lnFilter.getValue());
            })).setKey("ln");

        HeaderRow filterRow = grid.appendHeaderRow();
        filterRow.getCell(grid.getColumnByKey("fn")).setComponent(fnFilter);
        filterRow.getCell(grid.getColumnByKey("ln")).setComponent(lnFilter);

        add(grid);
    }
}
