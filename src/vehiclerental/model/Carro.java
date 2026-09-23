package vehiclerental.model;

public class Carro extends Veiculo implements Alugavel{
    private int numPortas;
    private boolean alugado;

    public Carro(String modelo, String placa, int anoFabricacao, int numPortas) {
        super(modelo, placa, anoFabricacao);
        this.numPortas = numPortas;
        this.alugado = false;
    }

    public int getNumPortas(){
        return numPortas;
    }

    public void setNumPortas(int numPortas){
        System.out.println("Numero de portas: " + numPortas);
    }


    @Override
    public void alugar() {
        if (!alugado){
            alugado = true;
            System.out.println("veiculo alugado com sucesso!");
        }else {
            System.out.println("erro, este veiculo ja foi alugado!");
        }
    }

    @Override
    public void devolver() {
        if (alugado){
            alugado = false;
            System.out.println("veiculo devolvido com sucesso!");
        }else {
            System.out.println("erro, este veiculo ja foi devolvido!");
        }
    }

    @Override
    public boolean isAlugado() {
        return alugado;
    }

    public String toString(){
        return "veiculo" + getModelo() + " - " + getPlaca() + " - " + getAnoFabricacao();
    }

    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Numero de portas: " + numPortas);
    }
}
