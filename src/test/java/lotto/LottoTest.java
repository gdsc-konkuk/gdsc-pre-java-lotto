package lotto;

import lotto.Exception.Validation;
import lotto.Model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    // 아래에 추가 테스트 작성 가능
    @Test
    void 보너스번호_검증테스트() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThatThrownBy(() -> Validation.bonusNumber(lotto, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void toString_테스트(){
        Lotto lotto = new Lotto(List.of(1,3,2,4,5,6));
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");

    }

    @Test
    void 로또_개수_중복_테스트(){
        Lotto a = new Lotto(List.of(1,2,3,4,5,6));
        Lotto b = new Lotto(List.of(4,5,6,7,8,9));
        assertThat(a.countDup(b)).isEqualTo(3L);
    }

    @Test
    void 보너스번호_확인_테스트(){
        Lotto a = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(a.isBonus(5)).isTrue();
        assertThat(a.isBonus(7)).isFalse();
    }
}