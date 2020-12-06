package gof.behavior.chain;

public class ChainApp {
    public static void main(String[] args) {
        Handler handler = new ConcreteHadnler(true);
        handler.handleMessage();
        handler = new ConcreteHadnler(false);
        handler.setSuccessor(new ConcreteHadnler2(true));
        handler.handleMessage();
    }
}

interface Handler {
    void handleMessage();
    void setSuccessor(Handler successor);
}

class ConcreteHadnler implements Handler {

    private boolean canHandle;
    private Handler successor;

    ConcreteHadnler(boolean canHandle) {
        this.canHandle = canHandle;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    @Override
    public void handleMessage() {
        if (canHandle)
            handlerMethod();
        else
            successor.handleMessage();
    }

    private void handlerMethod() {
        System.out.println("in ConcreteHadnler");
    }
}

class ConcreteHadnler2 implements Handler {

    private boolean canHandle;
    private Handler successor;

    ConcreteHadnler2(boolean canHandle) {
        this.canHandle = canHandle;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    @Override
    public void handleMessage() {
        if (canHandle)
            handlerMethod();
        else
            successor.handleMessage();
    }

    private void handlerMethod() {
        System.out.println("in ConcreteHadnler2");
    }
}
