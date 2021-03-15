import java.awt.Desktop;
import java.net.URI;

class Opener {
    public void first(){
        try {
            URI url1 = new URI("1st Hour Link");
            Desktop.getDesktop().browse(url1);
        } catch (Exception e) {
            System.out.print("Error loading page");
        }
    }
    public void second(){
        try {
            URI url2 = new URI("2nd Hour Link");
            Desktop.getDesktop().browse(url2);
        } catch (Exception e) {
            System.out.print("Error loading page");
        }
    }
    public void third(){
        try {
            URI url3 = new URI("3rd Hour Link");
            Desktop.getDesktop().browse(url3);
        } catch (Exception e) {
            System.out.print("Error loading page");
        }
    }
    public void fourth(){
        try {
            URI url4 = new URI("4th Hour Link");
            Desktop.getDesktop().browse(url4);
        } catch (Exception e) {
            System.out.print("Error loading page");
        }
    }
    public void fifth(){
        try {
            URI url5 = new URI("5th Hour Link");
            Desktop.getDesktop().browse(url5);
        } catch (Exception e) {
            System.out.print("Error loading page");
        }
    }
    public void sixth(){
        try {
            URI url6 = new URI("6th Hour Link");
            Desktop.getDesktop().browse(url6);
        } catch (Exception e) {
            System.out.print("Error loading page");
        }
    }
    public void advisory(){
        try {
            URI url0 = new URI("Advisory Link");
            Desktop.getDesktop().browse(url0);
        } catch (Exception e) {
            System.out.print("Error loading page");
        }
    }
}
