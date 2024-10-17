package EI.EI4;

import ADT.LinkedBinaryTree;
import ADT.Position;
import ADT.LinkedTree;

public class Empresa{
    private String nombre;
    private LinkedBinaryTree<Empleado> empleados;
    private LinkedTree<Empleado> empleadosGeneral;

    public Empresa(String nombre) {
        this.nombre = nombre;
        empleados = new LinkedBinaryTree<>();
        empleadosGeneral = new LinkedTree<>();
    }

    public void addEmpleado(Empleado empleado) {
        if (empleado.getCargo().equals("Jefe")) {
            // Si no hay raíz, añadimos al Jefe como la raíz
            if (empleados.isEmpty()) {
                empleados.addRoot(empleado);
            } else {
                System.out.println("Ya existe un Jefe.");
            }
        } else if (empleado.getCargo().equals("Gerente")) {
            // Si hay un Jefe, añadimos al Gerente como hijo de la raíz
            Position<Empleado> root = empleados.root();
            if (empleados.left(root) == null) {
                empleados.addLeft(root, empleado);  // Añadir como hijo izquierdo
            } else if (empleados.right(root) == null) {
                empleados.addRight(root, empleado);  // Añadir como hijo derecho
            } else {
                System.out.println("El Jefe ya tiene dos Gerentes.");
            }
        } else {
            // Añadir el empleado bajo un Gerente
            Position<Empleado> root = empleados.root();
            Position<Empleado> gerente = null;

            // Buscar al Gerente en el árbol (puede estar en el lado izquierdo o derecho de la raíz)
            if (empleados.left(root) != null && empleados.left(root).getElement().getCargo().equals("Gerente")) {
                gerente = empleados.left(root);
            } else if (empleados.right(root) != null && empleados.right(root).getElement().getCargo().equals("Gerente")) {
                gerente = empleados.right(root);
            }

            if (gerente != null) {
                // Añadir el nuevo empleado como hijo del Gerente
                if (empleados.left(gerente) == null) {
                    empleados.addLeft(gerente, empleado);  // Añadir como hijo izquierdo del Gerente
                } else if (empleados.right(gerente) == null) {
                    empleados.addRight(gerente, empleado);  // Añadir como hijo derecho del Gerente
                } else {
                    System.out.println("El Gerente ya tiene dos empleados.");
                }
            } else {
                System.out.println("No hay un Gerente disponible para asignar el empleado.");
            }
        }
    }

    public void addJefe(Empleado jefe) {
        if (empleadosGeneral.isEmpty()) {
            empleadosGeneral.addRoot(jefe);
            System.out.println("Jefe añadido: " + jefe.getNombre());
        } else {
            System.out.println("Ya existe un Jefe en la empresa.");
        }
    }
    public void addGerente(Empleado gerente) {
        if (!empleadosGeneral.isEmpty()) {
            Position<Empleado> root = empleadosGeneral.root();
            empleadosGeneral.addChild(root, gerente);
            System.out.println("Gerente añadido: " + gerente.getNombre());
        } else {
            System.out.println("No hay Jefe en la empresa para asignar un Gerente.");
        }
    }

    // Metodo para agregar un subempleado como hijo de un Gerente
    public void addSubEmpleado(Empleado subEmpleado) {
        if (!empleadosGeneral.isEmpty()) {
            Position<Empleado> root = empleadosGeneral.root();
            Position<Empleado> gerente = null;

            // Buscar el primer Gerente
            for (Position<Empleado> child : empleadosGeneral.children(root)) {
                if (child.getElement().getCargo().equals("Gerente")) {
                    gerente = child;
                    break;
                }
            }

            if (gerente != null) {
                empleadosGeneral.addChild(gerente, subEmpleado);
                System.out.println("Subempleado añadido: " + subEmpleado.getNombre());
            } else {
                System.out.println("No hay un Gerente disponible para asignar al Subempleado.");
            }
        } else {
            System.out.println("No hay Jefe en la empresa para asignar empleados.");
        }
    }

    public void empresaGeneral(){
        System.out.println("Recorrido General:");
        System.out.println("Recorrido Preorder:");
        for (Position<Empleado> p : empleadosGeneral.preorder()) {
            System.out.println(p.getElement());
        }
        System.out.println("Recorrido Postorder:");
        for (Position<Empleado> p : empleadosGeneral.postorder()) {
            System.out.println(p.getElement());
        }
    }

    public void empresaPreorder(){
        System.out.println("Recorrido Preorder:");
        for (Position<Empleado> p : empleados.preorder()) {
            System.out.println(p.getElement()); // Asumiendo que Empleado tiene un metodo toString()
        }
    }

    public void empresaPostorder(){
        System.out.println("Recorrido Postorder:");
        for (Position<Empleado> p : empleados.postorder()) {
            System.out.println(p.getElement());
        }
    }

    public void empresaInorder(){
        System.out.println("Recorrido Inorder:");
        for (Position<Empleado> p : empleados.inorder()) {
            System.out.println(p.getElement());
        }
    }

    @Override
    public String toString() {
        return nombre + empleados.toString();
    }
}
