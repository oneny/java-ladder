package cc.oakk.ladder.model.line;

import cc.oakk.ladder.model.line.dto.LineDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @ParameterizedTest
    @ValueSource(ints = { 4, 5, 6, 7, 8 })
    public void width(int width) {
        assertThat(Line.of(new boolean[width - 1]).width()).isEqualTo(width);
    }

    @Test
    public void of() {
        boolean[] data = new boolean[] { false, true, false, true, false, true };
        Line line = Line.of(data);
        LineDto dto = line.getDto();
        List<Connection> connections = dto.getConnections();
        for (int i = 0; i < data.length; i++) {
            assertThat(connections.get(i).isRight()).isEqualTo(data[i]);
        }
        assertThat(connections.get(connections.size() - 1).isRight()).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = { "0:0", "1:1", "2:-1", "3:1", "4:-1", "5:0" }, delimiter = ':')
    public void move(int position, int exceptedResult) {
        boolean[] data = new boolean[] { false, true, false, true, false, false };
        Line line = Line.of(data);
        assertThat(line.move(position)).isEqualTo(exceptedResult);
    }
}