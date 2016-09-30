import java.util.ArrayList;

public class Inventario {
    private ArrayList<Item> itens;
    
    public Inventario() {
        itens = new ArrayList<>();
    }
    
    public ArrayList<Item> getItens() {
        return itens;
    }
    
    public void adicionarItem(Item item) {
        itens.add(item);
    }
    
    public void removerItem(Item item) {
        itens.remove(item);
    }
}