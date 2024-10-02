package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 45가 넘으면 예외가 발생한다.")
    @Test
    void createLottoByOverNumber(){
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 51)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호가 6개 미만이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize(){
        assertThatThrownBy(() -> new Lotto(List.of(112341241, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호에 숫자 이외의 값이 들어가면 예외가 발생한다.")
    @Test
    void createLottoByNotInteger(){
        assertThatThrownBy(() -> new Lotto("ㄱ"))
                .isInstanceOf(IllegalArgumentException.class);
    }@DisplayName("로또 번호에 int 범위(-2^31~2^31-1)를 초과한 값이 들어가면 오류를 발생한다.")
    @Test
    void createLottoByNumberOverflow(){
        assertThatThrownBy(() -> new Lotto("635216165154154314523452350654961685416156941146984"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    

}