package org.howard.edu.lsp.finalexam.question2;

/**
 * Abstract report class using Template Method pattern.
 */
public abstract class Report {
    protected String header;
    protected String body;
    protected String footer;

    protected abstract void loadData();
    protected abstract void formatHeader();
    protected abstract void formatBody();
    protected abstract void formatFooter();

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