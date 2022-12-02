import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class TaskHandler extends DefaultHandler {
    public static final String TASKS = "tasks";
    public static final String TASK = "task";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String DUEDATE = "due date";
    public static final String STATUS = "status";

    private TaskList taskList = new TaskList();
    private StringBuilder elementValue;
    private Status statusElement;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (elementValue == null) {
            elementValue = new StringBuilder();
        } else {
            elementValue.append(ch, start, length);
        }
    }

    @Override
    public void startDocument() throws SAXException {
        taskList = new TaskList();
    }

    @Override
    public void startElement(String uri, String lName, String qName, Attributes attr) throws SAXException {
        switch (qName) {
            case TASKS:
                taskList.list = new ArrayList<>();
                break;
            case TASK:
                taskList.list.add(new Task());
                break;
            case TITLE:
                elementValue = new StringBuilder();
                break;
            case DESCRIPTION:
                elementValue = new StringBuilder();
                break;
            case DUEDATE:
                elementValue = new StringBuilder();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case TITLE:
                latestTask().setTitle(elementValue.toString());
                break;
            case DESCRIPTION:
                latestTask().setDescription(elementValue.toString());
                break;
            case DUEDATE:
                latestTask().setDueDate(elementValue.toString());
                break;
            case STATUS:
                latestTask().setStatus(statusElement);
                break;
        }
    }

    private Task latestTask() {
        List<Task> taskList1 = taskList.list;
        int latestTaskIndex = taskList1.size() - 1;
        return taskList1.get(latestTaskIndex);
    }

    public TaskList getList() {
        return taskList;
    }
}
