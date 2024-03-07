package demo.webflux.config.conveter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.r2dbc.postgresql.codec.Json;
import demo.webflux.metadata.DescriptionMetadata;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.io.IOException;


@ReadingConverter
@Slf4j
@RequiredArgsConstructor
public class JsonToDescriptionMetadataConverter implements Converter<Json,DescriptionMetadata> {

    private final ObjectMapper objectMapper;

    @Override
    public DescriptionMetadata convert(Json source) {
        try {
            objectMapper.readValue(source.toString(),DescriptionMetadata.class);
        } catch (IOException e) {
            log.error("Error while converting JSON to CourseMetadata", e);
            throw new RuntimeException(e);
        }
        return null;
    }
}
