public class Main {
    public static void main(String[] args) {
        String x = "++!++++!++++++!+++++!+++++++!+++++!++!";
        Interpreter i = new Interpreter();
        try {
            i.interprete(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}