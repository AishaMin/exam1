package exem.fitness;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;


public class Fitness {
    //Фитнес содержит информацию об абонементах, которые:
    //
    //зарегистрированы в тренажерном зале (массив абонементов);
    //зарегистрированы в бассейне (массив абонементов);
    //зарегистрированы на групповых занятиях (массив абонементов).
    //В каждой зоне (бассейн, тренажерный зал, групповые занятия) одновременно может быть зарегистрировано 20 абонементов.
    //
    //Когда фитнес клуб закрывается, клиенты покидают его (заполнить массив null элементами).

    //Разовый (на один день). По разовому абонементу клиенты могут посещать бассейн и тренажерный зал с 8 до 22 часов.
    //Дневной (срок действия может быть любым). По данному абонементу клиенты могут посещать тренажерный зал и групповые занятия (но не бассейн) с 8 до 16 часов.
    //Полный (срок действия может быть любым). По данному абонементу клиенты могут посещать тренажерный зал, бассейн и групповые занятия с 8 до 22 часов.

    private Membership [] gym = new Membership[20];
    private Membership [] swimmingPool = new Membership[20];
    private Membership [] group = new Membership[20];

//регистарация == добавления в массив

    // регистрация в зал
    public void registrationGym(Membership membership){
        for (int i = 0; i < gym.length; i += 1){
            if (gym [i] == null && Membership.getDateEndOfRegistration() != LocalDate.now()){
                if (Membership.type == TypeOfMembership.ONETIMEMEMBERSHIP){
                    gym [i] = membership;
            } else if (Membership.type == TypeOfMembership.DAYMEMBERSHIP && LocalTime.now()
                        .isAfter(LocalTime.of (16, 00,00)) ) {
                    gym [i] = membership;
                } else if (Membership.type == TypeOfMembership.FULLMEMBERSHIP){
                    gym [i] = membership;
                } else System.out.println("вход в данную зону невозможен");
            }
            System.out.println(membership.getName()+ " " + membership.getSurname() + "занимается в тренажорном зале" +
                    "Дата и время регистраци" + LocalDate.now() + LocalTime.now());
        }
}
// регистрация в бассейн
    public void registrationSwimmingPool (Membership membership){
        for (int i = 0; i < swimmingPool.length; i += 1){
            if (swimmingPool [i] == null && Membership.getDateEndOfRegistration() != LocalDate.now()){
                if (Membership.type == TypeOfMembership.ONETIMEMEMBERSHIP){
                    swimmingPool [i] = membership;
                } else if (Membership.type == TypeOfMembership.DAYMEMBERSHIP ) {
                    System.out.println("Вход в бассейн по дневному абонементу невозможен");
                } else if (Membership.type == TypeOfMembership.FULLMEMBERSHIP){
                    swimmingPool [i] = membership;
                } else System.out.println("вход в данную зону невозможен");
            }
        }
        System.out.println(membership.getName()+ " " + membership.getSurname() + "занимается в тренажорном зале" +
                "Дата и время регистраци" + LocalDate.now() + LocalTime.now());
    }

    //регистрация на групповые занятия
    public void registrationGroup(Membership membership){
        for (int i = 0; i < group.length; i += 1){
            if (group [i] == null && Membership.getDateEndOfRegistration() != LocalDate.now()){
                if (Membership.type == TypeOfMembership.ONETIMEMEMBERSHIP){
                    System.out.println("Вход на групповые занятия по дневному абонементу невозможен");
                } else if (Membership.type == TypeOfMembership.DAYMEMBERSHIP && LocalTime.now()
                        .isAfter(LocalTime.of (16, 00,00))) {
                    group [i] = membership;
                } else if (Membership.type == TypeOfMembership.FULLMEMBERSHIP){
                    group [i] = membership;
                } else System.out.println("вход в данную зону невозможен");
            }
        }
        System.out.println(membership.getName()+ " " + membership.getSurname() + "занимается в тренажорном зале" +
                "Дата и время регистраци" + LocalDate.now() + LocalTime.now());
    }

    //закрытие фитнеса
    public void closeFitness (){
        if (LocalTime.now().isAfter(LocalTime.of (22, 00,00))){
            for (int i = 0; i < 20; i += 1){
                    gym [i] = null;
                    swimmingPool [i] = null;
                    group [i] = null;
                }
            }
        }

    @Override
    public String toString() {
        return "Fitness{" +
                "gym=" + Arrays.toString(gym) +
                ", swimmingPool=" + Arrays.toString(swimmingPool) +
                ", group=" + Arrays.toString(group) +
                '}';
    }
}
