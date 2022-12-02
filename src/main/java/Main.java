import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.slf4j.*;

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
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        saxParser.parse("src/main/resources/Task.xml", taskHandler);

        List<Task> list = result.list;


        // Get the Template
        Template t = ve.getTemplate( "src/main/resources/hello.vm" );

        Task task = new Task();


        // Create a context and add data
        VelocityContext context = new VelocityContext();
        ArrayList<Task> tasks = new ArrayList<>();

        for(Task task1: list){
            tasks.add(task1);
        }
        context.put("tasks", tasks);





        // Render the template into a StringWriter
        StringWriter writer = new StringWriter();
        t.merge( context, writer );

        // Show the result
        System.out.println( writer.toString() );
    }
}

