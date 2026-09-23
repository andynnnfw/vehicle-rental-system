package vehiclerental.model;

public class Moto extends Veiculo implements Alugavel{
    private int cilindradas;
    private boolean alugado;

    public Moto(String modelo, String placa, int anoFabricacao, int cilindradas) {
        super(modelo, placa, anoFabricacao);
        this.cilindradas = cilindradas;
        this.alugado = false;
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
        System.out.println("Cilindradas: " + cilindradas);
    }
}
