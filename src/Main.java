
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            //Instâncias da lista e scanner
            LinkedList<Integer> linkedList = new LinkedList<>();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Qual o tamanho da lista?");
            int listSize = scanner.nextInt();

            //Adiciona novos numeros na lista
            for (int i = 0; i < listSize; i++) {
                System.out.println("Informe o numero que deseja inserir:");
                int number = scanner.nextInt();
                linkedList.append(number);
            }
            System.out.println("Sua lista:");
            linkedList.printLinkedList();

            System.out.println("Deseja remover algum dado?(S/N)");
            String opc = scanner.next();

            //Verifica exlusão de numeros
            if (opc.equals("S")) {
                boolean remove = true;

                while (remove) {
                    System.out.println("Qual numero deseja remover?");
                    int numberToRemove = scanner.nextInt();
                    linkedList.delete(numberToRemove);

                    linkedList.printLinkedList();

                    System.out.println("Deseja remover algum dado?(S/N)");
                    String opc2 = scanner.next();

                    if (!opc2.equals("S")) remove = false;
                }
                linkedList.printLinkedList();
            }

            System.out.println("Escolha um método para ordenar a lista:\n" +
                    "\n1 - Bubble Sort\n2 - Selection Sort");
            int opcSort = scanner.nextInt();

            if (opcSort == 1) {
                linkedList.bubbleSort();
                linkedList.printLinkedList();
            } else if (opcSort == 2) {
                linkedList.selectionSort();
                linkedList.printLinkedList();
            }

            System.out.println("Me diga um numero para alicarmos a busca");
            int binatySearch = scanner.nextInt();

            if (linkedList.binarySearch(binatySearch) == -1) {
                System.out.println("Numero não encontrado");
            } else {
                System.out.println("Numero " + linkedList.binarySearch(binatySearch) + " encontrado na lista!");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }
}