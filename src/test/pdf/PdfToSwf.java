package test.pdf;

public class PdfToSwf {
  public static void  main(String[] args){
	  System.out.println("¿ªÊ¼...");
	  
	  String pdf = "D:\\E27DF55CA5701A7A5CB8FCA8336A98B97810.pdf";
	  String swf = "D:\\E27DF55CA5701A7A5CB8FCA8336A98B97810.swf";
	  pdftoswf(pdf, swf);
	  System.out.println("½áÊø...");
  }
  
  private static boolean pdftoswf(String pdf, String swf) {
		boolean flag = false;
		try {
			Process process = Runtime
					.getRuntime()
					.exec(
							"C:\\SWFTools\\pdf2swf.exe "
									+ pdf
									+ " "
									+ swf
									+ "  -f -T 9 -t -s zoom=200 -s bitmap -s languagedir=C:\\xpdf\\xpdf-chinese-simplified");
			System.out.println("C:\\SWFTools\\pdf2swf.exe "
					+ pdf
					+ " "
					+ swf
					+ "  -f -T 9 -t -s zoom=120  -s bitmap");
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return flag;
	}
}
