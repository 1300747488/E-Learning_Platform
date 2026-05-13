package com.ray.elearning_platform.mapper;

import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.session.Configuration;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class MyBatisMapperXmlTest {

    @Test
    void mapperXmlFilesCanBeParsed() throws Exception {
        URI mapperDirUri = Objects.requireNonNull(
                getClass().getClassLoader().getResource("mapper"),
                "mapper resource directory is missing"
        ).toURI();

        List<Path> mapperFiles;
        try (Stream<Path> paths = Files.list(Path.of(mapperDirUri))) {
            mapperFiles = paths
                    .filter(path -> path.getFileName().toString().endsWith(".xml"))
                    .sorted()
                    .toList();
        }

        Configuration configuration = new Configuration();
        configuration.setMapUnderscoreToCamelCase(true);

        for (Path mapperFile : mapperFiles) {
            assertDoesNotThrow(() -> {
                try (InputStream inputStream = Files.newInputStream(mapperFile)) {
                    XMLMapperBuilder builder = new XMLMapperBuilder(
                            inputStream,
                            configuration,
                            mapperFile.toString(),
                            configuration.getSqlFragments()
                    );
                    builder.parse();
                }
            }, () -> "Failed to parse mapper XML: " + mapperFile);
        }
    }
}
