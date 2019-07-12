import java.util.List;
import java.util.Map;


public class Main {

	public static void main(String[] args) {

		BookCollection bc = new BookCollection();
		//List<Book> foundBooks = bc.findBooks(book -> book.getTitle().toLowerCase().contains("men"));
		List<Book> foundBooks = bc.findBooksV2(book -> book.getTitle().toLowerCase().contains("men"));
		
		/*for (Book nextBook : foundBooks) {
			System.out.println (nextBook.getTitle() + " by " + nextBook.getAuthor());
		}*/
		
		foundBooks.forEach(System.out::println);
		
		System.out.println("---");
		Map<Integer,String> bookMap = bc.findBookTitles(book -> book.getTitle().toLowerCase().contains("men"));
		bookMap.forEach((k,v) -> System.out.println("k : " + k + " v : " + v));
		
		System.out.println("No of Matched Books : " + bc.getNoOfMatchedBooks(book -> book.getTitle().toLowerCase().contains("men")));
	}
}