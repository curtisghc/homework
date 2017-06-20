import java.net.URL;
import java.util.Scanner;
import java.io.*;

public class xkcdDow {

    public static String geturl(String page) {
        String link = "Image link not found";
        try{
            Scanner sc = new Scanner(new URL(page).openStream());
            String line;
            while((line = sc.nextLine()) != null){
                if(line.contains("//imgs.xkcd.com/comics/")) {
                    String[] linePart = line.split("\"");
                    for(String part: linePart){
                        if(part.contains("//imgs.xkcd.com/comics/")){
                            return "http:" + part;
                        }
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println(link);
        }
        return link;
    }

    public static void crawl(int home) {
        for(int n = home; n > 0; n--){
            try{
                String page = geturl("http://www.xkcd.com/" + n + "/");
                String[] elements = page.split("/");
                String localPath = elements[4];

                URL url = new URL(page);
                InputStream in = new BufferedInputStream(url.openStream());
                OutputStream out = new BufferedOutputStream(new FileOutputStream(localPath));
                for(int i; (i = in.read()) != -1;){
                    out.write(i);
                }
                in.close();
                out.close();

                System.out.println("" + n + ": Downloaded " + page + " to ./" + localPath);
            }
            catch(Exception e){
                System.err.println("" + n + ": failed to download");
                e.printStackTrace();

            }
        }
    }

    public static void main(String[] args) {
        int initial = Integer.parseInt(args[0]);
        crawl(initial);
    }
}
