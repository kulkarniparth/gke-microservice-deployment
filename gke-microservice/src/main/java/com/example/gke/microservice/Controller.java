package com.example.gke.microservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Value("gs://file-upload-bucket-parth-kulkarni-unique-hopefully/hello2.txt")
    private Resource gcsFile;

    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello "+name+" !! "+StreamUtils.copyToString(
                gcsFile.getInputStream(),
                Charset.defaultCharset()
        );
    }

    @PostMapping
    public String writeGcs(@RequestBody String data) throws IOException {
        try (OutputStream os = ((WritableResource) gcsFile).getOutputStream()) {
            os.write(data.getBytes());
        }
        return "file was updated\n";
    }

}