package design_patterns.b_structural.bridge;

import design_patterns.b_structural.bridge.a.Movie;
import design_patterns.b_structural.bridge.b.Formatter;
import design_patterns.b_structural.bridge.b.Printer;
import design_patterns.b_structural.bridge.c.HtmlFormatter;
import design_patterns.b_structural.bridge.c.MoviePrinter;
import design_patterns.b_structural.bridge.c.PrintFormatter;

public class Main {

    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setClassification("Action");
        movie.setTitle("John Wick");
        movie.setRuntime("2:15");
        movie.setYear("2014");

        Printer moviePrinter = new MoviePrinter(movie);

        Formatter printFormatter = new PrintFormatter();
        System.out.println(moviePrinter.print(printFormatter));


        Formatter htmlFormatter = new HtmlFormatter();
        System.out.println(moviePrinter.print(htmlFormatter));
    }


}
