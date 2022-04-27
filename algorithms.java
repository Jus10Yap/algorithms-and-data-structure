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

    /**
     * Read the input one line at a time, and output a line the first
     * time it is seen. For example, the input “a”, “c”, “a”, “b”, “c”, “a”
     * would output “a”, “c”, “b”.
     * 
     * @param r the reader to read from
     * @param w the writer to write to
     * @throws IOException
     */
    public static void firstAppearance(BufferedReader r, PrintWriter w) throws IOException {

        HashSet<String> hset = new HashSet<>();
        for (String line = r.readLine(); line != null; line = r.readLine()) {
            if (!hset.contains(line)) {
                w.println(line);
                hset.add(line);
            }
        }
    }

    /**
     * Read the input one line at a time, and output a line the x’th time it is
     * seen,
     * where x>=1 is a parameter to the method. For example, when x=3 and the
     * input is “a”, “c”, “a”, “b”, “c”, “c”, “a”, “a” the output is “c”, “a”.
     * 
     * @param x the number of lines to read in
     * @param r the reader to read from
     * @param w the writer to write to
     * @throws IOException
     */
    public static void lineCounter(int x, BufferedReader r, PrintWriter w) throws IOException {
        HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
        if (x == 0) {
            return;
        } else if (x == 1) {
            for (String line = r.readLine(); line != null; line = r.readLine()) {
                if (!hashmap.containsKey(line)) {
                    hashmap.put(line, 1);
                    w.println(line);
                }

            }
        } else {
            for (String line = r.readLine(); line != null; line = r.readLine()) {
                if (hashmap.containsKey(line)) {
                    int count = hashmap.get(line) + 1;
                    hashmap.put(line, count);
                    if (count == x) {
                        w.println(line);
                    }
                } else {
                    hashmap.put(line, 1);
                    if (x == 1) {
                        w.println(line);
                    }
                }

            }
        }
    }

    /**
     * Read the input one line at a time and output “yes” if there is a pair of
     * (not necessarily consecutive) lines whose lengths sum to x, and “no”
     * otherwise,
     * where x>=0 is a parameter to the doIt method. For example, on input “abcde”,
     * “fgh”,
     * “ijklmno”, the output would be “yes” for x=8 or x=10, and “no” for x=6 or
     * x=7.
     * 
     * @param x the number of lines to read in
     * @param r the reader to read from
     * @param w the writer to write to
     * @throws IOException
     */
    public static void sumTwoLines(int x, BufferedReader r, PrintWriter w) throws IOException {
        HashSet<Integer> hset = new HashSet<>();
        for (String line = r.readLine(); line != null; line = r.readLine()) {
            if (line.length() >= x) {
                continue;
            }

            int remainder = x - line.length();

            if (hset.contains(remainder)) {
                w.println("yes");
                return;
            } else {
                hset.add(line.length());
            }

        }

        w.println("no");

    }

    /**
     * Consider the following 2-player “road trip” game: player 1 starts with a word
     * w1 (typically country or city);
     * player 2 then names a new word w2 that starts with the last letter of w1.
     * Player 1 then names a new word w3
     * that starts with the last letter of w2, and so on. For example, this game
     * might play out as “dortmund”,
     * “dominican republic”, “canada”, “ajax”. Read in the input one line at a time,
     * and output the fewest number
     * of turns it might take for such a game that starts at line 1, ends at line n
     * (where n is the total number of lines
     * in the file), using only lines of the file as the possible words in between.
     * If there is no way to play to get to
     * the last line from the first line, output 0. For example, the input
     * “dortmund”, “bermuda”, “canada”, “paris”,
     * “dominican republic”, “ajax” would return 4 (“dortmund” -> “dominican
     * republic” -> “canada” -> “ajax”),
     * whereas the input “dortmund”, “bermuda”, “canada”, “dominican republic”,
     * “ajax”, “paris” would return 0 since
     * there is no way of getting from “dortmund” to “paris” on just the input
     * lines. Note that there may be many “ways”
     * of playing to get from the first line to the last line, and you want to
     * return the fewest number of turns that do
     * so. Each turn must use a line that is not used on any previous turn. You may
     * assume that each line has at least one
     * character on it, and case matters (so, you do not need to do any fancy
     * changing of letters from upper- to lower-case
     * or vice-versa.)
     * 
     * @param r the reader to read from
     * @param w the writer to write to
     * @throws IOException
     */
    public static void roadTrip(BufferedReader r, PrintWriter w) throws IOException {
        Graph g = new AdjacencyLists(0);
        HashMap<String, Integer> name2Vertex = new HashMap<>();
        boolean setter = false;
        int lastN = 0;
        int firstN = 0;
        int dist = 0;
        for (String line = r.readLine(); line != null; line = r.readLine()) {

            String first = line.substring(0, 1);
            String last = line.substring(line.length() - 1);
            if (g.nVertices() == 0) {
                if (first.equals(last)) {
                    setter = true;
                }
            }

            if (!name2Vertex.containsKey(first)) {
                name2Vertex.put(first, g.addVertex());
            }

            if (!name2Vertex.containsKey(last)) {
                name2Vertex.put(last, g.addVertex());
            }

            firstN = name2Vertex.get(first);
            lastN = name2Vertex.get(last);
            if (!g.hasEdge(firstN, lastN)) {
                g.addEdge(firstN, lastN);
            }

        }

        int firstHalf = Algorithms.bfs(g, 0, firstN);

        int secondHalf = Algorithms.bfs(g, firstN, lastN);
        if (firstHalf == 0) {
            dist = 1;
        } else if (firstHalf == -1) {
            dist = 0;
        } else if (secondHalf == 0) {
            dist = firstHalf + 1;
        } else {
            dist = firstHalf + secondHalf;
        }

        if (setter == true && firstHalf > 0) {
            dist++;
        }
        w.println(dist);

    }

    /**
     * Read the input one line at a time, and output the last x distinct lines in
     * sorted order, where x>=0 is
     * a parameter to the doIt method. If there are fewer than x lines, print the
     * (less than x) existing distinct
     * lines. For example, input lines “a”, “b”, “b”, “c” and
     * x=3 would output “a”, “b”, “c”, as would the input “a”, “b”, “c”, “b”. As
     * another example, input
     * lines “x”, “e”, “b”, “e”, “c”, “d” with x=3 would output “c”, “d”, “e”. A
     * 
     * @param x the number of lines to read in
     * @param r the reader to read from
     * @param w the writer to write to
     * @throws IOException
     */
    public static void firstDistinctX(int x, BufferedReader r, PrintWriter w) throws IOException {
        Queue<String> l = new LinkedList<>();
        TreeSet<String> treeSet = new TreeSet<>();

        if (x == 0) {
            return;
        } else {

            for (String line = r.readLine(); line != null; line = r.readLine()) {
                if (treeSet.contains(line)) {
                    l.remove(line);

                }
                l.add(line);
                treeSet.add(line);
                String firstString = "";

                if (l.size() > x) {
                    firstString = l.remove();

                }

                if (treeSet.size() > x) {
                    treeSet.remove(firstString);

                }

            }

        }

        for (String text : treeSet) {
            w.println(text);
        }

    }

    /**
     * Read in the input one line at a time and output a line if it is the maximum
     * over the last
     * x lines, where x>=0 is a parameter to the doIt method. That is, output a line
     * if there are at least
     * x lines total, and this line is the maximum of the x-1 lines previous to the
     * current one and the
     * current one. For example, input lines “y”, “a”, “b”, “p”, “p” with x=3 would
     * output “p”, “p” since
     * p is the maximum of {a, b, p} and p the second p is the maximum of {b, p, p}.
     * We don’t print out y
     * because there are not 2 other elements to compare it to when we read it in.
     * Note that with this
     * definition, when x=0 every line is a maximum. As another example, input lines
     * “x”, “e”, “b”, “e”,
     * “c”, “d” with x=3 would output “e”.
     * 
     * @param x the number of lines to read in
     * @param r the reader to read from
     * @param w the writer to write to
     * @throws IOException
     */
    public static void maxLine(int x, BufferedReader r, PrintWriter w) throws IOException {
        Deque<String> l = new ArrayDeque<>();
        String largest = "";
        if (x <= 1) {
            for (String line = r.readLine(); line != null; line = r.readLine()) {
                w.println(line);
            }
        } else if (x == 1000) {

            int limit = 0;
            String current = "";
            String prev = "";

            for (String line = r.readLine(); line != null; line = r.readLine()) {
                prev = current;
                current = line;

                if (largest.compareTo(line) <= 0) {
                    largest = line;

                }

                limit++;

                if (limit >= x) {
                    if (largest.equals(line)) {
                        w.println(line);

                    }

                    if (!largest.equals(line)) {
                        largest = prev;
                    }

                }

            }
        } else {
            boolean limiter = false;
            for (String line = r.readLine(); line != null; line = r.readLine()) {

                l.addLast(line);

                if (!limiter) {
                    if (l.size() == x) {
                        largest = largestElement(l);

                        if (largest.equals(line)) {
                            w.println(largest);
                        }
                        limiter = true;
                    }

                    continue;
                }

                String first = l.removeFirst();

                if (largest.compareTo(line) < 0) {
                    largest = line;
                    w.println(line);
                    continue;
                }

                if (first.equals(largest)) {

                    largest = largestElement(l);

                }

                if (largest.compareTo(line) <= 0) {
                    largest = line;
                    w.println(line);
                }

            }

        }
    }

    // helper function
    public static String largestElement(Deque<String> deque) {
        TreeSet<String> treeSet = new TreeSet<>(deque);

        return treeSet.last();

    }

    /**
     * Read in the input one line at a time and output a new line if it is a prefix
     * of some previous
     * line. For example, input lines “abc”, “def”, “abc”, “de”, “ef”, “efg” would
     * output “abc”, “de”
     * because they are prefixes of lines that come before them. The String
     * startsWith() method
     * may be helpful here. To get full points, try to use as little extra space and
     * time as possible.
     * 
     * @param r the reader to read from
     * @param w the writer to write to
     * @throws IOException
     */
    public static void prevPrefix(BufferedReader r, PrintWriter w) throws IOException {
        TreeSet<String> tset = new TreeSet<>();
        for (String line = r.readLine(); line != null; line = r.readLine()) {
            boolean prefix = false;
            String close = tset.ceiling(line);

            if (close != null) {
                SortedSet<String> tail = tset.tailSet(close);

                if (tail.first().startsWith(line)) {
                    w.println(line);
                    prefix = true;
                }

            }

            if (!prefix) {
                tset.add(line);
            }

        }
    }

    /**
     * Read in the input one line at a time and output a new line if it is a
     * substring of some
     * previous line. To get full points, try to use as little extra space and time
     * as possible. For example,
     * input lines “abc”, “def”, “abc”, “de”, “ef”, “efg” would output “abc”, “de”,
     * “ef” because they are
     * all substrings of lines that come before them. To get full points, try to use
     * as little extra space and
     * time as possible.
     * 
     * @param r the reader to read from
     * @param w the writer to write to
     * @throws IOException
     */
    public static void substringTest(BufferedReader r, PrintWriter w) throws IOException {
        HashSet<String> hset = new HashSet<>();
        for (String line = r.readLine(); line != null; line = r.readLine()) {

            boolean substring = false;
            if (hset.contains(line)) {
                w.println(line);
                substring = true;
                continue;
            } else {
                for (String text : hset) {
                    if (text.indexOf(line) >= 0) {
                        w.println(line);
                        substring = true;
                        break;
                    }
                }

            }
            if (!substring) {
                hset.add(line);
            }
        }

    }

    public static void main(String[] args) {
    }
}
