import java.io.StringWriter;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

public class Main {
    public static void main( String[] args ) throws Exception {
        // Get and initialize an engine
        VelocityEngine ve = new VelocityEngine();
        ve.init();
        // Get the Template
        Template t = ve.getTemplate( "src/main/resources/hello.vm" );
        // Create a context and add data
        VelocityContext context = new VelocityContext();
        UserInfo user = new UserInfo("Emiiiiiii", "emiiiiiiii@student.com");
        context.put("user", user);
        // Render the template into a StringWriter
        StringWriter writer = new StringWriter();
        t.merge( context, writer );
        // Show the result
        System.out.println( writer.toString() );
    }
}

