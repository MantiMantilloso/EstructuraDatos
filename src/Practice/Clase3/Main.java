package Practice.Clase3;

public class Main {
    public static void main(String[] args) {
        Paciente paciente1 = new Paciente("Lola",732921811,34, false);
        Paciente pacienten1 = new Paciente("Sabrina", 999999999, 3,false);
        Paciente pacientev1 = new Paciente("Rauw", 456999999, 67,true);
        Paciente paciente2 = new Paciente("Jose",732561811,34, true);
        Paciente pacienten2 = new Paciente("Mari", 920999999, 4,false);
        Paciente pacientev2 = new Paciente("Yeye", 456990399, 78,false);

        Hospital hospitalpepito = new Hospital("pepito", "paris", 4);

        hospitalpepito.atenderPaciente(paciente1);
        hospitalpepito.atenderPaciente(pacienten1);
        hospitalpepito.atenderPaciente(pacientev1);
        hospitalpepito.atenderPaciente(paciente2);
        hospitalpepito.atenderPaciente(pacienten2);
        hospitalpepito.atenderPaciente(pacientev2);



        


    }
}
