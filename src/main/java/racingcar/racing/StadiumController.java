package racingcar.racing;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import racingcar.racing.domain.CarCollection;
import racingcar.racing.domain.ResultRacingCar;
import racingcar.racing.domain.Stadium;
import racingcar.racing.view.CarRacingConsoleView;

import java.util.Map;
import java.util.Objects;

@RestController
public class StadiumController {

    public static void main(String[] args) {

        CarRacingConsoleView view = new CarRacingConsoleView();

        String carNames = view.inputCarNames();
        int round = view.inputRound();

        Stadium stadium = new Stadium(new CarCollection(CarCollection.initCars(carNames)), round);

        view.beforeRacing();
        while(!stadium.isRacingEnd()){
            view.showRacing(stadium.racingCars());
        }

        view.showWinners(stadium.getWinner());
    }

    @PostMapping(value = "/racing"
            , consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResultRacingCar racingCar(@RequestBody Map<String, Objects> body){

        String names = body.get("names").toString();
        Integer count = Integer.parseInt(body.get("count").toString());

        Stadium stadium = new Stadium(new CarCollection(names), count);

        return stadium.resultRacing();
    }




}
