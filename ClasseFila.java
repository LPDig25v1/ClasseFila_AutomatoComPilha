class No {
    String elemento;
    No proximo;
    No anterior;

    public No(String elemento) {
        this.elemento = elemento;
        this.proximo = null;
        this.anterior = null;
    }
}

class Fila {
    private No inicio;
    private No fim;

    public Fila() {
        inicio = null;
        fim = null;
    }

    public void enqueue(String elemento) {
        No novoNo = new No(elemento);
        if (inicio == null) {
            inicio = fim = novoNo;
        } else {
            fim.proximo = novoNo;
            novoNo.anterior = fim;
            fim = novoNo;
        }
    }

    public String dequeue() {
        if (inicio == null) {
            throw new IllegalStateException("A fila está vazia.");
        }
        String elementoRemovido = inicio.elemento;
        inicio = inicio.proximo;
        if (inicio != null) {
            inicio.anterior = null;
        } else {
            fim = null;
        }
        return elementoRemovido;
    }

    public boolean isEmpty() {
        return inicio == null;
    }
}

class TesteFila {
    public static void main(String[] args) {
        // Criando uma fila
        Fila fila = new Fila();

        // Verificando se a fila está vazia
        System.out.println("Fila está vazia? " + fila.isEmpty());
        
        // Enfileirando elementos
        fila.enqueue("5");
        fila.enqueue("1");
        fila.enqueue("8");

        System.out.println("Fila está vazia? " + fila.isEmpty());

        // Desenfileirando elementos
        System.out.println("Elemento removido: " + fila.dequeue());
        System.out.println("Elemento removido: " + fila.dequeue());
        System.out.println("Elemento removido: " + fila.dequeue());

        // Verificando se a fila está vazia novamente
        System.out.println("Fila está vazia? " + fila.isEmpty());
    }
}