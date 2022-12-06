import java.io.StringWriter;
import java.util.ArrayList;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.slf4j.*;

public class Main {
    public static void main(String[] args) throws Exception {

        // Get and initialize an engine
        VelocityEngine ve = new VelocityEngine();
        ve.init();

        // Get the Template
        Template t = ve.getTemplate("src/main/resources/hello.vm");

        //Hardcoding the task insertion since I couldn't figure out how exactly SAXParser works
        Task task1 = new Task("Bachelor's thesis", "Finish the application for the bachelor's thesis", "20-06-2023", Status.TODO);
        Task task2 = new Task("Learn how to play guitar", "Learn the basic chords in order to play the guitar", "24-12-2022", Status.IN_PROGRESS);
        Task task3 = new Task("Web Technologies project backend", "Finish the backend of the project", "20-12-2022", Status.TODO);
        Task task4 = new Task("Web Technologies project frontend", "Finish the frontend of the project", "10-01-2023", Status.TODO);
        Task task5 = new Task("Title 1", "Description 1", "20-12-2022", Status.DONE);
        Task task6 = new Task("Title 2", "Description 2", "20-12-2022", Status.DONE);
        Task task7 = new Task("Title 3", "Description 3", "20-12-2022", Status.DONE);
        Task task8 = new Task("Title 4", "Description 4", "20-12-2022", Status.DONE);
        Task task9 = new Task("Title 5", "Description 5", "20-12-2022", Status.DONE);
        Task task10 = new Task("Title 6", "Description 6", "20-12-2022", Status.DONE);



        // Create a context and add data
        VelocityContext context = new VelocityContext();
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
        tasks.add(task5);
        tasks.add(task6);
        tasks.add(task7);
        tasks.add(task8);
        tasks.add(task9);
        tasks.add(task10);
        context.put("tasks", tasks);


        // Render the template into a StringWriter
        StringWriter writer = new StringWriter();
        t.merge(context, writer);

        // Show the result
        System.out.println(writer.toString());
    }
}