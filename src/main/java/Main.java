import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.slf4j.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

//saxon
public class Main {
    public static void main( String[] args ) throws Exception {

        // Get and initialize an engine
        VelocityEngine ve = new VelocityEngine();
        ve.init();

        TaskHandler taskHandler = new TaskHandler();
        TaskList result = taskHandler.getList();

        //Initialize the XML parser
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            TaskHandler handler = new TaskHandler();
            saxParser.parse(new File("C:\\Users\\emi\\Desktop\\Faculta\\WebTechnologies\\Lab\\Assignment4_Templates\\Assignment4_Templates\\src\\main\\resources\\Task.xml"), handler);
            //Get Employees list
            List<Task> taskList = handler.getList().list;
            //print employee information
            for(Task task : taskList)
                System.out.println(task);






        // Get the Template
        Template t = ve.getTemplate( "src/main/resources/hello.vm" );
        Task task = new Task();

        // Create a context and add data
        VelocityContext context = new VelocityContext();
        ArrayList<Task> tasks = new ArrayList<>();

        for(Task task1: taskList){
            tasks.add(task1);
        }
        context.put("tasks", tasks);

        // Render the template into a StringWriter
        StringWriter writer = new StringWriter();
        t.merge( context, writer );

        // Show the result
        System.out.println( writer.toString() );
        } catch (ParserConfigurationException | SAXException | IOException e) {

            e.printStackTrace();
        }
    }
}

