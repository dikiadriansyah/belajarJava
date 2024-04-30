public class Enum_with_name_at_begining {

    public enum BookCode {
        _10A("Simon Haykin", "Communication System"), _42B("Stefan Hakins",
                "A Brief History of Time"), E1("Sedra Smith", "Electronics Circuits");

        private String author;
        private String title;

        BookCode(String author, String title) {
            this.author = author;
            this.title = title;
        }

        public String getName() {
            String name = name();
            if (name.charAt(0) == '_') {
                name = name.substring(1, name.length());
            }
            return name;
        }

        public static BookCode of(String code) {
            if (Character.isDigit(code.charAt(0))) {
                code = "_" + code;
            }
            return BookCode.valueOf(code);
        }
    }

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // Display information for each BookCode
        for (BookCode bookCode : BookCode.values()) {
            System.out.println("Code: " + bookCode.getName());
            System.out.println("Author: " + bookCode.author);
            System.out.println("Title: " + bookCode.title);
            System.out.println();
        }

        /*
         * output:
         * Code: 10A
         * Author: Simon Haykin
         * Title: Communication System
         * 
         * Code: 42B
         * Author: Stefan Hakins
         * Title: A Brief History of Time
         * 
         * Code: E1
         * Author: Sedra Smith
         * Title: Electronics Circuits
         */

        // Example of using the 'of' method
        String codeToFind = "10A";
        BookCode foundBook = BookCode.of(codeToFind);
        System.out.println("Book found using code '" + codeToFind + "':");
        System.out.println("Author: " + foundBook.author);
        System.out.println("Title: " + foundBook.title);

        /*
         * output:
         * 
         * Book found using code '10A':
         * Author: Simon Haykin
         * Title: Communication System
         * 
         */

    }
}
