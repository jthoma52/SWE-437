package quotes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class QuoteWriter {

	public static boolean write(String fileName, QuoteList list) {
		
		try {
			File quoteFile = new File(fileName);
			FileOutputStream is = new FileOutputStream(quoteFile);
			OutputStreamWriter osw = new OutputStreamWriter(is);
			Writer w = new BufferedWriter(osw);
			w.write("<?xml version=\"1.0\"?>\n");
			w.write("<quote-list>\n");

			for(int i = 0; i < list.getSize(); i++) {
				Quote q = list.getQuote(i);
				w.write("   <quote>\n");
				w.write("      <quote-text>" + q.getQuoteText() + "</quote-text>\n");
				w.write("      <author>" + q.getAuthor() + "</author>\n");
				w.write("   </quote>\n");
			}
			w.write("</quote-list>\n");
			w.close();
		} catch (Exception e) {
			System.out.println("Something went wrong");
		}

		return false;
	}

}
