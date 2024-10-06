package Model;

import java.util.LinkedList;
import java.util.Scanner;

public class TowerControl {
    private final LinkedList<AirplaneModel> _waitingForLand;

    public TowerControl(){
        _waitingForLand = new LinkedList<>();
    }

    public void AddLandQueue(){
        AirplaneModel airPlane = CreateAirplane();
        _waitingForLand.add(airPlane);
    }

    public void Land(){
        if(_waitingForLand.isEmpty()){
            System.out.println("Não há aviões esperando para realizar o pouso.");
        }

        InitCountdown("Iniciando contagem regressiva para pouso:","Pouso concluído do Avião 202! ✈");

        _waitingForLand.removeFirst();
    }

    public void ShowAirportStatus(){

        String planeText = "avião";
        int landSize = _waitingForLand.size();
        if(landSize > 1)
            planeText = "aviões";

        System.out.println("Há atualmente " + landSize + " " + planeText + " na fila de pouso.");
    }

    private void InitCountdown(String message, String finalMessage){
        System.out.println(message);
        Countdown(5);
        System.out.println(finalMessage);
    }

    private void Countdown(int seconds){

        System.out.println(seconds + "...");

        if(seconds == 0){
            return;
        }

        seconds -= 1;

        Countdown(seconds);
    }

    private AirplaneModel CreateAirplane(){
        System.out.println("Digite o identificador do avião (Ex: Avião 001):");
        String airPlaneId = new Scanner(System.in).nextLine();
        System.out.println("Digite o tipo da aeronave (Ex: Avião 001):");
        String airplaneType = new Scanner(System.in).nextLine();
        return new AirplaneModel(airPlaneId, airplaneType);
    }

    public int ShowControls(){
        System.out.println("Bem-vindo ao Sistema de Controle de Aeroporto!\n" +
                "\n" +
                "1. Adicionar avião para decolar.\n" +
                "2. Adicionar avião para pousar.\n" +
                "3. Realizar decolagem.\n" +
                "4. Realizar pouso.\n" +
                "5. Exibir status do aeroporto.\n" +
                "6. Sair\n" +
                "\n" +
                "Escolha uma opção:");

        try{
            return new Scanner(System.in).nextInt();
        }
        catch (Exception ex){
            System.out.println("Comando inválido");
            return -1;
        }
    }
}