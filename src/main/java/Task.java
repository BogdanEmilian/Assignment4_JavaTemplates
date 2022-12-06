public class Task {

    public String title;
    public String description;
    public String dueDate;
    public Status status;

    public Task(){
        this.title = "Dummy title";
        this.description = "Dummy description";
        this.dueDate = "01/01/2000";
        this.status = Status.TODO;
    }

    public Task(String title, String description, String dueDate, Status status){
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}