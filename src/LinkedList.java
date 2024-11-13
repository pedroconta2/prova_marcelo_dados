public class LinkedList<T extends Comparable<T>> {
    private Node<T> head;  // Cabeça da lista

    public LinkedList() {
        head = null;
    }

    // Método que adiciona um novo nó
    public void append(T data) {
        Node<T> nodeAux = new Node<>(data);

        if (head == null) {
            head = nodeAux;
        } else {
            Node<T> last = head;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(nodeAux);
        }
    }

    // Método para remover um elemento específico
    public void delete(T data) {
        Node<T> nodeAux = head;

        // Se a lista estiver vazia
        if (nodeAux == null) {
            System.out.println("Lista vazia");
            return;
        }

        // Se remover o primeiro nó
        if (nodeAux != null && nodeAux.getData().equals(data)) {
            head = nodeAux.getNext();
            nodeAux = null;
            return;
        }

        Node<T> nodeAux2 = null;

        while (nodeAux != null && !nodeAux.getData().equals(data)) {
            nodeAux2 = nodeAux;
            nodeAux = nodeAux.getNext();
        }

        if (nodeAux == null) {
            System.out.println("Valor não encontrado");
            return;
        }

        nodeAux2.setNext(nodeAux.getNext());
        nodeAux = null;
    }

    // Método que imprime a LinkedList
    public void printLinkedList() {
        if (head == null) {
            System.out.println("Lista vazia.");
            return;
        }

        Node<T> nodeAux = head;
        while (nodeAux != null) {
            System.out.print(nodeAux.getData() + " ");
            nodeAux = nodeAux.getNext();
        }
        System.out.println();
    }

    // Método de ordenação Bubble Sort
    public void bubbleSort() {
        if (head == null) {
            System.out.println("Lista vazia.");
            return;
        }

        boolean swapped;
        Node<T> current;
        do {
            swapped = false;
            current = head;
            while (current != null && current.getNext() != null) {
                if (current.getData().compareTo(current.getNext().getData()) > 0) {
                    // Troca os dados dos nós
                    T temp = current.getData();
                    current.setData(current.getNext().getData());
                    current.getNext().setData(temp);
                    swapped = true;
                }
                current = current.getNext();
            }
        } while (swapped);  // Continua até finalizar as trocas
    }

    // Método de ordenação Selection Sort
    public void selectionSort() {
        if (head == null) {
            System.out.println("Lista vazia.");
            return;
        }

        Node<T> i = head;
        while (i != null) {
            Node<T> j = i.getNext();
            while (j != null) {
                if (i.getData().compareTo(j.getData()) > 0) {
                    // Troca os dados dos nós
                    T temp = i.getData();
                    i.setData(j.getData());
                    j.setData(temp);
                }
                j = j.getNext();
            }
            i = i.getNext();
        }
    }

    // Método que transforma uma LinkedList em Array, para auxiliar na binarySearch
    private Object[] toArray() {
        int size = 0;
        Node<T> nodeAux = head;

        // Conta o número de elementos
        while (nodeAux != null) {
            size++;
            nodeAux = nodeAux.getNext();
        }

        // Cria o array e preenche com os dados
        Object[] array = new Object[size];
        nodeAux = head;
        int i = 0;
        while (nodeAux != null) {
            array[i++] = nodeAux.getData();
            nodeAux = nodeAux.getNext();
        }

        return array;
    }

    // Método de busca binária
    public int binarySearch(T target) {
        Object[] arrayAux = toArray();
        int left = 0;
        int right = arrayAux.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Comparação entre o alvo e o elemento do meio
            if (target.compareTo((T) arrayAux[mid]) == 0) {
                return mid;  // Elemento encontrado
            }
            if (target.compareTo((T) arrayAux[mid]) > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;  // Elemento não encontrado
    }
}