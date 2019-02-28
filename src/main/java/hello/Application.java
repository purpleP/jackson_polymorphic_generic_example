package hello;

import com.fasterxml.jackson.core.JsonProcessingException;
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
            new InFilter<>("property", List.of(1))
        ).forEach(f -> {
            String asstr = null;
            try {
                asstr = m.writeValueAsString(f);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            System.out.println(asstr);
            try {
                System.out.println(m.readValue(asstr, DataFilter.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
