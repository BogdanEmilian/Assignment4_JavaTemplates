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

        Task task = new Task();


        // Create a context and add data
        VelocityContext context = new VelocityContext();
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(task);
        context.put("tasks", tasks);


        // Render the template into a StringWriter
        StringWriter writer = new StringWriter();
        t.merge(context, writer);

        // Show the result
        System.out.println(writer.toString());
    }
}