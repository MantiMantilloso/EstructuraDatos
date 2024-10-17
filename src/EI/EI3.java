package EI;
import ADT.DoublyLinkedList;

public class EI3 {

    public static void main(String[] args) {

        DoublyLinkedList<PCComponents> list = new DoublyLinkedList<>();

        System.out.println(list);
        PCComponents graphics1 = new PCComponents("GPU","GeForceRTX-4090",1760.00);
        PCComponents graphics2 = new PCComponents("GPU","GeForceRTX-4060",299.00);
        PCComponents graphics3 = new PCComponents("GPU","RadeonRX-6400",119.00);

        PCComponents processor1 = new PCComponents("CPU","IntelCore7-13700",319.00);
        PCComponents processor2 = new PCComponents("CPU","IntelCore5-13400",179.00);
        PCComponents processor3 = new PCComponents("CPU","AMDRyzen5-7600",182.00);




        //addFirst

        list.addFirst(graphics1);
        list.addFirst(graphics2);
        list.addFirst(graphics3);
        System.out.println(list);

        //addLast
        list.addLast(processor1);
        list.addLast(processor2);
        list.addLast(processor3);
        System.out.println(list);

        //remove methods
        System.out.println(list.removeFirst());
        System.out.println(list.removeLast());

        System.out.println("El componente mas economico actualmente en la lista es: "+ findCheapestComponent(list));
        System.out.println("El componente mas caro actualmente en la lista es: "+ findExpesiveComponent(list));

        System.out.println(list);

        while (!list.isEmpty()) {
            System.out.println(list.removeFirst().getModel());

        }

    }
    public static String findCheapestComponent(DoublyLinkedList<PCComponents> list) {
        if (list.isEmpty()) {
            return "The list is empty.";
        }

        DoublyLinkedList.Node<PCComponents> current = list.header.getNext(); // Start after header
        PCComponents cheapest = current.getElement(); // Assume the first component is the cheapest

        while (current != list.trailer) { // Traverse the list until the trailer
            PCComponents component = current.getElement();
            if (component.getPrice() < cheapest.getPrice()) {
                cheapest = component; // Update if a cheaper component is found
            }
            current = current.getNext();
        }

        return cheapest.getModel(); // Return the model of the cheapest component
    }
    public static String findExpesiveComponent(DoublyLinkedList<PCComponents> list) {
        if (list.isEmpty()) {
            return "The list is empty.";
        }
        DoublyLinkedList.Node<PCComponents> current = list.header.getNext();
        PCComponents expesive = current.getElement();
        while (current != list.trailer) {
            PCComponents component = current.getElement();
            if (component.getPrice() > expesive.getPrice()) {
                expesive = component;
            }
            current = current.getNext();
        }
        return expesive.getModel();
    }


    public static class PCComponents{
        private String type;
        private String model;
        private double price;

        PCComponents(String type, String model, double price){
            this.type = type;
            this.model = model;
            this.price = price;
        }
        public String getType() {
            return type;
        }
        public String getModel() {
            return model;
        }
        public double getPrice() {
            return price;
        }
        @Override
        public String toString() {
            return "[type=" + type + ", model=" + model + ", price=" + price + "]";
        }

    }

}
