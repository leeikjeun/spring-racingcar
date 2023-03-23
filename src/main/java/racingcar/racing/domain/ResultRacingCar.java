package racingcar.racing.domain;

import java.util.List;

public class ResultRacingCar {

    private final String winners;
    private final List<Car> racingCars;

    public ResultRacingCar(String winners, List<Car> racingCars) {
        this.winners = winners;
        this.racingCars = racingCars;
    }

    public String getWinners() {
        return winners;
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

    @Override
    public String toString() {
        return "ResultRacingCar{" +
                "winners='" + winners.toString() + '\'' +
                ", racingCars=" + racingCars.toString() +
                '}';
    }
}
