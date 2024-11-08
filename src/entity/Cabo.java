package entity;

//Autor: Diego Roberto

public class Cabo {
    
    private String origem;
    private String destino;
    private String reguaOrigem;
    private String reguaDestino;
    private String tribOrigem;
    private String tribDestino;
    private String rackOrigem;
    private String rackDestino;

    public Cabo() {
        this.origem = "0";
        this.destino = "0";
        this.reguaOrigem = "0";
        this.reguaDestino = "0";
        this.tribOrigem = "1";
        this.tribDestino = "1";
        this.rackOrigem = "1";
        this.rackDestino = "1";
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getReguaOrigem() {
        return reguaOrigem;
    }

    public void setReguaOrigem(String reguaOrigem) {
        this.reguaOrigem = reguaOrigem;
    }

    public String getReguaDestino() {
        return reguaDestino;
    }

    public void setReguaDestino(String reguaDestino) {
        this.reguaDestino = reguaDestino;
    }

    public String getTribOrigem() {
        return tribOrigem;
    }

    public void setTribOrigem(String tribOrigem) {
        this.tribOrigem = tribOrigem;
    }
    
    public String getTribDestino() {
        return tribDestino;
    }

    public void setTribDestino(String tribDestino) {
        this.tribDestino = tribDestino;
    }

    public String getRackOrigem() {
        return rackOrigem;
    }

    public void setRackOrigem(String rackOrigem) {
        this.rackOrigem = rackOrigem;
    }

    public String getRackDestino() {
        return rackDestino;
    }

    public void setRackDestino(String rackDestino) {
        this.rackDestino = rackDestino;
    }
    
}