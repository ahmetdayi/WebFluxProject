package demo.webflux.config.conveter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.webflux.metadata.DescriptionMetadata;
import io.r2dbc.postgresql.codec.Json;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

import java.io.IOException;

@WritingConverter
@Slf4j
@RequiredArgsConstructor
public class DescriptionMetadataToJsonConverter implements Converter<DescriptionMetadata, Json> {

    private final ObjectMapper objectMapper;

    @Override
    public Json convert(DescriptionMetadata source) {

        try {
          return  Json.of(objectMapper.writeValueAsBytes(source));
        } catch (IOException e) {
            log.error("Error while converting CourseMetadata to JSON", e);
            throw new RuntimeException(e);
        }
    }
}
