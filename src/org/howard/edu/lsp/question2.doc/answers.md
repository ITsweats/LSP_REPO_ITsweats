## Java Code

### Report.java
```java
package org.howard.edu.lsp.finalexam.question2;

/**
 * Abstract report class using the Template Method pattern.
 */
public abstract class Report {
    protected String header;
    protected String body;
    protected String footer;

    /**
     * Loads report-specific data.
     */
    protected abstract void loadData();

    /**
     * Formats the report header.
     */
    protected abstract void formatHeader();

    /**
     * Formats the report body.
     */
    protected abstract void formatBody();

    /**
     * Formats the report footer.
     */
    protected abstract void formatFooter();

    /**
     * Template method that defines the fixed report generation workflow.
     */
    public final void generateReport() {
        loadData();
        formatHeader();
        formatBody();
        formatFooter();

        System.out.println("=== HEADER ===");
        System.out.println(header);
        System.out.println();

        System.out.println("=== BODY ===");
        System.out.println(body);
        System.out.println();

        System.out.println("=== FOOTER ===");
        System.out.println(footer);
        System.out.println();
    }
}


Design explanation:
The Template Method pattern is used in the Report class through the final generateReport() method. This method defines the fixed workflow: loadData(), formatHeader(), formatBody(), and formatFooter(). The subclasses StudentReport and CourseReport provide their own implementations of those steps. The driver demonstrates polymorphism by storing both reports in a List<Report> and calling generateReport() on each object.
