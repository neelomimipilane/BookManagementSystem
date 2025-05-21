public class Book {
        private String isbn;
        private String title;
        private String author;
        private String genre;
        private double price;
        private int quantity;

        public Book(String isbn, String title, String author, String genre, double price, int quantity) {
            this.isbn = isbn;
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.price = price;
            this.quantity = quantity;
        }

        // Getters
        public String getIsbn() { return isbn; }
        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        public String getGenre() { return genre; }
        public double getPrice() { return price; }
        public int getQuantity() { return quantity; }

        // Setters
        public void setQuantity(int quantity) { this.quantity = quantity; }

        @Override
        public String toString() {
            return isbn + "," + title + "," + author + "," + genre + "," + price + "," + quantity;
        }

        public static Book fromString(String data) {
            String[] parts = data.split(",");
            return new Book(
                    parts[0], // isbn
                    parts[1], // title
                    parts[2], // author
                    parts[3], // genre
                    Double.parseDouble(parts[4]), // price
                    Integer.parseInt(parts[5]) // quantity
            );
        }
    }

