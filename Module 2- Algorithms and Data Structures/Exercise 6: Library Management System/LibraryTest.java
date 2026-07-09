import java.util.Arrays;

public class LibraryTest {
    public static void main(String[] args) {
        Book[] library = {
            new Book("B01", "Java Programming", "James Gosling"),
            new Book("B02", "Clean Code", "Robert Martin"),
            new Book("B03", "Design Patterns", "Erich Gamma"),
            new Book("B04", "Algorithms", "Robert Sedgewick")
        };

        System.out.println("--- Linear Search Test ---");
        Book foundLinear = LibrarySearch.linearSearchByTitle(library, "Design Patterns");
        System.out.println("Result: " + foundLinear);

        Arrays.sort(library);

        System.out.println("\n--- Binary Search Test (Sorted Array) ---");
        Book foundBinary = LibrarySearch.binarySearchByTitle(library, "Design Patterns");
        System.out.println("Result: " + foundBinary);
    }
}
