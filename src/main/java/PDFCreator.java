import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class PDFCreator{
    public PDFCreator(){}

    public void createPDF(Set<String> jezyki, Integer iloscSlow) throws IOException {
        try(PDDocument doc = new PDDocument())
        {
            PDPage page = new PDPage();
            doc.addPage(page);
            try(PDPageContentStream zawartosc = new PDPageContentStream(doc, page))
            {
                zawartosc.beginText();
                zawartosc.setFont(PDType1Font.TIMES_ROMAN, 12);
                zawartosc.setLeading(14.5f);
                zawartosc.newLineAtOffset(25, 700);
                zawartosc.showText("slowniki powiazane ze slowami: "+String.join(", ", jezyki));
                zawartosc.newLine();
                zawartosc.showText("ilosc slow: " + iloscSlow.toString());
                zawartosc.endText();
            }
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
            doc.save("src/main/PDFFiles/" + formatter.format(date) + ".pdf");
        }
    }

}
