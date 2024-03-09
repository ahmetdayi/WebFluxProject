package demo.webflux.config.conveter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.r2dbc.postgresql.codec.Json;
import demo.webflux.metadata.DescriptionMetadata;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.io.IOException;


@ReadingConverter
@Slf4j

public class JsonToDescriptionMetadataConverter implements Converter<Json,DescriptionMetadata> {

    private final ObjectMapper objectMapper;

    public JsonToDescriptionMetadataConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public DescriptionMetadata convert(Json source) {
        try {
            return objectMapper.readValue(source.asString(),DescriptionMetadata.class);
        } catch (IOException e) {
            log.error("Error while converting JSON to CourseMetadata", e);
            throw new RuntimeException(e);
        }

    }
}
