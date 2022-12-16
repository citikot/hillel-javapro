package homework4.part2;

import java.io.*;

public class TestCase {
    public static void main(String[] args) {

        Obstacle[] goals = {
                new Runway(200),
                new Wall(4, 60),
                new Wall(6, 150),
                new Runway(400),
                new Wall(4, 60),
                new Wall(6, 150),
                new Wall(8, 300),
                new Wall(3, 380),
                new Runway(1000),
                new Wall(5, 300),
                new Wall(3, 800),
                new Runway(1500),
                new Wall(8, 300),
                new Wall(2, 600),
                new Wall(4, 700),
                new Wall(6, 1200)
        };

        Participant[] participants = {
                new Human(300, 5, "Калдырь"),
                new Human(600, 10, "Бугай"),
                new Human(150, 8, "Куряга"),
                new Robot(100, 10, "Робот Дрим"),
                new Robot(800, 5, "Робот Драм"),
                new Robot(350, 3, "Робот Друм"),
                new Cat(1800, 10, "Кот Кузя"),
                new Robot(1000, 8, "Кошка Муся"),
                new Robot(200, 7, "Кот Толстопуз"),
        };

        int distanceDone = 0;

        for (Participant participant : participants) {
            for (Obstacle goal : goals) {
                if (goal instanceof Runway) {
                    participant.run(participant.getName());
                    distanceDone = 0;
                    if (!goal.overcome(((Runway) goal).getRunwayLength(), participant.getRunLimit())) {
                        StringBuilder output = new StringBuilder();
                        output.append("Учасник ");
                        output.append(participant.getName());
                        output.append(" не пройшов перешкоду ");
                        output.append(((Runway) goal).getName());
                        output.append(" на дистанції ");
                        output.append(((Runway) goal).getRunwayLength());
                        output.append(". Пройдено ");
                        output.append(distanceDone);
                        System.out.println(output);
                        break;
                    }
                } else {
                    distanceDone = ((Wall) goal).getDistance();
                    participant.jump(participant.getName());
                    if (!goal.overcome(((Wall) goal).getWallHeight(), participant.getJumpLimit())) {
                        // сход с дистанции
                        StringBuilder output = new StringBuilder();
                        output.append("Учасник ");
                        output.append(participant.getName());
                        output.append(" не пройшов перешкоду ");
                        output.append(((Wall) goal).getName());
                        output.append(" на дистанції ");
                        output.append(participant.getRunLimit());
                        output.append(". Пройдено ");
                        output.append(distanceDone);
                        System.out.println(output);
                        break;
                    } else {
                        // репорт о прохождении дистанции
                        StringBuilder output = new StringBuilder();
                        output.append("Учасник ");
                        output.append(participant.getName());
                        output.append(" пройшов перешкоду ");
                        output.append(((Wall) goal).getName());
                        output.append(" на дистанції ");
                        output.append(distanceDone);
                        System.out.println(output);
                    }
                }
            }
        }
    }
}


