package Model;

import java.util.LinkedList;
import java.util.Scanner;

public class TowerControl {
    private final LinkedList<AirplaneModel> _waitingForLand;
    private final LinkedList<AirplaneModel> _waitingForTakeoff;

    public TowerControl(){
        _waitingForLand = new LinkedList<>();
        _waitingForTakeoff = new LinkedList<>();
    }

    public void AddLandQueue(){
        AirplaneModel airPlane = CreateAirplane("Pouso");
        _waitingForLand.add(airPlane);
    }

    public void AddTakeoffQueue(){
        AirplaneModel airPlane = CreateAirplane("Decolagem");
        _waitingForTakeoff.add(airPlane);
    }

    public void Land(){
        if(_waitingForLand.isEmpty()){
            System.out.println("Não há aviões esperando para realizar o pouso.");
            return;
        }

        InitCountdown("Iniciando contagem regressiva para pouso:",
                ("Pouso concluído do Avião " + _waitingForLand.getFirst().Id + "! ✈"));

        _waitingForLand.removeFirst();
    }

    public void Takeoff(){
        if(_waitingForTakeoff.isEmpty()){
            System.out.println("Não há aviões esperando para realizar a decolagem.");
            return;
        }

        InitCountdown("Iniciando contagem regressiva para a decolagem:",
                ("Decolagem concluída do Avião " + _waitingForTakeoff.getLast().Id + "! ✈"));

        _waitingForTakeoff.removeLast();
    }

    public void ShowAirportStatus(){

        planeInfo(_waitingForLand, "pouso");

        planeInfo(_waitingForTakeoff, "decolagem");
    }

    private void planeInfo(LinkedList<AirplaneModel> list, String operation){

        int size = list.size();
        String planeText = size > 1 ? "aviões" : "avião";

        System.out.println("\nHá atualmente " + size + " " + planeText + " na fila de " + operation + ".");

        for(int i = 0; i < size; i++){
            list.get(i).str();
        }
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

    private AirplaneModel CreateAirplane(String operation){
        System.out.println("\n\nDigite o identificador do avião (Ex: 001):");
        String airPlaneId = new Scanner(System.in).nextLine();
        return new AirplaneModel(airPlaneId, operation);
    }

    public int ShowControls(){
        System.out.println("""
                
                
                Bem-vindo ao Sistema de Controle de Aeroporto!
                
                1. Adicionar avião para decolar.
                2. Adicionar avião para pousar.
                3. Realizar decolagem.
                4. Realizar pouso.
                5. Exibir status do aeroporto.
                6. Sair
                
                Escolha uma opção:""");

        try{
            return new Scanner(System.in).nextInt();
        }
        catch (Exception ex){
            System.out.println("Comando inválido");
            return -1;
        }
    }
}