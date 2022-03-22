import java.io.IOException;

class MemoryArray{
    class Node {
        int value;
        Node prev;
        Node next;

        public Node(){
            value = 0;
            prev = null;
            next = null;
        }
    }

    Node cursor;
    Node head;
    public MemoryArray(){
        cursor = new Node();
        head = cursor;
    }

    public int get(){
        return cursor.value;
    }

    public void put(int n){
        cursor.value = n;
    }

    public void moveLeft(){
        if (cursor.prev == null){
            Node temp = new Node();
            cursor.prev = temp;
            temp.next = cursor;
            cursor = temp;
        } else {
            cursor = cursor.prev;
        }
    }

    public void moveRight(){
        if (cursor.next == null){
            Node temp = new Node();
            cursor.next = temp;
            temp.prev = cursor;
            cursor = temp;
        } else {
            cursor = cursor.next;
        }
    }

    public void increase(){
        if (++cursor.value > 127) cursor.value = 0;
    }

    public void decrease(){
        if (--cursor.value < 0) cursor.value = 127;
    }
}

public class Interpreter {
    MemoryArray memoryArray;
    public Interpreter(){
        memoryArray = new MemoryArray();
    }

    char[] refine(String code){
        int count = 0, opcode = 0, index = 0;
        char[] map = {'.', ',', '+', '-', '>', '<', '[', ']'};
        for (int i = 0; i < code.length(); i++){
            if (code.charAt(i) == '!') count++;
        }
        char[] refined = new char[count];
        for (int i = 0; i < code.length(); i++){
            switch (code.charAt(i)){
                case '+':
                    opcode = (opcode + 1) % 8;
                    break;
                case '!':
                    refined[index++] = map[opcode];
                    break;
            }
        }
        return refined;
    }

    public void interprete(String code) throws IOException{
        char[] refined = refine(code);
        interprete(refined, 0, refined.length - 1);
    }

    public void interprete(char[] code, int startIndex, int endIndex) throws IOException{
        for (int i = startIndex; i <= endIndex; i++){
            char character = code[i];
            switch (character){
                case '+':
                    memoryArray.increase();
                    break;
                case '-':
                    memoryArray.decrease();
                    break;
                case '>':
                    memoryArray.moveRight();
                    break;
                case '<':
                    memoryArray.moveLeft();
                    break;
                case '.':
                //memoryArray.print();    
                System.out.printf("%c", memoryArray.get());
                    break;
                case ',':
                    int n = System.in.read();
                    memoryArray.put(n);
                    break;
                case '[':
                    int start = i+1, end = endIndex;
                    int count = 1;
                    for (int j = start; j < endIndex; j++){
                        if (code[j] == ']'){
                            if (--count == 0){
                                end = j-1;
                                break;
                            }
                        } else if (code[j] == '[') count++;
                    }
                    while (memoryArray.get() != 0) interprete(code, start, end);
                    i = end;
                    break;
            }
        }
    }
}