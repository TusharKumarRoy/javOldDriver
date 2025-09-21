
import java.util.ArrayList;
import java.util.List;

interface CourseComponent {
    void showDetails();
}

class Lesson implements CourseComponent {
    private String title;
    private String instructorName;


    public Lesson(String title){
        this.title = title;
    }
    
    @Override
    public void showDetails(){
        System.out.println("Lesson : Title : " + title);
    }
}

class CourseModule implements CourseComponent {
    private String moduleName;
    private List<CourseComponent> components = new ArrayList<>();
    public CourseModule(String moduleName) {
        this.moduleName = moduleName;
    }

    public void addComponent(CourseComponent component) {
        components.add(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Module: " + moduleName);
        for (CourseComponent component : components) {
            component.showDetails();
        }
    }
}


public class Main {
    public static void main(String[] args) {
        // Lessons
        Lesson l1 = new Lesson("Intro to Java");
        Lesson l2 = new Lesson("OOP Concepts");

        // Main module
        CourseModule module = new CourseModule("Java Basics");
        module.addComponent(l1);
        module.addComponent(l2);

        // Sub-module with its own lesson
        CourseModule subModule = new CourseModule("Advanced Topics");
        subModule.addComponent(new Lesson("Generics"));

        // Add sub-module to main module
        module.addComponent(subModule);

        // Display everything
        module.showDetails();
    }
}