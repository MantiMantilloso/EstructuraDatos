package EI.EI4;

public class Main {
    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Jose","Jefe", 4000);
        Empleado empleado2 = new Empleado("Joaquin","Gerente", 3000);
        Empleado empleado3 = new Empleado("kathy","IT intern", 200);
        Empleado empleado4 = new Empleado("James","Gerente", 2000);
        Empleado empleado5 = new Empleado("Lopez","Communications", 1500);
        Empleado empleado6 = new Empleado("Juan","Gerente", 4000);
        Empresa empresa1 = new Empresa("pepitoSA");

        empresa1.addEmpleado(empleado1);
        empresa1.addEmpleado(empleado2);
        empresa1.addEmpleado(empleado3);
        empresa1.addEmpleado(empleado4);
        empresa1.addEmpleado(empleado5);
        empresa1.empresaPreorder();
        empresa1.empresaPostorder();
        empresa1.empresaInorder();


        empresa1.addJefe(empleado1);
        empresa1.addGerente(empleado2);
        empresa1.addGerente(empleado4);
        empresa1.addGerente(empleado6);
        empresa1.addSubEmpleado(empleado3);
        empresa1.empresaGeneral();

    }
}
