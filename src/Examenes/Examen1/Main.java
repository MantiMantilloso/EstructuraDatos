package Examenes.Examen1;

public class Main {
    public static void main(String[] args) {
        EmpresaTelecomunicacion emp = new EmpresaTelecomunicacion();

        Operador operador1 = new Operador("Jose", "321");
        Operador operador2 = new Operador("Maria", "322");

        Llamada llamada1 = new Llamada("Kathy", "soporte tecnico", "09963592836");
        Llamada llamada2 = new Llamada("Martin","soporte tecnico", "09963592536");
        emp.addOperador(operador1);
        emp.addOperador(operador2);
        emp.addLlamada(llamada1);
        emp.addLlamada(llamada2);
        System.out.println(emp.getOperadores());
        emp.procesarLlamadas();
        emp.addLlamada(llamada1);
        emp.procesarLlamadas();
        emp.addLlamada(llamada2);
        emp.procesarLlamadas();
        System.out.println("Maria: "+ emp.llamadasAtendidas("Maria"));
        System.out.println("Jose: "+ emp.llamadasAtendidas("Jose"));
        System.out.println(emp.getOperadores());
    }
}
