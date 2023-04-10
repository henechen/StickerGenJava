import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        API api = API.NASA;

        String url = api.getUrl();
        ContentExtractor extractor = api.getExtractor();

        var http = new ClientHttp();
        String json = http.dataSearch(url);

        List<Content> contents = extractor.contentExtractor(json);
        StickerGen generator = new StickerGen();

        for (int i = 0; i < 3; i++) {

            Content content = contents.get(i);

            InputStream inputStream = new URL(content.url()).openStream();

            String fileName = "saida/" + content.title() + ".png";

            generator.stickerGenerator(inputStream, fileName);
        }
    }
}