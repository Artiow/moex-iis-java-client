package com.artiow.moex.api.model.mapper.data;

import com.artiow.moex.api.model.SecurityPaperDescription;
import com.artiow.moex.api.model.SecurityPaperDescriptionKey;
import com.artiow.moex.api.model.mapper.extractor.AttributeExtractor;
import com.artiow.moex.api.model.schema.Row;
import lombok.val;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static java.util.Optional.ofNullable;

public class SecurityPaperDescriptionDataMapper extends AbstractDataMapper<SecurityPaperDescription> {

    private static final Map<String, SecurityPaperDescriptionKey> KEY_MAP;

    static {
        // mapping by name
        val keyMap = Arrays.stream(SecurityPaperDescriptionKey.values()).collect(Collectors.toMap(
                SecurityPaperDescriptionKey::name,
                Function.identity()
        ));

        // mapping by pseudonym
        keyMap.remove("EMITTERID");
        keyMap.put("EMITTER_ID", SecurityPaperDescriptionKey.EMITTERID);

        KEY_MAP = Collections.unmodifiableMap(keyMap);
    }


    @Override
    protected SecurityPaperDescription rowMapping(List<Row> rows, AttributeExtractor extractor) {
        val result = new SecurityPaperDescription();
        rows.forEach(row -> rowMapping(result, extractor.process(row)));
        return result;
    }

    protected void rowMapping(SecurityPaperDescription result, AttributeExtractor.Processor processor) {
        val key = findKeyByName(processor.readString("name").toUpperCase());
        result.putValue(key, processor.read("value", key.getType()), processor.readString("title"));
    }

    private SecurityPaperDescriptionKey findKeyByName(String name) {
        return ofNullable(KEY_MAP.get(name))
                .orElseThrow(() -> new IllegalArgumentException(format("Key \"%s\" not found", name)));
    }
}
