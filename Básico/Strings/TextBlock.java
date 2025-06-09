public class TextBlock {

	public static void main(String[] args) {
		
		String html = """
            <html>
                <body>
                    <span>example text</span>
                </body>
            </html>""";
			
		String escape = """
            "fun" with
            whitespace
            and other escapes \"""
            """;
		
		String ignoreNewLine = """
            This is a long test which looks to \
            have a newline but actually does not""";
			
		String escapeSpaces = """
            line 1       
            line 2       \s
            """;
			
		System.out.println(html);
		System.out.println(escape);
		System.out.println(ignoreNewLine);
		System.out.println(escapeSpaces);
	}

}