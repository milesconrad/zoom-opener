import java.awt.Desktop;
import java.net.URI;

class Links {
    public void first(){
        try {
            URI url1 = new URI("1st link");
            Desktop.getDesktop().browse(url1);
        } catch (Exception e) {
            System.out.print("Error loading page");
        }
    }
    public void second(){
        try {
            URI url2 = new URI("2nd link");
            Desktop.getDesktop().browse(url2);
        } catch (Exception e) {
            System.out.print("Error loading page");
        }
    }
    public void third(){
        try {
            URI url3 = new URI("3rd link");
            Desktop.getDesktop().browse(url3);
        } catch (Exception e) {
            System.out.print("Error loading page");
        }
    }
    public void fourth(){
        try {
            URI url4 = new URI("4th link");
            Desktop.getDesktop().browse(url4);
        } catch (Exception e) {
            System.out.print("Error loading page");
        }
    }
    public void fifth(){
        try {
            URI url5 = new URI("5th link");
            Desktop.getDesktop().browse(url5);
        } catch (Exception e) {
            System.out.print("Error loading page");
        }
    }
    public void sixth(){
        try {
            URI url6 = new URI("6th link");
            Desktop.getDesktop().browse(url6);
        } catch (Exception e) {
            System.out.print("Error loading page");
        }
    }
    public void advis(){
        try {
            URI url7 = new URI("Advisory link");
            Desktop.getDesktop().browse(url7);
        } catch (Exception e) {
            System.out.print("Error loading page");
        }
    }
}