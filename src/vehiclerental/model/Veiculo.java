package vehiclerental.model;

import vehiclerental.exception.AnoInvalidoException;
import vehiclerental.exception.ModeloInvalidoException;

import java.time.LocalDateTime;

public class Veiculo {
    private String modelo;
    private String placa;
    private int anoFabricacao;
    private int anoAtual = LocalDateTime.now().getYear();

    public Veiculo(String modelo, String placa, int anoFabricacao){
        this.placa = placa;
        this.setModelo(modelo);
        this.setAnoFabricacao(anoFabricacao);
    }

    public String getPlaca(){
        return placa;
    }

    public void setPlaca(String placa){
        this.placa = placa;
    }

    public String getModelo(){
        return modelo;
    }

    public void setModelo(String modelo){
        if (modelo == null || modelo.isEmpty()){
            throw new ModeloInvalidoException("este ano digitado eh invalido");
        }
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao){
        if (anoFabricacao < 1833 || anoFabricacao > anoAtual){
            throw new AnoInvalidoException("esse ano nao eh valido");
        }
        this.anoFabricacao = anoFabricacao;
    }

    public void mostrarInfo(){
        System.out.println("Modelo: " + getModelo());
        System.out.println("Placa: " + placa);
        System.out.println("Ano fabricado: " + anoFabricacao);
    }
}
