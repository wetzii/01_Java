package inventar;
public class Snack implements Sellable {

    private String label;
    private int priceCents;
    private int stock;

    public Snack(String label, int priceCents, int stock) {
        this.label = label;
        this.priceCents = priceCents;
        this.stock = stock;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public int getPriceCent() {
        return priceCents;
    }
    @Override
    public boolean isAvalibale() {
        return stock > 0;
    }

    @Override
    public void sellOne() {
    	
        if (isAvalibale()) {
            stock--;
            System.out.println(label + " verkauft. Restbestand: " + stock);
        } else {
            System.out.println(label + " nicht mehr verfügbar!");
        }
    }
}
