package Practice.Clase2.Ejercicio4;

import ADT.LinkedQueue;
import ADT.SinglyLinkedList;

public class CadenaHotelera {

    private LinkedQueue<Reservacion> vipQueue;
    private LinkedQueue<Reservacion> ordinarioQueue;

    private LinkedQueue<Reservacion> aceptadas;
    private LinkedQueue<Reservacion> rechazadas;

    private SinglyLinkedList<Hotel> hoteles;

    public CadenaHotelera() {
        this.vipQueue = new LinkedQueue<>();
        this.ordinarioQueue = new LinkedQueue<>();
        this.aceptadas = new LinkedQueue<>();
        this.rechazadas = new LinkedQueue<>();
        this.hoteles = new SinglyLinkedList<>();
    };

    public void procesarReservaciones(){

        while(!vipQueue.isEmpty()){
            SinglyLinkedList.Node<Hotel> currentHotel = hoteles.head;
            while(currentHotel != null && !currentHotel.getElement().getNombre().equals(vipQueue.first().getNomHotel())){
                currentHotel = currentHotel.getNext();
            }
            if(currentHotel != null){
                if(!currentHotel.getElement().isFull()){
                    currentHotel.getElement().removeHabitacion();
                    aceptadas.enqueue(vipQueue.dequeue());
                }else{
                    rechazadas.enqueue(vipQueue.dequeue());
                }
                return;
            }
            rechazadas.enqueue(vipQueue.dequeue());
        }
        while(!ordinarioQueue.isEmpty()){
            SinglyLinkedList.Node<Hotel> currentHotel = hoteles.head;
            while(currentHotel != null && !currentHotel.getElement().getNombre().equals(ordinarioQueue.first().getNomHotel())){
                currentHotel = currentHotel.getNext();
            }
            if(currentHotel != null){
                if(!currentHotel.getElement().isFull()){
                    currentHotel.getElement().removeHabitacion();
                    aceptadas.enqueue(vipQueue.dequeue());
                }else{
                    rechazadas.enqueue(vipQueue.dequeue());
                }
                return;
            }
            rechazadas.enqueue(vipQueue.dequeue());
        }


    }

    public void addReservacion(Reservacion reservacion){
        if(reservacion.isVIP()) {vipQueue.enqueue(reservacion);}
        else {ordinarioQueue.enqueue(reservacion);}
    }

    public void addHotel(Hotel hotel){
        hoteles.addFirst(hotel);
    }

}
