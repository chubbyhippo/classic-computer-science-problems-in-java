package io.github.chubbyhippo.trivialcompression;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CompressedGeneTest {

    @Test
    @DisplayName("should compress and decompress")
    void shouldCompressAndDecompress() {
        final var original = "TAGGGATTAACCGTTATATATATATAGCCATGGATCGATTATATAGGGATTAACCGTTATATATATATAGCCATGGATCGATTATA";
        var compressed = new CompressedGene(original);
        final var decompressed = compressed.decompress();
        assertThat(original).isEqualTo(decompressed);
    }
}