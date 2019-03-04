package hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws IOException {
        var m = new ObjectMapper();
        Stream.of(
            new EqFilter<>("property", 1),
            new InFilter<>("property", List.of(2)),
            new LikeFilter("property", "%property%")
        ).forEach(f -> {
            String asstr = null;
            try {
                asstr = m.writeValueAsString(f);
                System.out.println(asstr);
                System.out.println(m.readValue(asstr, DataFilter.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
