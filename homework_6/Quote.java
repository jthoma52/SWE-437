import java.util.*;

/**
 * Quote data object.
 * @author Mongkoldech Rajapakdee & Jeff offutt
 *         Date: Nov 2009
 * A quote has two parts, an author and a quoteText.
 * This bean class provides getters and setters for both, plus a toString()
 */
public class Quote
{
   private String author;
   private String quoteText;
   private List<String> keywords;

   // Default constructor does nothing
   public Quote ()
   {
   		keywords = new ArrayList<String>();
   }
	
   public Quote(String author, String quoteText) {
		this.author = author;
		this.quoteText = quoteText;
		keywords = new ArrayList<String>();
   }
   // Constructor that assigns both strings
   public Quote (String author, String quoteText, List<String> keywords)
   {
      this.author = author;
      this.quoteText = quoteText;
	  if(keywords.size() > 5) {
	  	this.keywords = new ArrayList<String>();
	  	for(int i = 0; i <  5; i++) {
			this.keywords.add(keywords.get(i)); //only add up to 5 keywords
		}
	  } else {
	  	this.keywords = keywords;
	  }
   }

   // Getter and setter for author
   public String getAuthor ()
   {
      return author;
   }
   public void setAuthor (String author)
   {
      this.author = author;
   }

   // Getter and setter for quoteText
   public String getQuoteText ()
   {
      return quoteText;
   }
   public void setQuoteText (String quoteText)
   {
      this.quoteText = quoteText;
   }

   public List<String> getKeywords() {
		return keywords;
   }

   public void addKeyword(String keyword) {
		if(keywords.size() < 5)
			keywords.add(keyword);
   }


   @Override
   public String toString ()
   {
      return "Quote {" + "author='" + author + '\'' + ", quoteText='" + quoteText + '\'' + '}';
   }
}
