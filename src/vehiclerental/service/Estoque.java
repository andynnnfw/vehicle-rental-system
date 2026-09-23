package vehiclerental.service;

import vehiclerental.exception.ItemNaoEncontradoException;
import vehiclerental.model.Alugavel;

import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private Map<String, Alugavel> itens;

    public Estoque(){
        this.itens = new HashMap<>();
    }

    public void adicionar(String placa, Alugavel item){
        itens.put(placa, item);
    }

    public Alugavel buscarPorPlaca(String placa){
        Alugavel item = itens.get(placa);

        if (item == null){
            throw new ItemNaoEncontradoException("nao foi possivel encontrar esse veiculo!");
        }
        return item;
    }

    public void remover(String placa){
        itens.remove(placa);
    }

    public void listarTodos(){
        if (itens.isEmpty()){
            System.out.println("nao tem veiculos disponiveis no momento...");
            return;
        }

        for (Map.Entry<String, Alugavel> entrada : itens.entrySet()){
            System.out.println("placa: " + entrada.getKey() + " -> " + entrada.getValue());
        }
    }
}
