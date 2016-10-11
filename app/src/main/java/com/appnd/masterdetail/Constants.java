package com.appnd.masterdetail;

import com.appnd.masterdetail.model.BookItem;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Class which contains constant static values which can be used across all the classes.
 */
public class Constants {
    public static final String PACKAGE_NAME = "com.appnd.masterdetail";
    public static final String DATE_FORMAT = "dd/MM/yyyy";

    //Sample list of items used to fill listview in exercise 1
    public static final List<String> items = Arrays.asList("Item 1", "Item 2", "Item 3", "Item 4");

    //Sample list of items used to fill RecyclerView in exercise 2
    public static final List<BookItem> bookItems = Arrays.asList(
            new BookItem(0, "Title1", "Author1", new Date(1475698490), "Description", "http://novalibros.com/wp-content/uploads/2015/06/novela-el-juego-de-ender.jpg"),
            new BookItem(1, "Title2", "Author2", new Date(1470602012), "Description", "http://www.rosaspage.com/im/feliz.jpg"));
}
