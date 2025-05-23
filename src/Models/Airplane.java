package Models;

public class Airplane {

    private String model;
    private String marka;
    private String Id;
    private int koltukKapasitesi;

    public  Airplane(String model , String marka , String Id , int koltukKapasitesi){
        this.model = model;
        this.marka = marka;
        this.Id = Id;
        this.koltukKapasitesi = koltukKapasitesi;
    }

    public String getModel(){
        return model;
    }
    public String getMarka(){
        return marka;
    }
    public String getId(){
        return Id;
    }
    public int getKoltukKapasitesi(){
        return koltukKapasitesi;
    }
    @Override
    public String toString() {
        return marka + " " + model + " (Seri No: " + Id + ", Kapasite: " + koltukKapasitesi + ")";
    }
}
