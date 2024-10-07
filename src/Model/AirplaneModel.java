package Model;

public class AirplaneModel {
    public String Id;

    public String Type;

    public AirplaneModel(String id, String type){
        Id = id;
        Type = type;
    }

    public void str(){
        System.out.println("Id: " + Id + " | " + "Operação: " + Type);
    }
}
