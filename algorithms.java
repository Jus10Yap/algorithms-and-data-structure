import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class algorithms {

    /*
     * Read the input one line at a time and output every x’th line,
     * starting with line 0, where x>0 is a parameter to the everyX method.
     * 
     * @param x the number of lines to read in
     * 
     * @param r the reader to read from
     * 
     * @param w the writer to write to
     * 
     * @throws IOException
     */
    public static void everyX(int x, BufferedReader r, PrintWriter w) throws IOException {

        int count = 0;
        for (String line = r.readLine(); line != null; line = r.readLine(), count++) {
            if (count % x == 0) {
                w.println(line);
            }

        }

    }

    /**
     * Read the input one line at a time and
     * output every x’th line from the end,
     * starting with the last line, where x>0
     * is a parameter to the everyXEnd method.
     * 
     * @param x the number of lines to read in
     * @param r the reader to read from
     * @param w the writer to write to
     * @throws IOException
     */
    public static void everyXEnd(int x, BufferedReader r, PrintWriter w) throws IOException {
        ArrayList<String> l = new ArrayList<>();

        for (String line = r.readLine(); line != null; line = r.readLine()) {
            l.add(line);

        }
        int count = 0;
        for (int i = l.size() - 1; i >= 0; i--, count++) {
            if (count % x == 0) {
                w.println(l.get(i));
            }

        }
    }

    /**
     * Read the input one line at a time, and output
     * the last x lines in reverse order, where x>=0
     * is a parameter to the lastX method. If there are
     * fewer than x lines, print the n < x existing
     * lines in reverse. (The lines themselves are
     * forwards, their order is reversed.)
     * 
     * @param x the number of lines to read in
     * @param r the reader to read from
     * @param w the writer to write to
     * @throws IOException
     */
    public static void lastX(int x, BufferedReader r, PrintWriter w) throws IOException {
        Deque<String> l = new ArrayDeque<>();
        if (x == 0) {
            w.print("");
        } else {
            int limit = 0;
            for (String line = r.readLine(); line != null; line = r.readLine()) {
                if (limit == (x)) {
                    l.removeLast();
                    limit--;
                }
                l.addFirst(line);
                limit++;
            }

            Iterator<String> i = l.iterator();
            while (i.hasNext()) {
                w.println(i.next());
            }
        }

    }

    public static void main(String[] args) {
    }
}