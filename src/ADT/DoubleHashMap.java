package ADT;

public class DoubleHashMap<K, V> extends ProbeHashMap<K, V> {

    /** Constructor con capacidad predeterminada. */
    public DoubleHashMap() {
        super();
    }

    /** Constructor con capacidad específica. */
    public DoubleHashMap(int cap) {
        super(cap);
    }

    /** Constructor con capacidad y factor primo específico. */
    public DoubleHashMap(int cap, int p) {
        super(cap, p);
    }

    /**
     * Función hash1 para calcular el índice inicial (igual que en ProbeHashMap).
     * @param key la clave para la que se calculará el hash
     * @return el índice inicial en la tabla
     */
    private int hash1(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    /**
     * Función hash2 para calcular el desplazamiento de doble hashing.
     * Usamos un número primo menor que la capacidad para garantizar que el desplazamiento sea cíclico.
     * @param key la clave para la que se calculará el desplazamiento
     * @return el desplazamiento del doble hash
     */
    private int hash2(K key) {
        return 7 - (Math.abs(key.hashCode()) % 7); // 7 debe ser un número primo menor que capacity
    }

    /**
     * Redefinimos findSlot para usar double hashing en lugar de linear probing.
     * @param h el valor hash precalculado (hash1) para la clave dada
     * @param k la clave de interés
     * @return el índice de la entrada encontrada, o si no se encuentra, -(a+1) donde a es el índice del primer espacio disponible.
     */
    @Override
    protected int findSlot(int h, K k) {
        int hash1 = h;                      // índice inicial usando el primer hash
        int hash2 = hash2(k);                // segundo hash para el desplazamiento
        int avail = -1;                      // no hay un espacio disponible al inicio
        int j = hash1;                       // índice actual para la tabla

        do {
            if (isAvailable(j)) {            // puede estar vacío o ser DEFUNCT
                if (avail == -1) avail = j;  // este es el primer espacio disponible
                if (table[j] == null) break; // si está vacío, se termina la búsqueda
            } else if (table[j].getKey().equals(k)) {
                return j;                    // coincidencia encontrada
            }
            j = (j + hash2) % capacity;      // recalcula índice con double hashing
        } while (j != hash1);                // para cuando vuelve al inicio

        return -(avail + 1);                 // no encontró la clave
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < capacity; i++) {
            sb.append("Espacio [").append(i).append("]: ");
            MapEntry<K, V> entry = table[i];

            if (entry == null) {
                sb.append("Vacío\n");
            } else if (entry == DEFUNCT) {
                sb.append("DEFUNCT\n");
            } else {
                sb.append("Ocupado - Clave: ").append(entry.getKey())
                        .append(", Valor: ").append(entry.getValue()).append("\n");
            }
        }

        return sb.toString();
    }
}

