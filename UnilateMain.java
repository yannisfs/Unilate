class UnilateMain{
    public static void main(String[] args){
        Thread unilateThread = new Thread(new Unilate());

        unilateThread.start();
    }
}