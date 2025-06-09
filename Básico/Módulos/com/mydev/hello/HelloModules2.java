package hello;

import com.mydevel.hi.HiModules;
import static javax.xml.XMLConstants.XML_NS_PREFIX;

public class HelloModules2 {
    public static void main(String[] args) {
        System.out.println("Hello Modules!");
        System.out.println("The XML namespace prefix is: " + XML_NS_PREFIX);
        HiModules hiModules = new HiModules();
        System.out.println(hiModules.getHi());
    }
}