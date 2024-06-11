package Lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegerTest {
    @Test
    void test1(){
        Integer number1 = Integer.valueOf(1);
        Integer number2 = Integer.valueOf(1);

        assertThat(number1).isEqualTo(number2);
        assertThat(number1).isSameAs(number2); //애도 통과함
    }

    @Test
    void test2(){
        int number1 = 100;
        int number2 = 100;

        assertThat(number1).isEqualTo(number2);
        assertThat(number1).isSameAs(number2); //애도 통과함
    }

    @Test
    void test3(){
        int number1 = Integer.valueOf(1000); //실패함
        int number2 = Integer.valueOf(1000);

        assertThat(number1).isEqualTo(number2);
//        assertThat(number1).isSameAs(number2);
        assertThat(number1==number2).isTrue();
    }

    @Test
    void test4(){
        int number1 = 1000; //실패함
        int number2 = 1000;

        assertThat(number1).isEqualTo(number2);
        assertThat(number1==number2).isTrue();
    }

    @Test
    void test5(){
        Integer number1 = 1000; //실패함
        Integer number2 = 1000;

        assertThat(number1).isEqualTo(number2);
        assertThat(number1==number2).isTrue();
    }
}
