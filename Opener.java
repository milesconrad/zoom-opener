import java.awt.Desktop;
import java.net.URI;

class Opener {
    public void advisory(){
        try {
            URI url0 = new URI("https://oneoakland.webex.com/meet/chisnell");
            Desktop.getDesktop().browse(url0);
        } catch (Exception e) {
            System.out.print("Error loading page");
        }
    }
    public void first(){
        try {
            URI url1 = new URI("https://oneoakland.webex.com/meet/david.weeks");
            Desktop.getDesktop().browse(url1);
        } catch (Exception e) {
            System.out.print("Error loading page");
        }
    }
    public void second(){
        try {
            URI url2 = new URI("https://oneoakland.webex.com/meet/kirsten.williams");
            Desktop.getDesktop().browse(url2);
        } catch (Exception e) {
            System.out.print("Error loading page");
        }
    }
    public void third(){
        try {
            URI url3 = new URI("https://oneoakland.webex.com/meet/mrcastle");
            Desktop.getDesktop().browse(url3);
        } catch (Exception e) {
            System.out.print("Error loading page");
        }
    }
    public void fourth(){
        try {
            URI url4 = new URI("https://oneoakland.webex.com/meet/alec.snyder");
            Desktop.getDesktop().browse(url4);
        } catch (Exception e) {
            System.out.print("Error loading page");
        }
    }
    public void fifth(){
        try {
            URI url5 = new URI("https://oneoakland.webex.com/meet/kristen.elsner");
            Desktop.getDesktop().browse(url5);
        } catch (Exception e) {
            System.out.print("Error loading page");
        }
    }
    public void sixth(){
        try {
            URI url6 = new URI("https://oneoakland.webex.com/meet/jennifer.hull");
            Desktop.getDesktop().browse(url6);
        } catch (Exception e) {
            System.out.print("Error loading page");
        }
    }
}
