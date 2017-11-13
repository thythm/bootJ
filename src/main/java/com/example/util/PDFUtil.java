package com.example.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author majunjie
 * @description 操作pdf
 * @date 2017/11/10 15:18
 */
public class PDFUtil {

    static Font font;

    public static final String SRC = "C:\\Users\\PC\\Desktop\\pdf\\helloWorld.pdf";
    public static final String DEST = "C:\\Users\\PC\\Desktop\\pdf\\hello_highlighted.pdf";
    public static final String img = "C:\\Users\\PC\\Desktop\\123.jpg";

    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        manipulatePdf(SRC, DEST);

//        generatePDF();
    }

    public static void manipulatePdf(String src, String dest) throws Exception {
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        PdfContentByte canvas = stamper.getOverContent(1);

        Image image = Image.getInstance(img);

        image.setAbsolutePosition(50, 50);

        canvas.addImage(image);

        /*canvas.saveState();
        canvas.setColorFill(BaseColor.YELLOW);
        //左顶点，宽度、高度
        canvas.rectangle(36, 758, 66, 16);
        canvas.fill();
        canvas.restoreState();
        //开始写入文本
        canvas.beginText();
        //设置字体和大小
        canvas.setFontAndSize(font.getBaseFont(), 10);
        //设置字体的输出位置
        canvas.setTextMatrix(36, 758);
        //要输出的text
        canvas.showText("多退少补" );*/

        stamper.close();
        reader.close();
    }

    public static void generatePDF(){
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\PC\\Desktop\\pdf\\HelloWorld.pdf"));
            document.open();
            document.add(new Paragraph("test"));
            document.add(new Paragraph("甲方：比尔盖茨", font));
            document.add(new Paragraph("乙方：乔布斯", font));
            document.add(new Paragraph("手机：13777844021", font));
            document.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static {
        BaseFont bfChinese = null;
        try {
            bfChinese = BaseFont.createFont("STSongStd-Light",
                    "UniGB-UCS2-H", false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        font = new Font(bfChinese, 10, Font.NORMAL);
    }

}
