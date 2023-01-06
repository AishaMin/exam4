import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;

public class Application {
    public static void main(String[] args) {

           EntityManagerFactory factory = Persistence
                   .createEntityManagerFactory("exam4");

           EntityManager manager = factory.createEntityManager();





        Group group1 = new Group();
        Group group2 = new Group();
        Group group3 = new Group();
        group1.climberCount = 3;
        group2.climberCount = 2;
        group3.climberCount = 2;

        Mountain mountain1 = new Mountain("Ортлер", "Италия", 3905, LocalDateTime.of(2022,12,5,17,00));
        Mountain mountain2 = new Mountain("Фудзияма", "Япония", 3776,  LocalDateTime.of(2022,12,5,17,00));
        Mountain mountain3 = new Mountain("Маналсу", "Гималайи", 8156,  LocalDateTime.of(2022,12,5,17,00));

        Climber climber1 = new Climber("Афанасий", "Спб 33 ворота гостинного двора");
        Climber climber2 = new Climber("Егор", "МСК 33 ворота гостинного двора");
        Climber climber3 = new Climber("Олег", "ЕКб 33 ворота гостинного двора");
        Climber climber4 = new Climber("Анастасия", " 33 ворота гостинного двора");
        Climber climber5 = new Climber("София", "Спб 33 ворота гостинного двора");
        Climber climber6 = new Climber("Мира", "третий круг ада");
        Climber climber7 = new Climber("Мария", "второй круг ада Данте");

        manager.getTransaction().begin();

        manager.persist(group1);
        manager.persist(group2);
        manager.persist(group3);

        manager.persist(mountain1);
        manager.persist(mountain2);
        manager.persist(mountain3);

        manager.persist(climber1);
        manager.persist(climber2);
        manager.persist(climber3);
        manager.persist(climber4);
        manager.persist(climber5);
        manager.persist(climber6);
        manager.persist(climber7);




        manager.getTransaction().commit();



    }
}
