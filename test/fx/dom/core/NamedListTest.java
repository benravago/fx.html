package fx.dom.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NamedListTest {
    
    @Test
    void append() {
        var l = new NamedItemList();
        var a = list(5);
        for (var i = 0; i < a.length; i++) {
            l.insert(l.size,a[i]);
        }
        check(l,"A","B","C","D","E");
    }
    
    @Test
    void insert() {
        var l = new NamedItemList();
        var a = list(5);
        for (var i = 0; i < a.length; i++) {
            l.insert(0,a[i]);
        }
        check(l,"E","D","C","B","A");
    }

    @Test
    void remove() {
        var l = new NamedItemList();
        var a = list(5);
        for (var i = 0; i < a.length; i++) {
            l.insert(i,a[i]);
        }

        var b = l.item(1);
        NamedItemList.unlink(b);
        
        var d = l.namedItem("D");
        NamedItemList.unlink(d);                
        
        check(l,"A","C","E");
    }
    
    @Test
    void inject() {
        var l = new NamedItemList();
        var a = list(5);

        l.insert(0,a[0]);
        l.insert(1,a[2]);
        l.insert(2,a[4]);

        l.insert(1,a[1]);
        l.insert(3,a[3]);

        check(l,"A","B","C","D","E");
    }    
    
    @Test
    void replace() {
        var l = new NamedItemList();
        var a = list(5);
        for (var i = 0; i < a.length; i++) {
            l.insert(i,a[i]);
        }
        
        var b = l.item(1);
        NamedItemList.replace(new Named("bx"), b);
        
        var d = l.namedItem("D");
        NamedItemList.replace(new Named("dx"), d);                
        
        check(l,"A","bx","C","dx","E");
    }

    @Test
    void extend() {
        var l = new NamedItemList();
        var a = list(26);
        for (var i = 0; i < a.length; i++) {
            l.insert(i,a[i]);
        }
        check(l,"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
    }

    @Test
    void expand() {
        var l = new NamedItemList();
        var a = list(26);
        for (var i = 0; i < a.length; i++) {
           l.insert(0,a[i]);
        }
        check(l,"Z","Y","X","W","V","U","T","S","R","Q","P","O","N","M","L","K","J","I","H","G","F","E","D","C","B","A");
    }

    
    NamedItem[] list(int n) {
        var a = new NamedItem[n]; 
        for (var i = 0; i < n; i++) {
            a[i] = new Named(""+(char)('A'+i));
        }
        return a;
    }    

    void check(NamedItemList a, String...b) {
        assertEquals(a.getLength(),b.length);
        for (var i = 0; i < b.length; i++) {
            assertEquals(a.item(i).nodeName,b[i]);
        }
    }

}