package classe;

public class Venda {
    String datv;
    String prodv;
    int quantv;
    public String getDatv() {
        return datv;
    }
    public void setDatv(String datv) {
        this.datv = datv;
    }
    public String getProdv() {
        return prodv;
    }
    public void setProdv(String prodv) {
        this.prodv = prodv;
    }
    public int getQuantv() {
        return quantv;
    }
    public void setQuantv(int quantv) {
        this.quantv = quantv;
    }
    public Venda(String datv, String prodv, int quantv) {
        this.datv = datv;
        this.prodv = prodv;
        this.quantv = quantv;
    }
    @Override
    public String toString() {
        return "Venda [datv=" + datv + ", prodv=" + prodv + ", quantv=" + quantv + "]";
    }
    
}
