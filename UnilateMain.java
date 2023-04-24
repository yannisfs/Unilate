public class UnilateMain{
    public static void main(String[] args){
        Unilate unilate = new Unilate();
        ScrollMenu sMenu = new ScrollMenu();
        unilate.addToWindow(sMenu.getPanel());
    }
}